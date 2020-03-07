import javax.swing.*;
import java.io.*;
import java.util.*;
public class GameToFile
{
    public static void save(String fln,Data d1)
    {
        String nm1=fln.trim()+".AdiTicTacToe";
        
        JButton butt[]=d1.keys;
        int k=d1.m;
       
        try
        {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(nm1));
           
            oos.writeObject(butt);
            oos.writeInt(k);
            oos.close();
          
        }
        catch(Exception exce)
        {
        }
    }

}
