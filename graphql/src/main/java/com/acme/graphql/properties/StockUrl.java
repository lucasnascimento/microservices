package com.acme.graphql.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("stock")
public class StockUrl extends UrlProperties{

}
