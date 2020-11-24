package TransactionRefundMS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import TransactionRefundMS.pojos.*;

import org.apache.log4j.Logger;

import TransactionRefundMS.util.ConnectionUtil;

public class EmployeeDAOPostgres implements EmployeeDAO {
	
	private static Logger log = Logger.getRootLogger();
	private Statement statement;
	private PreparedStatement prepSt;
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	Employee emp= new Employee();

	@Override
	public boolean signIn(String username, String password) {
		int rows=0;
		
		String sql="select * from login where username=? and password=? ;";
		
		//User user=new User();
		
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, (username));
			prepSt.setString(2, (password));
			ResultSet rs = prepSt.executeQuery();
			
			log.info(" result set " + rs);
			
			while(rs.next()) {
				
				int employee_id= rs.getInt("employee_id");
				
				//employee.setEmployeeId(userId);

				
				log.info(" Postgres dao authenticated " );
				return true;
				
			}
			//rows=prepSt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		log.info(" Postgres dao ----- Failed to authenticate " + username );
		return false;
	}

	
}
