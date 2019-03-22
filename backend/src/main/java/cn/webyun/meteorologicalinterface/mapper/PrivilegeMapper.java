package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.Privilege;
import cn.webyun.meteorologicalinterface.entity.PrivilegeCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PrivilegeMapper {
    @SelectProvider(type=PrivilegeSqlProvider.class, method="countByExample")
    long countByExample(PrivilegeCriteria example);

    @DeleteProvider(type=PrivilegeSqlProvider.class, method="deleteByExample")
    int deleteByExample(PrivilegeCriteria example);

    @Delete({
        "delete from sys_privileges",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_privileges (priv_name, priv_desc)",
        "values (#{privName,jdbcType=VARCHAR}, #{privDesc,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(Privilege record);

    @InsertProvider(type=PrivilegeSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(Privilege record);

    @SelectProvider(type=PrivilegeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="priv_name", property="privName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_desc", property="privDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<Privilege> selectByExampleWithRowbounds(PrivilegeCriteria example, RowBounds rowBounds);

    @SelectProvider(type=PrivilegeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="priv_name", property="privName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_desc", property="privDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<Privilege> selectByExample(PrivilegeCriteria example);

    @Select({
        "select",
        "id, priv_name, priv_desc",
        "from sys_privileges",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="priv_name", property="privName", jdbcType=JdbcType.VARCHAR),
        @Result(column="priv_desc", property="privDesc", jdbcType=JdbcType.VARCHAR)
    })
    Privilege selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PrivilegeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Privilege record, @Param("example") PrivilegeCriteria example);

    @UpdateProvider(type=PrivilegeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Privilege record, @Param("example") PrivilegeCriteria example);

    @UpdateProvider(type=PrivilegeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Privilege record);

    @Update({
        "update sys_privileges",
        "set priv_name = #{privName,jdbcType=VARCHAR},",
          "priv_desc = #{privDesc,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Privilege record);
}
