import cs102.Hangman;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * new game button control method
 * @author Onur Ertunc
 * @version 11.12.2020
 */
public class NewGameButtonControl extends JButton implements ActionListener, IHangmanView {

    private Hangman hangman;
    private ActionListener theHandler;

    public NewGameButtonControl( Hangman hangman ) {

        super( "New Game");
        this.setPreferredSize( new Dimension(200, 200));

        this.hangman = hangman;


        this.addActionListener( this );
        this.setEnabled( true );
    }

    /**
     * updates view of the button. Makes it enable at the end of each game.
     * @param hangmanModel hangman instance
     */
    public void updateView(Hangman hangmanModel) {

        if ( !hangman.isGameOver() ) {
            this.setEnabled( true );
        }
    }

    /**
     * controls the button, pressed the new game button, the method makes it disabled
     * @param event button events
     */
    public void actionPerformed( ActionEvent event ) {

        hangman.initNewGame();
        this.setEnabled( false );
    }
}
