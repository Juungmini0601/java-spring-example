package com.raon.example.kafka.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
	private String orderId;
	private String customerId;
	private List<OrderItem> items;
	private BigDecimal totalAmount;
	private LocalDateTime orderTime;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class OrderItem {
		private String productId;
		private int quantity;
		private BigDecimal price;
	}
}