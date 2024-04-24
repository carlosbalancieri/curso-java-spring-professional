package com.cursojavaspringprofessional.desafio01;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cursojavaspringprofessional.desafio01.entities.Order;
import com.cursojavaspringprofessional.desafio01.services.OrderService;


@SpringBootApplication
@ComponentScan({"com.cursojavaspringprofessional"})
public class Desafio01Application implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;	
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Code: ");
		Integer code = sc.nextInt();
		System.out.print("Basic Value: ");
		Double basic = sc.nextDouble();
		System.out.print("Discount: ");
		Double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		Double totalValue = orderService.total(order);
		
		System.out.println("Pedido código " + code);
		System.out.println("Valor total: " + totalValue);
		
	}

}
