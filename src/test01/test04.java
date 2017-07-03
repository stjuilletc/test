package test04;

import java.io.*;
import java.util.Scanner;

public class test04 {
    public static Scanner scan = new Scanner(System.in);

    public static void main (String args[]) throws FileNotFoundException {
        File fichierTexte = new File ("fichierTexte.txt");
        if(!fichierTexte.exists()){
            new FileOutputStream(new File("repertoire.txt"));
        }
        FileWriter ecrireFichier;
        FileReader lireFichier;

        System.out.println("Entrer le nom");
        String nom=scan.nextLine();

        try{
            lireFichier = new FileReader(fichierTexte);
            String ligne = "";
            int i = 0;
            while((i = lireFichier.read()) != -1){
                ligne += (char)i;
            }

            System.out.println(ligne);

            ecrireFichier = new FileWriter(fichierTexte);
            ecrireFichier.write(ligne + "\n" + nom);
            ecrireFichier.close();


        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}