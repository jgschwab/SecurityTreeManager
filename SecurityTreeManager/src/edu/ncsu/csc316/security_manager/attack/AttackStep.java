package edu.ncsu.csc316.security_manager.attack;

/**
 * Defines a step in the tree of attack possibilities. 
 * This object is stored as a field of AttackNode.
 * @author Justin Schwab
 */
public class AttackStep {
	/** Shows if this AttackStep is a GOAL, AND, or OR node. */
	private char tag;
	/** The description of this AttackStep */
	private String desc;
	/** The cost of this AttackStep */
	private double cost;
	/** The probability of this AttackStep */
	private double prob;
	/** The impact of this AttackStep */
	private double impact;
	
	/**
	 * Constructs an AttackStep with all possible information.
	 * @param tag Shows if this AttackStep is a GOAL, AND, or OR node.
	 * @param prob The probability of this AttackStep
	 * @param impact The impact of this AttackStep
	 * @param cost The cost of this AttackStep
	 * @param desc The description of this AttackStep
	 */
	public AttackStep(char tag, double prob, double impact, double cost, String desc){
		if(tag != 'G' && tag != 'O' && tag != 'A'){
			throw new IllegalArgumentException("Invalid AttackStep tag");
		}
		this.tag= tag;
		this.prob = prob;
		this.impact = impact;
		this.cost = cost;
		this.desc = desc;
	}

	/**
	 * Gets the cost of this AttackStep
	 * @return The cost of this AttackStep
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Sets the cost of this AttackStep
	 * @param cost The cost to assign to this AttackStep
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the probability of this AttackStep
	 * @return The probability of this AttackStep
	 */
	public double getProb() {
		return prob;
	}

	/**
	 * Sets the probability of this AttackStep
	 * @param prob The probability to assign to this AttackStep
	 */
	public void setProb(double prob) {
		this.prob = prob;
	}

	/**
	 * Gets the impact of this AttackStep
	 * @return The impact of this AttackStep
	 */
	public double getImpact() {
		return impact;
	}

	/**
	 * Sets the impact of this AttackStep
	 * @param impact The impact to assign to this AttackStep
	 */
	public void setImpact(double impact) {
		this.impact = impact;
	}

	/**
	 * Gets the tag for this AttackStep
	 * @return The tag of this AttackStep
	 */
	public char getTag() {
		return tag;
	}

	/**
	 * Gets the description of this AttackStep
	 * @return
	 */
	public String getDesc() {
		return desc;
	}

	/**
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttackStep other = (AttackStep) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (Double.doubleToLongBits(impact) != Double.doubleToLongBits(other.impact))
			return false;
		if (Double.doubleToLongBits(prob) != Double.doubleToLongBits(other.prob))
			return false;
		if (tag != other.tag)
			return false;
		return true;
	}
	*/
}