package eu.deustotech.beerclipsdemo.states;

public class FinalState extends AbstractState {
	private final String answer; // text associated to the state
	
	public FinalState(String answer) {
		super();
		this.answer = answer;
	}
		
	public String getAnswer() {
		return this.answer;
	}
}