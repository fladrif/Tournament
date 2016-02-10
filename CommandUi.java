import java.util.*;

public class CommandUi implements Ui{
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
	/*
	public boolean getOrRemove(){
		System.out.println("Add or remove player? a/r");
		String input = scan.nextLine();
		while(true){
			if(input.equals("a")) return true;
			else if(input.equals("r")) return false;
			else input = scan.nextLine();
		}
	}
	*/
	public int getOrRemoveOrDone(){
		System.out.print("Add or remove player, or finish: a/r/f ");
		String input = scan.nextLine();
		while(true){
			if(input.equals("a")) return 1;
			else if(input.equals("r")) return -1;
			else if(input.equals("f")) return 0;
			else input = scan.nextLine();
		}
	}
	/*
	public boolean reportOrFinish(){
		System.out.print("Report match or finish round? r/f ");
		String input = scan.nextLine();
		while(true){
			if(input.equals("r")) return true;
			else if(input.equals("f")) return false;
			else input = scan.nextLine();
		}
	}
	*/
	public int reportOrDropOrFinish(){
		System.out.print("Report match, drop player, or finish round: r/d/f ");
		String input = scan.nextLine();
		while(true){
			if(input.equals("r")) return 1;
			else if(input.equals("d")) return 0;
			else if(input.equals("f")) return -1;
			else input = scan.nextLine();
		}
	}
	public int getTable(){
		System.out.print("Which table? ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	public int getWin(){
		System.out.print("Player 1 wins? ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	public int getLoss(){
		System.out.print("Player 1 loss? ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	public int getDraw(){
		System.out.print("Player 1 draw? ");
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
	public void showPlayers(LinkedList<Player> players){
		for(Player p : players){
			System.out.println("ID: " + p.getId() + " Name: " + p.getName());
		}
	}
	public void displayRound(Round rnd){
		System.out.println("::Round " + rnd.getRoundNum() + "::");
		for(Match a : rnd.getMatches()){
			if(a.getPlayer2() != null && a.getDone() == false){
				System.out.println("Table " + a.getTable() + ": " + a.getPlayer1().getName() + " vs. " + a.getPlayer2().getName());
			} else if(a.getPlayer2() != null){
				System.out.println("done ::Table " + a.getTable() + ": " + a.getPlayer1().getName() + " vs. " + a.getPlayer2().getName() + "::");
			} else {
				System.out.println(a.getPlayer1().getName() + " has a bye");
			}
		}
	}
	public void displayResult(LinkedList<Player> players){
		System.out.println("::Results::");
		Iterator<Player> plit = players.stream().sorted((a1, a2) -> Integer.compare(a2.getMatchPoints(), a1.getMatchPoints())).sorted((a1, a2) -> Integer.compare(a2.getGamePoints(), a1.getGamePoints())).iterator();
		while(plit.hasNext()){
			Player p = plit.next();
			System.out.println(p.getName() + " -- " + p.getMatchPoints());
		}
	}
}
