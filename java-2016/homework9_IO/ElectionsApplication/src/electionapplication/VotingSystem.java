package electionapplication;

import java.util.List;

public interface VotingSystem {

	void save(List<VotingList> votesList) throws Exception;

	List<VotingList> loadAll() throws Exception;

}
