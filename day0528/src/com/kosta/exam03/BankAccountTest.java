package com.kosta.exam03;

import java.util.Scanner;

class BankAccountTest{
	public static void menu() {
		System.out.println("1.입금 2.출금 3.잔액조회 0.종료");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("DONGBank에 오신걸 환영합니다.");
		BankAccount account = new BankAccount();
		int sel;
		int amount;
		try{
			while(true) {
				menu();
				sel = sc.nextInt();
				if(sel == 0) {
					break;
				}
				switch(sel) {
				case 1:
					System.out.println("입금하실 금액을 입력하세요");
					amount = sc.nextInt();
					account.deposit(amount);
					break;
				case 2:
					System.out.println("출금할 금액을 입력하세요");
					amount = sc.nextInt();
					account.withdraw(amount);
					break;
				case 3:
					System.out.println("잔액:"+account.getBalance());
					break;
				}
			}
		}catch(NegativeBalanceException e){
			System.out.println("예외발생:"+e.getMessage());
//			e.printStackTrace();
		}		
	}
}