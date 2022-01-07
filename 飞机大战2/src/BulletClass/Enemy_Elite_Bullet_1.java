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

import static ImagePane.AllImage.Image_Enemy_Basic_Bullet;
import static ImagePane.AllImage.Image_Enemy_Elite_Bullet_1;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.My_Flighter;

public class Enemy_Elite_Bullet_1 extends Bullet{
    int Image_Width=30;
    int Image_Height=208;
    int Judge_Width=7;
    int Judge_Height=50;
    double Rotate;
    PathTransition pt;
    InvalidationListener listener1;
    InvalidationListener listener2;

    class Bullet_Move implements Runnable
    {
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pt.play();
                }
            });
            while(true)
            {
                Bullet_Judge();
                if(Exi==0||Bullet_Y>=1040||Bullet_Y<=-40||Bullet_X>=1040||Bullet_X<=-80)
                {
                    Exi=0;
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
                try {
                    Thread.sleep(50);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Initialize(int X,int Y,double Radius)
    {
        Bullet_X=X+1;
        Bullet_Y=Y+65;
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
        Launch_Interval=1000;
        Speed=6.7;
        Exi=1;
        Judge_Radius=7;
        Bullet_Image=new ImageView(Image_Enemy_Elite_Bullet_1);
        Bullet_Image.setFitWidth(Image_Width/2);
        Bullet_Image.setFitHeight(Image_Height/2);
        Bullet_Image.setX(Bullet_X-9);
        Bullet_Image.setY(Bullet_Y-55);
        double Flighter_Height=My_Flighter.Y;
        Rotate=Math.atan(((double)My_Flighter.X-(double)Bullet_X)/((double)My_Flighter.Y-(double)Bullet_Y))*180/3.14;
        if(Bullet_Y<Flighter_Height)
        {
            double Hypotenuse=(1050-Bullet_Y)/(Math.cos(Rotate*3.14/180));
            Bullet_Image.setRotate(-Rotate);
            pt=new PathTransition(Duration.millis(1500/(Speed/10)),new Line(Bullet_X,Bullet_Y,Bullet_X+(Math.tan(Rotate*3.14/180)*(1050-Bullet_Y))*1500/Hypotenuse,(1050-Bullet_Y)*1500/Hypotenuse+Bullet_Y),Bullet_Image);
        }
        else
        {
            double Hypotenuse=(50+Bullet_Y)/(Math.cos(Rotate*3.14/180));
            Bullet_Image.setRotate(180-Rotate);
            pt=new PathTransition(Duration.millis(1500/(Speed/10)),new Line(Bullet_X,Bullet_Y,Bullet_X-(Math.tan(Rotate*3.14/180)*(50+Bullet_Y))*1500/Hypotenuse,Bullet_Y-(Bullet_Y+50)*1500/Hypotenuse),Bullet_Image);
        }
        Bullet_Image.translateXProperty().addListener(listener1);
        Bullet_Image.translateYProperty().addListener(listener2);
        pt.setInterpolator(Interpolator.LINEAR);
        new Thread(new Bullet_Move()).start();
    }

    public void Bullet_Judge()
    {
        double Flighter_X=My_Flighter.X;
        double Flighter_Y=My_Flighter.Y;
        double Dis=Math.pow(Math.pow(Flighter_X-Bullet_X,2)+Math.pow((Flighter_Y-Bullet_Y),2),0.5);
        double Judge1_X=Bullet_X-40*Math.sin(Rotate*3.14/180);
        double Judge1_Y=Bullet_Y-40*Math.cos(Rotate*3.14/180);
        double Dis1=Math.pow(Math.pow(Flighter_X-Judge1_X,2)+Math.pow((Flighter_Y-Judge1_Y),2),0.5);
        double Judge2_X=Bullet_X+40*Math.sin(Rotate*3.14/180);
        double Judge2_Y=Bullet_Y+40*Math.cos(Rotate*3.14/180);
        double Dis2=Math.pow(Math.pow(Flighter_X-Judge2_X,2)+Math.pow((Flighter_Y-Judge2_Y),2),0.5);
        if(Dis<=Judge_Radius+My_Flighter.Judge_Radius||Dis1<=Judge_Radius+My_Flighter.Judge_Radius||Dis2<=Judge_Radius+My_Flighter.Judge_Radius)
        {
            My_Flighter.Health-=Damage;
            Exi=0;
        }
    }
}
