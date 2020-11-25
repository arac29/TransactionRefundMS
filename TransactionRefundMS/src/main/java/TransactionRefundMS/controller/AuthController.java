package TransactionRefundMS.controller;

import TransactionRefundMS.service.*;
import io.javalin.http.Context;

public class AuthController {
	
	private AuthService auth= new AuthServiceImpl();

	public void signIn(Context ctx) {
		String username =ctx.formParam("username");
		
		String password =ctx.formParam("password");
		
		int authenticated= auth.authenticatedUser(username,password);
		
		if (authenticated !=0) {
			//ctx.status(200);
			ctx.cookieStore("security", auth.createToken(authenticated));
			
			if(authenticated <=100) {
				ctx.redirect("employeeDashboard.html");
			}
			if(authenticated >=200 && authenticated <300) {
				ctx.redirect("bencoDashboard.html");
			}
			if(authenticated >= 300 && authenticated <400) {
				ctx.redirect("deheadDashboard.html");
			}
			if(authenticated >=400) {
				ctx.redirect("directSupDashboard.html");
			}			
//			ctx.req.getRequestDispatcher("/readAllUsers").forward(ctx.req, ctx.res);
			
		} 
		
		else {
			ctx.redirect("index.html?error=failed-login");
		}
		
	}
	
	public void checkUser(Context ctx) {
		ctx.html(auth.validateToken(ctx.cookieStore("security")));
	}
	

}
