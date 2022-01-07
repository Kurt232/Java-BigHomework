package ImagePane;

import FlighterClass.Enemy_Boss;
import FlighterClass.Enemy_Elite_1;
import FlighterClass.Enemy_Elite_2;
import FlighterClass.Enemy_Type1;
import MapClass.Map_1;
import MyThread.Enemy_Generator;
import Updates.Super_Bullet;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.skin.ProgressBarSkin;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.plaf.ProgressBarUI;

import static ImagePane.AllImage.*;
import static MapClass.Map_1.*;

public class Map_1_Pane{
    public static Pane Main_Pane=new Pane();
    public static Pane Title_Pane=new Pane();
    public static Scene Title_Scene=new Scene(Title_Pane,Map_Width,Map_Height);
    public static Scene Main_Scene=new Scene(Main_Pane,Map_Width,Map_Height);

    public static void Initialize_Game(Stage Primary_Stage)
    {
        Primary_Stage.setScene(Main_Scene);
        Main_Pane.getChildren().add(ImageView_Background_1);
        Map_1.Initialize_Game();
        Main_Scene.setOnKeyPressed(e->{
            switch(e.getCode())
            {
                case UP:My_Flighter.Up();break;
                case RIGHT:My_Flighter.Right();My_Flighter.Flighter_Image.setImage(Image_Right_Flighter);break;
                case DOWN:My_Flighter.Down();break;
                case LEFT:My_Flighter.Left();My_Flighter.Flighter_Image.setImage(Image_Left_Flighter);break;
            }
        });
        Main_Scene.setOnKeyReleased(e->{
            switch(e.getCode())
            {
                case UP:My_Flighter.Up_Signal=0;break;
                case RIGHT:My_Flighter.Right_Signal=0;My_Flighter.Flighter_Image.setImage(Image_Self_Flighter);break;
                case DOWN:My_Flighter.Down_Signal=0;break;
                case LEFT:My_Flighter.Left_Signal=0;My_Flighter.Flighter_Image.setImage(Image_Self_Flighter);break;
            }
        });
        new Thread(new Enemy_Generator()).start();
    }

    public void start(Stage Primary_Stage)
    {
        Map_1.Initialize_Title(Primary_Stage);
        Main_Pane.setPickOnBounds(false);

        Primary_Stage.setTitle("飞机大战");
        Primary_Stage.setResizable(false);

        Primary_Stage.setScene(Title_Scene);
        Primary_Stage.show();
        Primary_Stage.setOnCloseRequest(e->{System.exit(0);});

        /*Enemy_Elite_2 e1=new Enemy_Elite_2();
        e1.Initialize(800,300,1,600);
        Main_Pane.getChildren().add(e1.Flighter_Image);
        Main_Pane.getChildren().add(e1.r2);
        Main_Pane.getChildren().add(e1.r1);
        e1.Bullet_Type.Initialize(e1.X,e1.Y);*/

        /*Enemy_Boss e2=new Enemy_Boss();
        e2.Initialize(500,500,1,600);
        e2.Boom(500,500);
        Title_Pane.getChildren().add(new Circle(500,500,10));
        Main_Pane.getChildren().add(e2.Flighter_Image);
        e2.Bullet_Type.Initialize(e2.X,e2.Y,30);
        Main_Pane.getChildren().add(e2.Boss_Health);
        Main_Pane.getChildren().add(e2.r1);
        Main_Pane.getChildren().add(e2.Warning);*/
        //Main_Pane.getChildren().add(new Line(310,0,310,1000));



    }
}

