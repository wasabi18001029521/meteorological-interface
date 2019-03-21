package cn.webyun.meteorologicalinterface.mapper;

import cn.webyun.meteorologicalinterface.entity.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    // 用户注册
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public int insertRegister(String username, String password);

    // 查询用户名
    @Select("select username from user")
    public List<String> selectUsername();

    // 根据ID查询用户所有信息
    @Select("select * from user where id = #{id}")
    public UserDo selectUserId(Integer id);

    // 用户登录密码效验
    @Select("select password from user where username = #{username}")
    public String selectUserPassword(String username);

    // 根据用户名查询用户id
    @Select("select id from user where username = #{username}")
    public Integer selectUser(String username);

    // 通过用户名查找用户
    @Select("select username from user where username = #{username}")
    public UserDo selectFindUsername(String username);

    // 用户修改密码
    @Update("update user set password = #{password} where username = #{username};")
    public Integer updatePassword(String password,String username);

    // 用户名查询密码
    @Select("select password from user where username = #{username}")
    public String selectPassword(String username);
}
