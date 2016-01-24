import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class LectureIris {
	@SuppressWarnings("resource")
	public static ArrayList<Point> LectureFichier(String fichier){
        String ligne;
        String[] ligneCoupee ;
        ArrayList<Point> lesPoints = new ArrayList<Point>();
        BufferedReader ficTexte;
        try {
            ficTexte = new BufferedReader(new FileReader(new File(fichier)));
        do {
             ligne = ficTexte.readLine();
              if (ligne != null) {
                 System.out.println(ligne);
                 if (ligne.charAt(0) != '@'){
                     ligneCoupee = ligne.split(",");
                     lesPoints.add(new Point(Float.parseFloat(ligneCoupee[0]),Float.parseFloat(ligneCoupee[1])));
                    }
                }
            } while (ligne != null);
        return lesPoints;
        }
        catch(Exception e){
        	System.out.println("problem");
        	return null;
        }
	}
}
