package com.company;
public class Plan {
    public static void main (String[] args){
        int num=0;//总数
        for(int i=0; 3*i<=50; ++i) {
            for(int j=0; 2*j<=(50-i*3); ++j) {
                int k = 50-3*i-2*j;
                if (k >=0&&i+j+k==30){
                    System.out.printf("the numbers of first and second and third reward respectively are %d, %d, %d\n",i,j,k);
                    ++num;
                }
            }
        }
        System.out.printf("the total is %d\n",num);
    }
}
