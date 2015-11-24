import java.util.*;

public class Round{
	int roundNum;
	LinkedList<Match> matches;
	Pairing pair;
	public Round(int roundNum, LinkedList<Player> active){
		this.roundNum = roundNum;
		pair = new Pairing();
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
}
