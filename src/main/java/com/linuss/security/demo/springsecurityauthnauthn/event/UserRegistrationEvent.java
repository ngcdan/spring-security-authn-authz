package com.linuss.security.demo.springsecurityauthnauthn.event;

import com.linuss.security.demo.springsecurityauthnauthn.entities.Customer;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4113549487933175429L;
	private final Customer customer;

	public UserRegistrationEvent(Customer customer) {
		super(customer);
		this.customer=customer;
	}

}