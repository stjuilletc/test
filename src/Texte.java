import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Created by donat on 04/07/2017.
 */
public class Texte extends JTextField implements CaretListener {
    private Fenetre f ;
    public Texte(Fenetre f){
        super("0");
        this.f=f;
        addCaretListener(this);
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        f.setCDR(this.getText());

    }
}
