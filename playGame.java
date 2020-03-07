import javax.swing.*;
public class playGame
{
    static boolean isOver(JButton butt[])
    {
        if (Winner(butt)!=0)
        {
            return true;
        }
        for(int i=0;i<9;i++)
        {
            if(butt[i].getText().charAt(0)==' ')
            {
                return false;
            }

        }
        return true;
    }

    static int Winner(JButton butt[])
    {
        char c=' ';
        char moves[]=new char[9];
        for(int i=0;i<9;i++)
        {
            moves[i]=butt[i].getText().charAt(0);
        }
        if(moves[0]==moves[1]&&moves[1]==moves[2]&&moves[0]!=' ')
        {
            c=moves[0];
        }
        if(moves[3]==moves[4]&&moves[4]==moves[5]&&moves[3]!=' ')
        {
            c=moves[3];
        }
        if(moves[6]==moves[7]&&moves[7]==moves[8]&&moves[6]!=' ')
        {
            c=moves[6];
        }
        if(moves[0]==moves[3]&&moves[3]==moves[6]&&moves[0]!=' ')
        {
            c=moves[0];
        }
        if(moves[1]==moves[4]&&moves[4]==moves[7]&&moves[1]!=' ')
        {
            c=moves[7];
        }
        if(moves[2]==moves[5]&&moves[5]==moves[8]&&moves[2]!=' ')
        {
            c=moves[2];
        }
        if(moves[0]==moves[4]&&moves[4]==moves[8]&&moves[0]!=' ')
        {
            c=moves[0];
        }
        if(moves[2]==moves[4]&&moves[4]==moves[6]&&moves[2]!=' ')
        {
            c=moves[2];
        }
        if(c=='X')
        {
            return 1;
        }
        if(c=='O')
        {
            return 2;
        }
        return 0;
    }
}