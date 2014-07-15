package com.mycompany.camel.spring;
import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessorStep3 implements Processor {
	

public void process(Exchange exchange) throws Exception {
	System.out.println("MyProcessorStep3");
 	String body = exchange.getIn().getBody(String.class);
 	System.out.println("MyProcessorStep3 BODY: "+ body);
 	// change the message to say Hello
 	System.out.println("MyProcessorStep3 Headers: " + exchange.getIn().getHeaders());

 	//File file = (File)exchange.getIn().getHeader("FILE1");
 	
 	//System.out.println("HEADER1:" + file.getName() + "-" + file);
 	
 	// copy headers from IN to OUT to propagate them
 	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
 	// 	copy attachements from IN to OUT to propagate them
 	exchange.getOut().setAttachments(exchange.getIn().getAttachments());

		
	}
}