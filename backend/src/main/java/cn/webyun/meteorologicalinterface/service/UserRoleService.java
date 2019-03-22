package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.Role;
import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.entity.UserRole;
import cn.webyun.meteorologicalinterface.entity.UserRoleCriteria;
import cn.webyun.meteorologicalinterface.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Cacheable(value = "userRolesByUserCache", key = "#userId", unless = "#result == null")
    public List<UserRole> getUserRolebyUserId(Integer userId) {

        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andUserIdEqualTo(userId);
        return userRoleMapper.selectByExample(userRoleCriteria);

    }

    @Cacheable(value = "userRolesByRoleCache", key = "#roleId", unless = "#result == null")
    public List<UserRole> getUserRolebyRoleId(Integer roleId) {

        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andRoleIdEqualTo(roleId);
        return userRoleMapper.selectByExample(userRoleCriteria);

    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", key = "#user.id"),
            @CacheEvict(value = "userRolesByRoleCache", key = "#role.id")
    })
    public UserRole addInfo(User user, Role role) {
        UserRole urole = new UserRole();

        urole.setUserId(user.getId());
        urole.setUserName(user.getUserName());
        urole.setUserFullName(user.getUserFullName());
        urole.setRoleId(role.getId());
        urole.setRoleName(role.getRoleName());
        urole.setRoleDesc(role.getRoleDesc());

        userRoleMapper.insert(urole);

        return urole;
    }

    public void addInfos(User user, List<Role> roles) {
        for (Role i : roles) {
            addInfo(user, i);
        }
    }

    public void addInfos(Role role, List<User> users) {
        for (User i : users) {
            addInfo(i, role);
        }
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", key = "#user.id"),
            @CacheEvict(value = "userRolesByRoleCache", allEntries = true)
    })
    public void delInfos(User user) {
        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andUserIdEqualTo(user.getId());
        userRoleMapper.deleteByExample(userRoleCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", key = "#userId"),
            @CacheEvict(value = "userRolesByRoleCache", allEntries = true)
    })
    public void delInfosByUser(Integer userId) {
        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andUserIdEqualTo(userId);
        userRoleMapper.deleteByExample(userRoleCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", allEntries = true),
            @CacheEvict(value = "userRolesByRoleCache", key = "#role.id")
    })
    public void delInfos(Role role) {
        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andRoleIdEqualTo(role.getId());
        userRoleMapper.deleteByExample(userRoleCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", allEntries = true),
            @CacheEvict(value = "userRolesByRoleCache", key = "#roleId")
    })
    public void delInfosByRole(Integer roleId) {
        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        userRoleCriteria.createCriteria().andRoleIdEqualTo(roleId);
        userRoleMapper.deleteByExample(userRoleCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", key = "#user.id"),
            @CacheEvict(value = "userRolesByRoleCache", allEntries = true)
    })
    public void updateInfos(User user, List<Role> roles) {
        delInfos(user);
        addInfos(user, roles);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userRolesByUserCache", allEntries = true),
            @CacheEvict(value = "userRolesByRoleCache", key = "#role.id")
    })
    public void updateInfos(Role role, List<User> users) {
        delInfos(role);
        addInfos(role, users);
    }
}
