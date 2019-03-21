/*
package cn.webyun.meteorologicalinterface.security;



import cn.webyun.meteorologicalinterface.entity.JwtUser;
import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

*/
/**
 * 用户验证方法
 *
 * @author hackyo
 * Created on 2017/12/8 9:18.
 *//*

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        } else {
            return new JwtUser(user.getUsername(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        }
    }

}
*/
