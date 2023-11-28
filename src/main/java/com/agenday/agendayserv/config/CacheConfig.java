package com.agenday.agendayserv.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


import java.time.Duration;


@Configuration
@EnableCaching
public class CacheConfig {


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName("ohio-redis.render.com");
        redisConfig.setPort(6379);
        redisConfig.setPassword("kyDohZksWGdBU4KfRelqage7qUM146bx");
        redisConfig.setUsername("red-cliujf9b2fgs73faq6lg");
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfig = JedisClientConfiguration.builder();
        jedisClientConfig.connectTimeout(Duration.ofSeconds(60));
        jedisClientConfig.useSsl();


        return new JedisConnectionFactory(redisConfig, jedisClientConfig.build());
    }


    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(2));


        return RedisCacheManager.builder(jedisConnectionFactory())
                .cacheDefaults(config)
                .build();
    }
}
