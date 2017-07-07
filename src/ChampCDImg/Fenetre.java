package ChampCDImg;
import javax.imageio.IIOException;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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


    public Fenetre(HashMap<String, Champions> hmap) {
        this.hmap=hmap;
        this.pack();
        this.setTitle("Fenetre");
        this.setSize(1200, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout g = new GridLayout(5, 6);
        imt=new JPanel();
        imt.setLayout(new GridLayout(1,2));
        container.setLayout(g);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                t[i][j] = new JLabel("");
                if (i == 0 && j != 0) {
                    t[i][j] = new JLabel(Integer.toString(j));
                }
                t[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
            }
        }
        champs=hmap.get("Jax");


    t[0][0].setText("\\");

        t[1][0] = new JLabel("A");
        t[1][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t[2][0] = new JLabel("Z");
        t[2][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t[3][0] = new JLabel("E");
        t[3][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        t[4][0] = new JLabel("R");
        t[4][0].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                container.add(t[i][j]);
                t[i][j].setHorizontalAlignment(JLabel.CENTER);
                t[i][j].setVerticalAlignment(JLabel.CENTER);
                t[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                if (j > 0) {
                    if (i == 1) {
                        t[i][j].setText(Float.toString(champs.getA(j)));
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
        String[] sbox=initBox();
        JComboBox box = new JComboBox(sbox);
        box.addItemListener(new ItemState());
        bas.add(box);
        bas.add(tab);

        img=new ImagePanel();
        imt.add(container);
        imt.add(img);
        p.add(bas,BorderLayout.NORTH);
        p.add(imt,BorderLayout.CENTER);
        JMenuBar m =new JMenuBar();
        m.add(new JMenu("test"));
        this.setJMenuBar(m);
        this.setContentPane(p);
        this.setVisible(true);
    }

    public void setCDR(String CDR) {

        try {
            float f = Float.parseFloat(CDR);
            this.CDR = f / 100;
            actualise();
        } catch (Exception e) {
        }

    }
    public String[] initBox(){
        String s[] = new String[hmap.size()];
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        int i=0;
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            s[i] = mentry.getKey().toString();
            i++;
        }
        return s;
    }
    public void actualise() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
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
        t[0][0].setIcon(champs.getiP());
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
            champs=hmap.get(e.getItem());
            //System.out.println(champs);
            actualise();
           /* if (e.getItem().equals("Jax")) {
                champs = Top[0];
                actualise();
            }
            if(e.getItem().equals("Olaf")){
                champs = Top[1];
                actualise();
            }

            if (e.getItem().equals("Tryndamere")){
                champs = Top[2];
                actualise();

            }

            if (e.getItem().equals("Gnar")){
                champs = Top[3];
                actualise();
            }

            if(e.getItem().equals("Fiora")){
                champs = Top[4];
                actualise();
            }

            if(e.getItem().equals("Irelia")){
                champs = Top[5];
                actualise();
            }*/


        }
    }
}