package dromeymodel;
/*Tools to measure software Quality*/
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
class Array1 {
    public static void main(String[] args) {
      int length;
      Scanner sc= new Scanner (System.in);
      System.out .println("Enter no of friends whose name you want to enter :");
      length= sc.nextInt();
      String []names = new String[length];
      for(int count=0;count<length;count++){
          System.out.println("Enter name of friend"+(count+1));
          names[count]=sc.next();}
      System.out.println("My friends name are: ");
      for(int count=0;count<length;count++){
          
          System.out.println(names[count]);
      }
    }
    
    
}

public class check4 {

	private static final String FILENAME = "E:\\test\\filename.txt";

    public static void main(String[] args) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "This is the content to write into file\n";

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}

  
