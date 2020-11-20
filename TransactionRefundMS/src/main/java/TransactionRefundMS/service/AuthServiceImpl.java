package TransactionRefundMS.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
//import org.apache.log4j.Logger;

import TransactionRefundMS.util.ConnectionUtil;

public class AuthServiceImpl implements AuthService{
	
	
	private Statement statement;
	private PreparedStatement prepSt;

	private ConnectionUtil connUtil = new ConnectionUtil();

	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	//private static Logger log = Logger.getRootLogger();
	
	private static byte[] salt = new SecureRandom().getSeed(16);

	private Map<String, String> tokenRepo = new HashMap<>();
	
	// ADD THE LOGIN DAO??? where the login function is
	
	@Override
	public boolean authenticatedUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String createToken(String username) {
		String token = simpleHash(username);

		tokenRepo.put(token, username);

		return token;
	}

	@Override
	public String validateToken(String token) {
		return tokenRepo.get(token);
	}
	
	private String simpleHash(String username) {
		
		String hash = null;
		
		MessageDigest md;
		
		try {
			
			md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			
			byte[] bytes = md.digest(username.getBytes());

			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < bytes.length; i++) {
				
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(0));
			}
			
			hash = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
		
			e.printStackTrace();
		}
		
		return hash;
	}
}