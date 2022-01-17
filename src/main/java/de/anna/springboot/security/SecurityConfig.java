package de.anna.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());

        /* auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                    .withUser("anna")
                    .password("$2a$12$EEIqrTF5/RIHh2Z7IKnRxepWz2prXuaQ07aVtXfSkDFO1dOCG2EXi")
                    .roles("ADMIN")
                .and()
                    .withUser("robert")
                    .password("$2a$12$EEIqrTF5/RIHh2Z7IKnRxepWz2prXuaQ07aVtXfSkDFO1dOCG2EXi")
                    .roles("USER");
                    */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .antMatchers("/**/addkunde", "/**/addproduktstammdaten").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .logoutSuccessUrl("/");
    }
}
