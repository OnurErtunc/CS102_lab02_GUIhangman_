import cs102.Hangman;
/**
 * 
 * @author Onur Ertunc
 * @version 3.12.2020
 *
 */
public class ConsoleHangmanView implements IHangmanView {
	
	public void updateView( Hangman hangmanModel) {
		
		if ( !hangmanModel.isGameOver() ) {
			
			if ( hangmanModel.getNumOfIncorrectTries() == 0 ) {
				System.out.println( "Letter box: " + hangmanModel.getAllLetters() );
			}
			System.out.println( "Remaining tries: " + ( hangmanModel.getMaxAllowedIncorrectTries() - hangmanModel.getNumOfIncorrectTries() ) );
			System.out.println( hangmanModel.getKnownSoFar() );
			System.out.println( "Used letters: " + hangmanModel.getUsedLetters() );
		}
		else if ( hangmanModel.isGameOver() ) {
			if ( hangmanModel.hasLost() ) {
				
				System.out.println( "You lost." );

			}
			else if ( !hangmanModel.hasLost() ) {
				
				System.out.println( "You won!!!" );

			}
		}
		
		int number = hangmanModel.getNumOfIncorrectTries();
        if(number == 0) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }
        if(number == 1) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }
        if(number == 2) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|    O");
            System.out.println("|    I");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }
        if(number == 3) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|    O");
            System.out.println("|   /I");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }
        if(number == 4) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|    O");
            System.out.println("|   /I\\");
            System.out.println("|");
            System.out.println("|");
            System.out.println("--------");
        }
        if(number == 5) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|    O");
            System.out.println("|   /I\\");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("--------");
        }
        if(number == 6) {
            System.out.println(" ----- ");
            System.out.println("|/   |");
            System.out.println("|    O");
            System.out.println("|   /I\\");
            System.out.println("|   / \\");
            System.out.println("|");
            System.out.println("--------");
        }
		
	}

}
