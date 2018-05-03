package com.an9elkiss.commons.auth;

import com.an9elkiss.commons.command.Principal;

public class AppContext {

	// TODO
	public static Principal getPrincipal() {
		Principal principal = new Principal();
		principal.setName("rz");

		return principal;
	}

}
