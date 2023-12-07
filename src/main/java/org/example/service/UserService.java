package org.example.service;

import org.example.data.model.Product;
import org.example.data.model.User;
import org.example.dto.request.AddPostRequest;
import org.example.dto.request.AddProductRequest;
import org.example.dto.request.LoginRequest;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.AddPostResponse;
import org.example.dto.response.AddProductResponse;
import org.example.dto.response.UserInfoResponse;

import java.util.List;

public interface UserService {
    void register(RegisterRequest request);
    UserInfoResponse login(LoginRequest request);
    AddProductResponse addProduct(AddProductRequest request);
    List<Product> viewAllProduct(long userId);
    AddPostResponse addPost(AddPostRequest request);
    UserInfoResponse findUserById(long userId);
}
