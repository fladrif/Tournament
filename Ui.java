import java.util.*;

public interface Ui{
	public String getPlayer();
	public int removePlayer();
	public boolean getOrRemove();
	public void showPlayers(LinkedList<Player> players);
}
