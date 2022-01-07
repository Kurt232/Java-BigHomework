package FlighterClass;

import BulletClass.Enemy_Basic_Bullet;
import BulletClass.Enemy_Elite_Bullet_1;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static ImagePane.AllImage.*;
import static ImagePane.AllImage.Image_Boom1_6;
import static ImagePane.Map_1_Pane.Main_Pane;

public class Enemy_Elite_1 extends Flighter{
    int Image_Width=412;
    int Image_Height=256;
    InvalidationListener listener;
    PathTransition pt;
    public Rectangle r1=new Rectangle();
    public Rectangle r2=new Rectangle();

    class My_Bullet_Launch implements Runnable{
        public void run()
        {
            try {
                Thread.sleep(3200);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            while(true)
            {
                if(Exi==0)
                    break;
                Bullet_Type=new Enemy_Elite_Bullet_1();
                Bullet_Type.Initialize(X,Y,0);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        Main_Pane.getChildren().add(Bullet_Type.Bullet_Image);
                    }
                });
                try {
                    Thread.sleep(300);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
                Bullet_Type=new Enemy_Elite_Bullet_1();
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
        }
    }

    class Flighter_Thread implements Runnable//集合了播放运动动画、越界判定销毁和血量低于0后销毁判定
    {
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pt.play();
                }
            });
            while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(Health>=0)
                            r1.setWidth(200*((double)Health/50));
                    }
                });
                if (Health <= 0) {
                    Exi = 0;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ImageView Boom_Image=new ImageView(Image_Boom1_1);
                            Boom_Image.setX(X-40);
                            Boom_Image.setY(Y-40);
                            Boom_Image.setScaleX(1.7);
                            Boom_Image.setScaleY(1.7);
                            KeyFrame keyframe1=new KeyFrame(Duration.millis(0), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Main_Pane.getChildren().add(Boom_Image);
                                }
                            });
                            KeyFrame keyframe2=new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Boom_Image.setImage(Image_Boom1_2);
                                }
                            });
                            KeyFrame keyframe3=new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Boom_Image.setImage(Image_Boom1_3);
                                }
                            });
                            KeyFrame keyframe4=new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Boom_Image.setImage(Image_Boom1_4);
                                }
                            });
                            KeyFrame keyframe5=new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Boom_Image.setImage(Image_Boom1_5);
                                }
                            });
                            KeyFrame keyframe6=new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Boom_Image.setImage(Image_Boom1_6);
                                }
                            });
                            KeyFrame keyframe7=new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    Boom_Image.setVisible(false);
                                    Main_Pane.getChildren().remove(Boom_Image);
                                }
                            });
                            Timeline animation=new Timeline(keyframe1);
                            animation.getKeyFrames().add(keyframe2);
                            animation.getKeyFrames().add(keyframe3);
                            animation.getKeyFrames().add(keyframe4);
                            animation.getKeyFrames().add(keyframe5);
                            animation.getKeyFrames().add(keyframe6);
                            animation.getKeyFrames().add(keyframe7);
                            animation.play();

                            pt.stop();
                            Flighter_Image.setVisible(false);
                            r1.setVisible(false);
                            r2.setVisible(false);
                            Flighter_Image.translateYProperty().removeListener(listener);
                            Main_Pane.getChildren().remove(Flighter_Image);
                            Main_Pane.getChildren().remove(r1);
                            Main_Pane.getChildren().remove(r2);
                        }
                    });
                    Thread.currentThread().interrupt();
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Initialize(int i,int j,int num,int Des_Y)
    {
        Num=num;
        Health=50;
        this.X=i;
        this.Y=j;
        Speed=0.7;
        Exi=1;
        Judge_Radius=74;
        Bullet_Type=new Enemy_Elite_Bullet_1();

        r1.setHeight(7);
        r1.setWidth(200);
        r1.setArcHeight(7);
        r1.setArcWidth(7);
        r2.setHeight(9);
        r2.setWidth(202);
        r2.setArcHeight(7);
        r2.setArcWidth(7);
        r1.setFill(Color.RED);
        r2.setFill(Color.rgb(225,225,225,0.6));
        r1.setX(X-100);
        r2.setX(X-101);
        r1.setY(Y+80);
        r2.setY(Y+79);

        listener=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Y=j+(int)Flighter_Image.getTranslateY();
                r1.setY(Y+80);
                r2.setY(Y+79);
            }
        };
        Flighter_Image=new ImageView(Image_Enemy_Elite_1);
        Flighter_Image.setFitHeight(Image_Height/2);
        Flighter_Image.setFitWidth(Image_Width/2);
        Flighter_Image.setX(X-102);
        Flighter_Image.setY(Y-70);
        Flighter_Image.translateYProperty().addListener(listener);
        pt=new PathTransition(Duration.millis((Des_Y-(double)Y)/(Speed/10)),new Line(X,Y,X,Des_Y),Flighter_Image);
        new Thread(new Flighter_Thread()).start();
        new Thread(new My_Bullet_Launch()).start();
    }
}
