/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dromeymodel;

import java.io.FileOutputStream;
public class check1 {
    public static int d,a;
    public static int e=10;
    int r=23;
    //public int r=23;
    check1(){}
    check1(int e,int d){
        this.e =e;
        this.d =d;
//        r = 23;
        }
    
  public static void main(String args[]) {
    check1 c=new check1(10,0);
      a = 42 / d;
      System.out.println("This will not be printed.");
      
    try {
        FileOutputStream fout= new FileOutputStream("D:\\java.txt");
        String s="Welcome to java";
        byte b[]=s.getBytes();
        int q=12;
//        byte a[]=q.getBytes();
        fout.write(b);
//        fout.write(String.valueOf(q));
        fout.close();
        System.out.println("Success.............");
    }
    catch(Exception e){
        System.out.println(e);
    }
    
    
}

   }

