package com.mycompany.camel.spring;
import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

public class MyProcessorStep1 implements Processor {
	

public void process(Exchange exchange) throws Exception {
		System.out.println("MyProcessorStep1");
	 	String body = exchange.getIn().getBody(String.class);
	 	System.out.println("MyProcessorStep1 BODY: "+ body);
	 	// change the message to say Hello
	 	System.out.println("MyProcessorStep1 Headers: " + exchange.getIn().getHeaders());
	 	//CamelFileName
	 	//GenericFile genericFile = (GenericFile)exchange.getIn().getBody();
	 	//File file = new File(genericFile.getAbsoluteFilePath());
	 	exchange.getOut().setHeader("FILE1", exchange.getIn().getHeader("CamelFileName"));
	 	// copy headers from IN to OUT to propagate them
	 	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
	 	// 	copy attachements from IN to OUT to propagate them
	 	exchange.getOut().setAttachments(exchange.getIn().getAttachments());
	
		
	}
}