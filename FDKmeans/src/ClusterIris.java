import java.util.ArrayList;

public class ClusterIris {

	private Iris centre;
	
	private ArrayList<Iris> lesIris; 

	public ClusterIris(double minSepalLength, double maxSepalLength, double minSepalWidth,	double maxSepalWidth,
			double minPetalLength, double maxPetalLength, double minPetalWidth, double maxPetalWidth){
		lesIris = new ArrayList<Iris>();
		double sepalLength = this.aleatoire(minSepalLength,maxSepalLength);
		double sepalWidth = this.aleatoire(minSepalWidth,maxSepalWidth);
		double petalLength = this.aleatoire(minPetalLength,maxPetalLength);
		double petalWidth = this.aleatoire(minPetalWidth,maxPetalWidth);
		this.centre = new Iris(sepalLength,sepalWidth,petalLength,petalWidth); 
	}
	
	private double aleatoire(double min, double max) {
		double n =  (min + Math.random() * (max - min));
		return n;
	}

	/**
	 * @return the centre
	 */
	public Iris getCentre() {
		return centre;
	}

	/**
	 * @param centre the centre to set
	 */
	public void setCentre(Iris centre) {
		this.centre = centre;
	}

	/**
	 * @return the lesIris
	 */
	public ArrayList<Iris> getLesIris() {
		return lesIris;
	}

	/**
	 * @param lesIris the lesIris to set
	 */
	public void setLesIris(ArrayList<Iris> lesIris) {
		this.lesIris = lesIris;
	}

	public void addIris(Iris iris) {
		this.lesIris.add(iris);
	}

	public void calculCentre() {
		double sepalLengthNew=0;
		double sepalWidthNew=0;
		double petalLengthNew=0;
		double petalWidthNew=0;
		int nbElements=0;
		for(Iris iris : lesIris){
			sepalLengthNew += iris.getSepalLength();
			sepalWidthNew += iris.getSepalWidth();
			petalLengthNew += iris.getPetalLength();
			petalWidthNew += iris.getPetalWidth();
			nbElements+=1;
		}
		Iris nouveauCentre = new Iris(sepalLengthNew/nbElements, sepalWidthNew/nbElements, petalLengthNew/nbElements, petalWidthNew/nbElements);
		this.centre=nouveauCentre;
	}


}
