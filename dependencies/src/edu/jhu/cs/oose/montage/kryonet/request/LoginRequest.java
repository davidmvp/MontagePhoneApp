package edu.jhu.cs.oose.montage.kryonet.request;

/**
 * Login request that the client sends to the server.
 * @author Greg Kogut
 *
 */
public class LoginRequest {
	/**UID of this user.*/
	private String uid;

	/**
	 * LoginRequest constructor.
	 * @param uid uid of the user
	 */
	public LoginRequest(String uid) {
		super();
		this.uid = uid;
	}
	
	/**
	 * Default constructor for kryonet
	 */
	public LoginRequest() {
	}

	/**
	 * Getter for the uid.
	 * @return the user's uid
	 */
	public String getUid() {
		return uid;
	}
	
}
