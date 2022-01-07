package com.company;
import java.util.Scanner;
public class Reward {
    public static void main(String[] args){
        double profit,reward=0;
        final double hundredThousand=100000;
        Scanner inPut=new Scanner(System.in);
        profit=inPut.nextDouble();
        if(profit<=1*hundredThousand) reward+=profit*0.1;
        else if(1*hundredThousand<profit) reward+=1*hundredThousand*0.1;
        if(1*hundredThousand<profit&&profit<=2*hundredThousand) reward+=(profit-1*hundredThousand)*0.075;
        else if(2*hundredThousand<profit) reward+=1*hundredThousand*0.075;
        if(2*hundredThousand<profit&&profit<=4*hundredThousand) reward+=(profit-2*hundredThousand)*0.05;
        else if(4*hundredThousand<profit) reward+=2*hundredThousand*0.05;
        if(4*hundredThousand<profit&&profit<=6*hundredThousand) reward+=(profit-4*hundredThousand)*0.03;
        else if(6*hundredThousand<profit) reward+=2*hundredThousand*0.03;
        if(6*hundredThousand<profit&&profit<=10*hundredThousand) reward+=(profit-6*hundredThousand)*0.015;
        else if(10*hundredThousand<profit) reward+=4*hundredThousand*0.15+(profit-10*hundredThousand)*0.01;
        System.out.println(reward);
    }
}