
public class TriangleTest {
    public static void main(String[] args){
        double[][] v=new double[4][3];
        v[0]=new double[]{3,4,5};
        v[1]=new double[]{3,4,8};
        v[2]=new double[]{3,3,3};
        v[3]=new double[]{3.2,4.3,5,5};
        for(int i=0; i<4; i++){
            Triangle test= new Triangle(v[i][0],v[i][1],v[i][2]);
            System.out.println(test.toString());
            System.out.println(test.getArea());
            System.out.println(test.getPerimeter());
        }
    }
}

class Triangle implements Comparable<Triangle>{
    //three of Triangle
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }


    private boolean checkTriangle(){
        double d=(a+b+c)/2;
        return d*(d-a)*(d-b)*(d-c)>0.00;
    }

    public double getPerimeter(){
        if(checkTriangle())
            return a+b+c;
        return -1;
    }

    public double getArea(){
        if(checkTriangle()) {
            double d = getPerimeter() / 2;
            return Math.sqrt(d * (d - a) * (d - b) * (d - c));
        }
        return -1;
    }


    boolean isRightTriangle(){
        if(checkTriangle())
            return a*a==b*b+c*c||b*b==a*a+c*c||c*c==a*a+b*b;
        return false;
    }

    @Override
    public String toString() {
        if(checkTriangle())
            return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}'+'\n'
                +"the Area is "+getArea()+'\n'
                +"the Perimeter is "+ getPerimeter()+'\n'
                +"the Triangle "+ (isRightTriangle()? "is": "is not")+" right triangle"+'\n';
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}'+"it is not a triangle";
    }
    //useless
    public int compareTo(Triangle o){
        return  0;
    }

}
