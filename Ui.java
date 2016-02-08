import java.util.*;

public interface Ui{
	public String getPlayer();
	public int removePlayer();
	//public boolean getOrRemove();
	public int getOrRemoveOrDone();
	public boolean reportOrFinish();
	public int getTable();
	public int getWin();
	public int getLoss();
	public int getDraw();
	public void showPlayers(LinkedList<Player> players);
	public void displayRound(Round rnd);
	public void displayResult(LinkedList<Player> players);
}
