package com.incredible.dependency.injection;

public class Room {
	private int roomNumber;
	private Student allotedTo;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Room(Student allotedTo) {
		this.allotedTo = allotedTo;

	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", allotedTo=" + allotedTo.getName() + "]";
	}
}