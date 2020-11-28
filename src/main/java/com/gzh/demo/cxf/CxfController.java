package com.gzh.demo.cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CxfController {
	
	public static void main(String[] args) {
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
