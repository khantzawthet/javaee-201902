package com.jdc.jsf.navigation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NavigateByAction {

	public String goToOtherPage() {
		return "/otherpage";
	}
}
