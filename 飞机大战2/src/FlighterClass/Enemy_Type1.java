package FlighterClass;

import BulletClass.Bullet;
import BulletClass.Enemy_Basic_Bullet;
import BulletClass.Self_Basic_Bullet;
import com.sun.tools.javac.Main;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import static ImagePane.AllImage.*;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.*;

public class Enemy_Type1 extends Flighter{
    int Image_Height=536;
    int Image_Width=788;
    InvalidationListener listener1;
    InvalidationListener listener2;
    PathTransition Move;
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
                Bullet_Type=new Enemy_Basic_Bullet();
                Bullet_Type.Initialize(X-15,Y,0);
                Bullet Bullet_Type2=new Enemy_Basic_Bullet();
                Bullet_Type2.Initialize(X+15,Y,0);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Main_Pane.getChildren().add(Bullet_Type2.Bullet_Image);
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

    class My_Flighter_Move implements Runnable{
        public void run()
        {
            while(true)
            {
                if(Exi==0)
                    break;
                try {
                    Thread.sleep(3200);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
                int Origin_X=X;
                int Origin_Y=Y;
                Path path1=new Path(new MoveTo(X,Y+10));
                path1.getElements().add(new LineTo(Map_Width-X,Y+10));
                Move.setPath(path1);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Move.play();
                    }
                });
                try {
                    Thread.sleep(3200);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
                Path path2=new Path(new MoveTo(Map_Width-Origin_X,Origin_Y+10));
                path2.getElements().add(new LineTo(Origin_X,Origin_Y+10));
                Move.setPath(path2);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Move.play();
                    }
                });
            }
        }
    }

    class My_Flighter_Death implements Runnable
    {
        public void run()
        {
            while(true)
            {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(Health>=0)
                            r1.setWidth(100*((double)Health/5));
                    }
                });
                if(Health<=0)
                {
                    Exi=0;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ImageView Boom_Image=new ImageView(Image_Boom1_1);
                            Boom_Image.setX(X-40);
                            Boom_Image.setY(Y-40);
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

                            Move.stop();
                            Flighter_Image.setVisible(false);
                            r1.setVisible(false);
                            r2.setVisible(false);
                            Flighter_Image.translateYProperty().removeListener(listener1);
                            Flighter_Image.translateYProperty().removeListener(listener2);
                            Main_Pane.getChildren().remove(Flighter_Image);
                            Main_Pane.getChildren().remove(r1);
                            Main_Pane.getChildren().remove(r2);
                        }
                    });
                    break;
                }
                try {
                    Thread.sleep(50);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Initialize(int i, int j, PathTransition pt,int num)
    {
        Num=num;
        Health=5;
        X=i;//起点X
        Y=j;//起点Y
        listener1=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                X=i+(int)Flighter_Image.getTranslateX();
                r1.setX(X-50);
                r2.setX(X-51);

            }
        };
        listener2=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Y=j+(int)Flighter_Image.getTranslateY();
                r1.setY(Y+70);
                r2.setY(Y+69);
            }
        };
        Judge_Radius=37;
        Speed=3;
        Exi=1;

        r1.setHeight(7);
        r1.setWidth(100);
        r1.setArcHeight(7);
        r1.setArcWidth(7);
        r2.setHeight(9);
        r2.setWidth(102);
        r2.setArcHeight(7);
        r2.setArcWidth(7);
        r1.setFill(Color.RED);
        r2.setFill(Color.rgb(225,225,225,0.6));
        r1.setX(X-50);
        r2.setX(X-51);
        r1.setY(Y+70);
        r2.setY(Y+69);

        Bullet_Type=new Enemy_Basic_Bullet();
        Flighter_Image=new ImageView(Image_Enemy_Flighter_Type1);
        Flighter_Image.setFitWidth(157.6);
        Flighter_Image.setFitHeight(107.2);
        Flighter_Image.setX(this.X-77);
        Flighter_Image.setY(this.Y-45);
        Flighter_Image.translateXProperty().addListener(listener1);
        Flighter_Image.translateYProperty().addListener(listener2);
        Move=pt;
        Move.setNode(Flighter_Image);
        Move.play();
        new Thread(new My_Bullet_Launch()).start();
        new Thread(new My_Flighter_Move()).start();
        new Thread(new My_Flighter_Death()).start();
    }
}
