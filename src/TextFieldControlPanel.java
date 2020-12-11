import cs102.Hangman;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextFieldControlPanel extends JPanel {

    // Properties
    private Hangman hangman;
    private JTextField field;
    private ActionListener handler;

    public TextFieldControlPanel(HangmanModel hangman ) {

        this.hangman = hangman;

        field = new JTextField(20);
        handler = new TheHandler();
        field.addActionListener( handler );

        this.add( field );
    }

    private class TheHandler implements ActionListener {



        public void actionPerformed( ActionEvent event ) {

            String str = field.getText();

            for ( int i = 0; i < str.length(); i++ ) {
                hangman.tryThis( str.charAt(i) );
            }
            field.setText( "" );
        }
    }
}
