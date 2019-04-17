package cn.webyun.meteorologicalinterface.controller;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


@Component
public class RedisKeyVolit implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获得请求参数的key
        String key = request.getParameter("key");
        System.out.println("请求参数的key" + key);

        //获取redis中的Key
        if (redisTemplate.opsForValue().get(key) == null) {

            System.out.println("获取redis中的Key" + redisTemplate.opsForValue().get(key));
            JSONObject jsonObject = new JSONObject();
            PrintWriter out = null;
            response.setStatus(401);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            jsonObject.put("errorCode", "401");
            jsonObject.put("errorInfo", "redis中判断的权限异常");
            out = response.getWriter();
            out.println(jsonObject);
            return false;
        } else {
            //如果不为空，通过key取出value
            //遍历这个value中的Lis找到对应的产品
            //取出有效期，
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
