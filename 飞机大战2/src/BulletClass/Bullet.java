package BulletClass;

import javafx.scene.image.ImageView;

public abstract class Bullet {
    public int Bullet_X;//子弹横坐标
    public int Bullet_Y;//子弹纵坐标
    public int Exi=1;
    public double Damage;//伤害
    public int Launch_Interval;//发射间隔
    public double Speed;//子弹的发射速度
    public double Judge_Radius;//判定半径
    public ImageView Bullet_Image;

    public abstract void Initialize(int X,int Y,double Radius);
    public abstract void Bullet_Judge();
}
