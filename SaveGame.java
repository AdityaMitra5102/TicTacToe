import javax.swing.*;
import java.awt.event.*;
class SaveGame implements ActionListener
{
    JFrame fr=new JFrame("Save Game");
    JTextField fln=new JTextField(30);
    JButton sv=new JButton("Save");
    JPanel pan=new JPanel();
    Data d;
    SaveGame(Data k)
    {
        d=k;
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
        GameToFile.save(fln.getText(),d);
        fr.setVisible(false);
    }
}