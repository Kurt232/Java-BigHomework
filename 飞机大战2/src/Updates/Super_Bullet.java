package Updates;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import static ImagePane.AllImage.Image_Super_Bullet_Update;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.My_Flighter;

public class Super_Bullet extends Update{
    int Image_Width=111;
    int Image_Height=78;
    PathTransition pt;
    InvalidationListener listener;

    class Update_Thread implements Runnable
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
                Judge();
                if(Y>=1010||Exi==0)
                {
                    Exi=0;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pt.stop();
                            Update_Image.setVisible(false);
                            Update_Image.translateYProperty().removeListener(listener);
                            Main_Pane.getChildren().remove(Update_Image);
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

    public void Initialize(double i,double j)
    {
        X=i;
        Y=j;
        double Origin_Y=Y;
        listener=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Y=Origin_Y+Update_Image.getTranslateY();
            }
        };
        Judge_Radius=22;
        Speed=2.3;
        Exi=1;
        Update_Image=new ImageView(Image_Super_Bullet_Update);
        Update_Image.setX(X-38);
        Update_Image.setY(Y-28);
        Update_Image.setFitWidth(Image_Width/1.5);
        Update_Image.setFitHeight(Image_Height/1.5);
        Update_Image.translateYProperty().addListener(listener);
        pt=new PathTransition(Duration.millis((1030-Y)/(Speed/10)),new Line(X,Y,X,1030),Update_Image);
        pt.setInterpolator(Interpolator.LINEAR);
        new Thread(new Update_Thread()).start();
    }

    public void Judge()
    {
        double Flighter_X=My_Flighter.X;
        double Flighter_Y=My_Flighter.Y;
        double Dis=Math.pow(Math.pow(Flighter_X-X,2)+Math.pow((Flighter_Y-Y),2),0.5);
        if(Dis<=Judge_Radius+My_Flighter.Judge_Radius)
        {
            My_Flighter.Bullet_Class=2;
            Exi=0;
        }
    }
}
