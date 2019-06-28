package mantisrestaurante.com.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mantisrestaurante.com.br.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImplementacao userDetaisServiceImple;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/home").permitAll()
		.antMatchers("/sobre").permitAll()
		.antMatchers("/contato").permitAll()
		
		.antMatchers("/entrar").permitAll()
		.antMatchers("/entrar-gerente").permitAll()
		.antMatchers("/erro-login").permitAll()
		
		.antMatchers("/cadastrar").permitAll()
		.antMatchers("/cadastrar/usuario-cadastrado").permitAll()
		
		.antMatchers("/cardapio").permitAll()
		.antMatchers("/cardapio/entradas").permitAll()
		.antMatchers("/cardapio/frango").permitAll()
		.antMatchers("/cardapio/carne").permitAll()
		.antMatchers("/cardapio/peixes-e-camaroes").permitAll()
		.antMatchers("/cardapio/macarroes-e-arroz").permitAll()
		.antMatchers("/cardapio/sopas").permitAll()
		.antMatchers("/cardapio/sobremesas").permitAll()
		
		.antMatchers("/carrinho").permitAll()
		.antMatchers("/carrinho/adicionar-prato/{id}").permitAll()
		.antMatchers("/carrinho/remover-prato/{id}").permitAll()
		.antMatchers("/carrinho/prato/aumentar-quantidade/{id}").permitAll()
		.antMatchers("/carrinho/prato/diminuir-quantidade/{id}").permitAll()
		.antMatchers("/carrinho/vazio").permitAll()
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/entrar").defaultSuccessUrl("/cardapio").failureUrl("/erro-login").permitAll()
		
		.and()
		.logout()
		.logoutSuccessUrl("/home")
		.permitAll();
	}
	
	@Configuration
	@Order(1)
	public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	    public App1ConfigurationAdapter() {
	        super();
	    }
	 
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/area-gerente/*")
	        	.authorizeRequests()
	        	.anyRequest()
	        	.hasRole("GERENTE")
	           
	        	.and()
	        	.formLogin()
	        	.loginPage("/entrar")
	        	.defaultSuccessUrl("/cardapio")
	        	.failureUrl("/erro-login")
	           
	        	.and()
	        	.logout()
	        	.logoutSuccessUrl("/home")
	        	.deleteCookies("JSESSIONID")
	           
	        	.and()
	        	.exceptionHandling()
	        	.accessDeniedPage("/403")
	           
	        	.and()
	        	.csrf().disable();
	    }
	}
	
	@Configuration
	@Order(2)
	public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	 
	    public App2ConfigurationAdapter() {
	        super();
	    }
	 
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/meus-dados/*")
	          .authorizeRequests()
	          .anyRequest()
	          .hasRole("USER")
	           
	          .and()
	          .formLogin()
	          .loginPage("/entrar")
	          .defaultSuccessUrl("/cardapio")
	          .loginPage("/entrar")
	          .failureUrl("/erro-login")
	           
	          .and()
	          .logout()
	          .logoutSuccessUrl("/home")
	          .deleteCookies("JSESSIONID")
	           
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	           
	          .and()
	          .csrf().disable();
	    }
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetaisServiceImple).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override	
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**", "/imagens/**");
	}
}
