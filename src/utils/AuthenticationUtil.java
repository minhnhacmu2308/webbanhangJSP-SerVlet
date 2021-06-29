package utils;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.UserModel;

public class AuthenticationUtil {
	public boolean checkToken(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserModel user =(UserModel) session.getAttribute("admin");
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}
}
