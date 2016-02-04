import java.util.*;
import java.util.concurrent.atomic.*;

public class Pairing{
	public LinkedList<Match> getMatches(int roundNum, List<Player> active){
		LinkedList<Match> matches = new LinkedList<Match>();
		final LinkedList<Player> thisMatch = new LinkedList<Player>();
		Iterator<Player> plit = active.stream().sorted((a1, a2) -> Integer.compare(a2.getMatchPoints(), a1.getMatchPoints())).iterator();
		Set<Player> usedP = new HashSet<Player>();
		AtomicInteger table = new AtomicInteger(1);
		do{
			thisMatch.add(plit.next());
			if(plit.hasNext()){
				plit.forEachRemaining(a -> {
					if((thisMatch.getFirst().getOpp().stream().noneMatch(b -> b.getId() == a.getId())) && !usedP.contains(a) && !usedP.contains(thisMatch.getFirst())){
						matches.add(new Match(roundNum, table.getAndIncrement(), thisMatch.getFirst(), a));
						usedP.add(thisMatch.getFirst());
						usedP.add(a);
			/* Unneeded addition. It will create byes after the first failed match
					} else if (!usedP.contains(a) && !usedP.contains(thisMatch.getFirst())){
						System.out.println("Player: " + thisMatch.getFirst().getName() + " has bye");
						System.out.println("Match points: " + thisMatch.getFirst().getMatchPoints());
						matches.add(new Match(roundNum, thisMatch.getFirst()));
						usedP.add(thisMatch.getFirst());
			*/
					}
				});
			} else {
				matches.add(new Match(roundNum, thisMatch.getFirst()));
				usedP.add(thisMatch.getFirst());
			}
			thisMatch.clear();
			plit = active.stream().filter(a -> !usedP.contains(a)).sorted((a1, a2) -> Integer.compare(a2.getMatchPoints(), a1.getMatchPoints())).iterator();
		}while(plit.hasNext());

		return matches;
	}
}
