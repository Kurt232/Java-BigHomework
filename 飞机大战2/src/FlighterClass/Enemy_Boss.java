package FlighterClass;

import BulletClass.Boss_Bullet_1;
import BulletClass.Boss_Daodan;
import BulletClass.Bullet;
import BulletClass.Enemy_Elite_Bullet_2;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import static ImagePane.AllImage.*;
import static ImagePane.Map_1_Pane.Main_Pane;
import static ImagePane.Map_1_Pane.Title_Pane;
import static MapClass.Map_1.Map_Width;
import static MapClass.Map_1.My_Flighter;

public class Enemy_Boss extends Flighter{
    int Image_Height=334;
    int Image_Width=448;
    double Image_Width_G=120;
    double Image_Height_G=300;
    double Image_Width_Health=405;
    double Image_Height_Health=36;
    InvalidationListener listener1;
    InvalidationListener listener2;
    PathTransition pt;
    Timeline animation=new Timeline();
    FadeTransition ft=new FadeTransition();
    FadeTransition ft2=new FadeTransition();
    Bullet Bullet_Type2;
    public Rectangle r1=new Rectangle();
    public ImageView Bullet_G=new ImageView(Image_G_1);
    public ImageView Bullet_G_2=new ImageView(Image_G_1);
    public ImageView G_Warning1=new ImageView(Image_G_Warning);
    public ImageView G_Warning2=new ImageView(Image_G_Warning);
    public ImageView Boss_Health=new ImageView(Image_Boss_Health);
    public ImageView Warning=new ImageView(Image_Boss_Warning);

    class Bullet_G implements Runnable{
        public void run()
        {
            for(int i=0;i<50;i++)
            {
                if(Math.abs(My_Flighter.X-(X-190))<My_Flighter.Judge_Radius+40||Math.abs(My_Flighter.X-(X+190))<My_Flighter.Judge_Radius+40)
                    My_Flighter.Health-=0.1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Bullet_Launch implements Runnable {
        public void run() {
            Bullet_G.setFitHeight(Image_Height_G*3);
            Bullet_G.setFitWidth(Image_Width_G*2);
            Bullet_G_2.setFitHeight(Image_Height_G*3);
            Bullet_G_2.setFitWidth(Image_Width_G*2);
            KeyFrame keyframe1=new KeyFrame(Duration.millis(70), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Bullet_G.setImage(Image_G_1);
                    Bullet_G_2.setImage(Image_G_1);
                }
            });
            KeyFrame keyframe2=new KeyFrame(Duration.millis(140), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Bullet_G.setImage(Image_G_2);
                    Bullet_G_2.setImage(Image_G_2);
                }
            });
            KeyFrame keyframe3=new KeyFrame(Duration.millis(210), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Bullet_G.setImage(Image_G_3);
                    Bullet_G_2.setImage(Image_G_3);
                }
            });
            KeyFrame keyframe4=new KeyFrame(Duration.millis(280), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Bullet_G.setImage(Image_G_4);
                    Bullet_G_2.setImage(Image_G_4);
                }
            });
            animation=new Timeline(keyframe1);
            animation.getKeyFrames().add(keyframe2);
            animation.getKeyFrames().add(keyframe3);
            animation.getKeyFrames().add(keyframe4);
            animation.setCycleCount(20);
            ft.setNode(G_Warning1);
            ft.setDuration(Duration.millis(500));
            ft.setFromValue(0);
            ft.setToValue(1);
            ft.setAutoReverse(true);
            ft.setCycleCount(4);
            ft2.setNode(G_Warning2);
            ft2.setDuration(Duration.millis(500));
            ft2.setFromValue(0);
            ft2.setToValue(1);
            ft2.setAutoReverse(true);
            ft2.setCycleCount(4);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            for(int counter=1;;counter++)
            {
                if (Exi == 0)
                    break;

                double Radius=50;
                for (int i = 0; i < 10; i++,Radius-=10)
                {
                    if (Exi == 0)
                        break;
                    Bullet_Type = new Boss_Bullet_1();
                    Bullet_Type2=new Boss_Bullet_1();
                    Bullet_Type.Initialize(X -200, Y, Radius);
                    Bullet_Type2.Initialize(X+200,Y,-Radius);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type.Bullet_Image);
                            Main_Pane.getChildren().add(Bullet_Type2.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Exi == 0)
                    break;
                Radius=50;
                for (int i = 0; i < 10; i++,Radius-=10)
                {
                    if (Exi == 0)
                        break;
                    Bullet_Type = new Boss_Bullet_1();
                    Bullet_Type2=new Boss_Bullet_1();
                    Bullet_Type.Initialize(X - 100, Y, Radius);
                    Bullet_Type2.Initialize(X+100,Y,-Radius);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type.Bullet_Image);
                            Main_Pane.getChildren().add(Bullet_Type2.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Exi == 0)
                    break;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (Exi == 0)
                    break;
                for(int i=0;i<3;i++)//导弹
                {
                    if (Exi == 0)
                        break;
                    Bullet_Type=new Boss_Daodan();
                    Bullet_Type2=new Boss_Daodan();
                    Bullet_Type.Initialize(X-50,Y,0);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Exi == 0)
                        break;
                    Bullet_Type2.Initialize(X+50,Y,0);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().add(Bullet_Type2.Bullet_Image);
                        }
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Exi == 0)
                        break;
                }


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Exi == 0)
                    break;
                if(counter%3==0)
                {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Speed=1;
                            G_Warning1.setVisible(true);
                            G_Warning2.setVisible(true);
                            Main_Pane.getChildren().add(G_Warning1);
                            Main_Pane.getChildren().add(G_Warning2);
                            ft.play();
                            ft2.play();

                        }
                    });

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Bullet_G.setVisible(true);
                            Bullet_G_2.setVisible(true);
                            Main_Pane.getChildren().add(Bullet_G);
                            Main_Pane.getChildren().add(Bullet_G_2);
                            G_Warning1.setVisible(false);
                            G_Warning2.setVisible(false);
                            Main_Pane.getChildren().remove(G_Warning1);
                            Main_Pane.getChildren().remove(G_Warning2);
                            ft.stop();
                            ft2.stop();
                            animation.play();
                            new Thread(new Bullet_G()).start();
                        }
                    });
                    if (Exi == 0)
                        break;
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Exi == 0)
                        break;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Speed=2;
                            animation.stop();

                            Bullet_G.setVisible(false);
                            Bullet_G_2.setVisible(false);
                            Main_Pane.getChildren().remove(Bullet_G);
                            Main_Pane.getChildren().remove(Bullet_G_2);
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class My_Flighter_Move implements Runnable
    {
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    pt.play();
                }
            });
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Speed=2;
            while (true) {
                if (Exi == 0)
                    break;

                int Origin_X = X;
                int Origin_Y = Y;
                double Des_X=200+Math.random()*800;

                Path path0=new Path(new MoveTo(Origin_X,Origin_Y+10));
                path0.getElements().add(new LineTo(Des_X,Origin_Y+10));
                pt.setPath(path0);
                pt.setDuration(Duration.millis(Math.abs((double)Origin_X-Des_X)/(Speed/10)));
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pt.play();
                    }
                });
                try {
                    Thread.sleep((long)(Math.abs((double)Origin_X-Des_X)/(Speed/10)+1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Path path1 = new Path(new MoveTo(Des_X, Origin_Y + 10));
                path1.getElements().add(new LineTo(130, Origin_Y + 10));
                pt.setPath(path1);
                pt.setDuration(Duration.millis(Math.abs(Des_X-130)/(Speed/10)));
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pt.play();
                    }
                });
                try {
                    Thread.sleep((long)(Math.abs(Des_X-130)/(Speed/10)+500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double Des_X_2=200+Math.random()*800;
                Path path2 = new Path(new MoveTo(130, Origin_Y + 10));
                path2.getElements().add(new LineTo(Des_X_2, Origin_Y + 10));
                pt.setDuration(Duration.millis(Math.abs(Des_X_2-130)/(Speed/10)));
                pt.setPath(path2);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pt.play();
                    }
                });
                try {
                    Thread.sleep((long)(Math.abs(Des_X_2-130)/(Speed/10)+1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Path path3 = new Path(new MoveTo(Des_X_2, Origin_Y + 10));
                path3.getElements().add(new LineTo(870, Origin_Y + 10));
                pt.setDuration(Duration.millis(Math.abs(870-Des_X_2)/(Speed/10)));
                pt.setPath(path3);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pt.play();
                    }
                });
                try {
                    Thread.sleep((long)(Math.abs(870-Des_X_2)/(Speed/10)+500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Path path4 = new Path(new MoveTo(870, Origin_Y + 10));
                path4.getElements().add(new LineTo(Des_X, Origin_Y + 10));
                pt.setDuration(Duration.millis(Math.abs(870-Des_X)/(Speed/10)));
                pt.setPath(path4);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        pt.play();
                    }
                });
                try {
                    Thread.sleep((long)(Math.abs(870-Des_X)/(Speed/10)+1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Flighter_Thread implements Runnable
    {
        public void run()
        {
            while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if(Health>=0)
                            r1.setWidth(655*((double)Health/800));
                    }
                });
                if (Health <= 0) {
                    Exi = 0;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {


                            pt.stop();
                            G_Warning1.setVisible(false);
                            G_Warning2.setVisible(false);
                            Bullet_G.setVisible(false);
                            Bullet_G_2.setVisible(false);
                            animation.stop();
                            ft.stop();
                            ft2.stop();



                            Boom(X-150,Y-30);

                            Boom(X+150,Y+20);

                            Boom(X,Y);

                            Boom(X+70,Y-40);

                            Boom(X-50,Y+50);
                        }
                    });
                            try {
                                Thread.sleep(700);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main_Pane.getChildren().remove(Bullet_G);
                            Main_Pane.getChildren().remove(Bullet_G_2);
                            Main_Pane.getChildren().remove(G_Warning1);
                            Main_Pane.getChildren().remove(G_Warning2);
                            Flighter_Image.translateXProperty().removeListener(listener1);
                            Flighter_Image.translateYProperty().removeListener(listener2);
                            Boss_Health.setVisible(false);
                            r1.setVisible(false);
                            Flighter_Image.setVisible(false);
                            Main_Pane.getChildren().remove(Flighter_Image);
                            Main_Pane.getChildren().remove(r1);
                            Main_Pane.getChildren().remove(Boss_Health);
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
        Boss_Health.setFitWidth(Image_Width_Health*1.7);
        Boss_Health.setFitHeight(Image_Height_Health*1.7);

        Boss_Health.setX(170);
        Boss_Health.setY(900);
        Num=num;
        Health=800;
        this.X=i;
        this.Y=j;
        Speed=0.7;
        Exi=1;
        Judge_Radius=170;

        r1.setHeight(15);
        r1.setWidth(655);
        r1.setArcHeight(14);
        r1.setArcWidth(14);
        r1.setFill(Color.RED);
        r1.setX(190);
        r1.setY(922);

        Bullet_Type=new Boss_Bullet_1();
        Flighter_Image=new ImageView(Image_Boss);
        Flighter_Image.setFitHeight(Image_Height);
        Flighter_Image.setFitWidth(Image_Width);
        Flighter_Image.setX(X-223);
        Flighter_Image.setY(Y-160);

        listener1=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                X=i+(int)Flighter_Image.getTranslateX();
                G_Warning1.setX(X-220);
                G_Warning2.setX(X+150);
                Bullet_G.setX(X-300);
                Bullet_G_2.setX(X+70);
            }
        };
        listener2=new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Y=j+(int)Flighter_Image.getTranslateY();
                Bullet_G.setY(Y-70);
                Bullet_G_2.setY(Y-70);
                G_Warning1.setY(Y-80);
                G_Warning2.setY(Y-80);
            }
        };
        Flighter_Image.translateXProperty().addListener(listener1);
        Flighter_Image.translateYProperty().addListener(listener2);
        pt=new PathTransition(Duration.millis((Des_Y-(double)Y)/(Speed/10)),new Line(X,Y,X,Des_Y),Flighter_Image);
        new Thread(new Bullet_Launch()).start();
        new Thread(new My_Flighter_Move()).start();
        new Thread(new Flighter_Thread()).start();
    }

    public void Boom(int i,int j)
    {
        ImageView Boom_Image=new ImageView(Image_Boom2_1);
        Boom_Image.setX(i-45);
        Boom_Image.setY(j-45);
        Boom_Image.setScaleX(1.7);
        Boom_Image.setScaleY(1.7);
        KeyFrame keyframe1=new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main_Pane.getChildren().add(Boom_Image);
            }
        });
        KeyFrame keyframe2=new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_2);
            }
        });
        KeyFrame keyframe3=new KeyFrame(Duration.millis(150), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_3);
            }
        });
        KeyFrame keyframe4=new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_4);
            }
        });
        KeyFrame keyframe5=new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_5);
            }
        });
        KeyFrame keyframe6=new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_6);
            }
        });
        KeyFrame keyframe7=new KeyFrame(Duration.millis(350), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_7);
            }
        });
        KeyFrame keyframe8=new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_8);
            }
        });
        KeyFrame keyframe9=new KeyFrame(Duration.millis(450), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_9);
            }
        });
        KeyFrame keyframe10=new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_10);
            }
        });
        KeyFrame keyframe11=new KeyFrame(Duration.millis(550), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setImage(Image_Boom2_11);
            }
        });
        KeyFrame keyframe12=new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boom_Image.setVisible(false);
                Main_Pane.getChildren().remove(Boom_Image);
            }
        });
        Timeline Boom=new Timeline(keyframe1);
        Boom.getKeyFrames().add(keyframe2);
        Boom.getKeyFrames().add(keyframe3);
        Boom.getKeyFrames().add(keyframe4);
        Boom.getKeyFrames().add(keyframe5);
        Boom.getKeyFrames().add(keyframe6);
        Boom.getKeyFrames().add(keyframe7);
        Boom.getKeyFrames().add(keyframe8);
        Boom.getKeyFrames().add(keyframe9);
        Boom.getKeyFrames().add(keyframe10);
        Boom.getKeyFrames().add(keyframe11);
        Boom.getKeyFrames().add(keyframe12);
        Boom.play();
    }
}
