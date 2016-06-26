package electionapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MainClass {

	public static void main(String[] args) throws Exception {

		OptimizedVoteRecords repository = new OptimizedVoteRecords();

			repository.openTxt();

			PoolingBooth records = new PoolingBooth(repository);
			List<VotingList> listOfVotes = new ArrayList<VotingList>();

			listOfVotes.add(new VotingList("1111111111111", "Alliser Thorne", Candidate.MUTTLEY));
			listOfVotes.add(new VotingList("1111111111111", "Alliser Thorne", Candidate.MUTTLEY));
			listOfVotes.add(new VotingList("2222222222222", "Eddison Tollet", Candidate.JOHN_SNOW));
			listOfVotes.add(new VotingList("3333333333333", "Jeor Mormont", Candidate.JOHN_SNOW));
			listOfVotes.add(new VotingList("4444444444444", "Samwell Tarly", Candidate.JOHN_SNOW));
			listOfVotes.add(new VotingList("5555555555555", "Olly", Candidate.A_TREE));
			listOfVotes.add(new VotingList("6666666666666", "Pãcalã", null));
			listOfVotes.add(new VotingList("7777777777777", "Caligula", Candidate.INCICTATUS));

			records.save(listOfVotes);

			Map<Candidate, Integer> voteCount = countCandidateVotes(listOfVotes);
			System.out.println("Votes per candidate: " + voteCount);

			Candidate mostVotedCandidate = getTheWinner(voteCount);
			System.out.println("And the winner is: " + mostVotedCandidate);

			List<String> nameOfTheVoters = new ArrayList<String>();
			List<String> numberOfInvalidVotes = new ArrayList<>();

			for (VotingList vote : listOfVotes) {

				if (vote.getCandidate() == null) {
					numberOfInvalidVotes.add(vote.getCitizenName());
					System.out.println(vote.getCitizenName() + " has no candidate choosen.");

				}
				if (nameOfTheVoters.contains(vote.getCnp())) {
					System.out.println(vote.getCitizenName() + " has broken the rules and will be fined. All of his votes are invalidated.");
					numberOfInvalidVotes.add(vote.getCitizenName());

				} else {
					nameOfTheVoters.add(vote.getCnp());
				}
			}
			int validVotes = nameOfTheVoters.size() - numberOfInvalidVotes.size();
			int dupeVoter = numberOfInvalidVotes.size();

			System.out.println("Valid number of votes: " + validVotes);
			System.out.println("Invalid number of votes: " + dupeVoter);
		}

	/**
	 * The inventoryCount HashMap, holds all the candidates stored as keys,
	 * whereas their value represents the number of valid votes assigned to
	 * them. In order to get through the listOfVotes, an iterator object of type
	 * VotingList is used If the key is equal to the "candidate" attribute given
	 * by method v.getCandidate(), the corresponding value of the key is
	 * increased by 1 and both key and value are introduces into a new countLog
	 * HashMap.
	 * 
	 * @param listOfVotes
	 *            - an arrayList which holds the total registered votes (both
	 *            valid & invalid)
	 * @return countLog - the hashmap countlog contains all candidates (keys)
	 *         with their votes (values)
	 */

	private static Map<Candidate, Integer> countCandidateVotes(List<VotingList> listOfVotes) {
		Map<Candidate, Integer> countLog = new HashMap<Candidate, Integer>();
		Iterator<VotingList> iterator = listOfVotes.iterator();

		while (iterator.hasNext()) {
			VotingList v = iterator.next();
			Candidate cv = v.getCandidate();

			if (countLog.containsKey(cv)) {
				int counter = countLog.get(cv);
				countLog.put(cv, ++counter);
			} else {
				countLog.put(cv, 1);
			}
		}
		return countLog;
	}

	/**
	 * Initially the maximum number of votes for a candidate is set as 0 and the
	 * reference to the winner is set to be null.
	 * 
	 * 
	 * @param inventoryCount
	 * @return
	 */

	private static Candidate getTheWinner(Map<Candidate, Integer> inventoryCount) {
		int maxCount = 0;
		Candidate winner = null;
		for (Entry<Candidate, Integer> entry : inventoryCount.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				winner = entry.getKey();
			}
		}
		return winner;
	}

}
