package ChampCDImg;

import javax.swing.*;
import java.io.File;
import java.util.HashMap;

/**
 * Created by tom on 06/07/2017.
 */
public class Traducteur {


    String path="";


    public Traducteur(String p) {
        path = p;
    }

//   0=nom    1 =A
    // constructeur du Traducteur
    public Traducteur(){
        JFileChooser dialogue = new JFileChooser(new File("."));// on choisit le ficher depuis lequel on veut recuperer les champions
        if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
            if(dialogue.getSelectedFile()!=null){
                File fichier = dialogue.getSelectedFile();
                if(fichier!=null)
                    path=fichier.getPath();
            }
        }
    }



    // on cree la hashmap depuis le fichier en le lisant
    public HashMap toDo()  {
        java.util.Scanner lecteur;
        java.io.File fichier = new java.io.File(path);
        HashMap<String, Champions> hmap = new HashMap<String, Champions>();// on cree la hashmap
        try {
            lecteur = new java.util.Scanner(fichier);// lecture du fichier// on lit le fichier
        }catch(java.io.FileNotFoundException e){
            System.out.println("Fichier introuvable ");
            return hmap;
        }

        String q =lecteur.nextLine();
        System.out.println(q);
        q=q.replace(',','.');// on remplace les , par des . pour le format des float
        System.out.println(q);
        String[] qt = q.split(" "); //on split la chaine en fonction des espaces
        System.out.println(qt.length);
        while(qt.length==19) {

            String nom = null;
            float[] A = new float[5];
            float[] Z = new float[5];
            float[] E = new float[5];
            float[] R = new float[5];
            for (int i = 0; i < qt.length; i++) {
                if (i == 0)
                    nom = qt[i];
                else if (i < 6)
                    A[i - 1] = Float.parseFloat(qt[i]);
                else if (i < 11)
                    Z[i - 6] = Float.parseFloat(qt[i]);
                else if (i < 16)
                    E[i - 11] = Float.parseFloat(qt[i]);
                else if (i < 21)
                    R[i - 16] = Float.parseFloat(qt[i]);
                else
                    System.out.println(qt[i]);

            }
            R[3] = 0;
            R[4] = 0;
           /* System.out.println("nom =" + nom);
            for (int i = 0; i < 5; i++)
                System.out.println(A[i] + " " + Z[i] + " " + " " + E[i] + " " + R[i]);*/
            String path="C:\\Users\\tom\\Downloads\\"+nom+".jpg";
            String pathp="C:\\Users\\tom\\Downloads\\"+nom+"Passive.jpg";
            String pathq="C:\\Users\\tom\\Downloads\\"+nom+"Q.jpg";
            String pathw="C:\\Users\\tom\\Downloads\\"+nom+"W.jpg";
            String pathe="C:\\Users\\tom\\Downloads\\"+nom+"E.jpg";
            String pathr="C:\\Users\\tom\\Downloads\\"+nom+"R.jpg";
            Icon spP= new ImageIcon(pathp);
            Icon spQ= new ImageIcon(pathq);
            Icon spW= new ImageIcon(pathw);
            Icon spE= new ImageIcon(pathe);
            Icon spR= new ImageIcon(pathr);

            Champions c = new Champions(nom, A, Z, E, R, path,spP,spQ,spW,spE,spR); // on cree le champion depuis les informations recuperer depuis le fichier texte
            System.out.println(c);
            hmap.put(nom,c);// on ajoute le champion a la hashmap
            if (lecteur.hasNext()) {
                q = lecteur.nextLine();
                q = q.replace(',', '.');
                qt = q.split(" ");
            } else {
                return hmap;
            }
        }
        return hmap;

    }




}
