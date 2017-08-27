package hs;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by tom on 11/07/2017.
 */
public class Fenetre extends JFrame {
    JPanel p;
    JLabel pv;
    JTextField dmg;
    Bouton b;
    JLabel img;
    int t = 0;
    ArrayList<Integer> tab=new ArrayList<>();

    public Fenetre(){
        this.pack();
        this.setTitle("Fenetre");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        GridLayout g = new GridLayout(2, 2);
        p = new JPanel();
        pv = new JLabel();
        dmg = new JTextField();
        b= new Bouton(this);
        img = new JLabel();
        pv.setText("30");
        dmg.setText("0");
        pv.setHorizontalAlignment(JLabel.CENTER);
        pv.setVerticalAlignment(JLabel.CENTER);
        dmg.setHorizontalAlignment(JLabel.CENTER);
        String pathr="C:\\Users\\tom\\Downloads\\hs.jpg";
        Icon spP= new ImageIcon(pathr);
        img.setIcon(spP);
        p.setLayout(g);
        p.add(pv);
        p.add(dmg);
        p.add(b);
        p.add(img);





        this.setContentPane(p);
        this.setVisible(true);
    }

    public void fintour(){
        int a=Integer.parseInt(dmg.getText());
        tab.add(t,a);
        t=t+1;
        int tot=Integer.parseInt(pv.getText())-a;
        pv.setText(Integer.toString(tot));
        dmg.setText("0");
        if(tot<=0){
            fin();
        }
    }


    public void fin(){
       JPanel q=new JPanel();
        GridLayout g1 = new GridLayout(tab.size()+1, 2);
        q.setLayout(g1);
        Border border1 = LineBorder.createBlackLineBorder();
        JLabel j= new JLabel("tours");
        j.setHorizontalAlignment(JLabel.CENTER);
        j.setVerticalAlignment(JLabel.CENTER);
        j.setBorder(border1);
        JLabel o= new JLabel("pv perdu");
        o.setHorizontalAlignment(JLabel.CENTER);
        o.setVerticalAlignment(JLabel.CENTER);
        o.setBorder(border1);
        q.add(j);
        q.add(o);
        for(int i =0;i<tab.size();i++){
            JLabel a= new JLabel(Integer.toString(i+1));
            a.setHorizontalAlignment(JLabel.CENTER);
            a.setVerticalAlignment(JLabel.CENTER);
            a.setBorder(border1);
            q.add(a);
            JLabel b = new JLabel(tab.get(i).toString());
            b.setVerticalAlignment(JLabel.CENTER);
            b.setHorizontalAlignment(JLabel.CENTER);
            b.setBorder(border1);
            q.add(b);
        }
        setContentPane(q);
    }

}
