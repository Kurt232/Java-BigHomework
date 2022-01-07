package com.company;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Account[] test = new Account[10];
        for (int i = 0; i < 10; i++) {
            test[i]=new Account(100+i,100);
        }
        while(true){
            System.out.println("Please input id:");
            System.out.println("or input -1 to exit");
            Scanner inPut= new Scanner(System.in);
            int inPutId=inPut.nextInt();
            if(inPutId==-1) break;
            if(109<inPutId||inPutId<100){
                System.out.println("error id");
                continue;
            }
            Account acc=test[inPutId-100];
            while(true) {
                System.out.println("Enter and id: " + inPutId);
                System.out.println("Main menu:");
                System.out.println("1:check balance");
                System.out.println("2:withdraw");
                System.out.println("3:deposit");
                System.out.println("4:exit");
                System.out.println("Enter a choice :");
                int inOp = inPut.nextInt();
                if (inOp == 1) {
                    System.out.println(acc.getBalance());
                }
                if (inOp == 2) {
                    System.out.println("Please input the number of withdraw:");
                    int inNum = inPut.nextInt();
                    if (inNum == acc.withDraw(inNum)) System.out.println("operation success");
                    else System.out.println("operation failure");
                }
                if (inOp == 3) {
                    System.out.println("Please input the number of deposit:");
                    int inNum = inPut.nextInt();
                    if (inNum == acc.deposit(inNum)) System.out.println("operation success");
                    else System.out.println("operation failure");
                }
                if (inOp == 4) {
                    System.out.println("Bye");
                    break;
                }
            }
        }
    }
}



