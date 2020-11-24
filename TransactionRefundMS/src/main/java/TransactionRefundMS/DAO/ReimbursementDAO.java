package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.*;

public interface ReimbursementDAO {
	public void createReimbursement(Reimbursement reimbursement);
	
	public Reimbursement readReimbursement(int reimbursementId);
	
	public List<Reimbursement> readAllReimbursements();
	public Reimbursement updateReimbursement(Reimbursement reimbursement);
}
