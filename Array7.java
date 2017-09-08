package dromeymodel;
/*my name*/
import java.util.*;
public class Array7 {
    int m,n;
    int [][]a= new int[10][10];
    int [][]b= new int[10][10];
    int [][]c= new int[10][10];
    Scanner s=new Scanner(System.in);
    void setdata(){
        System.out.println("Enter number of row and column in matrix: ");
        m=s.nextInt();
        n=s.nextInt();
        System.out.println("Enter array1 elements: ");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                a[i][j]=s.nextInt();
            }
        }
         System.out.println("Enter array2 elements: ");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                b[i][j]=s.nextInt();
            }
        }
    }
    void display()
    {
        System.out.println("array1 is: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+"\t");
                
            }
            System.out.println();
        }
        System.out.println("array2 is: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(b[i][j]+"\t");
                
            }
            System.out.println();
        }
    }
    void sum(){
        if(m==n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        System.out.println("Sum of two matrices are: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(c[i][j]+"\t");
                
            }
            System.out.println();
        }
    }
        else{
            System.out.println("Sum of matrices not posible");
        }
    }
        void subtract(){
             if(m==n){
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c[i][j]=a[i][j]-b[i][j];
            }
        }
        System.out.println("Subtraction of two matrices is: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(c[i][j]+"\t");
                
            }
            System.out.println();
        }
    }
              else{
            System.out.println("Subtraction of matrices not posible");
        }
        }
        void transpose(){
            for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                c[i][j]=a[j][i];
            }
            }
            System.out.println("TRanspose of first matrix is: ");
            for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(c[i][j]+"\t");
                
            }
            System.out.println();
        }
        }
        void Sumdiagonal()
        {
            int sum=0;
            for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    sum=sum+a[i][j];
                }
            }
            }
            System.out.print("sum of daigonal element of first matrix is: ");
                System.out.println(sum);   
        }
        void sumrc(){
            for(int i=0;i<m;i++){
                a[i][n]=0;
            for(int j=0;j<n;j++){
                    a[i][n]=a[i][n]+a[i][j];
            }
            }
            for(int j=0;j<n;j++){
                a[m][j]=0;
            for(int i=0;i<m;i++){
                    a[m][j]=a[m][j]+a[i][j];
            }
            }
            System.out.println("sum of row and column elements of first matrix is: ");
            for(int i=0;i<(m+1);i++){
            for(int j=0;j<(n+1);j++){
                if((i==m)&& (j==n)){
                System.out.print(" ");
                }
                else
                {
                    System.out.print(a[i][j]+"\t");
                }
            }
            System.out.println();
        }
        }
        void multi()
        { 
            if(m==n)
            {
           for(int i=0;i<m;i++){ 
               
           for(int j=0;j<n;j++){
               c[i][j]=0;
               for(int k=0;k<m;k++){
                   c[i][j]=c[i][j]+(a[i][k]*b[k][j]);
               }
           }
           }
           System.out.println("Multiplication of two matriXes is:: ");
            for(int i=0;i<m;i++){ 
           for(int j=0;j<n;j++){
            System.out.print(c[i][j]+"\t");
           }
           System.out.println();
           }
            }
            else{
                System.out.println("Matrix multiplication is not possible in this condition: ");
            }
        }
    public static void main(String[] args) {
        Array7 q=new Array7();
        q.setdata();
        q.display();
//        q.sum();
//        q.subtract();
//        q.transpose();
//        q.Sumdiagonal();
//        q.sumrc();
    q.multi();
    }
    
}
