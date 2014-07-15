package com.mycompany.camel.spring;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessorStep2 implements Processor {
	

public void process(Exchange exchange) throws Exception {
	System.out.println("MyProcessorStep2");
 	String body = exchange.getIn().getBody(String.class);
 	System.out.println("MyProcessorStep2 BODY: "+ body);
 	// change the message to say Hello
 	System.out.println("MyProcessorStep2 Headers: " + exchange.getIn().getHeaders());
 	exchange.getOut().setBody("MyProcessorStep2" + body);
 	// copy headers from IN to OUT to propagate them
 	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
 	// 	copy attachements from IN to OUT to propagate them
 	exchange.getOut().setAttachments(exchange.getIn().getAttachments());

		
	}
}