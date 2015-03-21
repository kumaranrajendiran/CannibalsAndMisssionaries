import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Driver class for executing the problem
 * 
 * @author kumaran
 * 
 */
public class ProblemExecutor {

	/**
	 * Method to execute the problem given the initial state Extension of
	 * Breadth first
	 * 
	 * @param initialState
	 *            of type State
	 * @return goal state if found or returns null
	 */
	public static State executeProblem(State initialState) {
		if (initialState.hasGoalStateReached()) {
			return initialState;
		}

		Queue<State> statesTobeProcessed = new LinkedList<State>(); // FIFO
																	// queue
		Set<State> exploredStates = new HashSet<State>();
		StateGenerator generator = new StateGenerator();
		statesTobeProcessed.add(initialState);
		while (true) {
			if (statesTobeProcessed.isEmpty()) {
				return null;
			}
			State state = statesTobeProcessed.poll();
			exploredStates.add(state);
			List<State> successors = generator.generateSuccessorStates(state);
			for (State successor : successors) {
				if (!exploredStates.contains(successor)
						|| !statesTobeProcessed.contains(successor)) {
					if (successor.hasGoalStateReached()) {
						return successor;
					} else
						statesTobeProcessed.add(successor);
				}
			}
		}
	}

	/**
	 * Print the states that had been followed to reach the goal state
	 * 
	 * @param goalState
	 */
	private static void printStates(State goalState) {

		if (goalState == null) {
			return;
		}
		printStates(goalState.parentState);
		System.out.println("<State>"+goalState.toString()+"</State>");
	}

	public static void main(String args[]) {
		State initialState = new State(3, 3, 0, 0, true, null);
		State goalState = executeProblem(initialState);
		if (goalState == null) {
			System.out.println("Goal state cannot be reached");
		} else
			printStates(goalState);
	}

}
