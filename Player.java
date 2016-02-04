import java.util.*;

public class Player{
	String name;
	int playerId;
	int matches, games, matchPoints, gamePoints;
	List<Player> opponents;
	public Player(String name, int id){
		this.name = name;
		playerId = id;
		games = 0;
		matches = 0;
		matchPoints = 0;
		gamePoints = 0;
		opponents = new LinkedList<Player>();
	}
	public void addOpp(Player p){
		opponents.add(p);
	}
	public void addMatch(int points){
		matches++;
		matchPoints += points;
	}
	public void addGames(int numOfGames, int points){
		games += numOfGames;
		gamePoints += gamePoints;
	}
	public List<Player> getOpp(){
		return opponents;
	}
	public int getMatches(){
		return matches;
	}
	public int getGames(){
		return games;
	}
	public int getMatchPoints(){
		return matchPoints;
	}
	public int getGamePoints(){
		return gamePoints;
	}
	public String getName(){
		return name;
	}
	public int getId(){
		return playerId;
	}
}
