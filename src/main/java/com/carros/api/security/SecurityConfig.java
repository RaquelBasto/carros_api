package com.carros.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true) // habilita a segurança por método
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService") //foram incontradas mais classes com mesmo nome, então vamos identificar pelo nome indicado nessa anotação
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
        //sobrescrevendo o metodo de segurança para deixar apenas o basic auth
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //obrigatório usar encoder para as senhas
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);

//        auth.inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("user").password(encoder.encode("user")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
//    }
    }
}
