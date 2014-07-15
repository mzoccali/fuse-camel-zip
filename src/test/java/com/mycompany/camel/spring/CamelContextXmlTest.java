/**
 * 
 */
package com.mycompany.camel.spring;

import static org.junit.Assert.*;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mzo
 *
 */
public class CamelContextXmlTest extends CamelSpringTestSupport {

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				"META-INF/spring/camel-context.xml");
	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}


	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCamelRoute() throws Exception {
		// Create routes from the output endpoints to our mock endpoints so we can assert expectations
		context.start();

		// Validate our expectations
		assertMockEndpointsSatisfied();
	}

	
/*
	// TODO Create test message bodies that work for the route(s) being tested
	// Expected message bodies
	protected Object[] expectedBodies = {
			"<something id='1'>expectedBody1</something>",
			"<something id='2'>expectedBody2</something>" };
	// Templates to send to input endpoints
	@Produce(uri = "file:src/data?noop=true")
	protected ProducerTemplate inputEndpoint;
	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:output")
	protected MockEndpoint outputEndpoint;
	@EndpointInject(uri = "mock:output2")
	protected MockEndpoint output2Endpoint;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}


	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCamelRoute() throws Exception {
		// Create routes from the output endpoints to our mock endpoints so we can assert expectations
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() throws Exception {
				from("file:target/messages/others").to(output2Endpoint);
				from("file:target/messages/uk").to(outputEndpoint);
			}
		});

		// Define some expectations

		// TODO Ensure expectations make sense for the route(s) we're testing
		output2Endpoint.expectedBodiesReceivedInAnyOrder(expectedBodies);

		// Send some messages to input endpoints
		for (Object expectedBody : expectedBodies) {
			inputEndpoint.sendBody(expectedBody);
		}

		// Validate our expectations
		assertMockEndpointsSatisfied();
	}

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				"META-INF/spring/camel-context.xml");
	}
*/
}
