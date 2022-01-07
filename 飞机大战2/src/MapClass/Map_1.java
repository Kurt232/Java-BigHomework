package MapClass;

import FlighterClass.*;
import ImagePane.Map_1_Pane;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Vector;

import static ImagePane.AllImage.*;
import static ImagePane.Map_1_Pane.Title_Pane;

public class Map_1 {
    public static int Map_Height=1000;
    public static int Map_Width=1000;
    public static int Map_1_Image_Height=1608;
    public static int Map_1_Image_Width=536;
    public static ImageView ImageView_Background_1=new ImageView(Image_Background_1);
    public static ImageView Title_Back=new ImageView(Image_Title_Back);
    public static ImageView Start=new ImageView(Image_Start);
    public static ImageView Start_Frame=new ImageView(Image_Start_Frame);

    public static Vector<Flighter> All_Flighter=new Vector<>();
    public static Self_Flighter My_Flighter=new Self_Flighter();

    public static void Initialize_Title(Stage Primary_Stage)
    {
        Start.setX(140);
        Start.setY(670);
        Start.setMouseTransparent(true);
        Start_Frame.setX(70);
        Start_Frame.setY(650);
        Start_Frame.setOnMouseEntered(e->{
            Start_Frame.setOpacity(0.5);
        });
        Start_Frame.setOnMouseExited(e->{
            Start_Frame.setOpacity(1);
        });
        Start_Frame.setOnMousePressed(e->{
            Map_1_Pane.Initialize_Game(Primary_Stage);
        });
        Title_Pane.getChildren().add(Title_Back);
        Title_Pane.getChildren().add(Start_Frame);
        Title_Pane.getChildren().add(Start);
    }

    public static void Initialize_Game()
    {
        My_Flighter.Initialize();
        All_Flighter.add(My_Flighter);
        ImageView_Background_1.setFitWidth(Map_Width);
        ImageView_Background_1.setFitHeight(((double)Map_Width/(double)Map_1_Image_Width)*(double)Map_1_Image_Height);
        ImageView_Background_1.setY(-300);
        PathTransition pt=new PathTransition(Duration.millis(20000),new Line(Map_Width/2,0,Map_Width/2,1500),ImageView_Background_1);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setInterpolator(Interpolator.LINEAR);
        pt.play();
    }
}
