package ChampCDImg;

import java.util.HashMap;

public class Main {
    public static void main(String [] args) {

        Traducteur t = new Traducteur();
        HashMap<String, Champions> hmap =t.toDo();
        Fenetre f = new Fenetre(hmap);
    }
}
