package com.game;

public class User {

	private String name;
	private int point;
	private double result;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public double getResult() {
		return result;
	}

	public User(String name, int point) {
		this.name = name;
		this.point = point;
		this.result = (double)(point / (Math.random() * 100 + 1));
	}

}