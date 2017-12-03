package eu.deustotech.beerclipsdemo.states;

public interface NextStateListener {
	public void started(InitialState state);
	public void nextState(UsualState state);
	public void finished(FinalState state);
}