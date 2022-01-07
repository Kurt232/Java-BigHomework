package com.company;

public class stage {
    public static void main(String[] args){
        for(int i=2; i<1000; i++){
            int d = 2*i+1;
            if(i%3==2&&i%4==3&&i%5==3&&i%6==5&&i%7==5){
                System.out.println(i);
                break;
            }
        }
    }
}
