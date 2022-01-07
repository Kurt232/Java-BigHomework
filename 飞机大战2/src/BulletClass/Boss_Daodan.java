package BulletClass;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import static ImagePane.AllImage.*;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.My_Flighter;

public class Boss_Daodan extends Bullet{
    int Image_Width=50;
    int Image_Height=50;
    double Rotate;
    PathTransition pt;
    InvalidationListener listener1;
    InvalidationListener listener2;

    class Bullet_Move implements Runnable {
        public void run() {
            int counter=0;
            double Pre_Rotate=Rotate;
            for (int i = 0; ; i++) {
                Bullet_Judge();
                if (Exi==0||Bullet_Y >= 1040 || Bullet_Y <= -40 || Bullet_X >= 1040 || Bullet_X <= -80) {
                    Exi = 0;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pt.stop();
                            Bullet_Image.setVisible(false);
                            Bullet_Image.translateXProperty().removeListener(listener1);
                            Bullet_Image.translateYProperty().removeListener(listener2);
                            Main_Pane.getChildren().remove(Bullet_Image);
                        }
                    });
                    Thread.currentThread().interrupt();
                    break;
                }
                if (i <= 20&&counter==0) {
                    double Cur_X=My_Flighter.X;
                    double Cur_Y=My_Flighter.Y;
                    if (Math.abs(Bullet_Y - Cur_Y) >= 100 && Bullet_Y < Cur_Y) {
                        Rotate = Math.atan((Cur_X - (double) Bullet_X) / (Cur_Y - (double) Bullet_Y)) * 180 / 3.14;
                        double Gap=Math.abs(Pre_Rotate-Rotate);
                        if(Gap>180)Gap-=180;
                        if(Gap<90||i==0)
                        {
                            Pre_Rotate=Rotate;
                            double Hypotenuse = (1050 - Bullet_Y) / (Math.cos(Rotate * 3.14 / 180));
                            pt = new PathTransition(Duration.millis(1500 / (Speed / 10)), new Line(Bullet_X, Bullet_Y, Bullet_X + (Math.tan(Rotate * 3.14 / 180) * (1050 - Bullet_Y)) * 1500 / Hypotenuse, (1050 - Bullet_Y) * 1500 / Hypotenuse + Bullet_Y), Bullet_Image);
                            pt.setInterpolator(Interpolator.LINEAR);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Bullet_Image.setRotate(-Rotate);
                                    pt.play();
                                }
                            });
                        }
                        else counter++;
                    } else if (Math.abs(Bullet_Y - Cur_Y) >= 100 && Bullet_Y > Cur_Y) {
                        Rotate = Math.atan((Cur_X - (double) Bullet_X) / (Cur_Y - (double) Bullet_Y)) * 180 / 3.14;
                        double Gap=Math.abs(Pre_Rotate-Rotate);
                        if(Gap>180)Gap-=180;
                        if(Gap<90||i==0)
                        {
                            Pre_Rotate=Rotate;
                            double Hypotenuse = (50 + Bullet_Y) / (Math.cos(Rotate * 3.14 / 180));
                            pt = new PathTransition(Duration.millis(1500 / (Speed / 10)), new Line(Bullet_X, Bullet_Y, Bullet_X - (Math.tan(Rotate * 3.14 / 180) * (50 + Bullet_Y)) * 1500 / Hypotenuse, Bullet_Y - (Bullet_Y + 50) * 1500 / Hypotenuse), Bullet_Image);
                            pt.setInterpolator(Interpolator.LINEAR);
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Bullet_Image.setRotate(180 - Rotate);
                                    pt.play();
                                }
                            });
                        }
                        else counter++;
                    } else {
                        if (Bullet_X > Cur_X)
                        {
                            if(Bullet_Y> Cur_Y)
                                Rotate = 180+Math.atan((Cur_X - (double) Bullet_X) / (Cur_Y - (double) Bullet_Y)) * 180 / 3.14;
                            else Rotate = Math.atan((Cur_X - (double) Bullet_X) / (Cur_Y - (double) Bullet_Y)) * 180 / 3.14;
                            double Gap=Math.abs(Pre_Rotate-Rotate);
                            if(Gap>180)Gap-=180;
                            if(Gap<90||i==0)
                            {
                                Pre_Rotate=Rotate;
                                double Hypotenuse = (50 + Bullet_X) / (Math.sin(Rotate * 3.14 / 180));
                                pt = new PathTransition(Duration.millis(1500 / (Speed / 10)), new Line(Bullet_X, Bullet_Y, Bullet_X + (Bullet_X + 50) * 1500 / Hypotenuse, Bullet_Y + ((1 / Math.tan(Rotate * 3.14 / 180)) * (50 + Bullet_X)) * 1500 / Hypotenuse), Bullet_Image);
                                pt.setInterpolator(Interpolator.LINEAR);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bullet_Image.setRotate(- Rotate);
                                        pt.play();
                                    }
                                });
                            }
                            else counter++;
                        }
                        else{
                            if(Bullet_Y> Cur_Y)
                                Rotate = Math.atan((Cur_X - (double) Bullet_X) / (Cur_Y - (double) Bullet_Y)) * 180 / 3.14;
                            else Rotate = 180+Math.atan((Cur_X - (double) Bullet_X) / (Cur_Y - (double) Bullet_Y)) * 180 / 3.14;
                            double Gap=Math.abs(Pre_Rotate-Rotate);
                            if(Gap>180)Gap-=180;
                            if(Gap<90||i==0)
                            {
                                Pre_Rotate=Rotate;
                                double Hypotenuse = (1050 - Bullet_X) / (Math.sin(Rotate * 3.14 / 180));
                                pt = new PathTransition(Duration.millis(1500 / (Speed / 10)), new Line(Bullet_X, Bullet_Y,-(1050 - Bullet_X) * 1500 / Hypotenuse + Bullet_X , Bullet_Y - ((1 / Math.tan(Rotate * 3.14 / 180)) * (1050 - Bullet_X)) * 1500 / Hypotenuse), Bullet_Image);
                                pt.setInterpolator(Interpolator.LINEAR);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bullet_Image.setRotate(180 -Rotate);
                                        pt.play();
                                    }
                                });
                            }
                            else counter++;
                        }
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Initialize(int X,int Y,double Radius)
    {
        Bullet_X=X;
        Bullet_Y=Y+100;
        int Origin_X=Bullet_X;
        int Origin_Y=Bullet_Y;
        listener1=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Bullet_X=Origin_X+(int)Bullet_Image.getTranslateX();
            }
        };
        listener2=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Bullet_Y=Origin_Y+(int)Bullet_Image.getTranslateY();
            }
        };

        Damage=3;
        Launch_Interval=2000;
        Speed=2.5;
        Exi=1;
        Judge_Radius=20;
        Bullet_Image=new ImageView(Image_Boss_daodan);
        Bullet_Image.setFitWidth(Image_Width/2);
        Bullet_Image.setFitHeight(Image_Height/2);
        Bullet_Image.setX(Bullet_X-25);
        Bullet_Image.setY(Bullet_Y-25);

        Bullet_Image.translateXProperty().addListener(listener1);
        Bullet_Image.translateYProperty().addListener(listener2);
        new Thread(new Bullet_Move()).start();
    }

    public void Bullet_Judge()
    {
        double Flighter_X=My_Flighter.X;
        double Flighter_Y=My_Flighter.Y;
        double Dis=Math.pow(Math.pow(Flighter_X-Bullet_X,2)+Math.pow((Flighter_Y-Bullet_Y),2),0.5);
        if(Dis<=Judge_Radius+My_Flighter.Judge_Radius)
        {
            My_Flighter.Health-=Damage;
            Exi=0;
        }
    }
}
