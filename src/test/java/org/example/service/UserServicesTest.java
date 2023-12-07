package org.example.service;

import org.example.data.repo.PostRepo;
import org.example.data.repo.ProductRepo;
import org.example.data.repo.UserRepo;
import org.example.dto.request.AddPostRequest;
import org.example.dto.request.AddProductRequest;
import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@SpringBootTest
class UserServicesTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private PostRepo postRepo;
    @Test
    public void registerTest(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername("micheal");
        request.setEmail("ogbechie@gmail.com");
        request.setPassword("12345");
        userService.register(request);
        assertThat(userRepo.count(), is(1L));
    }
    @Test
    public void testLogin(){
        LoginRequest request = new LoginRequest();
        request.setPassword("12345");
        request.setEmail("ogbechie@gmail.com");
        var userDetails =userService.login(request);
        assertThat(userDetails.getUsername(),is("micheal"));
    }
    @Test
    public void testToAddProduct(){
        AddProductRequest request = new AddProductRequest();
        request.setUserId(1);
        request.setName("guitar");
        request.setDescription("fender stratocaster");
        request.setQuantity(10);
        request.setPrice(BigDecimal.valueOf(100000));
        userService.addProduct(request);
        assertThat(productRepo.count(),is(1L));
    }
    @Test
    public void testThatUserCanAddMultipleProduct(){
        AddProductRequest request = new AddProductRequest();
        request.setUserId(1);
        request.setName("deums");
        request.setDescription("tamar dark wood");
        request.setQuantity(2);
        request.setPrice(BigDecimal.valueOf(16435000));
        userService.addProduct(request);

        AddProductRequest request1 = new AddProductRequest();
        request1.setUserId(1);
        request1.setName("saxophone");
        request1.setDescription("armstrong supreme gold ");
        request1.setQuantity(24);
        request1.setPrice(BigDecimal.valueOf(3000));
        userService.addProduct(request1);
        assertThat(productRepo.count(),is(3L));

    }
    @Test
    public void testToFindAllProduct(){
        var products =userService.viewAllProduct(1L);
        products.forEach(product -> System.out.println("product"+product));
        assertThat(products.size(),is(3));
    }
    @Test
    public void testToPost(){
        AddPostRequest addPostRequest = new AddPostRequest();
        addPostRequest.setUserId(1L);
        addPostRequest.setTitle("story");
        addPostRequest.setContent("loremmmmmmmmmmmmmmmmmmmmmmm");
        addPostRequest.setImgUrl("http://ziggi.com");
        userService.addPost(addPostRequest);
        assertThat(postRepo.count(),is(1L));
    }



}