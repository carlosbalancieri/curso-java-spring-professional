package com.cursojavaspringprofessional.desafio01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursojavaspringprofessional.desafio01.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	public Double total(Order order) {
		
		if (order == null) return null;
		
		Double valorDoDesconto = getPercentualValue(order.getBasic(), order.getDiscount());		
		Double valorFrete;
		Double total;
				
		valorFrete = shippingService.shipment(order);
		total = order.getBasic() - valorDoDesconto + valorFrete;
		
		return total;
		
	}
	
	private Double getPercentualValue(Double basic, Double discount ) {
		return (basic * discount) / 100;
	}
	
}
