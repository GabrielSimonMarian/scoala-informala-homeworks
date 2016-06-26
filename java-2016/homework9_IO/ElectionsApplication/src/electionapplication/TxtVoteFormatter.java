package electionapplication;

public class TxtVoteFormatter {

	public String toTXT(VotingList vote) {
	
		return vote.getCnp() + "," + vote.getCitizenName() + "," + vote.getCandidate();
	}

	public VotingList fromTXT(String line) {

		String[] tokens = line.split(",");
		Candidate c = Candidate.valueOf(tokens[2]);
		return new VotingList(tokens[0], tokens[1], c);
	}

}
