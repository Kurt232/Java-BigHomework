package MyThread;

import FlighterClass.*;
import Updates.Super_Bullet;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import static ImagePane.Map_1_Pane.Main_Pane;
import static MapClass.Map_1.All_Flighter;
import static MapClass.Map_1.Map_Width;


public class Enemy_Generator implements Runnable{
    public static PathTransition Generate_Path(int i,int Des_X,int Des_Y)
    {
        if(i==1)
            return new PathTransition(Duration.millis(3000),new Line(20,-30,Des_X,Des_Y));
        else if(i==2)
            return new PathTransition(Duration.millis(3000),new Line(Map_Width-20,-30,Des_X,Des_Y));
        else return new PathTransition(Duration.millis(3000),new Line(Map_Width/2,-30,Des_X,Des_Y));
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_1=new Enemy_Type2();
        All_Flighter.add(Enemy2_1);
        Enemy2_1.Initialize(350,0,1);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_1.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_2=new Enemy_Type2();
        All_Flighter.add(Enemy2_2);
        Enemy2_2.Initialize(650,0,2);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_2.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_3=new Enemy_Type2();
        All_Flighter.add(Enemy2_3);
        Enemy2_3.Initialize(500,0,3);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_3.Flighter_Image);
            }
        });
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_4 = new Enemy_Type1();
        Enemy_Type1 Enemy1_5 = new Enemy_Type1();
        All_Flighter.add(Enemy1_4);
        All_Flighter.add(Enemy1_5);
        Enemy1_4.Initialize(20, -30, Generate_Path(1, 800, 300),4);
        Enemy1_5.Initialize(Map_Width - 20, -30, Generate_Path(2, 200, 300),5);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_4.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_4.r2);
                Main_Pane.getChildren().add(Enemy1_4.r1);
                Main_Pane.getChildren().add(Enemy1_5.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_5.r2);
                Main_Pane.getChildren().add(Enemy1_5.r1);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_6 = new Enemy_Type1();
        Enemy_Type1 Enemy1_7 = new Enemy_Type1();
        All_Flighter.add(Enemy1_6);
        All_Flighter.add(Enemy1_7);
        Enemy1_6.Initialize(20, -30, Generate_Path(1, 700, 200),6);
        Enemy1_7.Initialize(Map_Width - 20, -30, Generate_Path(2, 300, 200),7);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_6.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_6.r2);
                Main_Pane.getChildren().add(Enemy1_6.r1);
                Main_Pane.getChildren().add(Enemy1_7.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_7.r2);
                Main_Pane.getChildren().add(Enemy1_7.r1);
            }
        });
        try {
            Thread.sleep(14000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Super_Bullet Update_1=new Super_Bullet();
        Update_1.Initialize(500,-30);
        Enemy_Elite_1 Enemy3_8=new Enemy_Elite_1();
        All_Flighter.add(Enemy3_8);
        Enemy3_8.Initialize(200,-50,8,200);
        Enemy_Type2 Enemy2_9=new Enemy_Type2();
        All_Flighter.add(Enemy2_9);
        Enemy2_9.Initialize(650,0,9);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_9.Flighter_Image);
                Main_Pane.getChildren().add(Enemy3_8.Flighter_Image);
                Main_Pane.getChildren().add(Enemy3_8.r2);
                Main_Pane.getChildren().add(Enemy3_8.r1);
                Main_Pane.getChildren().add(Update_1.Update_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_10=new Enemy_Type2();
        All_Flighter.add(Enemy2_10);
        Enemy2_10.Initialize(350,0,10);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_10.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_11=new Enemy_Type1();
        All_Flighter.add(Enemy1_11);
        Enemy1_11.Initialize(20, -30, Generate_Path(1, 800, 300),11);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_11.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_11.r2);
                Main_Pane.getChildren().add(Enemy1_11.r1);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_12=new Enemy_Type1();
        All_Flighter.add(Enemy1_12);
        Enemy1_12.Initialize(20, -30, Generate_Path(1, 700, 200),12);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_12.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_12.r2);
                Main_Pane.getChildren().add(Enemy1_12.r1);
            }
        });
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_13 = new Enemy_Type1();
        Enemy_Type1 Enemy1_14 = new Enemy_Type1();
        All_Flighter.add(Enemy1_13);
        All_Flighter.add(Enemy1_14);
        Enemy1_13.Initialize(20, -30, Generate_Path(1, 800, 300),13);
        Enemy1_14.Initialize(Map_Width - 20, -30, Generate_Path(2, 200, 300),14);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_13.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_13.r2);
                Main_Pane.getChildren().add(Enemy1_13.r1);
                Main_Pane.getChildren().add(Enemy1_14.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_14.r2);
                Main_Pane.getChildren().add(Enemy1_14.r1);

            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_15 = new Enemy_Type1();
        Enemy_Type1 Enemy1_16 = new Enemy_Type1();
        All_Flighter.add(Enemy1_15);
        All_Flighter.add(Enemy1_16);
        Enemy1_15.Initialize(20, -30, Generate_Path(1, 700, 200),15);
        Enemy1_16.Initialize(Map_Width - 20, -30, Generate_Path(2, 300, 200),16);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_15.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_15.r2);
                Main_Pane.getChildren().add(Enemy1_15.r1);
                Main_Pane.getChildren().add(Enemy1_16.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_16.r2);
                Main_Pane.getChildren().add(Enemy1_16.r1);
            }
        });
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_17=new Enemy_Type2();
        All_Flighter.add(Enemy2_17);
        Enemy2_17.Initialize(350,0,17);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_17.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_18=new Enemy_Type2();
        All_Flighter.add(Enemy2_18);
        Enemy2_18.Initialize(650,0,18);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_18.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_19=new Enemy_Type2();
        All_Flighter.add(Enemy2_19);
        Enemy2_19.Initialize(500,0,19);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_19.Flighter_Image);
            }
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Enemy_Type1 Enemy1_20 = new Enemy_Type1();
        Enemy_Type1 Enemy1_21 = new Enemy_Type1();
        All_Flighter.add(Enemy1_20);
        All_Flighter.add(Enemy1_21);
        Enemy1_20.Initialize(20, -30, Generate_Path(1, 800, 300),20);
        Enemy1_21.Initialize(Map_Width - 20, -30, Generate_Path(2, 200, 300),21);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_20.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_20.r2);
                Main_Pane.getChildren().add(Enemy1_20.r1);
                Main_Pane.getChildren().add(Enemy1_21.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_21.r2);
                Main_Pane.getChildren().add(Enemy1_21.r1);

            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Elite_2 Enemy4_22=new Enemy_Elite_2();
        All_Flighter.add(Enemy4_22);
        Enemy4_22.Initialize(800,-50,22,150);
        Enemy_Type1 Enemy1_23 = new Enemy_Type1();
        Enemy_Type1 Enemy1_24 = new Enemy_Type1();
        All_Flighter.add(Enemy1_23);
        All_Flighter.add(Enemy1_24);
        Enemy1_23.Initialize(20, -30, Generate_Path(1, 700, 200),23);
        Enemy1_24.Initialize(Map_Width - 20, -30, Generate_Path(2, 300, 200),24);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_23.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_23.r2);
                Main_Pane.getChildren().add(Enemy1_23.r1);
                Main_Pane.getChildren().add(Enemy1_24.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_24.r2);
                Main_Pane.getChildren().add(Enemy1_24.r1);
                Main_Pane.getChildren().add(Enemy4_22.Flighter_Image);
                Main_Pane.getChildren().add(Enemy4_22.r2);
                Main_Pane.getChildren().add(Enemy4_22.r1);
            }
        });
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_25=new Enemy_Type2();
        All_Flighter.add(Enemy2_25);
        Enemy2_25.Initialize(350,0,25);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_25.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_26=new Enemy_Type2();
        All_Flighter.add(Enemy2_26);
        Enemy2_26.Initialize(650,0,26);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_26.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_27=new Enemy_Type2();
        All_Flighter.add(Enemy2_27);
        Enemy2_27.Initialize(500,0,27);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_27.Flighter_Image);
            }
        });


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type1 Enemy1_28 = new Enemy_Type1();
        Enemy_Type1 Enemy1_29 = new Enemy_Type1();
        All_Flighter.add(Enemy1_28);
        All_Flighter.add(Enemy1_29);
        Enemy1_28.Initialize(20, -30, Generate_Path(1, 800, 300),28);
        Enemy1_29.Initialize(Map_Width - 20, -30, Generate_Path(2, 200, 300),29);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_28.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_28.r2);
                Main_Pane.getChildren().add(Enemy1_28.r1);
                Main_Pane.getChildren().add(Enemy1_29.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_29.r2);
                Main_Pane.getChildren().add(Enemy1_29.r1);

            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Elite_2 Enemy4_30=new Enemy_Elite_2();
        All_Flighter.add(Enemy4_30);
        Enemy4_30.Initialize(800,-50,30,250);
        Enemy_Elite_2 Enemy4_33=new Enemy_Elite_2();
        All_Flighter.add(Enemy4_33);
        Enemy4_33.Initialize(200,-50,33,250);
        Enemy_Elite_1 Enemy3_34=new Enemy_Elite_1();
        All_Flighter.add(Enemy3_34);
        Enemy3_34.Initialize(500,-50,34,150);
        Enemy_Type1 Enemy1_31 = new Enemy_Type1();
        Enemy_Type1 Enemy1_32 = new Enemy_Type1();
        All_Flighter.add(Enemy1_31);
        All_Flighter.add(Enemy1_32);
        Enemy1_31.Initialize(20, -30, Generate_Path(1, 700, 200),31);
        Enemy1_32.Initialize(Map_Width - 20, -30, Generate_Path(2, 300, 200),32);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy1_31.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_31.r2);
                Main_Pane.getChildren().add(Enemy1_31.r1);
                Main_Pane.getChildren().add(Enemy1_32.Flighter_Image);
                Main_Pane.getChildren().add(Enemy1_32.r2);
                Main_Pane.getChildren().add(Enemy1_32.r1);
                Main_Pane.getChildren().add(Enemy4_30.Flighter_Image);
                Main_Pane.getChildren().add(Enemy4_30.r2);
                Main_Pane.getChildren().add(Enemy4_30.r1);
                Main_Pane.getChildren().add(Enemy4_33.Flighter_Image);
                Main_Pane.getChildren().add(Enemy4_33.r2);
                Main_Pane.getChildren().add(Enemy4_33.r1);
                Main_Pane.getChildren().add(Enemy3_34.Flighter_Image);
                Main_Pane.getChildren().add(Enemy3_34.r2);
                Main_Pane.getChildren().add(Enemy3_34.r1);
            }
        });
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_35=new Enemy_Type2();
        All_Flighter.add(Enemy2_35);
        Enemy2_35.Initialize(350,0,35);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_35.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_36=new Enemy_Type2();
        All_Flighter.add(Enemy2_36);
        Enemy2_36.Initialize(650,0,36);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_36.Flighter_Image);
            }
        });
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Type2 Enemy2_37=new Enemy_Type2();
        All_Flighter.add(Enemy2_37);
        Enemy2_37.Initialize(500,0,37);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Main_Pane.getChildren().add(Enemy2_37.Flighter_Image);
            }
        });

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Enemy_Boss Enemy5_38=new Enemy_Boss();
        FadeTransition ft=new FadeTransition();
        ft.setNode(Enemy5_38.Warning);
        ft.setDuration(Duration.millis(500));
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setAutoReverse(true);
        ft.setCycleCount(6);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Enemy5_38.Warning.setX(280);
                Enemy5_38.Warning.setY(400);
                Main_Pane.getChildren().add(Enemy5_38.Warning);
                ft.play();
            }
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        All_Flighter.add(Enemy5_38);
        Enemy5_38.Initialize(500,-100,38,200);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ft.stop();
                Main_Pane.getChildren().remove(Enemy5_38.Warning);
                Main_Pane.getChildren().add(Enemy5_38.Flighter_Image);
                Main_Pane.getChildren().add(Enemy5_38.Boss_Health);
                Main_Pane.getChildren().add(Enemy5_38.r1);
            }
        });
    }
}
