package ee.taltech.backend.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * to have our own properties on session user
 * also to have clean imports as our model User and spring security User have same name "User"
 */
@Getter
public class MyUser extends User {

    private Long id;
    private DbRole dbRole;


    public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id, DbRole dbRole) {
        super(username, password, authorities);
        this.id = id;
        this.dbRole = dbRole;
    }

    public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
                  boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
                  Long id, DbRole dbRole) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.dbRole = dbRole;
    }

}

