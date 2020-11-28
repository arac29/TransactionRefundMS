package TransactionRefundMS.service;
import TransactionRefundMS.pojos.*;


public interface ReimbursementService {
	
	public Reimbursement createReimbursement(Reimbursement reimbursement);
	
	public Reimbursement readReimbursement(int reimbursementId);
	
	public Reimbursement updateReimbursement(int reimbursementid, Reimbursement reimbursement);
	
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId);
	
	public int creatEvent(Event event);
	
	public Event readEvent(int eventId);
	
	public Event updateEvent(int eventId, Event event);
	
	public EventType readEventType(int eventTypeId);
	
	public GradingFormat readGradingFormat(int gradingFormatId);	
	
	public Grade readGrade(int gradeId);
}
