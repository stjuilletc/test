package path;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tom on 19/07/2017.
 */
public class Bouton extends JButton implements ActionListener{
    int i = 0;
    Fenetre f ;
    public Bouton(String s ,Fenetre f){
        super(s);
        this.f = f;
        addActionListener(this);
        setBackground(Color.WHITE);
        this.setContentAreaFilled(false);
    }
    protected void paintComponent(Graphics g)
    {
        g.setColor(getBackground());
        g.fillOval(0, 0, this.getSize().width-1, this.getSize().height-1);

        super.paintComponent(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        int j = i%5;
        switch(j){
            case 0:setBackground(Color.WHITE);
                break;

            case 1:setBackground(Color.CYAN);
                break;

            case 2:setBackground(Color.RED);
                break ;

            case 3:setBackground(Color.YELLOW);
                break;

            case 4:setBackground(Color.GREEN);
                break;
        }
        f.affiche();

    }

    public int getI(){
        return i;
    }
}
