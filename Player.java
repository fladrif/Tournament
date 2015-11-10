public class Player{
	String name;
	int matches, games, matchPoints, gamePoints;
	list<Player> opponents;
	public Player(String name){
		this.name = name;
		games = 0;
		matches = 0;
		matchPoints = 0;
		gamePoints = 0;
	}
	public void addOpp(Player p){
		opponents.add(p);
	}
}
