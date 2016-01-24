
public class Iris {
	
	private double sepalLength;
	
	private double sepalWidth;
	
	private double petalLength;
	
	private double petalWidth;

	/**
	 * @param sepalLength2
	 * @param sepalWidth2
	 * @param petalLength2
	 * @param petalWidth2
	 */
	public Iris(double sepalLength2, double sepalWidth2, double petalLength2,
			double petalWidth2) {
		this.sepalLength = sepalLength2;
		this.sepalWidth = sepalWidth2;
		this.petalLength = petalLength2;
		this.petalWidth = petalWidth2;
	}

	/**
	 * @return the sepalLength
	 */
	public double getSepalLength() {
		return sepalLength;
	}

	/**
	 * @param sepalLength the sepalLength to set
	 */
	public void setSepalLength(double sepalLength) {
		this.sepalLength = sepalLength;
	}

	/**
	 * @return the sepalWidth
	 */
	public double getSepalWidth() {
		return sepalWidth;
	}

	/**
	 * @param sepalWidth the sepalWidth to set
	 */
	public void setSepalWidth(double sepalWidth) {
		this.sepalWidth = sepalWidth;
	}

	/**
	 * @return the petalLength
	 */
	public double getPetalLength() {
		return petalLength;
	}

	/**
	 * @param petalLength the petalLength to set
	 */
	public void setPetalLength(double petalLength) {
		this.petalLength = petalLength;
	}

	/**
	 * @return the petalWidth
	 */
	public double getPetalWidth() {
		return petalWidth;
	}

	/**
	 * @param petalWidth the petalWidth to set
	 */
	public void setPetalWidth(double petalWidth) {
		this.petalWidth = petalWidth;
	}

	public String toString(){
		return "iris = "+this.sepalLength+" , "+sepalWidth+" , "+petalLength+" , "+petalWidth;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(petalLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(petalWidth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sepalLength);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sepalWidth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Iris other = (Iris) obj;
		if (Double.doubleToLongBits(petalLength) != Double
				.doubleToLongBits(other.petalLength))
			return false;
		if (Double.doubleToLongBits(petalWidth) != Double
				.doubleToLongBits(other.petalWidth))
			return false;
		if (Double.doubleToLongBits(sepalLength) != Double
				.doubleToLongBits(other.sepalLength))
			return false;
		if (Double.doubleToLongBits(sepalWidth) != Double
				.doubleToLongBits(other.sepalWidth))
			return false;
		return true;
	}
	

	
}
