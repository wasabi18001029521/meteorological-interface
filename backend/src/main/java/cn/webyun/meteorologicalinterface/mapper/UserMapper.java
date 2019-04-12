package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.User;
import cn.webyun.meteorologicalinterface.entity.UserCriteria;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface UserMapper {
    @SelectProvider(type = UserSqlProvider.class, method = "countByExample")
    long countByExample(UserCriteria example);

    @DeleteProvider(type = UserSqlProvider.class, method = "deleteByExample")
    int deleteByExample(UserCriteria example);

    @Delete({
            "delete from sys_users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into sys_users (user_name, user_full_name, ",
            "user_password, unit_id, ",
            "unit_name, unit_full_name, ",
            "account_expired, account_locked, ",
            "password_expired, account_enabled, ",
            "email, address, ",
            "phone)",
            "values (#{userName,jdbcType=VARCHAR}, #{userFullName,jdbcType=VARCHAR}, ",
            "#{userPassword,jdbcType=VARCHAR}, #{unitId,jdbcType=INTEGER}, ",
            "#{unitName,jdbcType=VARCHAR}, #{unitFullName,jdbcType=VARCHAR}, ",
            "#{accountExpired,jdbcType=INTEGER}, #{accountLocked,jdbcType=INTEGER}, ",
            "#{passwordExpired,jdbcType=INTEGER}, #{accountEnabled,jdbcType=INTEGER}, ",
            "#{email,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
            "#{phone,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User record);

    @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSelective(User record);

    @SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_full_name", property = "userFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "unit_id", property = "unitId", jdbcType = JdbcType.INTEGER),
            @Result(column = "unit_name", property = "unitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "unit_full_name", property = "unitFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "account_expired", property = "accountExpired", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_locked", property = "accountLocked", jdbcType = JdbcType.INTEGER),
            @Result(column = "password_expired", property = "passwordExpired", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_enabled", property = "accountEnabled", jdbcType = JdbcType.INTEGER),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR)
    })
    List<User> selectByExampleWithRowbounds(UserCriteria example, RowBounds rowBounds);

    @SelectProvider(type = UserSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_full_name", property = "userFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "unit_id", property = "unitId", jdbcType = JdbcType.INTEGER),
            @Result(column = "unit_name", property = "unitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "unit_full_name", property = "unitFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "account_expired", property = "accountExpired", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_locked", property = "accountLocked", jdbcType = JdbcType.INTEGER),
            @Result(column = "password_expired", property = "passwordExpired", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_enabled", property = "accountEnabled", jdbcType = JdbcType.INTEGER),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserCriteria example);

    @Select({
            "select",
            "id, user_name, user_full_name, user_password, unit_id, unit_name, unit_full_name, ",
            "account_expired, account_locked, password_expired, account_enabled, email, address, ",
            "phone",
            "from sys_users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_full_name", property = "userFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_password", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "unit_id", property = "unitId", jdbcType = JdbcType.INTEGER),
            @Result(column = "unit_name", property = "unitName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "unit_full_name", property = "unitFullName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "account_expired", property = "accountExpired", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_locked", property = "accountLocked", jdbcType = JdbcType.INTEGER),
            @Result(column = "password_expired", property = "passwordExpired", jdbcType = JdbcType.INTEGER),
            @Result(column = "account_enabled", property = "accountEnabled", jdbcType = JdbcType.INTEGER),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
            "update sys_users",
            "set user_name = #{userName,jdbcType=VARCHAR},",
            "user_full_name = #{userFullName,jdbcType=VARCHAR},",
            "user_password = #{userPassword,jdbcType=VARCHAR},",
            "unit_id = #{unitId,jdbcType=INTEGER},",
            "unit_name = #{unitName,jdbcType=VARCHAR},",
            "unit_full_name = #{unitFullName,jdbcType=VARCHAR},",
            "account_expired = #{accountExpired,jdbcType=INTEGER},",
            "account_locked = #{accountLocked,jdbcType=INTEGER},",
            "password_expired = #{passwordExpired,jdbcType=INTEGER},",
            "account_enabled = #{accountEnabled,jdbcType=INTEGER},",
            "email = #{email,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    @Select("select user_name from sys_users where user_name = #{username}")
    String selectUsername(String username);


    @Insert("insert into sys_users (user_name,user_password,user_key,user_register,user_effective) values(#{username,jdbcType=VARCHAR}," +
            "#{password,jdbcType=VARCHAR},#{md5username,jdbcType=VARCHAR},#{dateFormat,jdbcType=VARCHAR},#{dateFormat,jdbcType=VARCHAR})")
    int insertUser(String username, String password, String md5username, String dateFormat);

    @Select("select id from sys_users where user_name = #{username}")
    int selectId(String username);

    @Insert("insert into sys_user_interface (user_id,interface_id) values (#{id},#{interfaceId})")
    int insertId(int id, int interfaceId);

    @Insert("update sys_users set user_login=(#{dateFormat}) where user_name = #{username}")
    int updateTime(String dateFormat, String username);

    @Select("select id,user_name,user_register,user_login,user_key from sys_users where user_name = #{userNameFromJwtToken}")
    User selectUser(String userNameFromJwtToken);

    @Select("select user_effective from sys_users where user_key = #{key}")
    String selectEffective(String key);

    @Select("select user_password from sys_users where user_name = #{username}")
    String selectPassword(String username);

    @Update("update sys_users set user_password = #{checkPass} where user_name = #{usernmae} ")
    int updatePassword(String checkPass, String usernmae);
}
