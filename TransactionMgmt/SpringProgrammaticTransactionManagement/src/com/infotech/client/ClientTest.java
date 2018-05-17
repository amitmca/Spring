package com.infotech.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.infotech.model.Account;
import com.infotech.service.BankService;

public class ClientTest {
	public static void main(String[] args) {
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
		BankService bankService = (BankService) context.getBean("bankService");
		Account fromAccount=new Account();
		fromAccount.setAccountNumber(1111);
		Account toAccount=new Account();
		toAccount.setAccountNumber(2222);
		bankService.transferFund(fromAccount, toAccount, 1000.00);
		context.close();
	}
}
