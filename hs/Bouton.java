package hs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tom on 11/07/2017.
 */
public class Bouton extends JButton implements ActionListener{
    private Fenetre f ;
    public Bouton(Fenetre f){
        super("Fin du tour");
        this.f=f;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.fintour();
    }
}
