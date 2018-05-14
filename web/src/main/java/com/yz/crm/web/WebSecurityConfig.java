//package com.yz.crm.web;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        /**httpSecurity
//                .authorizeRequests()
//                    //我们指定了任何用户都可以访问的多个网址格式。具体来说，如果URL以“/ resources /”开头，等于“/ signup”或等于“/ about”，则任何用户都可以访问请求。
//                    .antMatchers("/user/index").permitAll()
//                    //任何以“/ admin /”开头的网址都将限制为具有“ROLE_ADMIN”角色的用户。您会注意到，由于我们正在调用该hasRole方法，我们不需要指定“ROLE_”前缀。
//                    .antMatchers("/admin/**").hasRole("ADMIN")
//                    //任何以“/ db /”开头的URL都需要用户同时拥有“ROLE_ADMIN”和“ROLE_DBA”。你会注意到，因为我们正在使用hasRole表达式，所以我们不需要指定“ROLE_”前缀。
//                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//                    //确保对我们应用程序的任何请求都要求用户进行身份验证
//                    .anyRequest().authenticated()
//                .and()
//                //允许用户使用基于表单的登录进行身份验证
//                .formLogin()
//                    //更新的配置指定登录页面的位置
//                    .loginPage("/user/index")
//                    .failureUrl("/error")
//                    //我们必须授予所有用户（即未经身份验证的用户）访问我们的登录页面。该formLogin().permitAll()方法允许所有用户访问与基于表单的登录相关的所有URL
//                    .permitAll()
//                .and()
//                .logout()
//                    .permitAll()
//                .and()
//                //允许用户使用HTTP基本认证进行认证
//                .httpBasic()
//                .and()
//                .logout()
//                    .logoutUrl("/user/logout")
//                    .logoutSuccessUrl("/user/index")
//                .and()
//                .oauth2Login();
//        ;**/
//
//
//        httpSecurity.authorizeRequests()
//                .anyRequest().authenticated() //4
//                .antMatchers("/user/*").permitAll()
//                .and()
//                .formLogin()
//                    .loginPage("/index.html")
//                    .failureUrl("/login?error")
//                    .permitAll() //5
//                .and()
//                .logout().permitAll(); //6
//    }
//
//    /**
//     * 确保配置得到提取
//     * 自动为应用程序中的每个URL注册springSecurityFilterChain过滤器
//     * 添加一个加载WebSecurityConfig的ContextLoaderListener
//     */
////    public WebSecurityConfig() {
////        super(WebSecurityConfig.class);
////    }
//}
