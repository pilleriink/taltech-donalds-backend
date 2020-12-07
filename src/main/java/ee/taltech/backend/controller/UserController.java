package ee.taltech.backend.controller;

import ee.taltech.backend.exception.UserNotFoundException;
import ee.taltech.backend.model.user.LoginDto;
import ee.taltech.backend.model.user.LoginResponse;
import ee.taltech.backend.model.user.RegisterDto;
import ee.taltech.backend.model.user.User;
import ee.taltech.backend.security.Roles;
import ee.taltech.backend.security.UserSessionHolder;
import ee.taltech.backend.service.users.LoginService;
import ee.taltech.backend.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.findById(id);
    }

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


