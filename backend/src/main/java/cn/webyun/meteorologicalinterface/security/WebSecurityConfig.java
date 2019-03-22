package cn.webyun.meteorologicalinterface.security;

import java.util.ArrayList;
import java.util.Collection;

import cn.webyun.meteorologicalinterface.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationProvider provider;// 自定义的AuthenticationProvider

    @Bean
    public PasswordEncoder myPasswordEncoder() {
        return new MyPasswordEncoder();//自定义的加密工具
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/weather/login", "/weather/hello").permitAll()
                .anyRequest().authenticated()
                .and()
                //.formLogin().loginProcessingUrl("weather/hello")
                //.and()
                .csrf().disable()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));

      /*  http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login.html")      // 设置登录页面
                .loginProcessingUrl("/user/login") // 自定义的登录接口
                .and()
                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html").permitAll()   // 设置所有人都可以访问登录页面
                .anyRequest()        // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();     // 关闭csrf防护*/
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JwtUser jwtUser = new JwtUser();
        String username1 = jwtUser.getUsername();
        String password = jwtUser.getPassword();
        InMemoryUserDetailsManager iud = new InMemoryUserDetailsManager();
        Collection<GrantedAuthority> adminAuth = new ArrayList<>();
        adminAuth.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        iud.createUser(new User("user", "123", adminAuth));
        return iud;
    }

}
