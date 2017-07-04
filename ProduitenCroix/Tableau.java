package ProduitenCroix;

import ProduitenCroix.Buton;
import ProduitenCroix.Texte;

import java.awt.GridLayout;
import javax.swing.*;


public class Tableau extends JFrame {
    Texte A= new Texte(this);
    Texte B= new Texte(this);
    Texte C= new Texte(this);
    Texte D= new Texte(this);

    public Tableau() {
        this.setTitle("Bouton");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(3, 3));
        this.getContentPane().add(A);
        this.getContentPane().add(B);
        this.getContentPane().add(C);
        this.getContentPane().add(D);
        Buton b= new Buton (this,"Reset");
        Buton c= new Buton (this,"OK");
        this.getContentPane().add(b);
        this.getContentPane().add(c);

        this.setVisible(true);

    }
    public void reset (){
        A.setText("");
            B.setText("");
            C.setText("");
            D.setText("");
        }


public void calcul (){
try {
    if (D.getText().equals("")) {
        float fa = Float.parseFloat(A.getText());
        float fb = Float.parseFloat(B.getText());
        float fc = Float.parseFloat(C.getText());
        float fd = fb * fc / fa;
        D.setText(String.valueOf(fd));
    }

    if (A.getText().equals("")){
        float fd = Float.parseFloat(D.getText());
        float fb = Float.parseFloat(B.getText());
        float fc = Float.parseFloat(C.getText());
        float fa = fb * fc / fd;
        A.setText(String.valueOf(fa));
    }

    if (B.getText().equals("")){
        float fa = Float.parseFloat(A.getText());
        float fc = Float.parseFloat(C.getText());
        float fd = Float.parseFloat(D.getText());
        float fb = fa * fd / fc;
        B.setText(String.valueOf(fb));
    }

    if (C.getText().equals("")){
        float fa = Float.parseFloat(A.getText());
        float fb = Float.parseFloat(B.getText());
        float fd = Float.parseFloat(D.getText());
        float fc = fa * fd / fb;
        C.setText(String.valueOf(fc));
    }


}
catch (Exception e){

}
    }

}
