package com.kosta.exam02;

class BankAccountTest{
	public static void main(String[] args) {
		try{
			BankAccount b1 = new BankAccount(1000);
			b1.deposit(100000);
			System.out.println("잔액:"+b1.getBalance());
			b1.deposit(10000);
			System.out.println("잔액:"+b1.getBalance());
			b1.withdraw(100000);
			System.out.println("잔액:"+b1.getBalance());
			b1.withdraw(1000000);
			System.out.println("잔액:"+b1.getBalance());
		}catch(NegativeBalanceException e){
			System.out.println("예외발생:"+e.getMessage());
			e.printStackTrace();
		}
	}
}