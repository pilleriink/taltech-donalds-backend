package ee.taltech.backend;

import ee.taltech.backend.model.user.User;
import ee.taltech.backend.repository.UserRepository;
import ee.taltech.backend.security.DbRole;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
//@Profile("test")
@AllArgsConstructor
public class UserApplicationInit implements CommandLineRunner {

    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setDbRole(DbRole.USER);
        usersRepository.save(user);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setDbRole(DbRole.ADMIN);
        usersRepository.save(admin);
    }
}

