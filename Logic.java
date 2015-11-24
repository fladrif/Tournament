public class Logic{
	Tourney tournament;
	public Logic(Ui inout){
		tournament = new Tourney();
		while(true){
			tournament.registerPlayer(inout.getPlayer);
		}
	}
}
