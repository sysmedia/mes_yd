package yude.mes.com.mes_yd.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author wangpw
 * @creat 2018-09-07-下午 2:47
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){

        RedisTemplate<Object,Object> template=new RedisTemplate<Object, Object>();

        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer valueSerializer=new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om=new ObjectMapper();

        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        valueSerializer.setObjectMapper(om);

        template.setValueSerializer(valueSerializer);

        template.setKeySerializer(new StringRedisSerializer());

        return  template;
    }

}
