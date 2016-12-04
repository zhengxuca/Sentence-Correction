/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cmpt310assignment5;

/**
 *
 * @author zxa
 */
public class M {

    String x;
    double pro;
    int t;
    public M()
    {
        x="";
        pro=0;
        t=0;
    }
    public M(String x,double pro,int t)
    {
        this.x=x;
        this.pro=pro;
        this.t=t;
    }
    public void setT(int t)
    {
        this.t=t;
    }
    public int getT()
    {
        return t;
    }
    
public void setX(String x)
{
    this.x=x;
}
public String getX()
{
    return x;
}
public void setPro(double p)
{
    pro=p;
}
public double getPro()
{
    return pro;
}


    
    
    
}
