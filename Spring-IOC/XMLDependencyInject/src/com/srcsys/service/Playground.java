package com.srcsys.service;

import com.srcsys.interfaces.Player;
public class Playground {

	private Player player;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void play() {
		player.play();
	}

}