package trois;

/**
 * Created by tom on 03/07/2017.
 */
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.GridLayout;
public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JTextField jtfA = new JTextField("");
    private JLabel labelA = new JLabel("A =");
    private JTextField jtfB = new JTextField("");
    private JLabel labelB = new JLabel("B =");
    private JTextField jtfC = new JTextField("");
    private JLabel labelC = new JLabel("C =");

    public Fenetre(){
        this.setTitle("Fenetre");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout g=new GridLayout(2,4);
        container.setLayout(g);
        container.add(labelA);
        container.add(jtfA);
        container.add(labelB);
        container.add(jtfB);
        container.add(labelC);
        container.add(jtfC);
        Bouton b=new Bouton(this);
        container.add(b);

        this.setContentPane(container);
        this.setVisible(true);
    }

    public float calcul(){//recupere les données et calcul la 4 eme valeur (D) depuis les 3 premieres valeurs  A B C
        String sa=jtfA.getText();
        String sb=jtfB.getText();
        String sc=jtfC.getText();
        Float fa=Float.parseFloat(sa);
        Float fb=Float.parseFloat(sb);
        Float fc=Float.parseFloat(sc);
        return fb*fc/fa;

    }
}