package com.gzh.demo;



import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootCxfApplicationTests {

	@Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void set(){
    	Map<Object, Object> map = redisTemplate.opsForHash().entries("Truck::Cyclical");
    	map.get("TRUCK100");
    	Map<Object, Object> map1 = redisTemplate.opsForHash().entries("DIG::BASE::EXCAVATOR");
    	//map1.get("TRUCK100");
    	System.out.println("map1:"+map1);
    }
    
}
