package TransactionRefundMS.Postgres;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.*;
import TransactionRefundMS.util.ConnectionUtil;
public class ReimbursementDAOPostgres {
	
	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
}
