package electionapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class VoteRecord implements VotingSystem {

	protected static final String VOTE_LIST = "votes.txt";
	protected TxtVoteFormatter txtFormater = new TxtVoteFormatter();

	@Override
	public void save(List<VotingList> votesList) throws IOException {
		File file = new File(VOTE_LIST);
		try (FileWriter writer = new FileWriter(file, true)) {
			for (VotingList vote : votesList) {
				writer.append(txtFormater.toTXT(vote) + "\n");
			}
		}
	}

	@Override
	public synchronized List<VotingList> loadAll() throws FileNotFoundException, IOException, ParseException {

		File file = new File(VOTE_LIST);
		ArrayList<VotingList> vote = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while (line != null) {
				VotingList v = txtFormater.fromTXT(line);
				vote.add(v);
				line = reader.readLine();
			}
		}
		return vote;
	}

}
