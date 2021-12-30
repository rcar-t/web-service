package rcar.samples.springbootmvc.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class HttpSecurityConfig(){

    @Configuration
    @Order(1)
    class ApiWebSecurityConfigurerAdapter: WebSecurityConfigurerAdapter()  {
        @Autowired private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder


        override fun configure(auth: AuthenticationManagerBuilder?) {
            super.configure(auth)
        }

        override fun configure(http: HttpSecurity) {
            http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/signup").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()

        }
    }

    @Configuration
    @Order(2)
    class FormLoginWebSecurityConfigurerAdapter:WebSecurityConfigurerAdapter() {
        override fun configure(auth: AuthenticationManagerBuilder?) {
            super.configure(auth)
        }

        override fun configure(http: HttpSecurity) {
            http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/user/signup").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()

        }
    }
}