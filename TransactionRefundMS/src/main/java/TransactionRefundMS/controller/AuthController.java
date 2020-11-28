package TransactionRefundMS.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import TransactionRefundMS.service.*;
import io.javalin.http.Context;

public class AuthController {
	
	private AuthService auth= new AuthServiceImpl();
	
	private static Logger log = Logger.getRootLogger();

	public void signIn(Context ctx) throws ServletException, IOException {
		
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
				//ctx.req.getRequestDispatcher("/employee").forward(ctx.req, ctx.res);
				ctx.redirect("directSupDashboard.html");
			}
			if(authenticated >= 300 && authenticated <400) {
				ctx.redirect("deheadDashboard.html");
			}
			if(authenticated >=400) {
				ctx.redirect("bencoDashboard.html");
				log.info("Benco");
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
