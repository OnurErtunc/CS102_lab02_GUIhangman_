import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( " Start of GUIHangman\n");

		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;

		// Initialization of instances
		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView);

		// Instance of TextFieldControlPanel instance created in part e
		TextFieldControlPanel textControlPanel;
		textControlPanel = new TextFieldControlPanel( hangman );

		// Another addition to the GUI
		NewGameButtonControl newGameButton;
		newGameButton = new NewGameButtonControl( hangman );

		// LabelsHangmanView
		LabelsHangmanView labelsHangmanView;
		labelsHangmanView = new LabelsHangmanView();

		// LetterButtonControls
		LetterButtonControls letterButtonControls;
		letterButtonControls = new HangmanLetterButtonControls( hangman, 13, 2 );
		letterButtonControls.addActionListener( new HangmanLetterButtonsController( hangman ) );

		// GallowsHangmanView
		GallowsHangmanView gallowsHangmanView;
		gallowsHangmanView = new GallowsHangmanView( hangman );

		// add view
		hangman.addView( labelsHangmanView );
		hangman.addView( gallowsHangmanView );
		//hangman.addView( letterButtonControls );
		hangman.addView( newGameButton );
		new SimpleJFrame( "GUIHangman", 									// title
							gallowsHangmanView,									// center
							textControlPanel, newGameButton,					// north, south
							letterButtonControls, labelsHangmanView );			// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
