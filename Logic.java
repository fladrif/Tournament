public class Logic{
	Tourney tournament;
	public Logic(Ui inout){
		tournament = new Tourney();
		while(true){
			if(inout.getOrRemove()){
				tournament.registerPlayer(inout.getPlayer());
			} else {
				tournament.removePlayer(inout.removePlayer());
			}
			inout.showPlayers(tournament.getPlayers());
		}
	}
}
