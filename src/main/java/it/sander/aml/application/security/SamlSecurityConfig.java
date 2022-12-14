package it.sander.aml.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		 securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
@Profile("saml")
public class SamlSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Value("${saml.sp}")
    private String samlAudience;

    @Autowired
    @Qualifier("saml")
    private SavedRequestAwareAuthenticationSuccessHandler samlAuthSuccessHandler;

    @Autowired
    @Qualifier("saml")
    private SimpleUrlAuthenticationFailureHandler samlAuthFailureHandler;
/*
    @Autowired
    private SAMLEntryPoint samlEntryPoint;

    @Autowired
    private SAMLLogoutFilter samlLogoutFilter;

    @Autowired
    private SAMLLogoutProcessingFilter samlLogoutProcessingFilter;

    @Bean
    public SAMLDiscovery samlDiscovery() {
        SAMLDiscovery idpDiscovery = new SAMLDiscovery();
        return idpDiscovery;
    }

    @Autowired
    private SAMLAuthenticationProvider samlAuthenticationProvider;

    @Autowired
    private ExtendedMetadata extendedMetadata;

    @Autowired
    private KeyManager keyManager;

    public MetadataGenerator metadataGenerator() {
        MetadataGenerator metadataGenerator = new MetadataGenerator();
        metadataGenerator.setEntityId(samlAudience);
        metadataGenerator.setExtendedMetadata(extendedMetadata);
        metadataGenerator.setIncludeDiscoveryExtension(false);
        metadataGenerator.setKeyManager(keyManager);
        return metadataGenerator;
    }

    @Bean
    public SAMLProcessingFilter samlWebSSOProcessingFilter() throws Exception {
        SAMLProcessingFilter samlWebSSOProcessingFilter = new SAMLProcessingFilter();
        samlWebSSOProcessingFilter.setAuthenticationManager(authenticationManager());
        samlWebSSOProcessingFilter.setAuthenticationSuccessHandler(samlAuthSuccessHandler);
        samlWebSSOProcessingFilter.setAuthenticationFailureHandler(samlAuthFailureHandler);
        return samlWebSSOProcessingFilter;
    }

    @Bean
    public FilterChainProxy samlFilter() throws Exception {
        List<SecurityFilterChain> chains = new ArrayList<>();
        chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/SSO/**"),
            samlWebSSOProcessingFilter()));
        chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/discovery/**"),
            samlDiscovery()));
        chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/login/**"),
            samlEntryPoint));
        chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/logout/**"),
            samlLogoutFilter));
        chains.add(new DefaultSecurityFilterChain(new AntPathRequestMatcher("/saml/SingleLogout/**"),
            samlLogoutProcessingFilter));
        return new FilterChainProxy(chains);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public MetadataGeneratorFilter metadataGeneratorFilter() {
        return new MetadataGeneratorFilter(metadataGenerator());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf()
        .disable();

        http
        .httpBasic()
        .authenticationEntryPoint(samlEntryPoint);

        http
        .addFilterBefore(metadataGeneratorFilter(), ChannelProcessingFilter.class)
        .addFilterAfter(samlFilter(), BasicAuthenticationFilter.class)
        .addFilterBefore(samlFilter(), CsrfFilter.class);

        http
        .authorizeRequests()
        .antMatchers("/", "/css/**", "/webjars/**", "/js/**", "/images/**").permitAll()
        .anyRequest().authenticated();

        http
        .logout()
        .addLogoutHandler((request, response, authentication) -> {
            try {
                response.sendRedirect("/saml/logout");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(samlAuthenticationProvider);
    }
*/
}
