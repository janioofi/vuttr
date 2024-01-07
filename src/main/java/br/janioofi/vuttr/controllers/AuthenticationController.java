package br.janioofi.vuttr.controllers;

import br.janioofi.vuttr.domain.DTO.UserDto;
import br.janioofi.vuttr.domain.services.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "API Authentication")
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto user){
        return ResponseEntity.ok(service.login(user));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(user));
    }
}
