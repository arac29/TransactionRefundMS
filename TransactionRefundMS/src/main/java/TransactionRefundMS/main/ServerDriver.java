package TransactionRefundMS.main;
import TransactionRefundMS.controller.*;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class ServerDriver {

	private static AuthController authController= new AuthController();
	private static ReimbursementController reimController=new ReimbursementController();
	private static EmployeeController employeeController = new EmployeeController();
	
	public static void main (String[]args) {
		
		
		Javalin app=Javalin.create( 
				config -> {config.addStaticFiles("/public"); }).start(9094);
		
		app.post("/cookie-storer", ctx -> {
		    ctx.cookieStore("string", "Hello world!");
		    ctx.cookieStore("i", 42);
		});
		
		
		app.get("/testing", ctx -> ctx.html("Welcome"));
		app.get("/", ctx -> ctx.redirect("index.html"));
		app.post("/employee", ctx -> ctx.redirect("employeeDashboard.html"));
		
		/**  AUTHORIZATION, AUTHENTICATION **/
		app.post("/signIn",  ctx -> authController.signIn(ctx));
		app.get("/auth", ctx -> authController.checkUser(ctx));
		app.post("/forward", ctx -> authController.validate(ctx));
		app.get("/logout" , ctx -> authController.logout(ctx));
		
		/**  REIMBURSEMENT  **/
		app.before("/submitForm", ctx -> {
		    
		});
		
		app.post("/submitForm", ctx -> reimController.submitReimbursementForm(ctx));
		//app.get("/newRequestForm", ctx -> reimController.checkBalance(ctx));
		app.get("/newRequest", ctx -> ctx.redirect("form.html"));
		
		app.get("/readReimbursementStatus", ctx -> reimController.checkStatus(ctx));
		app.get("/readReimbursements", ctx -> reimController.getReimbursements(ctx));

		
		app.get("/readEvents", ctx -> reimController.getEvents(ctx));
	}


//	public void updateAmount(Context ctx) {
//		// BENCO authentication?
//	}
//	public void cancelReimbursement(Context ctx) {
//		// regular employee and benco can do this?
//	}
//	public void updateStatus(Context ctx) {
//		//get id dept head, direct supervisor, benco
//		//get status
//		//get notes?
//		
//	}
//	public void additionalInfo
}
