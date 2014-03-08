package edu.usc.easysplit.services;

import edu.usc.easysplit.LoginRequest;
import edu.usc.easysplit.LoginResponse;

public interface ILoginService {

	public LoginResponse loginUser (LoginRequest request);
}
