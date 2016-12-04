/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cmpt310assignment5;

/**
 *
 * @author home
 */
public class Node {

    
    String i,j;
    double pro;
    public Node()
    {
        i="";
        j="";
        pro=0.0;
        
        
        
    }
    public Node(String i,String j,double pro)
    {
        this.i=i;
        this.j=j;
        this.pro=pro;
    }
    public void setI(String i)
    {
        this.i=i;
    }
    public String getI()
    {
        return i;
    }
       public void setJ(String j)
    {
        this.j=j;
    }
    public String getJ()
    {
        return j;
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
