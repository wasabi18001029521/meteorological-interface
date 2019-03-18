package cn.webyun.meteorologicalinterface.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    // 用户注册
    @Insert("insert into user(username,password) values(#{username},#{password})")
    public int insertRegister(String username, String password);

    // 查询用户名
    @Select("select username from user")
    public List<String> selectUsername();


}
