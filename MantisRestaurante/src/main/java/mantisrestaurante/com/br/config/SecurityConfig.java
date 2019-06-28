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
		.antMatchers("/erro-login").permitAll()
		
		.antMatchers("/meus-dados/cadastro").permitAll()
		.antMatchers("/meus-dados/usuario-cadastrado").permitAll()
		
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
		
		.antMatchers("/meus-dados/editar/{id}").hasRole("USER")
		.antMatchers("/meus-dados/pedido").permitAll()
		.antMatchers("/meus-dados/pedido/salvar-endereco").permitAll()
		.antMatchers("/meus-dados/pedido/realizar-pedido/{id}").permitAll()
		.antMatchers("/meus-dados/pedido/meus-pedidos").permitAll()
				/*
				 * .antMatchers("/area-gerente/cardapio").hasRole("GERENTE")
				 * .antMatchers("/area-gerente/cardapio/entradas").permitAll()
				 * .antMatchers("/area-gerente/cardapio/frango").permitAll()
				 * .antMatchers("/area-gerente/cardapio/carne").permitAll()
				 * .antMatchers("/area-gerente/cardapio/peixes-e-camaroes").permitAll()
				 * .antMatchers("/area-gerente/cardapio/macarroes-e-arroz").permitAll()
				 * .antMatchers("/area-gerente/cardapio/sopas").permitAll()
				 * .antMatchers("/area-gerente/cardapio/sobremesas").permitAll()
				 * .antMatchers("/area-gerente/cadastrar-pratos").permitAll()
				 * .antMatchers("/area-gerente/cadastrar-pratos/confirmacao").permitAll()
				 */
		
		.anyRequest().authenticated()
		
		.and() 
		
		.formLogin()
		.loginPage("/entrar").defaultSuccessUrl("/cardapio").permitAll()
		.loginPage("/entrar").failureUrl("/erro-login").permitAll()

		.and()
		.logout()
		.logoutSuccessUrl("/entrar?sair").logoutSuccessUrl("/home").permitAll()
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
	        	.loginPage("/entrar").defaultSuccessUrl("/area-gerente/cardapio")
	        	.loginPage("/entrar").failureUrl("/erro-login")
	           
	        	.and()
	        	.logout()
	        	.logoutUrl("/entrar?sair")
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
	          .loginPage("/entrar").defaultSuccessUrl("/area-gerente/cardapio")
	          .loginPage("/entrar").failureUrl("/erro-login")
	           
	          .and()
	          .logout()
	          .logoutUrl("/entrar?sair")
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
