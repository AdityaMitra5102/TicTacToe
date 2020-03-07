import java.io.*;
import javax.swing.*;
import java.awt.event.*;
class LoadGame implements ActionListener
{
    JFrame fr=new JFrame("Load Game");
    JTextField fln=new JTextField(30);
    JButton sv=new JButton("Load");
    JPanel pan=new JPanel();
    gui obj;
    static JButton[] ks=new JButton[9];
    static int m=0;
    LoadGame(gui ob)
    {
        obj=ob;
        pan.add(new JLabel("Enter File Name"));
        pan.add(fln);
        pan.add(sv);
        fr.setSize(400,200);
        fr.setResizable(false);
        fr.add(pan);
        fr.setVisible(true);
        sv.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        int m=load(fln.getText());
        for(int i=0;i<9;i++)
        {
            obj.butt[i].setText(ks[i].getText());
            obj.butt[i].setEnabled(ks[i].isEnabled());

        }
        obj.move=m;
        //System.out.println("Changed Move to "+obj.move);
        obj.ar.setText("Player "+m+"\'s Move");
        obj.fr.setVisible(true);
        fr.setVisible(false);
    }

    public static int load(String fln)
    {

        String nm1=fln.trim()+".AdiTicTacToe";
     
        int m=0;

        try
        {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(nm1));
       
            ks=(JButton[]) ois.readObject();
            m=ois.readInt();
            //System.out.println("Reading move "+m);
           
            ois.close();
        }
        catch(Exception exce)
        {
        }
        return m;
    }
}