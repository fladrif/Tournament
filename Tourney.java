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
		Collections.shuffle(active);
		rounds = new LinkedList<Round>();
		roundNum = 1;
		rounds.add(new Round(roundNum, active));
	}
	public boolean roundFinished(){
		if(rounds.get(roundNum - 1).roundFinished()){
			return true;
		} else {
			return false;
		}
	}
	public void nextRound(){
		Collections.shuffle(active);
		rounds.add(new Round(++roundNum, active));
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
	public void dropPlayer(int id){
		active.remove(active.stream().filter(a -> a.getId() == id).iterator().next());
	}
	public LinkedList<Player> getPlayers(){
		return players;
	}
	public LinkedList<Player> getActive(){
		return active;
	}
	public Round getRound(){
		return rounds.get(roundNum-1);
	}
	public int numOfPlayers(){
		int sum = 0;
		for(Player p : active){
			sum++;
		}
		return sum;
	}

	//DEBUG CODE
	public void printPlayers(){
		Iterator<Player> plit = players.stream().iterator();
		while(plit.hasNext()){
			Player pl = plit.next();
			System.out.println("Player name: " + pl.getName() + " ID: " + pl.getId());
		}
	}
	public void printMatches(){
		rounds.get(roundNum-1).printMatches();
	}
}
