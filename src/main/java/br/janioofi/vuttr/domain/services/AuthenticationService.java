package br.janioofi.vuttr.domain.services;

import br.janioofi.vuttr.domain.DTO.LoginResponseDto;
import br.janioofi.vuttr.domain.DTO.UserDto;
import br.janioofi.vuttr.domain.entities.User;
import br.janioofi.vuttr.domain.repositories.UserRepository;
import br.janioofi.vuttr.exceptions.BussinesException;
import br.janioofi.vuttr.infra.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    public LoginResponseDto login(@Valid UserDto user){
        var usernamePassword = new UsernamePasswordAuthenticationToken(user.username(), user.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User)auth.getPrincipal());
        return new LoginResponseDto(token);
    }

    public String register(@Valid UserDto user){
        if(this.repository.findByUsername(user.username()) != null){
            throw new BussinesException("There is already a registered user with this username");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        User data = new User(null, user.username(), encryptedPassword);
        repository.save(data);
        return "User registered successfully";
    }
}
