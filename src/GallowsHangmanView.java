import cs102.Hangman;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class GallowsHangmanView extends JPanel implements IHangmanView {

    // properties
    private Hangman hangman;
    private Rectangle2D.Double[] rec;
    private Line2D.Double[] manLines;
    private Ellipse2D.Double manHead;
    private Shape[] man;
    private String secretWord;
    private String tries;
    private String usedWords;

    // const
    private static final int PANEL_HEIGHT = 300, WIDTH = 300, X = 0, Y = 50;
    // background
    Color retroPink = new Color(243, 124, 112 );

    public GallowsHangmanView( Hangman hangman ) {

        super();
        this.hangman = hangman;
        this.setBackground( retroPink );

        rec = new Rectangle2D.Double[4];
        manLines = new Line2D.Double[5];
        man = new Shape[6]; // since player has 6 tries

        secretWord = "";
        tries = "";
        usedWords = "";

        rec[0] = (new Rectangle2D.Double(20 + X, 400 + Y, 300, 50));//bottom rectangle
        rec[1] = (new Rectangle2D.Double(60 + X, 40 + Y, 20, 360));//bottom vertical
        rec[2] = (new Rectangle2D.Double(80 + X, 40 + Y, 120, 20));//top horizontal
        rec[3] = (new Rectangle2D.Double(194 + X, 60 + Y, 6, 30));//top vertical

        // head
        manHead = new Ellipse2D.Double(167 + X, 90 + Y, 60, 60);

        // head
        manLines[0] = new Line2D.Double( manHead.getX() + (manHead.getWidth()/2 ),
                                            manHead.getY() + (manHead.getHeight() ),
                                            manHead.getX() + (manHead.getWidth()/2 ),
                                                manHead.getY() + (manHead.getHeight() + 70 ) );
        // left leg
        manLines[1] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() - 10,
                manLines[0].getY2() + 60);
        //right leg
        manLines[2] = new Line2D.Double(manLines[0].getX2(), manLines[0].getY2(), manLines[0].getX2() + 10,
                manLines[1].getY2());
        //left arm
        manLines[3] = new Line2D.Double(manLines[0].getX2(),
                ((manLines[0].getY2() - manLines[0].getY1()) / 5) + manLines[0].getY1()
                , manLines[0].getX1() - 28,
                ((manLines[0].getY2() - manLines[0].getY1()) / 4) + manLines[0].getY1() + 40);
        //right arm
        manLines[4] = new Line2D.Double(manLines[0].getX2(), manLines[3].getY1(), manLines[0].getX1() + 28,
                manLines[3].getY2());

        //adding the stick human shapes to an array
        man[0] = manHead;
        for (int i = 1; i < man.length; i++)
        {
            man[i] = manLines[i - 1];
        }
    }
    public void paintComponent( Graphics g ) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;//we're using this to draw shapes

        //drawing the gallow using rectangles
        g2.setPaint(Color.BLACK);
        for(int i = 0; i < rec.length; i++)
        {
            g2.fill(rec[i]);
        }

        //drawing the man based on the game state
        for(int i = 0; i < hangman.getNumOfIncorrectTries(); i++)
        {
            g2.draw(man[i]);
        }


    }

    @Override
    public void updateView(Hangman hangmanModel) {

        if ( !hangman.isGameOver() )
        {
            secretWord = hangman.getKnownSoFar();
            tries = "Tries: " + hangman.getNumOfIncorrectTries();
            usedWords = "Used letters: " + hangman.getUsedLetters();
        }

        else
        {
            //Lost message
            if ( hangman.hasLost() ){
                secretWord = "Oops";
                tries = "You died....";
                usedWords = "You used: " + hangman.getUsedLetters();
            }

            //Won message
            else{
                secretWord = "In " + hangman.getNumOfIncorrectTries();
                tries = "You saved your life!!";
                usedWords = "You used: " + hangman.getUsedLetters();
            }
        }
        repaint();
    }
}
