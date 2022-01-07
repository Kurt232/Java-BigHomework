package BulletClass;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.awt.geom.PathIterator;

import static ImagePane.AllImage.Image_Boss_Bullet_1;
import static ImagePane.AllImage.Image_Enemy_Basic_Bullet;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.My_Flighter;

public class Boss_Bullet_1 extends Bullet{
    double Rotate;
    double Image_Width=57;
    double Image_Height=56;
    PathTransition pt;
    InvalidationListener listener1;
    InvalidationListener listener2;

    class Bullet_Thread implements Runnable
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
                if(Bullet_Y>=1020||Exi==0)
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
        Bullet_X=X;
        Bullet_Y=Y+25;
        int Origin_X=Bullet_X;
        int Origin_Y=Bullet_Y;
        Rotate=Radius;
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
        Judge_Radius=6;
        Damage=1;
        Launch_Interval=5500;
        Speed=8;
        Exi=1;
        Bullet_Image=new ImageView(Image_Boss_Bullet_1);
        Bullet_Image.setFitWidth(Image_Width/2);
        Bullet_Image.setFitHeight(Image_Height/2);
        Bullet_Image.setX(Bullet_X-15);
        Bullet_Image.setY(Bullet_Y-14);
        Bullet_Image.translateXProperty().addListener(listener1);
        Bullet_Image.translateYProperty().addListener(listener2);
        double Hypotenuse=(1050-Bullet_Y)/(Math.cos(Rotate*3.14/180));
        pt=new PathTransition(Duration.millis(1500/(Speed/10)),new Line(Bullet_X,Bullet_Y,Bullet_X+(Math.tan(Rotate*3.14/180)*(1050-Bullet_Y))*1500/Hypotenuse,(1050-Bullet_Y)*1500/Hypotenuse+Bullet_Y),Bullet_Image);
        pt.setInterpolator(Interpolator.SPLINE(0.07,0.4,0.75,0.02));
        new Thread((new Bullet_Thread())).start();
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
