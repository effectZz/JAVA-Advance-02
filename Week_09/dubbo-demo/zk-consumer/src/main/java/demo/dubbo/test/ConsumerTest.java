package demo.dubbo.test;

import demo.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
		ctx.start();
		System.out.println("启动成功");
		DemoService demo = (DemoService) ctx.getBean("demoService");
		String sayhello = demo.sayhello("world");
		System.out.println(sayhello);
	}
}
