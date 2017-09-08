package dromeymodel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
//import java.lang.reflect.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.*;

//import java.util.HashMap;



/*.................................................................Constructor............................................................  **/
class dromeym {
    private JFrame mainframe;
    private JLabel headerlabel;
    private JLabel statuslabel;
//    private JLabel statuslabel2;
    private JPanel controlpanel;
    private int q;
    public int flag =0;
    public int flag2 =0;
//    private Field[] fields;
    public dromeym(){
        prepareGUI();
    }
    
/*.................................................................Frame Structure ............................................................  **/
    private void prepareGUI(){
        mainframe = new JFrame("Dromey Model");
        mainframe.setSize(500,500);
        mainframe.setLocationRelativeTo(null);
        mainframe.setLayout(new GridLayout(3,1));
        mainframe.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerlabel=new JLabel("",JLabel.CENTER);
        statuslabel=new JLabel("",JLabel.CENTER);
        statuslabel.setSize(350,50);
//        statuslabel2=new JLabel("",JLabel.CENTER);
//        statuslabel2.setSize(350,50);
        
        controlpanel=new JPanel();
        controlpanel.setLayout(new FlowLayout());
        mainframe.add(headerlabel);
        mainframe.add(controlpanel);
//        mainframe.add(statuslabel2);
        mainframe.add(statuslabel);
        mainframe.setVisible(true);
        }
    
    void showTextFieldDemo(){
        JLabel filename=new JLabel ("Enter file Name : ",JLabel.RIGHT);
        final JTextField address= new JTextField(25);
        JTextField finame= new JTextField(25);
        JTextField dir1= new JTextField(25);
        JButton browse=new JButton("Browse");
        
/*.................................................................Browse Button Working............................................................  **/

        browse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a) {
                Chooser frame = new Chooser();
                address.setText(frame.fileaddress);
                finame.setText(frame.fname);
                dir1.setText(frame.dir);
                
            }
        });
        
        
/*.................................................................Submit Button Working............................................................  **/
        

        JButton submit= new JButton ("Submit");
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data =address.getText();
                String data1 = finame.getText();
//                statuslabel.setText(data1+"   "+data);
                String directory=dir1.getText();
                String filenaam=finame.getText();
                String des="C:\\Users\\kiit1\\Documents\\NetBeansProjects\\DromeyModel\\src\\dromeymodel";
                String exe=" ";
                int u=filenaam.lastIndexOf('.');
                if(u>0){
                   exe=filenaam.substring(u+1);
                }
                if(exe == " "){
                statuslabel.setText("Select a file");
                }
                
                
                else if("java".equals(exe)){
                    if(directory.equals(des)){
                        try {
                            checkExists(directory,filenaam);
                        } catch (IllegalAccessException | ClassNotFoundException | FileNotFoundException ex) {
                        }
                        catch (InstantiationException ex) {
                            Logger.getLogger(dromeym.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                    else{
                        try{
                            String s= directory+"\\"+filenaam;
                            File afile =new File(s);
                            if(afile.renameTo(new File("C:\\Users\\kiit1\\Documents\\NetBeansProjects\\DromeyModel\\src\\dromeymodel\\" + afile.getName()))){
                                statuslabel.setText("File is moved successful!");
                                String ae=filenaam.substring(0,filenaam.lastIndexOf('.'));
                                Path path = Paths.get("C:\\Users\\kiit1\\Documents\\NetBeansProjects\\DromeyModel\\src\\dromeymodel\\" + afile.getName());
                                Charset charset = StandardCharsets.UTF_8;
                                String content = new String(Files.readAllBytes(path), charset);
                                content = content.replaceAll("package "+ae.toLowerCase() ,"package dromeymodel");
                                Files.write(path, content.getBytes(charset));
                                checkExists("C:\\Users\\kiit1\\Documents\\NetBeansProjects\\DromeyModel\\src\\dromeymodel",filenaam);
                            }
                            else{
                                statuslabel.setText("File is failed to move!");
                            }

                        }
                        catch(IllegalAccessException | ClassNotFoundException | FileNotFoundException p){} 
                        catch (IOException ex) {
                        Logger.getLogger(dromeym.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(dromeym.class.getName()).log(Level.SEVERE, null, ex);
                        }
                           
                    }
                    if(flag==0){
                    headerlabel.setText("File follow Correctness property");
                }
                if(flag==1){
                    headerlabel.setText("File not follow Correctness property");
                }
                if(flag2==0){
                    statuslabel.setText("File follow  Descriptive Property");
                }
                else if(flag2==1){
                    statuslabel.setText("File not follow  Descriptive Property");
                }
                }
                 else{
                    statuslabel.setText("file is of "+exe+" type please take java code file"); 
                }
            
            }
       
        });
        
        controlpanel.add(filename);
        controlpanel.add(address);
        controlpanel.add(browse);
        controlpanel.add(submit);
        mainframe.setVisible(true);
    }
    
    
    
    public void checkExists(String dir2, String file) throws IllegalAccessException, ClassNotFoundException, FileNotFoundException, InstantiationException {
//int flag=0;   
//int flag2=0;   
        String g=" ";
        int vi=dir2.lastIndexOf('\\') ;
        if(vi>0){
            g=dir2.substring(vi+1);
        }
        String a=file.substring(0,file.lastIndexOf('.'));
           String z=dir2+"\\"+file ;

/*.................................................................Extract variables............................................................  **/

        Class<?> c = Class.forName(g+"."+a);                                    
                Object obj = c.newInstance();
                Field[] fields = c.getFields();
                for (int i=0;i<fields.length ;i++) {
                Object value = fields[i].get(c); 
             fields[i].setAccessible(true);
            int q=(int)value;
            c = fields[i].getType();
            
            
/*.................................................................Check variables............................................................  **/
                        if((c.getName()== "int")||(c.getName()== "double")||(c.getName()== "float")){
                            
                                if(q==0) {
                                   flag=1;
                                }
                                else if(q<0)
                                    {
                                        flag=1;
                                    }
                                
                                else if(fields[i].getType().isArray()){
                                 Object[] object=(Object[])fields[i].get(c);
                                 for(int j=0;j<object.length;j++){
                                    object[j] = Array.get(object, j);
                                    flag =1;
                                  }
                                }
                                else if(value==" "){
                                    flag=1;
                                }
                                else if(fields[i].getType().equals(boolean.class)){
                                  if((q==(q+1))||(q==(q-1)))
                                  {
                                      flag=1;
                                  }      
                                }
                           
                        try{
                            
                            fields[i]=fields[i];
                           
                            flag=1;
                        }catch(ArithmeticException e){System.out.println("Assignment to itself"+e);}
                        
                
                    }
                    
                   if(fields[i].getName().length()>20)//over-described
                   {
                       flag2=1;
                   } 
                   String qp=fields[i].getName();
                   
                   Pattern p1 = Pattern.compile("[^a-zA-Z ]", Pattern.CASE_INSENSITIVE);
                    Matcher m1 = p1.matcher(qp);
                    boolean b = m1.find();

                    if (b||qp.length()>20) //name is ambiguous, misleading or wrong
                    {
                         flag2=1;
                         }
                }
                
                
                String b=null;	
		    BufferedReader br=null;
				br = new BufferedReader(new FileReader(z));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		        b= sb.toString();
		   } catch (IOException e) {
			} finally {
		        try {
					br.close();
				} catch (IOException e) {
				}}
Pattern p = Pattern.compile("(?s)/\\*.*?\\*/");
Matcher m = p.matcher(b);
while(m.find())
{
    
    if(m.group()==""){
    flag2=1;
    }
    if(m.group().length()<20){
        flag2=1;
    }
    if(m.group().length()>1000){
        flag2=1;
    }
}    
   
                
                
                
                
                
    }
                
            }
        
    

    
    

    
 
/*.................................................................Browse Files   ............................................................  **/

    class Chooser extends JFrame {
        JFileChooser chooser;
        String fileaddress;
        String fname;
        String dir;
        public Chooser() {
            chooser = new JFileChooser();
            int r = chooser.showOpenDialog(new JFrame());
            if (r == JFileChooser.APPROVE_OPTION) {
                fileaddress = chooser.getSelectedFile().getPath();
                fname= chooser.getSelectedFile().getName();
                dir=chooser.getCurrentDirectory().getPath();
            }
        }
    }


/*.................................................................  Main Class ............................................................  **/
    public class DromeyModel{
        public static void main(String[] args) {
            dromeym ck=new dromeym();
            ck.showTextFieldDemo();
        }
    }