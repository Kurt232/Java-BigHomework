package com.company;

import java.lang.Math;
public class BugTest {
    public static void main(String[] args){
        Bug bugExample=new Bug(100);
        for(int i=0; i<10; i++) {
            int random = (int) (Math.random() * 5);
            if (random % 4 == 0) {
                bugExample.turn();
                System.out.println("发生转向");
            }
            bugExample.move();
            System.out.println("此时位置 " + bugExample.getPosition());
        }
        System.out.println();
        Bug bugExample1=new Bug();
        for(int i=0; i<10; i++) {
            int random1 = (int) (Math.random() * 5);
            if (random1 % 4 == 0) {
                bugExample1.turn();
                System.out.println("发生转向");
            }
            bugExample1.move();
            System.out.println("此时位置 " + bugExample1.getPosition());
        }
    }
}

class Bug {
    private int position;
    private int direction;

    public Bug(){
        position=0;
        System.out.println("初始位置为 0");
        direction=1;
        System.out.println("默认向右为正");
    }

    public Bug(int p){
        position=p;
        System.out.println("初始位置为 "+p);
        direction=1;
        System.out.println("默认向右为正");
    }

    public void turn(){
        direction*=-1;
    }

    public void move(){
        position=position+direction;
    }

    public int getPosition(){
        return position;
    }
}
