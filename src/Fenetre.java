
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Fenetre extends JFrame {
    private JPanel container = new JPanel();
    private JLabel[] []t = new JLabel[5][6];
    private Champions champs;
    private float CDR=0;
    private Texte tab;
    private Champions [] Jungle ;


    public Fenetre(){
      this.setTitle("Fenetre");
      this.setSize(500,500);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout g=new GridLayout(5,6);
        container.setLayout(g);
        for(int i =0;i<5;i++) {
            for (int j = 0; j < 6; j++) {
                t[i][j] = new JLabel("");
                if(i==0 && j!=0){
                    t[i][j]= new JLabel(Integer.toString(j));
                }
            }
        }
        float [] A= new float[]{10,9,8,7,6};
        float [] Z= new float[]{10,10,10,10,10};
        float [] E= new float[]{26,24,22,20,18};
        float [] R= new float[]{25,20,15,0,0};
        Jungle = new Champions [3];
        champs = new Champions("Diana",A,Z,E,R);
        Jungle[0]= champs;
        t[1][0]=new JLabel("A");
        t[2][0]=new JLabel("Z");
        t[3][0]=new JLabel("E");
        t[4][0]=new JLabel("R");
        for(int i =0;i<5;i++){
            for(int j=0;j<6;j++){
                container.add(t[i][j]);
                if (j>0){
                    if (i==1){
                        t [i][j].setText(Float.toString(champs.getA(j)));
                    }
                    if (i==2){
                        t [i][j].setText(Float.toString(champs.getZ(j)));
                    }
                    if (i==3){
                        t [i][j].setText(Float.toString(champs.getE(j)));
                    }
                    if (i==4){
                        t [i][j].setText(Float.toString(champs.getR(j)));
                    }

                }
            }
        }
        JPanel p =new JPanel();
        p.setLayout(new GridLayout(2,1));
        JPanel bas= new JPanel();
         tab = new Texte(this);
         String [] st= {"Diana","Skarner","Ivern"};
         JComboBox box= new JComboBox(st);
         box.addItemListener(new ItemState());
         bas.add(box);
        bas.add(tab );
        p.add(container);
        p.add(bas);
        this.setContentPane(p);
        this.setVisible(true);
    }

    public void setCDR(String CDR) {
        try {
            float f = Float.parseFloat(CDR);
            this.CDR = f / 100;
            actualise();
        }catch(Exception e){}

    }
    public void actualise(){
        for(int i =0;i<5;i++){
            for(int j=0;j<6;j++){
                if (j>0){
                    if (i==1){
                        t [i][j].setText(Float.toString(champs.getA(j)*(1-CDR)));
                    }
                    if (i==2){
                        t [i][j].setText(Float.toString(champs.getZ(j)*(1-CDR)));
                    }
                    if (i==3){
                        t [i][j].setText(Float.toString(champs.getE(j)*(1-CDR)));
                    }
                    if (i==4){
                        t [i][j].setText(Float.toString(champs.getR(j)*(1-CDR)));
                    }

                }
            }
        }
    }
    class ItemState implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getItem().equals("Diana")){
                champs=Jungle[0];
                actualise();
            }
        }
    }
}


