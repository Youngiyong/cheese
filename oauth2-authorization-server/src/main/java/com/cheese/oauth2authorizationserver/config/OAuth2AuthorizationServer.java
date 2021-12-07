package com.cheese.oauth2authorizationserver.config;

import com.cheese.oauth2authorizationserver.service.AdminDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.util.FileCopyUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;

	@Autowired
    private DataSource ds;

	@Value("${jwt.private-key.path}")
	private String keyPath;

	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(ds);
	}
	
	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        		.tokenStore(tokenStore())
        		.accessTokenConverter(accessTokenConverter())
                .authenticationManager(authenticationManager)
				.userDetailsService(adminDetailsService);
    }

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(ds);
	}

	private String getSigningKey() throws IOException {
		InputStream inputStream = resourceLoader.getResource(keyPath).getInputStream();

		return FileCopyUtils.copyToString(new InputStreamReader(inputStream));
	}

//	@Bean
    public JwtAccessTokenConverter accessTokenConverter() throws IOException {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(getSigningKey());
//		converter.setVerifierKey(getSigningKey());
        return converter;
    }


}
