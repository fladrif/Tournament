import java.util.*;

public class CommandUi{
	Scanner scan;
	public CommandUi(){
		scan = new Scanner(System.in);
	}
	public String getPlayer(){
		System.out.print("Please enter the name of the player: ");
		return scan.nextLine();
	}
	public int removePlayer(){
		System.out.print("Please enter the Player ID: ");
		return scan.nextInt();
	}
	public boolean getOrRemove(){
		System.out.println("Add or remove player? A/R");
		if(scan.nextLine().equals("A")) return true;
		else return false;
	}
	public void showPlayers(LinkedList<Player> players){
		for(Player p : players){
			System.out.println("ID: " + p.getId() + " Name: " + p.getName());
		}
	}
}
