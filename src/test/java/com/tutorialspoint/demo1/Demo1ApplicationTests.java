package com.tutorialspoint.demo1;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tutorialspoint.demo1.service.OrderService;
import com.tutorialspoint.demo1.service.ProductService;


@SpringBootTest
@ActiveProfiles("test")
class Demo1ApplicationTests {

	 @Autowired
	   private OrderService orderService;

	   @Autowired
	   private ProductService productService;

	   @Test
	   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
	      Mockito.when(productService.getProductName()).thenReturn("Mock Product Name");
	      String testName = orderService.getProductName();

	      assertEquals("Mock Product Name", testName);
	   }

}
