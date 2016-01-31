
public class Iris {
	
	private float sepalLength;
	
	private float sepalWidth;
	
	private float petalLength;
	
	private float petalWidth;

	/**
	 * @param sepalLength2
	 * @param sepalWidth2
	 * @param petalLength2
	 * @param petalWidth2
	 */
	public Iris(float sepalLength2, float sepalWidth2, float petalLength2,
			float petalWidth2) {
		this.sepalLength = sepalLength2;
		this.sepalWidth = sepalWidth2;
		this.petalLength = petalLength2;
		this.petalWidth = petalWidth2;
	}

	/**
	 * @return the sepalLength
	 */
	public float getSepalLength() {
		return sepalLength;
	}

	/**
	 * @param sepalLength the sepalLength to set
	 */
	public void setSepalLength(float sepalLength) {
		this.sepalLength = sepalLength;
	}

	/**
	 * @return the sepalWidth
	 */
	public float getSepalWidth() {
		return sepalWidth;
	}

	/**
	 * @param sepalWidth the sepalWidth to set
	 */
	public void setSepalWidth(float sepalWidth) {
		this.sepalWidth = sepalWidth;
	}

	/**
	 * @return the petalLength
	 */
	public float getPetalLength() {
		return petalLength;
	}

	/**
	 * @param petalLength the petalLength to set
	 */
	public void setPetalLength(float petalLength) {
		this.petalLength = petalLength;
	}

	/**
	 * @return the petalWidth
	 */
	public float getPetalWidth() {
		return petalWidth;
	}

	/**
	 * @param petalWidth the petalWidth to set
	 */
	public void setPetalWidth(float petalWidth) {
		this.petalWidth = petalWidth;
	}

	public String toString(){
		return "iris = "+this.sepalLength+" , "+sepalWidth+" , "+petalLength+" , "+petalWidth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(petalLength);
		result = prime * result + Float.floatToIntBits(petalWidth);
		result = prime * result + Float.floatToIntBits(sepalLength);
		result = prime * result + Float.floatToIntBits(sepalWidth);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Iris other = (Iris) obj;
		if (Float.floatToIntBits(petalLength) != Float.floatToIntBits(other.petalLength))
			return false;
		if (Float.floatToIntBits(petalWidth) != Float.floatToIntBits(other.petalWidth))
			return false;
		if (Float.floatToIntBits(sepalLength) != Float.floatToIntBits(other.sepalLength))
			return false;
		if (Float.floatToIntBits(sepalWidth) != Float.floatToIntBits(other.sepalWidth))
			return false;
		return true;
	}

	

	
}
