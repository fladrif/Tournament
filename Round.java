import java.util.*;

public class Round{
	int roundNum;
	LinkedList<Match> matches;
	Pairing pair;
	public Round(int roundNum, LinkedList<Player> active){
		pair = new Pairing();
		this.roundNum = roundNum;
		matches = pair.getMatches(roundNum, active);
	}
	public boolean finishMatch(int table, int win, int loss, int draw){
		Iterator<Match> materate = matches.stream().filter(a -> a.getTable() == table).iterator();
		Match curMatch = materate.next();
		return curMatch.matchResult(win, loss, draw);
	}
	public boolean roundFinished(){
		Iterator<Match> materate = matches.stream().iterator();
		while(materate.hasNext()){
			if(!materate.next().getDone()) return false;
		}
		return true;
	}
	public LinkedList<Match> getMatches(){
		return matches;
	}
	public int getRoundNum(){
		return roundNum;
	}

	//DEBUG
	public void printMatches(){
		Iterator<Match> mat = matches.stream().iterator();
		while(mat.hasNext()){
			Match m = mat.next();
			if(m.getPlayer2() != null){
				System.out.println("P1: " + m.getPlayer1().getName() + " P2: " + m.getPlayer2().getName());
			} else {
				System.out.println("P1: " + m.getPlayer1().getName());
			}
		}
	}
}
