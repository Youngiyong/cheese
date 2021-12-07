package com.cheese.oauth2resourceserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

    @Value("${jwt.public-key.path}")
    private String keyPath;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/api/v1/**").authenticated();
    }

    @Bean
    public TokenStore tokenStore() throws IOException {
        return new JwtTokenStore(accessTokenConverter());
    }

    private String getSigningKey() throws IOException {
        InputStream inputStream = resourceLoader.getResource(keyPath).getInputStream();
        return FileCopyUtils.copyToString(new InputStreamReader(inputStream));
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() throws IOException {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(getSigningKey());
        System.out.println(getSigningKey());
        return converter;
    }


}
