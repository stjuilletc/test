package Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tom on 25/07/2017.
 */
public class Fenetre extends JFrame {
    JTextField csstext;
    JTextField jstext;
    JTextField bddtext;
    JTextField bddname;
    JTextField mdp;
    JTextField bddlog;
    JRadioButton html;
    JRadioButton xhtml;
    public Fenetre(){
        init();
    }

    public void init(){
        this.pack();
        this.setTitle("Fenetre");
        this.setSize(400,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel fond = new JPanel();
        fond.setLayout(new GridLayout(8,2));

        ButtonGroup bg =new ButtonGroup();
        html = new JRadioButton("HTML");
        xhtml= new JRadioButton("XHTML");
        bg.add(html);
        bg.add(xhtml);
        fond.add(html);
        fond.add(xhtml);
        fond.add(new JLabel("CSS :"));
        csstext = new JTextField();
        fond.add(csstext);
        fond.add(new JLabel("Javascript :"));
        jstext = new JTextField();
        fond.add(jstext);
        fond.add(new JLabel("Adresse de la BDD"));
        bddtext = new JTextField();
        fond.add(bddtext);
        fond.add(new JLabel("Nom de la BDD"));
        bddname = new JTextField();
        fond.add(bddname);
        fond.add(new JLabel("login"));
        bddlog = new JTextField();
        fond.add(bddlog);
        fond.add(new JLabel("Mdp"));
        mdp = new JTextField();
        fond.add(mdp);
        JButton b = new JButton("OK");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s="";
                /*if(html.isSelected()){

                }
                if(xhtml.isSelected()){

                }*/
                s+= "<!DOCTYPE html> \n <head> \n <title>Titre</title> \n <link href=\""+csstext.getText()+"\" rel=\"stylesheet\" type=\"text/css\" /> \n";
                s+="<script src=\""+jstext.getText()+"\" type=\"text/javascript\" /> \n </head>  \n <body></body> \n </html>";
                s+="\n   <?php $bdd=new PDO('mysql:host="+bddtext.getText()+";dbname="+bddname.getText()+"','"+bddlog.getText()+"','"+mdp.getText()+"');  ?>";

                System.out.print(s);







                StringSelection ss = new StringSelection(s);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            }
        });
        fond.add(b);
        fond.add(new JLabel(""));








        this.setContentPane(fond);
        this.setVisible(true);
    }

}
