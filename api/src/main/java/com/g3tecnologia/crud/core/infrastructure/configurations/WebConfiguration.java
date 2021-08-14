package com.g3tecnologia.crud.core.infrastructure.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class  WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("classpath:.home/volumes/spring_storage")
                .setCachePeriod(0);
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // TODO Auto-generated method stub
//        super.configure(auth);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET, "api/**").permitAll()
//                .antMatchers(HttpMethod.POST, "api/**").permitAll()
//                .antMatchers(HttpMethod.PUT, "api/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "api/**").permitAll()
//                .and()
//               // .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//              //  .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
//
//        http.csrf().disable();
//    }

}
