package edu.usc.easysplit.services;

import edu.usc.easysplit.GroupRequest;
import edu.usc.easysplit.GroupResponse;

public interface IGroupService {

	public GroupResponse createGroup (GroupRequest request);
	
	public GroupResponse alterGroup (GroupRequest request);
	
	public GroupResponse deleteGroup (GroupRequest request);
}