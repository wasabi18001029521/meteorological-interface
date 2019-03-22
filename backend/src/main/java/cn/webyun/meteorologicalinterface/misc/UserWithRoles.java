package cn.webyun.meteorologicalinterface.misc;

import cn.webyun.meteorologicalinterface.entity.Role;
import cn.webyun.meteorologicalinterface.entity.User;

import java.io.Serializable;
import java.util.List;

public class UserWithRoles implements Serializable {

    private User user;
    private List<Role> roles;

    public UserWithRoles(User user, List<Role> roles) {
        this.user = user;
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
