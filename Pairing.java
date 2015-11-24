import java.util.*;

public class Pairing{
	public LinkedList<Match> getMatches(int roundNum, List<Player> active){
		LinkedList<Match> matches = new LinkedList<Match>();
		final LinkedList<Player> thisMatch = new LinkedList<Player>();
		Iterator<Player> plit = active.stream().sorted((a1, a2) -> Integer.compare(a1.getMatchPoints(), a2.getMatchPoints())).iterator();
		Set<Player> usedP = new HashSet<Player>();
		int tableNum = 1;
		do{
			thisMatch.add(plit.next());
			plit.forEachRemaining(a -> {
				if((thisMatch.getFirst().getOpp().stream().noneMatch(b -> b.getId() == a.getId())) && !usedP.contains(a)){
					matches.add(new Match(roundNum, tableNum, thisMatch.getFirst(), a));
					tableNum ++;
					usedP.add(thisMatch.getFirst());
					usedP.add(a);
				} else if (!usedP.contains(a)){
					matches.add(new Match(roundNum, 0, thisMatch.getFirst()));
					usedP.add(thisMatch.getFirst());
				}
			});
			thisMatch.clear();
			plit = active.stream().filter(a -> !usedP.contains(a)).sorted((a1, a2) -> Integer.compare(a1.getMatchPoints(), a2.getMatchPoints())).iterator();
		}while(plit.hasNext());

		return matches;
	}
}
