
import java.util.Random;

public class PartThree {
	
	public void gameOnePlayer() {
		
		Keyboard keyboard = new Keyboard();
		Random rand = new Random();
		
		int playerCapital = 30;
		
		boolean done = false;
		while (!done) {
			
			System.out.println("the game master roll the dices");
			int dice1 = rand.nextInt(6);
			int dice2 = rand.nextInt(6);
			System.out.println("the results are " +dice1+" "+ dice2 );
			System.out.println("do you choose to take one of them, both, or quit?  [enter the result or -1 to quit]");
			
			int R = keyboard.readInt();
				
			if (R == -1) {
				return;
			}
			
			playerCapital -=  R;
			
			if (playerCapital < 0) {
				System.out.println("your capital went under 0, start again\nyour capital is 30");
				playerCapital = 30;
			}
			
			if (playerCapital == 0) {
				System.out.println("you win");
				return;
			}
		}
	}
	
	public void gameTwoPlayers() {
		
		Keyboard keyboard = new Keyboard();
		Random rand = new Random();
		
		int[] playersCapital = new int[] {30, 30};
		
		// keep track of turn of the player:
		int turn = 0;
		
		boolean done = false;
		while (!done) {
			System.out.println("player "+ (turn+1) + " turn");
			System.out.println("the game master roll the dices");
			int dice1 = rand.nextInt(6);
			int dice2 = rand.nextInt(6);
			System.out.println("the results are " +dice1+" "+ dice2 );
			System.out.println("do you choose to take one of them, both, or quit?  [enter the result or -1 to quit]");
			
			// read player input
			int R = keyboard.readInt();
			
			if ((R != -1) && (R != dice1) && (R != dice2) && (R != dice1+dice2))
			{
				// if the player played a number that was not an option:
				System.out.println("player " + (turn+1) + "tried to cheat, player" +  (turn+1)%2+1 + " win");
				return;
			}
				
			//	quit
			if (R == -1) {
				return;
			}
			
			// update capital
			playersCapital[turn] -=  R;
			
			// if current player has a capital under 0
			if (playersCapital[turn] < 0) {
				System.out.println("your capital went under 0, start again\nyour capital is 30");
				playersCapital[turn] = 30;
			}
			
			// if the current player's capital is 0
			if (playersCapital[turn] == 0) {
				System.out.println("player " + (turn+1) + " win");
				return;
			}
			
			// update turn:
			turn = (turn+1)%2;
		}
	}
}
