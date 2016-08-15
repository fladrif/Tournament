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
		done = true;
	}
	public boolean matchResult(int w, int l, int d){
		this.win = w;
		this.loss = l;
		this.draw = d;
		if(win != 0 && win != 1 && win != 2) return false;
		if(loss != 0 && loss != 1 && loss != 2) return false;
		if(draw != 0 && draw != 1 && draw != 2) return false;
		if((win + loss + draw) > 3) return false;
		done = true;
		return true;
	}
	public void finishMatch(){
		player1.addMatch(win > loss ? 3 : (win == loss ? 1 : 0));
		player1.addGames(win + loss + draw, win * 3 + draw);
		if(player2 != null){
			player2.addMatch(loss > win ? 3 : (win == loss ? 1 : 0));
			player2.addGames(win + loss + draw, loss * 3 + draw);
		}
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
