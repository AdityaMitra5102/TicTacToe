import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class gui extends JFrame implements ActionListener
{
    JFrame fr=new JFrame("Tic Tac Toe");
    public JButton butt[]=new JButton[9];
    JPanel p=new JPanel();
    JTextField ar=new JTextField(15);
    int move;
    Font font = new Font("Calibri", Font.BOLD, 20);
    JButton save=new JButton("Save and Exit");
    JButton ext=new JButton("EXIT");
    gui()
    {
        setDesign();
        fr.setResizable(false);
        for(int i=0;i<9;i++)
        {
            butt[i]=new JButton();
            butt[i].setPreferredSize(new Dimension(50,50));
            butt[i].setText(" ");
            butt[i].setBackground(Color.cyan);
            butt[i].setFont(font);
            butt[i].addActionListener(this);
            p.add(butt[i]);
        }
        fr.setBackground(Color.pink);
        save.setBackground(Color.yellow);
        save.addActionListener(this);

        ext.setBackground(Color.red);
        ext.addActionListener(this);
        ar.setEditable(false);
        p.add(new JScrollPane(ar));
        ext.setEnabled(false);
        p.add(save);
        p.add(ext);
        fr.setSize(220,280);
        fr.add(p);

        fr.setVisible(true);
        move=1;
        ar.setText("Player "+move+"\'s Move");
    }
    
    
    public void setKeys(JButton[] keys)
    {
        butt=keys;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() !=save)
        {
            for(int i=0;i<9;i++)
            {
                if(e.getSource()==butt[i])
                {

                    butt[i].setEnabled(false);
                    if(move==1)
                    {
                        butt[i].setText("X");
                    }
                    else
                    {
                        butt[i].setText("O");
                    }
                }
            }
            move+=1;
            if(move==3)
            {
                move=1;
            }
            ar.setText("Player "+move+"\'s Move");
            if(playGame.isOver(butt))
            {

                for(int i=0;i<9;i++)
                {
                    butt[i].setEnabled(false);

                }
                ext.setEnabled(true);
                save.setEnabled(false);
                int w=playGame.Winner(butt);
                if(w!=0)
                {
                    ar.setText("Player "+w+" wins");
                }
                else
                {
                    ar.setText("Draw Match");
                }
            }
        }
        if(e.getSource()==ext)
        {
            fr.setVisible(false);
        }
        if(e.getSource()==save)
        {
            fr.setVisible(false);
            new SaveGame(new Data(butt,move));
        }
    }

    public final static void setDesign() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  
        }
    }

}
