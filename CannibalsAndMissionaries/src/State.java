/**
 * Class to represent a problem state <m&c>s
 * 
 * @author kumaran
 * 
 */
public class State {

	int numCannibalsRight; // number of cannibals on the right side of the river
	int numCannibalsLeft; // number of cannibals on the left side of the river
	int numMissionariesRight; // number of missionaries on the right side of the
								// river
	int numMissionariesLeft; // number of missionaries on the left side of the
								// river
	boolean isBoatOnLeft; // to check if the boat is on the left side of the
							// river
	State parentState; // Parent state

	/**
	 * Constructor for State
	 * 
	 * @param numCannibalsLeft
	 * @param numMissionariesLeft
	 * @param numCannibalsRight
	 * @param numMissionariesRight
	 * @param isBoatOnLeft
	 */
	public State(int numCannibalsLeft, int numMissionariesLeft,
			int numCannibalsRight, int numMissionariesRight,
			boolean isBoatOnLeft, State parentState) {
		this.numCannibalsLeft = numCannibalsLeft;
		this.numMissionariesLeft = numMissionariesLeft;
		this.numCannibalsRight = numCannibalsRight;
		this.numMissionariesRight = numMissionariesRight;
		this.isBoatOnLeft = isBoatOnLeft;
		this.parentState = parentState;
	}

	/**
	 * Checks whether a goal state has been reached
	 * 
	 * @param s of type state
	 * 
	 * @return true if the goal state has been reached
	 */
	public boolean hasGoalStateReached() {
		return (this.numCannibalsLeft == 0 && this.numMissionariesLeft == 0);
	}

	/**
	 * Check if a state equals the current state
	 * 
	 * @param s
	 * @return true if the states are the same
	 */
	public boolean equals(State s) {
		return (s.numCannibalsLeft == this.numCannibalsLeft
				&& s.numCannibalsRight == this.numCannibalsRight
				&& s.numMissionariesLeft == this.numMissionariesLeft
				&& s.numMissionariesRight == this.numMissionariesRight && s.isBoatOnLeft == this.isBoatOnLeft);
	}

	/**
	 * Method to convert the state to string
	 */
	public String toString() {
		String state = "<NumCannibalsOnLeft>" + this.numCannibalsLeft
				+ "</NumCannibalsOnLeft>";
		state += "<NumCannibalsOnRight>" + this.numCannibalsRight
				+ "</NumCannibalsOnRight>";
		state += "<NumMissionariesOnLeft>" + this.numMissionariesLeft
				+ "</NumMissionariesOnLeft>";
		state += "<NumMissionariesOnRight>" + this.numMissionariesRight
				+ "</NumMissionariesOnRight>";
		state += "<IsBoatOnleft>" + String.valueOf(this.isBoatOnLeft)
				+ "</IsBoatOnleft>";
		return state;
	}
}
