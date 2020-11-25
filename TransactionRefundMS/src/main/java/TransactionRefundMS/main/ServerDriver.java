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
		
		
		app.get("/testing", ctx -> ctx.html("Welcome"));
		
		app.get("/", ctx -> ctx.redirect("index.html"));
		app.post("/signIn",  ctx -> authController.signIn(ctx));
		app.get("/auth", ctx -> authController.checkUser(ctx));
		
		
		
		app.get("/readReimbursementStatus", ctx -> reimController.checkStatus(ctx));
		
		
		
		//app.post("/")
	}
//	
//	public void submitForm(Context ctx) {
//		
//	}
//	
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
