package path;

import hs.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tom on 19/07/2017.
 */
public class Fenetre extends JFrame {

    String [] chemin;
    JTextField coul [] = new JTextField[5];
    Bouton [] btag ;

    public Fenetre(String [] chemin ){
        this.chemin=chemin;
        btag = new Bouton[chemin.length];
        this.pack();
        this.setTitle("Fenetre");
        this.setSize(200*chemin.length, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel fond = new JPanel();
        fond.setLayout(new GridLayout(2,1));
        JPanel p = new JPanel();
        int taille = chemin.length;

        GridLayout g = new GridLayout(1, taille);
        p.setLayout(g);
        for(int i=0;i<taille;i++){
            Bouton l = new Bouton(chemin[i],this);
            btag[i]=l;
            p.add(l);

        }
        fond.add(p);
        JPanel bas = new JPanel();
        bas.setLayout(new GridLayout(1,10));
        for(int i=0;i<5;i++){
            switch (i){
                case 0:bas.add(new JLabel("Tag Blanc = "));
                    coul[i]=new JTextField("");
                    bas.add(coul[i]);
                    break;
                case 1:bas.add(new JLabel("Tag Cyan = "));
                    coul[i]=new JTextField("");
                    bas.add(coul[i]);
                    break;
                case 2:bas.add(new JLabel("Tag Rouge = "));
                    coul[i]=new JTextField("");
                    bas.add(coul[i]);
                    break;
                case 3:bas.add(new JLabel("Tag Jaune = "));
                    coul[i]=new JTextField("");
                    bas.add(coul[i]);
                    break;
                case 4:bas.add(new JLabel("Tag Vert = "));
                    coul[i]=new JTextField("");
                    bas.add(coul[i]);
                    break;
            }
        }
        fond.add(bas);
        this.setContentPane(fond);
        this.setVisible(true);

    }


    public void affiche(){
        String s = "";
        for(int i=0;i<chemin.length;i++){
            if(!coul[btag[i].getI()].getText().equals(""))
                s+="< tag name = «"+coul[btag[i].getI()].getText()+"» >"+chemin[i]+"</tag>/";
            else
                s+=chemin[i]+"/";


        }
        System.out.println(s);

        File f = new File ( "path.xml" );

        try
        {
            FileWriter fw = new FileWriter (f);
            fw.write (s);
            fw.write ("\r\n");
            fw.close();
        }
        catch (IOException exception)
        {
            System .out.println ( "Erreur lors de la lecture : " + exception.getMessage());
        }
    }
}
