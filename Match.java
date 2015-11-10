public class Match{
	Player player1, player2;
	public Match(Player p1, Player p2){
		player1 = p1;
		player2 = p2;
		player1.addOpp(player2);
		player2.addOpp(player1);
	}
	private void matchResult(Player p, int win, int loss, int draw){
		
	}
	public void matchResult1(int win, int loss, int draw){
		matchResult(player1, win, loss, draw);
	}
	public void matchResult2(int win, int loss, int draw){
		matchResult(player2, win, loss, draw);
	}
}
