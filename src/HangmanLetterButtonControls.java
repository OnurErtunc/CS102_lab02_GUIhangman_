import cs102.Hangman;
import java.awt.*;
/**
 * class that extends LetterButtonControls to prevent some inefficiencies
 * @author Onur Ertunc
 * @version 11.12.2020
 */
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {

    public HangmanLetterButtonControls( Hangman hangman, int row, int col ) {

        super( hangman.getAllLetters(), row, col );
        this.setPreferredSize( new Dimension( 250, 200 ) );
    }

    /**
     * overrides the updateView method to provide efficiency between label and buttons as an input
     * @param hangmanModel hangman instance
     */
    public void updateView(Hangman hangmanModel) {

        // disable used buttons...
        if ( !hangmanModel.getUsedLetters().equals( "" ) ) {
            this.setDisabled( hangmanModel.getAllLetters() );
        }

        // enables them
        if ( hangmanModel.isGameOver() ) {
            setEnabledAll( true );
        }
    }
}
