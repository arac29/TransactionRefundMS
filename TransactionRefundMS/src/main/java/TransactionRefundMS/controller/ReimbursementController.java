package TransactionRefundMS.controller;
import TransactionRefundMS.pojos.*;
import TransactionRefundMS.service.*;
import org.apache.log4j.Logger;

import io.javalin.http.Context;

public class ReimbursementController {
	
	private static Logger log = Logger.getRootLogger();
	
	ReimbursementService reimbursementService = new ReimbursementServiceImpl();
	
	AuthService auth= new AuthServiceImpl();

	public void  checkStatus(Context ctx) {
		
	
	}
	public void submitReimbursementForm(Context ctx) {
		
		
		//int employeeId=Integer.parseInt(auth.validateToken(ctx.cookieStore("security")));
		int employeeId=100;
		//if (!employeeId)
		
		log.info("Submitting a new request" + employeeId);
				/* CREATE AN EVENT FIRST */

		String name = ctx.formParam("name"); // 1
		String startDate = ctx.formParam("startDate"); //2
		String endDate = ctx.formParam("endDate"); //3
		String location = ctx.formParam("location"); //4
		int eventTypeId = Integer.parseInt(ctx.formParam("eventTypeId")); //6
		String description = ctx.formParam("description"); //7
		int gradingFormatId =Integer.parseInt( ctx.formParam("format")); //8

		Event event = new Event(eventTypeId, name, description, startDate, endDate, location,
				gradingFormatId);
		
		int eventId=reimbursementService.creatEvent(event);
		log.info("Controller creating eventid- "+ eventId);

		/* CREATE A REIMBURSEMENT */
		
		double amountRequested = Double.parseDouble(ctx.formParam("amountRequested")); //5

		Reimbursement reimbursement = new Reimbursement(employeeId, eventId, amountRequested);
		
		log.info("Submitting a new request" + eventId + amountRequested );
		
		Reimbursement newa= new Reimbursement();
		newa=reimbursementService.createReimbursement(reimbursement);
		//create event, create reimbursement
	}
	
	public void updateAmount(Context ctx) {
		// BENCO authentication?
		//
	}
	public void cancelReimbursement(Context ctx) {
		// regular employee and benco can do this?
	}
	public void updateStatus(Context ctx) {
		//get id dept head, direct supervisor, benco
		//get status
		//get notes?
		
	}
	public void additionalInfo(Context ctx) {
		
	}
	
	
}
