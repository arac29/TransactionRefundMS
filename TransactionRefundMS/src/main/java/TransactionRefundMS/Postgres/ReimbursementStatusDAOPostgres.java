package TransactionRefundMS.Postgres;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.*;
import TransactionRefundMS.pojos.ReimbursementStatus;
import TransactionRefundMS.util.ConnectionUtil;

public class ReimbursementStatusDAOPostgres implements ReimbursementStatusDAO{
	
	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	@Override
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementStatus> readAllReimbursementStatuses() {
		// TODO Auto-generated method stub
		return null;
	}

}
