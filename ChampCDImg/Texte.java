package ChampCDImg;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
        f.setCDR(this.getText());

    }
}