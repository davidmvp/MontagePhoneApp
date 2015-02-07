package edu.jhu.cs.oose.montage.kryonet.response;

/**
 * LoginResponse that the server sends to a user.
 * @author Greg Kogut
 *
 */
public class LoginResponse {
	/**Determines the success of a login.*/
	private boolean successfulLogin;

	/**
	 * LoginResponse constructor.
	 * @param successfulLogin indicates the success of the login
	 */
	public LoginResponse(boolean successfulLogin) {
		super();
		this.successfulLogin = successfulLogin;
	}
	
	/**
	 * Default constructor for Kryonet.
	 */
	public LoginResponse() {
	}

	/**
	 * Returns whether login status.
	 * @return true if successfully logged in, false otherwise
	 */
	public boolean isSuccessfulLogin() {
		return successfulLogin;
	}
	
}
