public class Logic{
	Tourney tournament;
	public Logic(Ui inout){
		tournament = new Tourney();
		while(true){
			int choice = inout.getOrRemoveOrDone();
			if(choice == 1){
				tournament.registerPlayer(inout.getPlayer());
			} else if(choice == -1){
				tournament.removePlayer(inout.removePlayer());
			} else if(choice == 0){
				break;
			}
			inout.showPlayers(tournament.getPlayers());
		}
		tournament.startTournament();
		int numOfPlayers = tournament.numOfPlayers();
		int rounds = 2;
		int playerCap = 8;
		while(numOfPlayers >= playerCap){
			playerCap *= 2;
			rounds++;
		}
		inout.displayRound(tournament.getRound());
		while(true){
			if(inout.reportOrFinish()){
				if(!tournament.finishMatch(inout.getTable(), inout.getWin(), inout.getLoss(), inout.getDraw())){
					System.out.println("Incorrect values entered.");
				}
				inout.displayRound(tournament.getRound());
			} else {
				if(tournament.roundFinished()){
					if(--rounds == 0) break;
					tournament.nextRound();
					inout.displayRound(tournament.getRound());
				} else {
					System.out.println("Haven't finished round yet.");
				}
			}
		}
		System.out.println("Finished Tournament");
		inout.displayResult(tournament.getPlayers());
	}
}
