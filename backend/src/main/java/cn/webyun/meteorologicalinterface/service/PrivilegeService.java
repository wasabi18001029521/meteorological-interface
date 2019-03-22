package cn.webyun.meteorologicalinterface.service;

import cn.webyun.meteorologicalinterface.entity.Privilege;
import cn.webyun.meteorologicalinterface.entity.PrivilegeCriteria;
import cn.webyun.meteorologicalinterface.entity.RolePrivilege;
import cn.webyun.meteorologicalinterface.mapper.PrivilegeMapper;
import cn.webyun.meteorologicalinterface.utils.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeMapper privilegeMapper;

    @Cacheable(value = "privCache", unless = "#result == null")
    public Privilege getPrivByName(String privName) {
        PrivilegeCriteria critera = new PrivilegeCriteria();
        critera.createCriteria().andPrivNameEqualTo(privName);
        List<Privilege> privList = privilegeMapper.selectByExample(critera);
        if ((privList != null) && (privList.size() == 1)) return privList.get(0); else return null;
    }

    @Cacheable(value = "privListCache", unless = "#result == null")
    public List<Privilege> getList() {
        PrivilegeCriteria criteria = new PrivilegeCriteria();
        criteria.setOrderByClause("priv_desc asc");

        return privilegeMapper.selectByExample(criteria);
    }

    @Cacheable(value = "privListCache", unless = "#result == null")
    public List<Privilege> getListFromIds(List<Integer> idList) {

        PrivilegeCriteria criteria = new PrivilegeCriteria();
        PrivilegeCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("priv_desc asc");

        criterion.andIdIn(idList);

        return privilegeMapper.selectByExample(criteria);
    }

    public List<Privilege> getList(List<RolePrivilege> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        List<Integer> idList = new ArrayList<>();

        for( RolePrivilege i : list) {
            idList.add(i.getPrivId());
        }
        return getListFromIds(idList);
    }

    @Cacheable(value = "privListCache", unless = "#result == null")
    public List<Privilege> getList(Integer pageNum, Integer pageSize, String search, String category) {
        PrivilegeCriteria criteria = new PrivilegeCriteria();
        PrivilegeCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("priv_desc asc");

        if (search != null && search.trim() != "") {
            criterion.andPrivDescLike(StringUtils.escapeSQL(search.trim()));
        }

        return privilegeMapper.selectByExampleWithRowbounds(criteria, new RowBounds((pageNum - 1) * pageSize,pageSize));
    }

    @Cacheable(value = "privListSizeCache", unless = "#result == null")
    public Long getListSize(String search, String category) {
        PrivilegeCriteria criteria = new PrivilegeCriteria();
        PrivilegeCriteria.Criteria criterion = criteria.createCriteria();
        criteria.setOrderByClause("priv_desc asc");

        if (search != null && search.trim() != "") {
            criterion.andPrivDescLike(StringUtils.escapeSQL(search.trim()));
        }

        Long size = privilegeMapper.countByExample(criteria);

        return size;
    }

    @Cacheable(value = "privCache", key = "#id", unless = "#result == null")
    public Privilege getInfo(Integer id) {
        return privilegeMapper.selectByPrimaryKey(id);
    }

}
