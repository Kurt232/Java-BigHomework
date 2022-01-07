package com.company;

import java.util.Date;

public class AccountTest {
    public static void main(String[] args){
        Account test1=new Account(1122,20000,0.045);
        test1.withDraw(2500);
        test1.deposit(3000);
        System.out.printf("the balance is %f\nthe monthly interest rate is %f\n",test1.getBalance(),test1.getMonthlyInterestRate());
        System.out.println(test1.getDateCreated().toString());
    }
}
class Account{
    private int id;
    private double balance;//账户余额
    private double annualInterestRate;
    private Date dateCreated;//开户日期
//构造方法
    public Account(){
        id=0;
        balance=0;
        annualInterestRate=0;
        dateCreated=new Date();
    }
    public Account(int id, double balance){
        this.id=id;
        this.balance=balance;
        annualInterestRate=0;
        dateCreated=new Date();
    }
    public Account(int id, double balance, double annualInterestRate){
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
        dateCreated=new Date();
    }
//访问器和修改器
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    //方法
    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    public double withDraw(double money){//返回值为取出金额
        if(money>balance) return 0;
        else{
            balance-=money;
            return money;
        }
    }
    public double deposit(double money){
        balance+=money;
        return money;
    }
}
