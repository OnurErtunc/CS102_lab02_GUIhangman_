import cs102.Hangman;
import javax.swing.*;
import java.awt.*;

/**
 * LabelsHangmanView class shows the information about the game
 * it updates itself after each round
 *
 * @author Onur Ertunc
 * @version 9.12.2020
 */
public class LabelsHangmanView extends JPanel implements IHangmanView {

    // Instances
    private JLabel numberOfIncorrectAns;
    private JLabel knownSoFar;
    private JLabel usedLetters;
    private JLabel lost;

    // font setup
    private static final Font font = new Font("Serif", Font.BOLD, 50);

    // background color
    Color retroBlue = new Color(104, 174, 184);

    public LabelsHangmanView() {

        // calls JPanel! not a label
        super();
        this.setPreferredSize( new Dimension( 400, 200) );

        // initialize labels
        numberOfIncorrectAns = new JLabel( "" );
        knownSoFar = new JLabel( "" );
        usedLetters = new JLabel( "" );
        lost = new JLabel( "" );

        numberOfIncorrectAns.setFont( font );
        usedLetters.setFont( font );
        knownSoFar.setFont( font );

        // Layout setup
        this.setLayout( new BoxLayout( this, BoxLayout.Y_AXIS) );
        this.add( numberOfIncorrectAns );
        this.add( knownSoFar );
        this.add( usedLetters );
        this.add( lost );

        this.setBackground( retroBlue );

    }


    /**
     * updates data like incorrect tries, known characters, etc.
     * @param hangmanModel
     */
    public void updateView(Hangman hangmanModel) {

        // when the game is continuing, print the data
        if( !hangmanModel.isGameOver() ) {

            knownSoFar.setText( hangmanModel.getKnownSoFar() );
            numberOfIncorrectAns.setText( "Incorrect Tries: " + hangmanModel.getNumOfIncorrectTries() );
            usedLetters.setText( "Used letters: " + hangmanModel.getUsedLetters() );
        }
        else {
            // if the player wins
            if ( !hangmanModel.hasLost() ) {

                knownSoFar.setText( "You won! the word was " + hangmanModel.getKnownSoFar() );
            }
            // otherwise
            else {

                knownSoFar.setText( "You lost! ");
            }

        }
    }
}
