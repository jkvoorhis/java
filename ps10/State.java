public class State {
	private String stateName;
	private int count;

	// constructor
	public State() {
		stateName = "";
		count = 0;
	}

	// getters
	public String getSName() {
		return stateName;
	}
	public int getCount() {
		return count;
	}

	// setters
	public void setSName(String stateName) {
		this.stateName = stateName;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
