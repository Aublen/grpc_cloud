package org.example.grpc_cloud.application.controller;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc_cloud.service_api.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aublen
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GrpcClient("user_service")
    private UserServiceGrpc.UserServiceBlockingStub userServiceGrpc;

    @GetMapping("/get")
    public String get(@RequestParam("id") Integer id) {
        // 创建请求
        UserGetRequest request = UserGetRequest.newBuilder().setId(id).build();
        // 执行GRPC请求
        UserGetResponse response = userServiceGrpc.get(request);
        // 响应
        return response.getName();
    }

    @PostMapping("/create")
    public Integer create(@RequestParam("name") String name,
                          @RequestParam("gender") Integer gender) {
        // 创建请求
        UserCreateRequest request = UserCreateRequest.newBuilder()
                .setName(name).setGender(gender).build();
        // 执行GRPC请求
        UserCreateResponse response = userServiceGrpc.create(request);
        // 响应
        return response.getId();
    }
}
