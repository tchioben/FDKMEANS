import java.util.ArrayList;


public class TraitementIris {

	private float minSepalLength;

	private float maxSepalLength;
	
	private float minSepalWidth;
	
	private float maxSepalWidth;
	
	private float minPetalLength;
	
	private float maxPetalLength;
	
	private float minPetalWidth;
	
	private float maxPetalWidth;
	
	private ClusterIris[] lesClusters;
	
	private Iris lesCentres[] ;
	
	private Iris lesAnciensCentres[];
	
	//toutes les iris
	private ArrayList<Iris> lesIris;
	
	public TraitementIris(int n){

		
		//creation des centres
		lesCentres = new Iris[n];
		lesAnciensCentres = new Iris[n];
		
		lesIris = LectureIris.LectureFichier("iris.txt");
		Iris premiereIris = lesIris.get(0);
		minSepalLength = premiereIris.getSepalLength();
		maxSepalLength = premiereIris.getSepalLength();
		minSepalWidth = premiereIris.getSepalWidth();
		maxSepalWidth = premiereIris.getSepalWidth();
		minPetalLength = premiereIris.getPetalLength();
		maxPetalLength = premiereIris.getPetalLength();
		minPetalWidth = premiereIris.getPetalWidth();
		maxPetalWidth = premiereIris.getPetalWidth();
		
		lesClusters = new ClusterIris[n];
		System.out.println("tu passe ici?"+lesClusters.length);
		for(int l = 0; l<lesClusters.length; l++){
			System.out.println(lesClusters[l]+"tu fais quoi?");
		}
		
		//recherche des min et max
		for (Iris iris : lesIris){
			if (minSepalLength > iris.getSepalLength()){
				System.out.println("erreur...");
				minSepalLength = iris.getSepalLength();
				System.out.println(minSepalLength);
			}
			if (maxSepalLength < iris.getSepalLength()){
				maxSepalLength = iris.getSepalLength();
			}
			if (minSepalWidth > iris.getSepalWidth()){
				minSepalWidth = iris.getSepalWidth();
			}
			if (maxSepalWidth < iris.getSepalWidth()){
				maxSepalWidth = iris.getSepalWidth();
			}
			if (minPetalLength > iris.getPetalLength()){
				minPetalLength = iris.getPetalLength();
			}
			if (maxPetalLength < iris.getPetalLength()){
				maxPetalLength = iris.getPetalLength();
			}
			if (minPetalWidth > iris.getPetalWidth()){
				minPetalWidth = iris.getPetalWidth();
			}
			if (maxPetalWidth < iris.getPetalWidth()){
				maxPetalWidth = iris.getPetalWidth();
			}	
		}
		
		for(int i = 0; i<n ;i++){
			lesClusters[i] = new ClusterIris(minSepalLength, maxSepalLength,minSepalWidth, 
					maxSepalWidth, minPetalLength, maxPetalLength, minPetalWidth, maxPetalWidth);
			lesCentres[i]=lesClusters[i].getCentre();
		}
		
		// tant qu'on a pas les anciens centres qui sont �gaux aux nouveaux
		while (!egal(lesCentres,lesAnciensCentres)){
			for (int m=0; m<lesClusters.length;m++){
				lesClusters[m].setLesIris(new ArrayList<Iris>());
			}
			for(int l = 0; l<lesCentres.length; l++){
				System.out.println(lesCentres[l]);
				lesAnciensCentres[l]=lesCentres[l];
			}
		
			//dispatch les differents points dans les clusters
			remplirCluster();

			//calculer les nouveaux centres	
			calculerCentre();
		
			//vide les clusters
			for (int m=0; m<lesClusters.length;m++){
				lesCentres[m] = lesClusters[m].getCentre();
			}
		
			int p = 0;
			for(Iris iris : lesClusters[1].getLesIris()){
				System.out.println("numero = "+p+" : "+iris);
				p++;
			}
			System.out.println(lesClusters[0].getLesIris().size());
			System.out.println(lesClusters[1].getLesIris().size());
			System.out.println(lesClusters[2].getLesIris().size());
			
		}
	}

	
	
	//permet de remplir les clusters
	private void remplirCluster() {
		Iris lesCentres[] = new Iris[lesClusters.length];
		
		//on recupere les centres
		for (int i= 0 ; i < lesClusters.length;i++){
			lesCentres[i]= lesClusters[i].getCentre();  
		}
		
		//pour chaque iris
		for(Iris iris: lesIris){
			float[] lesDistances = new float[lesClusters.length];
			
			//calcul de la distance pour chaque centre
			for(int i2 = 0 ; i2< lesCentres.length; i2++){ 
				lesDistances[i2] = calculDistance(lesCentres[i2],iris);		
			}
			
			//on recupere la distance la plus proche afin de savoir dans quel cluster mettre le l'iris
			int laPlusProche = 0;
			float laValeurAssocie = lesDistances[0];
			for(int k=1;k<lesDistances.length;k++)
				if(lesDistances[k] < laValeurAssocie){
					laPlusProche= k;
					laValeurAssocie = lesDistances[k];
				}
			
			//on met l'iris dans le cluster le plus proche
			lesClusters[laPlusProche].addIris(iris);
			}		
		}
	

	private float calculDistance(Iris iris,Iris iris2) {
		float sepalLength = (float) Math.pow((iris.getSepalLength()-iris2.getSepalLength())/((maxSepalLength-minSepalLength)),2);
		float sepalWidth = (float) Math.pow((iris.getSepalWidth()-iris2.getSepalWidth())/((maxSepalWidth-minSepalWidth)),2);
		float petalLength = (float) Math.pow((iris.getPetalLength()-iris2.getPetalLength())/((maxPetalLength-minPetalLength)),2);
		float petalWidth = (float) Math.pow((iris.getPetalLength()-iris2.getPetalLength())/((maxPetalLength-minPetalLength)),2);
		
		
		float distance = (float) Math.sqrt(sepalLength+sepalWidth+petalLength+petalWidth);
		return distance;
	}
	
	
	private void calculerCentre(){
		for (int i = 0 ; i<lesClusters.length;i++){
			lesClusters[i].calculCentre();
		}
	}
	
    public static boolean egal(Iris[] lesCentres2, Iris[] lesAnciensCentres2){
        int ind=0;
        boolean rep=false;
         
        do{
            if(lesCentres2[ind].equals(lesAnciensCentres2[ind])){
                rep=true;
                ind+=1;
            }else{
                rep=false;
            }
        }while(lesCentres2[ind].equals(lesAnciensCentres2[ind]) && ind<1);
        return rep;
    }
	
}
