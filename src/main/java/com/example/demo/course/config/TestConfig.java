package com.example.demo.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.course.entities.Category;
import com.example.demo.course.entities.Order;
import com.example.demo.course.entities.OrderItem;
import com.example.demo.course.entities.Payment;
import com.example.demo.course.entities.Product;
import com.example.demo.course.entities.User;
import com.example.demo.course.entities.enums.OrderStatus;
import com.example.demo.course.repositories.CategoryRepository;
import com.example.demo.course.repositories.OrderItemRepository;
import com.example.demo.course.repositories.OrderRepository;
import com.example.demo.course.repositories.ProductRepository;
import com.example.demo.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "SmartTv", "Nulla eu imperdiet purus. Maacenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nan eleifend maximus tortor, at mollis.", 2190.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 2190.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Crass fringilla convallis sem vel faucibus.", 2190.0, "");

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		User u1 = new User(null, "Bob", "bob@gmail.com", "954425486", "F3443ff");
		User u2 = new User(null, "Maria", "maria@gmail.com", "943546543", "H435543");

		Order order1 = new Order(null, Instant.parse("2020-12-25T23:15:45Z"), OrderStatus.CANCELED, u1);
		Order order2 = new Order(null, Instant.parse("2020-11-25T13:15:45Z"), OrderStatus.DELIVERED, u2);
		Order order3 = new Order(null, Instant.parse("2020-11-23T05:45:23Z"), OrderStatus.SHIPPED, u1);

		OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(order3, p5, 2, p5.getPrice());

		Payment pay1 = new Payment(null, Instant.parse("2020-12-27T13:14:12Z"), order1);
		order1.setPayment(pay1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// save with composition;
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		orderRepository.save(order1);
	}
}
