package com.srcsys.bean;
import com.srcsys.interfaces.Player;

public class FootballPlayer implements Player {
	@Override
	public void play() {
		System.out.println("I Love Football..");
	}
}