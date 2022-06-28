package com.epam.conferences.service;

import com.epam.conferences.entity.dto.AuthorizedDataDto;
import com.epam.conferences.entity.user.User;
import org.fed333.servletboot.annotation.Inject;
import org.fed333.servletboot.annotation.PropertyValue;
import org.fed333.servletboot.annotation.Singleton;
import org.fed333.servletboot.security.encoding.password.PasswordEncoder;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Class to manage authorization operations.<br>
 * @author Roman Kovalchuk
 * @version 1.0
 * */
@Singleton
public class AuthorizationService {

    public static final String AUTHORIZED_USER = "authorizedUser";

    @Inject
    private UserService userService;

    @Inject
    private PasswordEncoder encoder;

    @Inject
    private LocaleResolverService localeResolverService;

    @PropertyValue
    private String messages;

    /**
     * Sings in the user account. Checks whether under these credentials exists authorized User.<br>
     * If is authorized, adds authorized User to the session.<br>
     * @param request dto request with credentials data
     * @param session current web session
     * @return true if User has been authorized, otherwise false
     * @since 1.0
     * */
    public boolean login(AuthorizedDataDto request, HttpSession session){
        String password = request.getPassword();
        Optional<User> authorized = Optional.ofNullable(userService.findUserByName(request.getUsername()));
        authorized.ifPresent(user -> session.setAttribute(AUTHORIZED_USER, user));
        return authorized.isPresent();
    }

    public void logout(HttpSession session){
        session.removeAttribute(AUTHORIZED_USER);
    }

    /**
     * Gives authorized user from session.<br>
     * @param session current HttpSession
     * @return authorized User if exists, otherwise null
     * */
    public User getAuthorized(HttpSession session){
        return (User) session.getAttribute(AUTHORIZED_USER);
    }

}
