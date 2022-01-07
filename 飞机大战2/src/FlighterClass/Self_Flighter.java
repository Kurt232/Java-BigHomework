package FlighterClass;

import BulletClass.Bullet;
import BulletClass.Self_Basic_Bullet;
import BulletClass.Self_Super_Bullet;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import static ImagePane.AllImage.Image_Health;
import static ImagePane.AllImage.Image_Self_Flighter;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.*;

public class Self_Flighter extends Flighter{
    public int Up_Signal=0;//上移信号
    public int Right_Signal=0;//上移信号
    public int Down_Signal=0;//上移信号
    public int Left_Signal=0;//上移信号
    public int Bullet_Class=1;
    int Image_Height=256;
    int Image_Width=234;
    ImageView Health_Image=new ImageView(Image_Health);
    Rectangle Health_Bar=new Rectangle();
    Rectangle Back_Bar=new Rectangle();

    class My_Flighter_Move implements Runnable{
        public void run()
        {
            while(true)
            {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(Health>=0)
                            Health_Bar.setWidth(700*((double)Health/10));
                        Move();
                    }
                });
                try {
                    Thread.sleep(10);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class My_Bullet_Launch implements Runnable{
        public void run()
        {
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            while(true)
            {
                if(Bullet_Class==1)
                {
                    Bullet_Type=new Self_Basic_Bullet();
                    Bullet_Type.Initialize(X,Y,0);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(Bullet_Type.Launch_Interval);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else if(Bullet_Class==2)
                {
                    Bullet_Type=new Self_Super_Bullet();
                    int Origin_X=X;
                    int Origin_Y=Y;
                    Bullet_Type.Initialize(Origin_X,Origin_Y,0);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(50);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    Bullet Bullet_Type2=new Self_Super_Bullet();
                    Bullet_Type2.Initialize(Origin_X-15,Origin_Y,0);
                    Bullet Bullet_Type3=new Self_Super_Bullet();
                    Bullet_Type3.Initialize(Origin_X+15,Origin_Y,0);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type2.Bullet_Image);
                            Main_Pane.getChildren().add(Bullet_Type3.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(Bullet_Type.Launch_Interval);
                    }catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void Initialize()
    {
        Health_Image.setX(28);
        Health_Image.setY(8);
        Health_Bar.setHeight(12);
        Health_Bar.setWidth(700);
        Health_Bar.setArcHeight(7);
        Health_Bar.setArcWidth(7);
        Back_Bar.setHeight(18);
        Back_Bar.setWidth(706);
        Back_Bar.setArcHeight(12);
        Back_Bar.setArcWidth(12);
        Health_Bar.setFill(Color.rgb(34,139,34));
        Back_Bar.setFill(Color.rgb(225,225,225,0.6));

        Health_Bar.setX(150);
        Back_Bar.setX(147);
        Health_Bar.setY(20);
        Back_Bar.setY(17);
        Main_Pane.getChildren().add(Back_Bar);
        Main_Pane.getChildren().add(Health_Bar);
        Main_Pane.getChildren().add(Health_Image);

        Num=0;
        Health=10;
        X=Map_Width/2;
        Y=Map_Height-50;
        Judge_Radius=10;
        Speed=4;
        Exi=1;
        Bullet_Type=new Self_Basic_Bullet();
        Flighter_Image=new ImageView(Image_Self_Flighter);
        Flighter_Image.setFitWidth(Image_Width/3);
        Flighter_Image.setFitHeight(Image_Height/3);
        Flighter_Image.setX(X-40);
        Flighter_Image.setY(Y-43);
        Main_Pane.getChildren().add(Flighter_Image);
        new Thread(new My_Flighter_Move()).start();
        new Thread(new My_Bullet_Launch()).start();
    }

    public void Up(){Up_Signal=1;}//向上，将移动信号置为1

    public void Right() {Right_Signal=1;}//向右，将移动信号置为1

    public void Down() {Down_Signal=1;}//向下，将移动信号置为1

    public void Left() {Left_Signal=1  ;}//向左，将移动信号置为1

    public void Move()
    {
        if(Up_Signal==1)//向上移动
        {
            if(Y>=20)
            {
                Y-=Speed;
                Flighter_Image.setY(Flighter_Image.getY()-Speed);
            }
        }
        if(Right_Signal==1)//向右移动
        {
            if(X<=980)
            {
                X+=Speed;
                Flighter_Image.setX(Flighter_Image.getX()+Speed);
            }
        }
        if(Down_Signal==1)//向下移动
        {
            if(Y<=980)
            {
                Y+=Speed;
                Flighter_Image.setY(Flighter_Image.getY()+Speed);
            }
        }
        if(Left_Signal==1)//向左移动
        {
            if(X>=20)
            {
                X-=Speed;
                Flighter_Image.setX(Flighter_Image.getX()-Speed);
            }
        }
    }
}
