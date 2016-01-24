import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class LectureIris {
	@SuppressWarnings("resource")
	public static ArrayList<Iris> LectureFichier(String fichier){
        String ligne;
        String[] ligneCoupee ;
        ArrayList<Iris> lesIris = new ArrayList<Iris>();
        BufferedReader ficTexte;
        try {
            ficTexte = new BufferedReader(new FileReader(new File(fichier)));
        do {
             ligne = ficTexte.readLine();
              if (ligne != null && ligne.length() > 0) {
                // System.out.println(ligne);
                 if (ligne.charAt(0) != '@' && ligne.charAt(0) != '%'){
                     ligneCoupee = ligne.split(",");
                     lesIris.add(new Iris(Float.parseFloat(ligneCoupee[0]),Float.parseFloat(ligneCoupee[1]),Float.parseFloat(ligneCoupee[2]),Float.parseFloat(ligneCoupee[3])));
                    }
                }
            } while (ligne != null);
        return lesIris;
        }
        catch(Exception e){
        	e.printStackTrace();
        	System.out.println("problem");
        	return null;
        }
	}
}
