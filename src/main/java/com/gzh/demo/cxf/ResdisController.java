package com.gzh.demo.cxf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class ResdisController {
	@Autowired
    private RedisTemplate<String,String> redisTemplate;
	
	@RequestMapping("getHashKey")
	public String getHashKey() {
		List<Object> values = redisTemplate.opsForHash().values("Truck:Truck::Cyclical");
        for(Object value : values){
            System.out.println("value======="+value);
        }
		return values.toString();
	}
}
