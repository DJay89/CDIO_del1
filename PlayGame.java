package dicegame;

public class PlayGame {

	public static void main(String[] args) {
		Player p1 = new Player(1,0,true);
		Player p2 = new Player(2,0,false);
		Player currentPlayer = new Player(0,0,false);

		Dice d1 = new Dice();
		Dice d2 = new Dice();
		
		int prevRoll1 = 0;
		int prevRoll2 = 0;
		
		while (p1.score < 40 && p2.score < 40)
		{
		//define who's turn it is
			if (p1.isTurn == true){
				currentPlayer = p1;
			}
			else {
				currentPlayer = p2;
			}
			
		//print who's turn it is
			int nextPlayerId;
			if (p1.isTurn == true){
				nextPlayerId = p1.id;
			}
			else {
				nextPlayerId = p2.id;
			}
				
			System.out.println("Det er spiller " + nextPlayerId + "'s tur.");
			
		//roll the dice
			int roll1 = d1.roll(); 
			int roll2 = d2.roll();
			
			System.out.println(roll1 + " " + roll2);
			
		//A player shall lose his score if the 
		//result of the dice roll is a pair of ones
			if (roll1 == 1 && roll2 == 1){
				currentPlayer.setScore(0);
			}
		//A player shall win the game, if the player 
		//throws a pair of 6’s twice, regardless from 
		//an extra turn or his previous turn.
			else if(roll1 == 6 && roll2 == 6 && prevRoll1 == 6 && prevRoll2 == 6){
				currentPlayer.setScore(40);
			}
		//Add dice values to current score
			else {
				currentPlayer.addScore(roll1+roll2);
			}
			
		//A player shall get an extra turn if 
		//the result of the dice throw is a pair.
			if (roll1 == roll2){ 
				if (currentPlayer == p1){
					p1.isTurn = true;
				}
				else {
					p1.isTurn = false;
				}
			}
			else {
				if (currentPlayer == p1){
					p1.isTurn = false;
				}
				else {
					p1.isTurn = true;
				}
			}
		
		//Print the score for both players
			System.out.println(p1 + "\t" + p2);
			System.out.println("-----------------------------------------------");
		
		//Save the rolls in prevRoll1 and prevRoll2
			prevRoll1 = roll1;
			prevRoll2 = roll2;
		}
		
		//Define the winner
		Player winner = new Player(0,0,false);
		
		if (p1.score>=40){
			winner = p1;
		}
		else {
			winner = p2;
		}
		
		//Print the winner
		System.out.println("Vinderen er: Spiller " + winner.id + "!");	
	}
}
