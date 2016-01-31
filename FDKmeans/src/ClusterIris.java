import java.util.ArrayList;

public class ClusterIris implements Cluster{

	private Iris centre;
	
	private ArrayList<Iris> lesIris; 

	public ClusterIris(float minSepalLength, float maxSepalLength, float minSepalWidth,	float maxSepalWidth,
			float minPetalLength, float maxPetalLength, float minPetalWidth, float maxPetalWidth){
		lesIris = new ArrayList<Iris>();
		float sepalLength = this.aleatoire(minSepalLength,maxSepalLength);
		float sepalWidth = this.aleatoire(minSepalWidth,maxSepalWidth);
		float petalLength = this.aleatoire(minPetalLength,maxPetalLength);
		float petalWidth = this.aleatoire(minPetalWidth,maxPetalWidth);
		this.centre = new Iris(sepalLength,sepalWidth,petalLength,petalWidth); 
	}
	
	private float aleatoire(float min, float max) {
		float n =  (float) (min + Math.random() * (max - min));
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
		float sepalLengthNew=0;
		float sepalWidthNew=0;
		float petalLengthNew=0;
		float petalWidthNew=0;
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
