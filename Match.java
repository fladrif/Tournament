public class Match{
	Player player1, player2;
	int win, loss, draw, round;
	int table;
	boolean done;
	public Match(int roundNum, int tableNum, Player p1, Player p2){
		player1 = p1;
		player2 = p2;
		player1.addOpp(player2);
		player2.addOpp(player1);
		round = roundNum;
		table = tableNum;
		win = 0;
		loss = 0;
		draw = 0;
	}
	public Match(int roundNum, Player player){
		player1 = player;
		player2 = null;
		round = roundNum;
		win = 2;
		loss = 0;
		draw = 0;
		player1.addMatch(3);
		player1.addGames(2, 6);
		done = true;
	}
	public boolean matchResult(int w, int l, int d){
		if((win + loss + draw) > 3) return false;
		this.win = w;
		this.loss = l;
		this.draw = d;
		player1.addMatch(win > loss ? 3 : (win == loss ? 1 : 0));
		player1.addGames(win + loss + draw, win * 3 + draw);
		player2.addMatch(loss > win ? 3 : (win == loss ? 1 : 0));
		player2.addGames(win + loss + draw, loss * 3 + draw);
		done = true;
		return true;
	}
	public Player getPlayer1(){
		return player1;
	}
	public Player getPlayer2(){
		return player2;
	}
	public int getWin(){
		return win;
	}
	public int getLoss(){
		return loss;
	}
	public int getDraw(){
		return draw;
	}
	public int getTable(){
		return table;
	}
	public boolean getDone(){
		return done; 
	}
}
