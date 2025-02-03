package redis.embedded;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.embedded.RedisServer;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SpringDataConnectivityTest {

    private RedisServer redisServer;
    private RedisTemplate<String, String> template;
    private JedisConnectionFactory connectionFactory;

    @Before
    public void setUp() throws IOException {
        redisServer = new RedisServer(6381);
        redisServer.start();

        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration("localhost", 6381);
        JedisClientConfiguration jedisConfig = JedisClientConfiguration.builder().build();
        connectionFactory = new JedisConnectionFactory(redisConfig, jedisConfig);
        connectionFactory.afterPropertiesSet();

        template = new StringRedisTemplate();
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
    }

    @Test
    public void shouldBeAbleToUseSpringData() {
        template.opsForValue().set("foo", "bar");

        final String result = template.opsForValue().get("foo");

        assertEquals("bar", result);
    }

    @After
    public void tearDown() throws IOException {
        redisServer.stop();
    }

}
