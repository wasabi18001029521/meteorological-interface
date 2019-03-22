package cn.webyun.meteorologicalinterface;

import cn.webyun.meteorologicalinterface.mapper.UserMapper;
import cn.webyun.meteorologicalinterface.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeteorologicalInterfaceApplicationTests {
@Resource
    UserService userService;
@Resource
    UserMapper userMapper;
    @Test
    public void contextLoads() throws ParseException {
//        List<String> findusername1 = userMapper.findusername();
//        for(String attribute : findusername1) {
//            if(attribute.equals("admin")){
//
//            }
//            System.out.println(attribute);
//        }
    }




}
