package cn.webyun.meteorologicalinterface.security;

import cn.webyun.meteorologicalinterface.entity.RolePrivilege;
import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.entity.UserRole;
import cn.webyun.meteorologicalinterface.service.RolePrivilegeService;
import cn.webyun.meteorologicalinterface.service.UserRoleService;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserPrivilegeDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserPrivilegeDetailsService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePrivilegeService rolePrivilegeService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {

            User user = userService.getUserByName(username);
            if (user == null) throw new UsernameNotFoundException("User: " + username + " not found.");

            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getAccountEnabled(),
                    !user.getAccountExpired(),
                    !user.getPasswordExpired(),
                    !user.getAccountLocked(),
                    getAuthorities(user));
        } catch (Exception e) {
            throw new UsernameNotFoundException("User: " + username + " query exception.");
        }

    }

    public Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (UserRole userRole : userRoleService.getUserRolebyUserId(user.getId()))
            for (RolePrivilege rolePrivilege : rolePrivilegeService.getRolePrivilegebyRoleId(userRole.getRoleId())) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rolePrivilege.getPrivName());
                authorities.add(grantedAuthority);
            }

        return authorities;

    }
}
