import cs102.Hangman;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * HangmanLetterButtonsController class provides an actionListener to buttons.
 */
public class HangmanLetterButtonsController implements ActionListener {

    // Instances
    private Hangman hangman;

    public HangmanLetterButtonsController( Hangman hangman) {

        this.hangman = hangman;
    }

    /**
     * get the letter of the key pressed and passes it to the tryThis
     * method of the Hangman object. It disables the button.
     * @param e button event
     */
    public void actionPerformed(ActionEvent e) {

        JButton letterButton = ( JButton ) e.getSource(); // this line casts the event and puts it into a button.
        char character = letterButton.getText().charAt(0); // takes the label on it as a char. charAt added...
        hangman.tryThis( character ); // tries the character;
    }
}
