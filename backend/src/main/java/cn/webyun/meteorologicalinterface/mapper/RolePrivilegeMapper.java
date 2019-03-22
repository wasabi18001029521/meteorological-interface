package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.RolePrivilege;
import cn.webyun.meteorologicalinterface.entity.RolePrivilegeCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RolePrivilegeMapper {
    @SelectProvider(type=RolePrivilegeSqlProvider.class, method="countByExample")
    long countByExample(RolePrivilegeCriteria example);

    @DeleteProvider(type=RolePrivilegeSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolePrivilegeCriteria example);

    @Delete({
        "delete from sys_role_privilege",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role_privilege (role_id, role_name, ",
        "role_desc, priv_id, ",
        "priv_name, priv_desc)",
        "values (#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleDesc,jdbcType=VARCHAR}, #{privId,jdbcType=INTEGER}, ",
        "#{privName,jdbcType=VARCHAR}, #{privDesc,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(RolePrivilege record);

    @InsertProvider(type=RolePrivilegeSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(RolePrivilege record);

    @SelectProvider(type=RolePrivilegeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_desc", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_id", property="privId", jdbcType=JdbcType.INTEGER),
        @Result(column="priv_name", property="privName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_desc", property="privDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<RolePrivilege> selectByExampleWithRowbounds(RolePrivilegeCriteria example, RowBounds rowBounds);

    @SelectProvider(type=RolePrivilegeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_desc", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_id", property="privId", jdbcType=JdbcType.INTEGER),
        @Result(column="priv_name", property="privName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_desc", property="privDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<RolePrivilege> selectByExample(RolePrivilegeCriteria example);

    @Select({
        "select",
        "id, role_id, role_name, role_desc, priv_id, priv_name, priv_desc",
        "from sys_role_privilege",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_desc", property="roleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_id", property="privId", jdbcType=JdbcType.INTEGER),
        @Result(column="priv_name", property="privName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_desc", property="privDesc", jdbcType=JdbcType.VARCHAR)
    })
    RolePrivilege selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RolePrivilegeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeCriteria example);

    @UpdateProvider(type=RolePrivilegeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolePrivilege record, @Param("example") RolePrivilegeCriteria example);

    @UpdateProvider(type=RolePrivilegeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolePrivilege record);

    @Update({
        "update sys_role_privilege",
        "set role_id = #{roleId,jdbcType=INTEGER},",
          "role_name = #{roleName,jdbcType=VARCHAR},",
          "role_desc = #{roleDesc,jdbcType=VARCHAR},",
          "priv_id = #{privId,jdbcType=INTEGER},",
          "priv_name = #{privName,jdbcType=VARCHAR},",
          "priv_desc = #{privDesc,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RolePrivilege record);
}
