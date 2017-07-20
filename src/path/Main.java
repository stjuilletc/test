package path;

import javax.swing.*;
import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by tom on 19/07/2017.
 */
public class Main {

    public static void main (String [] args) {
        String path = "";
        JFileChooser dialogue = new JFileChooser(new File("."));
        if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (dialogue.getSelectedFile() != null) {
                File fichier = dialogue.getSelectedFile();
                if (fichier != null)
                    path = fichier.getPath();
            }
        }
        String splitRegex = Pattern.quote(System.getProperty("file.separator"));
        String[] chemin = path.split(splitRegex);
        for (int i =0 ; i<chemin.length;i++){
            System.out.println(chemin[i]);
        }

        Fenetre f = new Fenetre(chemin);
    }
}
