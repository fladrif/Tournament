/*
	Main.java instantiates the classes and passes Ui into logic to start the game

	Tourney.java defines a class that holds all information pertinent to a specific instance of a tournament
		including date, specification, list of players, list of active players, and matches
	
	Round.java defines a class that holds a list of Match(es) that pertain to a certain round

	Match.java defines class that holds the information for a match(round #) between players and the outcome

	Pairing.java defines the class that generates pairs of players per round and avoids rematches

	Player.java defines class that holds player data including win rate and list of opponents

	Ui.java is an interface for the logic to work with and for the javafx to implement

	Ui.java defines class that instantiates the gui and displays all the informaton about the tournament
		and takes input for updates regarding match results

	Logic.java defines class that interfaces between the Ui class and Engine class.
*/
public class Main{
	public static void main(String[] args){
		CommandUi ui = new CommandUi();
		Logic log = new Logic(ui);
	}
}
