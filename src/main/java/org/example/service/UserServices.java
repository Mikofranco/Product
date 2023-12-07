package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.model.Product;
import org.example.data.model.User;
import org.example.data.repo.PostRepo;
import org.example.data.repo.ProductRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.AddPostRequest;
import org.example.dto.request.AddProductRequest;
import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.AddPostResponse;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.UserInfoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServices implements UserService{
    private final UserRepo userRepo;
    private final ProductService productService;
    private final ProductRepo productRepo;
    private final PostService postService;
    private final PostRepo postRepo;
    @Override
    public void register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        userRepo.save(user);
    }

    @Override
    public UserInfoResponse login(LoginRequest request) {
       var user = userRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
               .orElseThrow(()->new RuntimeException("invalid user details"));
        return UserInfoResponse.builder()
                .createdDate(user.getCreatedDate())
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest request) {
        var user = userRepo.findById(request.getUserId()).orElseThrow();
        var product = productService.add(request.getName(), request.getDescription(), request.getPrice(), request.getQuantity());
        product.setUser(user);
       var savedProduct = productRepo.save(product);
       return AddProductResponse.builder()
                       .userId(savedProduct.getUser().getId())
                               .userEmail(savedProduct.getUser().getEmail())
                                       .description(savedProduct.getDescription())
                                               .price(savedProduct.getPrice())
                                                       .quantity(savedProduct.getQuantity())
                                                               .userUsername(savedProduct.getUser().getUsername())
                                                                    .build();
    }

    @Override
    public List<Product> viewAllProduct(long userId) {
        var user =userRepo.findById(userId).orElseThrow();
        return productRepo.findAll().stream().filter(product -> product.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public AddPostResponse addPost(AddPostRequest request) {
        var user =userRepo.findById(request.getUserId()).orElseThrow();
        var post =postService.addPost(request.getTitle(), request.getContent(), request.getImgUrl());
        post.setUser(user);
        var userPost =postRepo.save(post);


        return AddPostResponse.builder()
                .imgUrl(userPost.getImgUrl())
                .title(userPost.getTitle())
                .content(userPost.getContent())
                .userInfoResponse(userInfo(user))
                .build();
    }

    @Override
    public UserInfoResponse findUserById(long userId) {
        User user =userRepo.findById(userId).orElseThrow();
       return UserInfoResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .createdDate(user.getCreatedDate())
                .email(user.getEmail())
                .build();
    }

    private static UserInfoResponse userInfo(User user) {
        return UserInfoResponse.builder()
                .username(user.getUsername())
                        .createdDate(user.getCreatedDate())
                                .email(user.getEmail())
                                        .build();
    }
}
