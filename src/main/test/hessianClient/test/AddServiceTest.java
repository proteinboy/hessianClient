package hessianClient.test;

import java.net.MalformedURLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caucho.hessian.client.HessianProxyFactory;
import com.tmh.hessian.service.AddService;
import com.tmh.hessian.service.TokenGenerator;

public class AddServiceTest {
	

	@Test
	public void test() {
		//spring配置文件获取方式
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");   
		AddService addService = (AddService)context.getBean("addService");  
		TokenGenerator tokenGenerator = (TokenGenerator)context.getBean("tokenGenerator");  
		
		String token = tokenGenerator.generatorToken("tmh");
		
		System.out.println("token:" + token);
		
		int r = addService.add(4, 5,token);
		System.out.println("The result is " + r);
		
		//无配置文件获取方式
//		String url = "http://localhost:8080/hessianService/addService.hessian";
//		System.out.println(url);
//		HessianProxyFactory factory = new HessianProxyFactory();
//		
//		/**tomcat  配置文件下tomcat-users.xml
//		 *  <role rolename="Hessian"/>
//		 *  <user username="Hessianuser" password="password" roles="Hessian"/>
//		 *  web.xml进行权限配置
//		 */
//		factory.setUser("HessianUser");
//		factory.setPassword("password");
//		AddService addService;
//		try {
//			addService = (AddService) factory.create(AddService.class, url);
//			int r = addService.add(4, 5);
//			System.out.println("The result is " + r);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
