package TransactionRefundMS.service;

public interface AuthService {
	
	public int authenticatedUser(String username, String password);
	
	public String createToken(String username);
	
	public String validateToken(String username);
	
	
}
