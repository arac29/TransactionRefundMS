package TransactionRefundMS.service;

public interface AuthService {
	
	public boolean authenticatedUser(String username, String password);
	
	public String createToken(String username);
	
	public String validateToken(String username);
	
	
}
