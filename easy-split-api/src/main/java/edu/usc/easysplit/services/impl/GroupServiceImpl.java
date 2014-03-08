package edu.usc.easysplit.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.usc.easysplit.Constants;
import edu.usc.easysplit.GroupRequest;
import edu.usc.easysplit.GroupResponse;
import edu.usc.easysplit.SplitGroup;
import edu.usc.easysplit.services.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService {
	
	@Autowired
	private CacheManagerImpl cacheService;

	@Override
	public GroupResponse createGroup (GroupRequest request) {
		GroupResponse response = new GroupResponse();
		
		SplitGroup newGroup = new SplitGroup();
		newGroup.setGroupId(0);
		newGroup.setGroupName(request.getGroupName());
		newGroup.setOwner(request.getOwner());
		
		Map<String, Integer> stats = new HashMap<String, Integer>();
		stats.put(request.getOwner(), 0);
		newGroup.setStats(stats);
		
		if (!this.cacheService.hasMapKey(Constants.ALL_GROUPS)) {
			Map<Integer, SplitGroup> allGroups = new HashMap<Integer, SplitGroup>();
			allGroups.put(0, newGroup);
			this.cacheService.storeMap(Constants.ALL_GROUPS, allGroups);
		} else {
			
		}
		
		response.setThisGroup(newGroup);
		response.setSuccess(true);
		return response;
	}

	@Override
	public GroupResponse alterGroup(GroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupResponse deleteGroup(GroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
