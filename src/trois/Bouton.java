package trois;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tom on 03/07/2017.
 */
public class Bouton extends JButton implements ActionListener{
    Fenetre f;
    public Bouton(Fenetre f) {
        super("valeur de D");
        this.f=f;
        this.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {// calcul le produit en croix
        float d=f.calcul();
        JOptionPane.showMessageDialog(f,d);
    }
}
