package cn.webyun.meteorologicalinterface.controller;

import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.message.request.LoginForm;
import cn.webyun.meteorologicalinterface.message.response.JwtResponse;
import cn.webyun.meteorologicalinterface.message.response.ResponseBase;
import cn.webyun.meteorologicalinterface.security.JwtProvider;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;


    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        String jwt = "";
        Boolean status = false;
        String userName = "";
        User user;
        List<String> authorities = null;
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            jwt = jwtProvider.generateJwtToken(authentication);
            status = true;
            userName = authentication.getName();
            user = userService.getUserByName(userName);
            authorities = getAuthoritiesListString(authentication.getAuthorities());

        } catch (AuthenticationException e) {
            status = false;
            return ResponseEntity.ok(new ResponseBase(false, "authentication error."));
        }
        return ResponseEntity.ok(new JwtResponse(jwt, status, user, authorities));

    }

    public List<String> getAuthoritiesListString(Collection<? extends GrantedAuthority> authorities) {

        List<String> list = new ArrayList<String>();

        for (GrantedAuthority authority : authorities) {
            list.add(authority.getAuthority());

        }
        return list;
    }


}
