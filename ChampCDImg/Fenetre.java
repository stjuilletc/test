package ChampCDImg;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JLabel[][] t = new JLabel[5][6];
    private Champions champs;
    private float CDR = 0;
    private Texte tab;
    private Champions[] Top;
    private ImagePanel img;
    private JPanel imt;


    public Fenetre() {
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
        float[] A = new float[]{10, 9, 8, 7, 6};
        float[] Z = new float[]{7, 6,  5, 4, 3};
        float[] E = new float[]{16, 14, 12, 10, 8};
        float[] R = new float[]{80, 80, 80, 0, 0};
        Top = new Champions[6];

        champs = new Champions("Jax", A, Z, E, R,"C:\\Users\\tom\\Downloads\\Jax.jpg");
        Top[0] = champs;

         A = new float[] {7, 7, 7, 7, 7};
         Z = new float[] {16, 16, 16, 16, 16};
         E = new float[] {12, 11, 10, 9, 8};
         R = new float[] {100, 90, 80, 0, 0};

        Champions c1 = new Champions ("Olaf", A ,Z ,E ,R,"C:\\Users\\tom\\Downloads\\Olaf.jpg");
        Top[1] = c1;

        A = new float[]{12, 12, 12, 12, 12};
        Z = new float[]{14, 14, 14, 14, 14};
        E = new float[]{13, 12, 11, 10, 9};
        R = new float[]{110, 100, 90, 0, 0};

        Champions c2 = new Champions("Tryndamere", A, Z, E, R,"C:\\Users\\tom\\Downloads\\Tryndamere.jpg");
        Top[2] =  c2;

        A = new float[]{20,(float)17.5, 15, (float)12.5, 10};
        Z = new float[]{15, 13, 11, 9, 7};
        E = new float[]{22, (float)19.5, 17, (float)14.5, 12};
        R = new float[]{120, 100, 80, 0, 0};
        //imic = new ImageIcon("C:\\Users\\tom\\Downloads\\Gnar.jpg");
        //bimg= new BufferedImage(imic.getIconWidth(),imic.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
        Champions c3 = new Champions("Gnar", A, Z, E, R,"C:\\Users\\tom\\Downloads\\Gnar.jpg");
        Top[3] =  c3;

        A = new float[]{16, 14, 12, 10, 8};
        Z = new float[]{24, 22, 20, 18, 16};
        E = new float[]{13, 11, 9, 7, 5};
        R = new float[]{110, 90, 70, 0, 0};
        Champions c4 = new Champions("Fiora", A, Z, E, R,"C:\\Users\\tom\\Downloads\\Fiora.jpg");
        Top[4] =  c4;

        A = new float[]{14, 12, 10, 8, 6};
        Z = new float[]{15, 15, 15, 15, 15};
        E = new float[]{8, 8, 8, 8, 8};
        R = new float[]{110, 85, 60, 0, 0};
        Champions c5 = new Champions("Irelia", A, Z, E, R,"C:\\Users\\tom\\Downloads\\Irelia.jpg");
        Top[5] =  c5;

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
        String[] st = {"Jax", "Olaf", "Tryndamere","Gnar","Fiora","Irelia"};
        JComboBox box = new JComboBox(st);
        box.addItemListener(new ItemState());
        bas.add(box);
        bas.add(tab);

        img=new ImagePanel();
        imt.add(container);
        imt.add(img);
        p.add(bas,BorderLayout.NORTH);
        p.add(imt,BorderLayout.CENTER);


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
        img.setImage(champs.getPicture());
        img.repaint();

    }

    class ItemState implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getItem().equals("Jax")) {
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
            }
        }
    }
}