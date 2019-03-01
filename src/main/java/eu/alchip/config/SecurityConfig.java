package eu.alchip.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { //implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    //pass hashed is secret123
    private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String methodName = "configure";
        logger.debug(methodName, "leggendo configure (AuthenticationManagerBuilder auth)");

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, active " +
                         "from AppUser where username = ?")
                .authoritiesByUsernameQuery("select username, authority " +
                        "from appuser " +
                        "where username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String methodName = "configure";
        logger.debug(methodName, "leggendo configure (HttpSecurity http)");

        http
                .authorizeRequests()
                    .antMatchers("/*", "/resources/**").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll();

        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
               // .logoutSuccessHandler(logoutSuccessHandler)
                .invalidateHttpSession(true)
                //.addLogoutHandler(logoutHandler)
                .deleteCookies("JSESSIONID");
    }

}
