package dicegame;

public class Player {

	int id, score;
	boolean isTurn;
	
	public Player (int id, int score, boolean isTurn)
	{
		this.id = id;
		this.score = score;
		this.isTurn = isTurn;
	}
	
	public void setScore(int score){
		this.score = score;
	}

	public void addScore(int point){
		this.score += point;
	}

	public String getScore(){
		return "" + score;
	}

	public String getId(){
		return "" + id;
	}

	public String toString(){
		return "Spiller " + id + " har " + score + " point.";
	}
}
