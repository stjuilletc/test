package ChampCDImg;
import javax.imageio.IIOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.*;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JLabel[][] t = new JLabel[5][6];
    private Champions champs;
    private float CDR = 0;
    private Texte tab;
    private Champions[] Top;
    private HashMap<String, Champions> hmap;
    private ImagePanel img;
    private JPanel imt;

    //constructeur
    public Fenetre(HashMap<String, Champions> hmap) {
        this.hmap=hmap;
        this.pack();
        this.setTitle("Fenetre");
        this.setSize(1200, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout g = new GridLayout(5, 6);// on creer un layout 5 sur 6
        imt=new JPanel();
        imt.setLayout(new GridLayout(1,2));//on applique le layout au panel
        container.setLayout(g);// on applique le layout au panel
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                t[i][j] = new JLabel("");
                if (i == 0 && j != 0) {
                    t[i][j] = new JLabel(Integer.toString(j));// on creer des label avec le texte qui vaut la valeur de J
                }
                t[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));// on creer des bordure au jlabel
            }
        }
        champs=hmap.get("Jax");//on recupere dans le dictionnaire le champion qui correspond au nom "JAX"


    t[0][0].setText("\\");

        t[1][0] = new JLabel("A");//on cree des Jlabel
        t[1][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));// on cree des bordure
        t[2][0] = new JLabel("Z");
        t[2][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t[3][0] = new JLabel("E");
        t[3][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t[4][0] = new JLabel("R");
        t[4][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                container.add(t[i][j]);// on ajoute les jlabel au Jpanel das le gridlayout
                t[i][j].setHorizontalAlignment(JLabel.CENTER);//on aligne horizontalemet
                t[i][j].setVerticalAlignment(JLabel.CENTER);//on aligne verticalemennt
                t[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));// on applique les bordure
                if (j > 0) {
                    if (i == 1) {
                        t[i][j].setText(Float.toString(champs.getA(j)));// on actualise le texte
                    }
                    if (i == 2) {
                        t[i][j].setText(Float.toString(champs.getZ(j)));
                    }
                    if (i == 3) {
                        t[i][j].setText(Float.toString(champs.getE(j)));
                    }
                    if (i == 4) {
                        t[i][j].setText(Float.toString(champs.getR(j)));
                    }

                }
            }
        }
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(1, 2));
        JPanel bas = new JPanel();
        bas.setLayout(new GridLayout(1,2));
        tab = new Texte(this);
        String[] sbox=initBox();// on cree une combobox
        for(int i=0;i< sbox.length;i++){
            System.out.println(sbox[i]);// on ajoute les elements a la combobox
        }
        Arrays.sort(sbox);// on trie le combobox
        JComboBox box = new JComboBox(sbox);
        box.addItemListener(new ItemState());//on ajoute un Itemlistener au combobox
        bas.add(box);
        bas.add(tab);

        img=new ImagePanel();
        imt.add(container);
        imt.add(img);
        p.add(bas,BorderLayout.NORTH);
        p.add(imt,BorderLayout.CENTER);
        JMenuBar m =new JMenuBar();
        m.add(new JMenu("test"));
        this.setJMenuBar(m);// on ajoute un JmenuBar
        this.setContentPane(p);
        this.setVisible(true);// on rend visible la fenetre
    }


    // on actualise la valeur de ma CDR
    public void setCDR(String CDR) {

        try {
            float f = Float.parseFloat(CDR);
            this.CDR = f / 100;
            actualise();
        } catch (Exception e) {
        }

    }

    // fonction pour construire la combobox
    public String[] initBox(){
        String s[] = new String[hmap.size()];
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        int i=0;
        while(iterator.hasNext()) {// boucle pour parcourir le dictionnaire a l'aide d'un iterateur
            Map.Entry mentry = (Map.Entry) iterator.next();
            s[i] = mentry.getKey().toString();// on recupere la valeur de la cle
            i++;
        }
        return s;
    }
    public void actualise() {// on actualise l'affichage apres un changement de champion ou de cdr
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {// on actualise le texte
                if (j > 0) {
                    if (i == 1) {
                        t[i][j].setText(Float.toString(champs.getA(j) * (1 - CDR)));
                    }
                    if (i == 2) {
                        t[i][j].setText(Float.toString(champs.getZ(j) * (1 - CDR)));
                    }
                    if (i == 3) {
                        t[i][j].setText(Float.toString(champs.getE(j) * (1 - CDR)));
                    }
                    if (i == 4) {
                        t[i][j].setText(Float.toString(champs.getR(j) * (1 - CDR)));
                    }

                }
            }
        }
           // System.out.println(champs.getPicture());
        t[0][0].setIcon(champs.getiP());// on actualise les icons
        t[1][0].setIcon(champs.getiQ());
        t[2][0].setIcon(champs.getiW());
        t[3][0].setIcon(champs.getiE());
        t[4][0].setIcon(champs.getiR());
        img.setImage(champs.getPicture());
        img.repaint();


    }

    class ItemState implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {;
            champs=hmap.get(e.getItem());// on recupere le champion correspondant
            actualise();


        }
    }
}