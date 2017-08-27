package ChampCDImg;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.security.spec.ECField;

public class Texte extends JTextField implements CaretListener {
    private Fenetre f ;
    public Texte(Fenetre f){
        super("0");
        this.f=f;
        this.setHorizontalAlignment(JLabel.CENTER);
        addCaretListener(this);
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        try {
            float cdr = Float.parseFloat(this.getText());
            if (cdr > 45) {
                return;
            }
            if (cdr < 0)
                return;
            f.setCDR(this.getText());
        }catch(Exception e1){

        }

    }
}