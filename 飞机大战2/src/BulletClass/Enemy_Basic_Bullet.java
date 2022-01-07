package BulletClass;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import static ImagePane.AllImage.Image_Enemy_Basic_Bullet;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.My_Flighter;

public class Enemy_Basic_Bullet extends Bullet{
    int Image_Width=84;
    int Image_Height=200;
    PathTransition pt;
    InvalidationListener listener;

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
                if(Bullet_Y>=1010||Exi==0)
                {
                    Exi=0;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pt.stop();
                            Bullet_Image.setVisible(false);
                            Bullet_Image.translateYProperty().removeListener(listener);
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
        int Origin_Y=Bullet_Y;
        listener=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Bullet_Y=Origin_Y+(int)Bullet_Image.getTranslateY();
            }
        };
        Judge_Radius=6;
        Damage=1;
        Launch_Interval=1100;
        Speed=5;
        Exi=1;
        Bullet_Image=new ImageView(Image_Enemy_Basic_Bullet);
        Bullet_Image.setFitWidth(28);
        Bullet_Image.setFitHeight(66.6);
        Bullet_Image.setX(Bullet_X-13);
        Bullet_Image.setY(Bullet_Y-53);
        Bullet_Image.translateYProperty().addListener(listener);
        pt=new PathTransition(Duration.millis((1030-(double)Bullet_Y)/(Speed/10)),new Line(Bullet_X,Bullet_Y,Bullet_X,1030),Bullet_Image);
        pt.setInterpolator(Interpolator.LINEAR);

        new Thread(new Bullet_Thread()).start();
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
