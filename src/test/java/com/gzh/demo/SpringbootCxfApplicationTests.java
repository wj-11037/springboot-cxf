package com.gzh.demo;



import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootCxfApplicationTests {

	@Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test1(){
    	Map<Object, Object> map = redisTemplate.opsForHash().entries("Truck::Cyclical");
    	map.get("TRUCK100");
    	Map<Object, Object> map1 = redisTemplate.opsForHash().entries("DIG::BASE::EXCAVATOR");
    	//map1.get("TRUCK100");
    	System.out.println("map1:"+map1);
    }
    
    @Test
    public void test2() {
    	String resquest="<request>" + 
				"	<initials>SJNK</initials>" + 
				"	<deviceId>GWI123</deviceId>" + 
				"</request>";

		// 创建动态客户端
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient("http://47.92.115.220:8081/test/HisService?wsdl");
		// 需要密码的情况需要加上用户名和密码
		//client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
		try {
			Object[] objects;
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("QueryDeptInfo", resquest);
			System.out.println("返回参数："+objects[0].toString());;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
}
