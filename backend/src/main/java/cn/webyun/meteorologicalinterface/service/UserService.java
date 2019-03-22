package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.Role;
import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.entity.UserCriteria;
import cn.webyun.meteorologicalinterface.entity.UserRole;
import cn.webyun.meteorologicalinterface.mapper.UserMapper;
import cn.webyun.meteorologicalinterface.message.request.UserInfoForm;
import cn.webyun.meteorologicalinterface.misc.UserWithRoles;
import cn.webyun.meteorologicalinterface.utils.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePrivilegeService rolePrivilegeService;

    /*@Cacheable(value = "userListCache")
    public List<User> getAllUsers() {
        return userMapper.selectByExample(null);
    }*/

    @Cacheable(value = "userListCache", unless = "#result == null")
    public List<User> getList() {
        UserCriteria criteria = new UserCriteria();
        criteria.setOrderByClause("user_name asc");

        return userMapper.selectByExample(criteria);
    }

    @Cacheable(value = "userListCache", unless = "#result == null")
    public List<User> getListFromIds(List<Integer> idList) {

        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("user_name asc");

        criterion.andIdIn(idList);

        return userMapper.selectByExample(criteria);
    }

    public List<User> getList(List<UserRole> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        List<Integer> idList = new ArrayList<>();

        for( UserRole i : list) {
            idList.add(i.getUserId());
        }

        return getListFromIds(idList);
    }

    @Cacheable(value = "userListCache", unless = "#result == null")
    public List<User> getList(Integer pageNum, Integer pageSize, String search, String category) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("user_full_name asc");

        if (search != null && search.trim() != "") {
            criterion.andUserFullNameLike(StringUtils.escapeSQL(search.trim()));
        }

        return userMapper.selectByExampleWithRowbounds(criteria, new RowBounds((pageNum - 1) * pageSize,pageSize));
    }

    public List<UserWithRoles> getListWithRoles(Integer pageNum, Integer pageSize, String search, String category) {

        List<User>  infoList = getList(pageNum, pageSize, search, category);

        List<UserWithRoles> resList = new ArrayList<UserWithRoles>();
        for(User i : infoList) {
            resList.add(new UserWithRoles(i,
                    roleService.getList(userRoleService.getUserRolebyUserId(i.getId()))));
        }

        return resList;
    }

    @Cacheable(value = "userListSizeCache", unless = "#result == null")
    public Long getListSize(String search, String category) {
        UserCriteria criteria = new UserCriteria();
        UserCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("user_full_name asc");

        if (search != null && search.trim() != "") {
            criterion.andUserFullNameLike(StringUtils.escapeSQL(search.trim()));
        }

        Long size = userMapper.countByExample(criteria);

        return size;
    }

    @Cacheable(value = "userIdCache", key = "#id", unless = "#result == null")
    public User getInfo(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Cacheable(value = "userNameCache", key = "#userName", unless = "#result == null")
    public User getUserByName(String userName) {
        UserCriteria critera = new UserCriteria();
        critera.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(critera);
        if ((userList != null) && (userList.size() == 1)) return userList.get(0); else return null;
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userListCache", allEntries = true),
            @CacheEvict(value = "userListSizeCache", allEntries = true)
    })
    public void addInfo(User user) {

        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userMapper.insert(user);
    }

    @Transactional
    public void addInfo(UserWithRoles info) {
        List<Role> roles = new ArrayList<>();

        User user = info.getUser();
        addInfo(user);

        for (Role i : info.getRoles()) {
            roles.add(roleService.getInfo(i.getId()));
        }

        userRoleService.addInfos(user, roles);

    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userIdCache", key = "#id"),
            @CacheEvict(value = "userNameCache", allEntries = true),
            @CacheEvict(value = "userListCache", allEntries = true),
            @CacheEvict(value = "userListSizeCache", allEntries = true)
    })
    public void delInfo(Integer id) {

        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void delInfos(Integer id) {

        delInfo(id);
        userRoleService.delInfosByUser(id);

    }

    @Transactional
    public void delInfo(UserWithRoles info) {

        delInfo(info.getUser().getId());

        userRoleService.delInfos(info.getUser());
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userIdCache", key = "#user.id"),
            @CacheEvict(value = "userNameCache", key = "#user.userName"),
            @CacheEvict(value = "userListCache", allEntries = true),
            @CacheEvict(value = "userListSizeCache", allEntries = true)
    })
    public void updateInfo(User user) {
        User u = getInfo(user.getId());
        if (! u.getUserPassword().equals(user.getUserPassword())) {
            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        }
        userMapper.updateByPrimaryKeySelective(user);

    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userListCache", allEntries = true),
            @CacheEvict(value = "userListSizeCache", allEntries = true),
            @CacheEvict(value = "userNameCache", key = "#info.user.userName"),
            @CacheEvict(value = "userIdCache", allEntries = true),
    })
    public void updateInfo(UserWithRoles info) {
        List<Role> roles = new ArrayList<>();


        User user = info.getUser();
        updateInfo(user);

        for (Role i : info.getRoles()) {
            roles.add(roleService.getInfo(i.getId()));
        }


        userRoleService.updateInfos(user, roles);

    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userListCache", allEntries = true),
            @CacheEvict(value = "userListSizeCache", allEntries = true),
            @CacheEvict(value = "userNameCache", key = "#info.username"),
            @CacheEvict(value = "userIdCache", allEntries = true),
    })
    public void updateUserInfo(UserInfoForm info) {
        UserCriteria critera = new UserCriteria();
        UserCriteria.Criteria criterion = critera.createCriteria();
        criterion.andUserNameEqualTo(info.getUsername());
        List<User> userList = userMapper.selectByExample(critera);
        if ((userList != null) && (userList.size() == 1)) {
            User user = userList.get(0);
            user.setUserFullName(info.getUserfullname());
            user.setEmail(info.getEmail());
            user.setAddress(info.getAddress());
            user.setPhone(info.getPhone());
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "userListCache", allEntries = true),
            @CacheEvict(value = "userListSizeCache", allEntries = true),
            @CacheEvict(value = "userNameCache", key = "#username"),
            @CacheEvict(value = "userIdCache", allEntries = true),
    })
    public void updateUserPassByName(String username, String npass) {
        UserCriteria critera = new UserCriteria();
        UserCriteria.Criteria criterion = critera.createCriteria();
        criterion.andUserNameEqualTo(username);
        List<User> userList = userMapper.selectByExample(critera);
        if ((userList != null) && (userList.size() == 1)) {
            User user = userList.get(0);
            user.setUserPassword(passwordEncoder.encode(npass));
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    public Boolean checkUserPassByName(String username, String opass) {
        User user = getUserByName(username);
        if (user != null) {
            if (passwordEncoder.matches(opass, user.getUserPassword())) {
                return true;
            }
        }
        return false;
    }

}
