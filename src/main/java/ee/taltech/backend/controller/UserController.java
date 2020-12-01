package ee.taltech.backend.controller;

import ee.taltech.backend.exception.MyBadRequestException;
import ee.taltech.backend.model.user.LoginDto;
import ee.taltech.backend.model.user.LoginResponse;
import ee.taltech.backend.model.user.RegisterDto;
import ee.taltech.backend.model.user.UserDto;
import ee.taltech.backend.security.JwtTokenProvider;
import ee.taltech.backend.security.MyUserDetailsService;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.security.UserSessionHolder;
import ee.taltech.backend.service.users.LoginService;
import ee.taltech.backend.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody RegisterDto registerDto){
        userService.saveUser(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

    @Secured({Roles.ADMIN, Roles.USER})
    @GetMapping("me")
    public Object getMe() {
        return UserSessionHolder.getLoggedInUser();
    }
}


