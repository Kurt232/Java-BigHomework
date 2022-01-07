package com.company;
import static java.lang.Math.*;
import java.util.Vector;
public class theNum {
    public static void main(String[] args){
        Vector v1= new Vector (10);
        for(int i=0;i<=100;i++){
            int num1=i*i-100;
            int num2=num1+268;
            int tmp=(int)Math.sqrt((double)num2);
            if(num2==tmp*tmp) v1.addElement(num1);
        }
        for(int i=0; i<v1.size(); i++){
            System.out.printf("the %d: %d\n",i,v1.get(i));
        }
    }
}
