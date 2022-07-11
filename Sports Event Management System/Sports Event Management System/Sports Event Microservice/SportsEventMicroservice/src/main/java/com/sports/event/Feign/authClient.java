package com.sports.event.Feign;

import com.sports.event.entity.JwtResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(name="authorization-service",url="http://localhost:8084/")

public interface authClient {
    @GetMapping("/api/auth/validate")
    public JwtResponse verifyToken(@RequestHeader(name="authorization",required = true)String token) ;
}

