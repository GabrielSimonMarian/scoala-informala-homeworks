package electionapplication;

import java.util.List;

public class PoolingBooth {

	private VotingSystem repository;

	public PoolingBooth(VotingSystem repository) {
		super();
		this.repository = repository;
	}

	public void save(List<VotingList> VotesList) throws Exception {

		repository.save(VotesList);
	}

}
