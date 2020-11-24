package TransactionRefundMS.controller;

import TransactionRefundMS.service.*;
import io.javalin.http.Context;

public class AuthController {
	
	private AuthService auth= new AuthServiceImpl();

	public void signIn(Context ctx) {
		String username =ctx.formParam("username");
		
		String password =ctx.formParam("password");
		
		boolean authenticated= auth.authenticatedUser(username,password);
		
		if (authenticated) {
			//ctx.status(200);
			ctx.cookieStore("security", auth.createToken(username));
			
			//ctx.html("loged in");
			//ctx.redirect("view-guests-http.html");
		} else {
			//ctx.status(401);
			ctx.redirect("index.html?error=failed-login");
		}
	}
	
	public void checkUser(Context ctx) {
		ctx.html(auth.validateToken(ctx.cookieStore("security")));
	}
	

}
