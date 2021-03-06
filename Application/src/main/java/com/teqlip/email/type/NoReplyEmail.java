package com.teqlip.email.type;

import com.teqlip.email.EmailAbstract;

public class NoReplyEmail extends EmailAbstract {

	private final static String fromEmailAddress = "no.reply@macrohard.com";
	
	public NoReplyEmail(String subject, String toEmailAddress, String content) {
		this.setFromEmail(fromEmailAddress);
		this.setSubject(subject);
		this.setToEmail(toEmailAddress);
		this.setContent(content);
	}
}
