//package redoing.imc;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class WebSecurityConfig {
//
////    @Autowired
////    private DataSource dataSource;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authz) -> {
//                            try {
//                                authz.requestMatchers("/home", "/home/**").permitAll()
//                                        .anyRequest().authenticated()
//                                        .and().formLogin(form -> form
//                                                .loginPage("/login")
//                                                .defaultSuccessUrl("/usuario/imc", true)
//                                                .permitAll())
//                                        .logout(logout -> {
//                                            logout.logoutUrl("/logout")
//                                                    .logoutSuccessUrl("/home");
//                                        })
//                                        .csrf().disable();
//                            } catch (Exception e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                )
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    //    public class SecurityConfiguration {
//    @Bean
//    public DataSource dataSource() {
////        return new EmbeddedDatabaseBuilder()
////                .setType(EmbeddedDatabaseType.H2)
////                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
////                .build();
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/imc");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("#12345678");
//        return dataSourceBuilder.build();
//    }
//
//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        return users;
//    }
//
////    @Bean
////    public UserDetailsManager users(DataSource dataSource) {
//////        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////
////        UserDetails user = User.builder()
////                .username("user")
////                .password(passwordEncoder().encode("password"))
////                .roles("USER")
////                .build();
////
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password(passwordEncoder().encode("password"))
////                .roles("USER", "ADMIN")
////                .build();
////
////        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
////        users.createUser(user);
////        users.createUser(admin);
////        return users;
////    }
//
//
//}