package com.srcsys.bean;
import com.srcsys.interfaces.Player;

public class BasketballPlayer implements Player {
	@Override
	public void play() {
		System.out.println("I Love Basketball..");
	}
}