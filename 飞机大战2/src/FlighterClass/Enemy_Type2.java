package FlighterClass;

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
import javafx.scene.shape.Line;
import javafx.util.Duration;

import static ImagePane.AllImage.*;
import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.All_Flighter;

public class Enemy_Type2 extends Flighter{
    int Image_Width=480;
    int Image_Height=316;
    InvalidationListener listener;
    PathTransition pt;

    class Flighter_Thread implements Runnable//集合了播放运动动画、越界判定销毁和血量低于0后销毁判定
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
                if(Y>=1010||Health<=0)
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

                            pt.stop();
                            Flighter_Image.setVisible(false);
                            Flighter_Image.translateYProperty().removeListener(listener);
                            Main_Pane.getChildren().remove(Flighter_Image);
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

    public void Initialize(int i,int j,int num)
    {
        Num=num;
        Health=1;
        this.X=i;
        this.Y=j;
        Speed=4;
        Exi=1;
        Judge_Radius=29;
        listener=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Y=j+(int)Flighter_Image.getTranslateY();
            }
        };
        Flighter_Image=new ImageView(Image_Enemy_Flighter_Type2);
        Flighter_Image.setFitHeight(63.2);
        Flighter_Image.setFitWidth(96);
        Flighter_Image.setX(i-48);
        Flighter_Image.setY(j-30);
        Flighter_Image.translateYProperty().addListener(listener);
        pt=new PathTransition(Duration.millis((1030-(double)Y)/(Speed/10)),new Line(X,Y,X,1030),Flighter_Image);
        pt.setInterpolator(Interpolator.LINEAR);
        new Thread(new Flighter_Thread()).start();
    }
}
