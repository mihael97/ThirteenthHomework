package hr.fer.zemris.java.strcutures;

/**
 * Public class represents trigonometric value storage
 * 
 * @author Mihael
 *
 */
public class TrigonometricResult {
	/**
	 * Value
	 */
	private int value;
	/**
	 * Value's sine
	 */
	private double sine;
	/**
	 * Value's cosine
	 */
	private double cosine;

	/**
	 * Constructor creates new instance
	 * 
	 * @param number
	 *            - number
	 */
	public TrigonometricResult(int number) {
		double angle = Math.toRadians(number);
		this.value = number;
		this.sine = Math.sin(angle);
		this.cosine = Math.cos(angle);
	}

	/**
	 * Method returns sine value
	 * 
	 * @return sine
	 */
	public double getSine() {
		return sine;
	}

	/**
	 * Method returns cosine value
	 * 
	 * @return cosine
	 */
	public double getCosine() {
		return cosine;
	}

	/**
	 * Method returns number
	 * 
	 * @return number
	 */
	public int getValue() {
		return value;
	}
}
