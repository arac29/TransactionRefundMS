package TransactionRefundMS.main;
import TransactionRefundMS.controller.AuthController;
import io.javalin.Javalin;

public class ServerDriver {

	private static AuthController authController= new AuthController();
	
	//private static final String USER_PATH=
	
	public static void main (String[]args) {
		
		
		Javalin app=Javalin.create( 
				config -> {config.addStaticFiles("/public"); }).start(9094);
		
		
		app.get("/testing", ctx -> ctx.html("Welcome"));
		
		app.get("/", ctx -> ctx.redirect("index.html"));
		app.post("/signIn",  ctx -> authController.signIn(ctx));
		//app.post("/")
	}
}
