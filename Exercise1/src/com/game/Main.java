package com.game;

import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static User[] user;
	
	public static void add() {
		System.out.println("====================");
		System.out.print("Player는 총 몇 명인가요? ");
		user = new User[scanner.nextInt()];
		
		for(int i = 0; i < user.length; i++) {
			System.out.println("Player의 이름과 점수를 입력하세요.");
			System.out.print("이름 : ");
			String name = scanner.next();
			System.out.print("점수 : ");
			int point = scanner.nextInt();
			
			user[i] = new User(name, point);
		}
	}
	
	public static void show() {
		System.out.println("====================");
		if(user == null) {
			System.out.println("저장된 Player가 없습니다. Player를 입력해주세요.");
			add();
		}
		else {
			for (int i = 0; i < user.length; i++) {
				System.out.println(user[i].getName() + " " + user[i].getPoint());
			}
		}
	}
	
	public static void play() {
		System.out.println("====================");
		User temp = null;
		
		if(user == null) {
			System.out.println("저장된 Player가 없습니다. Player를 입력해주세요.");
			add();
		}
		else {
			for(int i = 0; i < user.length; i++) {
				for(int j = 0; j < user.length; j++) {
					if(user[i].getResult() > user[j].getResult()) {
						temp = user[i];
						user[i] = user[j];
						user[j] = temp;
					}
				}
			}
		}
		
		System.out.println("Rank\t Name\t Point\t Result\t");
		for (int i = 0; i < user.length; i++) {
			System.out.println((i+1) + "\t" + user[i].getName() +"\t" + user[i].getPoint() + "\t" + user[i].getResult());
		}
	}
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("====================");
			System.out.println("1. Add players");
			System.out.println("2. Show all players");
			System.out.println("3. Play");
			System.out.println("0. Exit");
			System.out.print("메뉴를 선택하세요 : ");
			
			switch(scanner.nextInt()) {
			case 1 :
				add();
				break;
			case 2 :
				show();
				break;
			case 3 :
				play();
				break;
			case 0 :
				System.out.println("게임을 종료합니다.");
				scanner.close();
				System.exit(0);
			default :
				System.out.println("Error!");
			}
		}
	}
}