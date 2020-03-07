import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class newGame implements ActionListener
{
    JFrame fr=new JFrame("Tic Tac Toe");
    JPanel pan=new JPanel();
    JButton nn=new JButton("New Game");
    JButton ll=new JButton("Load Game");
    newGame()
    {
        fr.setSize(100,200);
        fr.setResizable(false);
        pan.add(new JLabel("Choose Game"));
        nn.addActionListener(this);
        ll.addActionListener(this);
        pan.add(nn);
        pan.add(ll);
        fr.add(pan);
        fr.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        fr.setVisible(false);
        if(e.getSource()==nn)
        {
            new gui();
        }
        else
        {
            gui obj=new gui();
            obj.fr.setVisible(false);
            new LoadGame(obj);
        }
    }
}
