package com.kaiomelo;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {
        return SUCCESS;
    }
}
