package com.mycompany.camel.spring;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.SimpleBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyProcessor implements Processor {
	


protected AbstractApplicationContext createApplicationContext() {
	return new ClassPathXmlApplicationContext(
			"META-INF/spring/camel-context.xml");
}


public void process(Exchange exchange) throws Exception {
		System.out.println("exchange.toString(): " + exchange.toString());
		
		System.out.println("body ${body}");
		
		SimpleBuilder simple = new SimpleBuilder("${file:ext} contains 'pdf'");
		//SimpleBuilder simplePdf = new SimpleBuilder("${file:ext} contains 'xml'");
		
		CamelContext context = new DefaultCamelContext();
		if (simple.matches(exchange)) {
			System.out.println("message OK");
			
			//exchange.getIn()
		
		}if (simple.matches(exchange)) {
			
		}else {
			System.out.println("message KO");
		}
		
		/*	context.addRoutes(new RoutesBuilder() {				
		public void configure(){
			from("stream:in?promptMessage=Enter something:")
			.to("file:data/outbox?fileName=${date:now:yyyyMMdd-hh:mm:ss}.txt");
			
		}

		@Override
		public void addRoutesToCamelContext(CamelContext context)
				throws Exception {
			// TODO Auto-generated method stub
			
				}
			});
					
					*/
		
	}
}