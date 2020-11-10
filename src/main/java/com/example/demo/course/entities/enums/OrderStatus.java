package com.example.demo.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2), 
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static OrderStatus orderValue(int value) {
		for (OrderStatus valueCode : OrderStatus.values()) {
			if (valueCode.getCode() == value) {
				return valueCode;
			}
		}
		throw new IllegalArgumentException("Invalid OrdersStatus code");
	}
}
