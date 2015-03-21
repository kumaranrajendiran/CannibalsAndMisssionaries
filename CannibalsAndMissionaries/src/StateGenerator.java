import java.util.ArrayList;
import java.util.List;

/**
 * Class used for generating successor states for a given state
 * 
 * @author kumaran
 * 
 */
public class StateGenerator {
	/**
	 * Checks if the generated state is valid or not
	 * 
	 * @param s
	 *            of type State
	 * @return true if the state is valid
	 */
	public boolean isValidState(State s) {
		if (s.numMissionariesLeft < 0 || s.numMissionariesRight < 0
				|| s.numCannibalsLeft < 0 || s.numCannibalsRight < 0) {
			return false;
		}
		if ((s.numCannibalsLeft > s.numMissionariesLeft && s.numMissionariesLeft > 0)
				|| (s.numCannibalsRight > s.numMissionariesRight && s.numMissionariesRight > 0)) {
			return false;
		}

		return true;
	}

	/**
	 * Generates all successor states for a given state
	 * 
	 * @param s
	 *            of type State
	 * @return list of successor states
	 */
	public List<State> generateSuccessorStates(State s) {
		State newState;
		List<State> successors = new ArrayList<State>();
		if (s.isBoatOnLeft == true) {
			// Two missionaries cross left to right.
			newState = new State(s.numCannibalsLeft, s.numMissionariesLeft - 2,
					s.numCannibalsRight, s.numMissionariesRight + 2, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// Two cannibals cross left to right.
			newState = new State(s.numCannibalsLeft - 2, s.numMissionariesLeft,
					s.numCannibalsRight + 2, s.numMissionariesRight, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary and one cannibal cross left to right.
			newState = new State(s.numCannibalsLeft - 1,
					s.numMissionariesLeft - 1, s.numCannibalsRight + 1,
					s.numMissionariesRight + 1, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary crosses left to right.
			newState = new State(s.numCannibalsLeft, s.numMissionariesLeft - 1,
					s.numCannibalsRight, s.numMissionariesRight + 1, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One cannibal crosses left to right.
			newState = new State(s.numCannibalsLeft - 1, s.numMissionariesLeft,
					s.numCannibalsRight + 1, s.numMissionariesRight, false, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
		} else {
			// Two missionaries cross right to left.
			newState = new State(s.numCannibalsLeft, s.numMissionariesLeft + 2,
					s.numCannibalsRight, s.numMissionariesRight - 2, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// Two cannibals cross right to left.
			newState = new State(s.numCannibalsLeft + 2, s.numMissionariesLeft,
					s.numCannibalsRight - 2, s.numMissionariesRight, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary and one cannibal cross right to left.
			newState = new State(s.numCannibalsLeft + 1,
					s.numMissionariesLeft + 1, s.numCannibalsRight - 1,
					s.numMissionariesRight - 1, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One missionary crosses right to left.
			newState = new State(s.numCannibalsLeft, s.numMissionariesLeft + 1,
					s.numCannibalsRight, s.numMissionariesRight - 1, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
			// One cannibal crosses right to left.
			newState = new State(s.numCannibalsLeft + 1, s.numMissionariesLeft,
					s.numCannibalsRight - 1, s.numMissionariesRight, true, s);
			if (isValidState(newState)) {
				successors.add(newState);
			}
		}
		return successors;
	}

}
