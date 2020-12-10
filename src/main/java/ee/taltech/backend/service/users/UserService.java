package ee.taltech.backend.service.users;

import ee.taltech.backend.exception.CategoryNotFoundException;
import ee.taltech.backend.exception.UserException;
import ee.taltech.backend.model.category.Category;
import ee.taltech.backend.model.user.RegisterDto;
import ee.taltech.backend.model.user.User;
import ee.taltech.backend.repository.UserRepository;
import ee.taltech.backend.security.DbRole;
import ee.taltech.backend.security.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(RegisterDto registerDto) {
        if (isBlank(registerDto.getUsername())) {
            throw new UserException("missing username");
        }
        if (isBlank(registerDto.getPassword())) {
            throw new UserException("missing password");
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setDbRole(DbRole.USER);
        userRepository.save(user);
        //email sent out to confirm it, not necessary fot iti0203
    }

    public User findById(Long id) throws UserException{
        return userRepository.findById(id).orElseThrow(UserException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        return findById(myUser.getId());
    }

}

