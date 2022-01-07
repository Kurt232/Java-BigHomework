package FlighterClass;

import BulletClass.Bullet;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public abstract class Flighter {
    public int Num;//编号
    public int Health;      //生命值
    public int X;           //X坐标
    public int Y;           //Y坐标
    public double Judge_Radius;//判定范围
    public double Speed;    //飞行速度
    public Bullet Bullet_Type;//子弹种类
    public int Exi=1;//存在性
    public ImageView Flighter_Image;//插图

    public boolean Death_Judge()
    {
        if(Health==0)
        {
            Exi=0;
            return true;
        }
            else return false;
    }
}
