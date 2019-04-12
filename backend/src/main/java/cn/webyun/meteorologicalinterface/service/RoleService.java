package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.*;
import cn.webyun.meteorologicalinterface.mapper.RoleMapper;
import cn.webyun.meteorologicalinterface.misc.RoleWithInfos;
import cn.webyun.meteorologicalinterface.utils.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserService userService;

    @Autowired
    PrivilegeService privilegeService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RolePrivilegeService rolePrivilegeService;

    @Cacheable(value = "roleListCache", unless = "#result == null")
    public List<Role> getList() {
        RoleCriteria criteria = new RoleCriteria();
        RoleCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("role_desc asc");

        return roleMapper.selectByExample(criteria);
    }

    @Cacheable(value = "roleListCache", unless = "#result == null")
    public List<Role> getListFromIds(List<Integer> idList) {

        RoleCriteria criteria = new RoleCriteria();
        RoleCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("role_desc asc");

        criterion.andIdIn(idList);

        return roleMapper.selectByExample(criteria);
    }

    public List<Role> getList(List<UserRole> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        List<Integer> idList = new ArrayList<>();

        for (UserRole i : list) {
            idList.add(i.getRoleId());
        }

        return getListFromIds(idList);
    }

    @Cacheable(value = "roleListCache", unless = "#result == null")
    public List<Role> getList(Integer pageNum, Integer pageSize, String search, String category) {
        RoleCriteria criteria = new RoleCriteria();
        RoleCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("role_desc asc");

        if (search != null && search.trim() != "") {
            criterion.andRoleDescLike(StringUtils.escapeSQL(search.trim()));
        }

        return roleMapper.selectByExampleWithRowbounds(criteria, new RowBounds((pageNum - 1) * pageSize, pageSize));
    }

    public List<RoleWithInfos> getListWithInfos(Integer pageNum, Integer pageSize, String search, String category) {

        List<Role> infoList = getList(pageNum, pageSize, search, category);

        List<RoleWithInfos> resList = new ArrayList<RoleWithInfos>();
        for (Role i : infoList) {
            resList.add(new RoleWithInfos(i, userService.getList(userRoleService.getUserRolebyRoleId(i.getId())),
                    privilegeService.getList(rolePrivilegeService.getRolePrivilegebyRoleId(i.getId()))));
        }

        return resList;
    }

    @Cacheable(value = "roleListSizeCache", unless = "#result == null")
    public Long getListSize(String search, String category) {
        RoleCriteria criteria = new RoleCriteria();
        RoleCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("role_desc asc");

        if (search != null && search.trim() != "") {
            criterion.andRoleDescLike(StringUtils.escapeSQL(search.trim()));
        }

        Long size = roleMapper.countByExample(criteria);

        return size;
    }

    @Cacheable(value = "roleCache", key = "#id", unless = "#result == null")
    public Role getInfo(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public Role getRoleByName(String roleName) {
        RoleCriteria critera = new RoleCriteria();
        critera.createCriteria().andRoleNameEqualTo(roleName);
        List<Role> roleList = roleMapper.selectByExample(critera);
        if ((roleList != null) && (roleList.size() == 1)) return roleList.get(0);
        else return null;
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "roleListCache", allEntries = true),
            @CacheEvict(value = "roleListSizeCache", allEntries = true)
    })
    public void addInfo(Role role) {

        roleMapper.insert(role);
    }

    @Transactional
    public void addInfo(RoleWithInfos info) {
        List<User> users = new ArrayList<>();
        List<Privilege> privs = new ArrayList<>();

        addInfo(info.getRole());

        for (User i : info.getUsers()) {
            users.add(userService.getInfo(i.getId()));
        }
        for (Privilege j : info.getPrivs()) {
            privs.add(privilegeService.getInfo(j.getId()));
        }

        userRoleService.addInfos(info.getRole(), users);
        rolePrivilegeService.addInfos(info.getRole(), privs);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "roleCache", key = "#id"),
            @CacheEvict(value = "roleListCache", allEntries = true),
            @CacheEvict(value = "roleListSizeCache", allEntries = true)
    })
    public void delInfo(Integer id) {

        roleMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void delInfos(Integer id) {

        delInfo(id);
        userRoleService.delInfosByRole(id);
        rolePrivilegeService.delInfosByRole(id);
    }

    @Transactional
    public void delInfo(RoleWithInfos info) {

        delInfo(info.getRole().getId());

        userRoleService.delInfos(info.getRole());
        rolePrivilegeService.delInfos(info.getRole());
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "roleCache", key = "#role.id"),
            @CacheEvict(value = "roleListCache", allEntries = true),
            @CacheEvict(value = "roleListSizeCache", allEntries = true)
    })
    public void updateInfo(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);

    }

    @Transactional
    public void updateInfo(RoleWithInfos info) {
        List<User> users = new ArrayList<>();
        List<Privilege> privs = new ArrayList<>();

        updateInfo(info.getRole());

        for (User i : info.getUsers()) {
            users.add(userService.getInfo(i.getId()));
        }
        for (Privilege j : info.getPrivs()) {
            privs.add(privilegeService.getInfo(j.getId()));
        }

        userRoleService.updateInfos(info.getRole(), users);
        rolePrivilegeService.updateInfos(info.getRole(), privs);
    }
}
