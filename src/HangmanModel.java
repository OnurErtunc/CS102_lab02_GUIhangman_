import cs102.Hangman;
import cs102.IHangmanSetup;
import java.util.ArrayList;
/**
 * 
 * @author Onur Ertunc
 * @version 3.12.2020
 */
public class HangmanModel extends Hangman {
	
	private ArrayList<IHangmanView> views;
	
	public HangmanModel( IHangmanSetup setup ) {
		
		super(setup);
		views = new ArrayList<IHangmanView>();
		
	}
	
	
	public void update() {
		
		for ( int i = 0; i < views.size(); i++ ) {
			views.get(i).updateView(this);
		}
	}
	
	public void addView( IHangmanView view ) {
		
		views.add(view);
		update();
	}
	
	public int tryThis( char letter ) {
		
		int overriden = super.tryThis( letter );
		update();
		return overriden;		
	}
	
	/*
	 * public void initNewGame() {
	 * 
	 * super.initNewGame(); update(); }
	 */
}
