package TransactionRefundMS.service;
import java.util.List;

import TransactionRefundMS.pojos.Event;
import TransactionRefundMS.pojos.EventType;
import TransactionRefundMS.pojos.Grade;
import TransactionRefundMS.pojos.GradingFormat;
import TransactionRefundMS.pojos.Reimbursement;
import TransactionRefundMS.pojos.ReimbursementStatus;


public interface ReimbursementService {
	
	public Reimbursement createReimbursement(Reimbursement reimbursement);
	
	public Reimbursement readReimbursement(int reimbursementId);
	
	public Reimbursement updateReimbursement(int reimbursementid, Reimbursement reimbursement);
	
	public void updateCost(int reimbursementid, double cost);
	
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId);
	
	public List<Reimbursement> readReimbursementById(int employee_id); //add
	
	public List<Reimbursement> readReimbursementByReportTo(int reportsTo);
	
	public int updateReimbursementDirSupDate(int reimbursementId, Reimbursement reimbursement);
	
	public int creatEvent(Event event);
	
	public Event readEvent(int eventId);
	
	public List<Event> readEventById(int employee_id); //add
	
	public Event updateEvent(int eventId, Event event);
	
	public EventType readEventType(int eventTypeId);
	
	public GradingFormat readGradingFormat(int gradingFormatId);	
	
	public Grade readGrade(int gradeId);
}
