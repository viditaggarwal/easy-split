package edu.usc.easysplit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class LoginResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	List<SplitGroup> memberOf = new ArrayList<SplitGroup>();
	
	private boolean success;

	public List<SplitGroup> getMemberOf() {
		return memberOf;
	}

	public void setMemberOf(List<SplitGroup> memberOf) {
		this.memberOf = memberOf;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}