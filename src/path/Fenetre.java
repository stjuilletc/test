package path;

import hs.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by tom on 19/07/2017.
 */
public class Fenetre extends JFrame {

    String [] chemin;
    JTextField coul [] = new JTextField[5];
    Bouton [] btag ;
    JTextField sel ;


    //constructeur de fenetre
    public Fenetre(){
        reset("");//fonction reset pour cree la fenetre selon un String
        setSize(800,400);

    }

    // fonction d affichage
    public void affiche(){
        String s = "<listes>\n    <liste>\n";//format xml
        for(int i=0;i<chemin.length;i++){
            if(!coul[btag[i].getI()].getText().equals(""))
                s+="        < rond type = «"+coul[btag[i].getI()].getText()+"» couleur =«"+btag[i].getCouleur()+"»>"+chemin[i]+"/</tag> \n";
            else
                s+="        "+chemin[i]+"/";


        }
        s+="    </liste>\n";
        s+="</listes>";




        StringSelection ss = new StringSelection(s);// copie dans press papier
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

    }
    public void reset(){
        JOptionPane jop = new JOptionPane();
        String p=jop.showInputDialog(null, "Selectionner fichier", "Choix fichier", JOptionPane.QUESTION_MESSAGE);
        reset(p);
    }

    public void reset(String path1){
        JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
        String path = path1;
        String splitRegex = Pattern.quote(System.getProperty("file.separator"));
        chemin = path.split(splitRegex);

        if(chemin.length==1){
            chemin=path.split("/");
        }
        for (int i =0 ; i<chemin.length;i++){
            System.out.println(chemin[i]);
        }
        btag = new Bouton[chemin.length];
        this.pack();
        this.setTitle("Fenetre");
        this.setSize(200*chemin.length, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel fond = new JPanel();
        fond.setLayout(new GridLayout(3,1));
        JPanel haut = new JPanel();

        JPanel p = new JPanel();
        int taille = chemin.length;

        GridLayout g = new GridLayout(1, taille);
        p.setLayout(g);

        JPanel select=new JPanel();
        select.setLayout(new GridLayout(1,2));
        sel = new JTextField();
        select.add(sel);
        JButton but = new JButton("Nouveau fichier");
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(sel.getText());
            }
        });
        select.add(but);
        fond.add(select);
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
                    coul[i]=new JTextField("Machine");
                    bas.add(coul[i]);
                    break;
                case 1:bas.add(new JLabel("Tag Cyan = "));
                    coul[i]=new JTextField("Dossier");
                    bas.add(coul[i]);
                    break;
                case 2:bas.add(new JLabel("Tag Rouge = "));
                    coul[i]=new JTextField("Fichier");
                    bas.add(coul[i]);
                    break;
                case 3:bas.add(new JLabel("Tag Jaune = "));
                    coul[i]=new JTextField("Protocol");
                    bas.add(coul[i]);
                    break;
                case 4:bas.add(new JLabel("Tag Vert = "));
                    coul[i]=new JTextField("Utilisateur");
                    bas.add(coul[i]);
                    break;
            }
            coul[i].getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    warn();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    warn();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    warn();
                }
                public void warn(){
                    affiche();
                }
            });
        }

        fond.add(bas);
        this.setContentPane(fond);
        this.setVisible(true);

    }

}
