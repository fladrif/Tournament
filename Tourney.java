import java.util.*;

public class Tourney{
	LinkedList<Player> players;
	LinkedList<Player> active;
	LinkedList<Round> rounds;
	String format;
	String description;
	int roundNum, playerId;
	public Tourney(){
		players = new LinkedList<Player>();
		playerId = 0;
	}
	public void startTournament(){
		active = players;
		rounds = new LinkedList<Round>();
		roundNum = 1;
	}
	public boolean nextRound(){
		if(rounds.get(roundNum - 1).roundFinished()){
			rounds.add(newRound(roundNum, active));
			return true;
		} else {
			return false;
		}
	}
	public boolean finishMatch(int table, int win, int loss, int draw){
		return rounds.get(roundNum - 1).finishMatch(table, win, loss, draw);
	}
	public void registerPlayer(String name){
		players.add(new Player(name, ++playerId));
	}
	public void removePlayer(int id){
		players.remove(players.stream().filter(a -> a.getId() == id).iterator().next());
	}
	public LinkedList<Player> getPlayers(){
		return players;
	}
	public int getRoundNum(){
		return roundNum;
	}
}
