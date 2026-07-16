package com.ecommerce.main;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserLogin;
import com.ecommerce.service.UserSignUp;
import com.ecommerce.serviceimpl.ProductServiceImpl;
import com.ecommerce.ui.ConsoleMenu;

public class App {
	public static void main(String[] args) {
		ConsoleMenu system = new ConsoleMenu();
		system.start();
//		UserSignUp user = new UserSignUp();
//		user.signUp("fjdskf","dsfd@gmail.com", "dsfd@123", "customer");
//		
//		UserLogin user = new UserLogin();
//		user.logIn("kodewala@gmail.com", "kode@123");
	}
}
