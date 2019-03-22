package cn.webyun.meteorologicalinterface.misc;

import cn.webyun.meteorologicalinterface.entity.*;

import java.io.Serializable;
import java.util.List;

public class RoleWithInfos implements Serializable {

    private Role role;
    private List<User> users;
    private List<Privilege> privs;

    public RoleWithInfos(Role role, List<User> users, List<Privilege> privs) {
        this.role = role;
        this.users = users;
        this.privs = privs;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Privilege> getPrivs() {
        return privs;
    }

    public void setPrivs(List<Privilege> privs) {
        this.privs = privs;
    }
}
