package edu.usc.easysplit;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private boolean newUser;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	@Override
	public String toString() {
		return this.userName;
	}
}