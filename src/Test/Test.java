package Test;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by tom on 03/07/2017.
 */
public class Test {

    public static void main(String [] args ){

    connect();
    }

    public static void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            String url = "jdbc:mysql://localhost:3306/stage";
            String user = "root";
            String passwd = "";
            Statement statement = null;
            ResultSet resultat = null;
            System.out.println("Connection en cours");
            Connection conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connexion effective !");
            statement = conn.createStatement();
            System.out.print( "Objet requête créé !" );
            Traducteur t = new Traducteur();
            HashMap<String, Champions> hmap =t.toDo();
            Set set = hmap.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                Champions c= (Champions) mentry.getValue();
                String nom=c.getNom();
                Float A1=c.getA(1);
                Float A2=c.getA(2);
                Float A3=c.getA(3);
                Float A4=c.getA(4);
                Float A5=c.getA(5);
                Float E1=c.getE(1);
                Float E2=c.getE(2);
                Float E3=c.getE(3);
                Float E4=c.getE(4);
                Float E5=c.getE(5);
                Float W1=c.getZ(1);
                Float W2=c.getZ(2);
                Float W3=c.getZ(3);
                Float W4=c.getZ(4);
                Float W5=c.getZ(5);
                Float R1=c.getR(1);
                Float R2=c.getR(2);
                Float R3=c.getR(3);
                Float R4=c.getR(4);
                Float R5=c.getR(5);
                String req= "INSERT INTO champion (nom,Q1,Q2,Q3,Q4,Q5,W1,W2,W3,W4,W5,E1,E2,E3,E4,E5,R1,R2,R3,R4,R5) VALUES ('"+nom+"',"+A1+","+A2+","+A3+","+A4+","+A5+","+W1+","+W2+","+W3+","+W4+","+W5+","+E1+","+E2+","+E3+","+E4+","+E5+","+R1+","+R2+","+R3+","+R4+","+R5+")";
                System.out.println(req);
                statement.executeUpdate(req);

            }
            /*(nom,Q1,Q2,Q3,Q4,Q5,W1,W2,W3,W4,W5,E1,E2,E3,E4,E5,R1,R2,R3,R4,R5)*/
            /*statement.executeUpdate("INSERT INTO champion VALUES ()");
            resultat = statement.executeQuery( "SELECT * FROM information;" );*/
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
