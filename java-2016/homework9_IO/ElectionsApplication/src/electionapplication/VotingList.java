package electionapplication;

public class VotingList {

	private String cnp;
	private String citizenName;
	private Candidate candidate;
	private int vote;

	public String getCnp() {
		return cnp;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public int getVote() {
		return vote;
	}

	public VotingList(String cnp, String citizenName, Candidate candidate) {
		this.cnp = cnp;
		this.citizenName = citizenName;
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "[" + cnp + ", " + citizenName + ", Voted: " + candidate + "number of votes: " + vote + "]";
	}

}
