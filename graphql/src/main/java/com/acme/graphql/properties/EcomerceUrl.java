package com.acme.graphql.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("ecommerce")
public class EcomerceUrl  extends UrlProperties{

}
