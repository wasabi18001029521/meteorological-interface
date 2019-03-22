package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.Privilege;
import cn.webyun.meteorologicalinterface.entity.Role;
import cn.webyun.meteorologicalinterface.entity.RolePrivilege;
import cn.webyun.meteorologicalinterface.entity.RolePrivilegeCriteria;
import cn.webyun.meteorologicalinterface.mapper.RolePrivilegeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolePrivilegeService {

    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Cacheable(value = "rolePrivsByRoleCache", key = "#roleId", unless = "#result == null")
    public List<RolePrivilege> getRolePrivilegebyRoleId(Integer roleId) {
        RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
        rolePrivilegeCriteria.createCriteria().andRoleIdEqualTo(roleId);
        return rolePrivilegeMapper.selectByExample(rolePrivilegeCriteria);
    }

    @Cacheable(value = "rolePrivsByPrivCache", key = "#privId", unless = "#result == null")
    public List<RolePrivilege> getRolePrivilegebyPrivId(Integer privId) {
        RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
        rolePrivilegeCriteria.createCriteria().andPrivIdEqualTo(privId);
        return rolePrivilegeMapper.selectByExample(rolePrivilegeCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", key = "#role.id"),
            @CacheEvict(value = "rolePrivsByPrivCache", key = "#priv.id")
    })
    public RolePrivilege addInfo(Role role, Privilege priv) {
        RolePrivilege rptiv = new RolePrivilege();

        rptiv.setRoleId(role.getId());
        rptiv.setRoleName(role.getRoleName());
        rptiv.setRoleDesc(role.getRoleDesc());

        rptiv.setPrivId(priv.getId());
        rptiv.setPrivName(priv.getPrivName());
        rptiv.setPrivDesc(priv.getPrivDesc());

        rolePrivilegeMapper.insert(rptiv);

        return rptiv;
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", key = "#role.id"),
            @CacheEvict(value = "rolePrivsByPrivCache", allEntries = true)
    })
    public void addInfos(Role role, List<Privilege> privs) {
        for (Privilege i : privs) {
            addInfo(role, i);
        }
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", allEntries = true),
            @CacheEvict(value = "rolePrivsByPrivCache", key = "#priv.id")
    })
    public void addInfos(Privilege priv, List<Role> roles) {
        for (Role i : roles) {
            addInfo(i, priv);
        }
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", key = "#role.id"),
            @CacheEvict(value = "rolePrivsByPrivCache", allEntries = true)
    })
    public void delInfos(Role role) {
        RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
        rolePrivilegeCriteria.createCriteria().andRoleIdEqualTo(role.getId());
        rolePrivilegeMapper.deleteByExample(rolePrivilegeCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", key = "#roleId"),
            @CacheEvict(value = "rolePrivsByPrivCache", allEntries = true)
    })
    public void delInfosByRole(Integer roleId) {
        RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
        rolePrivilegeCriteria.createCriteria().andRoleIdEqualTo(roleId);
        rolePrivilegeMapper.deleteByExample(rolePrivilegeCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", allEntries = true),
            @CacheEvict(value = "rolePrivsByPrivCache", key = "#priv.id")
    })
    public void delInfos(Privilege priv) {
        RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
        rolePrivilegeCriteria.createCriteria().andPrivIdEqualTo(priv.getId());
        rolePrivilegeMapper.deleteByExample(rolePrivilegeCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", allEntries = true),
            @CacheEvict(value = "rolePrivsByPrivCache", key = "#privId")
    })
    public void delInfosByPriv(Integer privId) {
        RolePrivilegeCriteria rolePrivilegeCriteria = new RolePrivilegeCriteria();
        rolePrivilegeCriteria.createCriteria().andPrivIdEqualTo(privId);
        rolePrivilegeMapper.deleteByExample(rolePrivilegeCriteria);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", key = "#role.id"),
            @CacheEvict(value = "rolePrivsByPrivCache", allEntries = true)
    })
    public void updateInfos(Role role, List<Privilege> privs) {
        delInfos(role);
        addInfos(role, privs);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "rolePrivsByRoleCache", allEntries = true),
            @CacheEvict(value = "rolePrivsByPrivCache", key = "#priv.id")
    })
    public void updateInfos(Privilege priv, List<Role> roles) {
        delInfos(priv);
        addInfos(priv, roles);
    }
}
