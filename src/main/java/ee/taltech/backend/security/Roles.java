package ee.taltech.backend.security;

/**
 * to have constants instead of hardcoded string, with interface we don't have to write "public static final"
 * all spring roles start with ROLE_ prefix
 */
public interface Roles { //to have convenient way of declaring roles, interface because we don't have to declare public static
    String USER = "ROLE_USER";
    String ADMIN = "ROLE_ADMIN";
}


