package TransactionRefundMS.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import TransactionRefundMS.pojos.Event;
import TransactionRefundMS.pojos.Reimbursement;
import TransactionRefundMS.service.AuthService;
import TransactionRefundMS.service.AuthServiceImpl;
import TransactionRefundMS.service.ReimbursementService;
import TransactionRefundMS.service.ReimbursementServiceImpl;
import io.javalin.http.Context;

public class ReimbursementController {
	
	private static Logger log = Logger.getRootLogger();
	
	ReimbursementService reimbursementService = new ReimbursementServiceImpl();
	
	AuthService auth= new AuthServiceImpl();

	public void  checkStatus(Context ctx) {
		int employeeId=ctx.cookieStore("id");
		log.info("Check Reimbursement Status of " + employeeId);
		
		//ctx.result(reimbursementService.re)
	
	}
	public void submitReimbursementForm(Context ctx) throws ServletException, IOException {
		
		
		int employeeId=ctx.cookieStore("id");
		//int employeeId=100;
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
		ctx.cookieStore("submitted" ,true);
		ctx.req.getRequestDispatcher("/forward").forward(ctx.req, ctx.res);
	}
	
	public void getReimbursements(Context ctx) {
		int id=ctx.cookieStore("id");
		List<Reimbursement> reimList = reimbursementService.readReimbursementById(id);
		ctx.json(reimList);
	}
	
	public void getEvents(Context ctx) {
		int id=ctx.cookieStore("id");
		List<Event> reimList = reimbursementService.readEventById(id);
		ctx.json(reimList);
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
	public boolean checkBalance(Context ctx) {
		
		return false;
	}
	
	
}
