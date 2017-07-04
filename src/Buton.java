import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buton extends JButton implements ActionListener {

    Tableau f;
    String s;

    public Buton(Tableau f, String s) {
        super(s);
        this.f = f;
        this.s = s;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (s.equals("Reset")) {
            f.reset();
        }
        if (s.equals("OK")) {
            f.calcul();
        }
    }
}