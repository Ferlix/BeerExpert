package eu.deustotech.beerclipsdemo.states;

import java.util.Set;

public class InitialState extends UsualState {

	public InitialState(String question, Set<StateChoice> choices) {
		super(question, choices);
	}
}