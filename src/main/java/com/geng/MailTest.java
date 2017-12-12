/*
package com.geng;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

class MailTest{
	public static final String SENDGRID_KEY = "";
	public static void main(String[] args){

		System.out.println("hello");
		SendGrid.Email mail = new SendGrid.Email();
		String toAddress="buaageng@163.com";
		mail.addTo(toAddress);
		mail.setFrom("a@a.com");
		mail.setFromName("gyj");
		String title="test";
		String content="<span style=\"font-size: 19px;\"><b><font color='blue'>%s</font></b></span>";
		mail.setSubject("test");
		mail.setHtml(content);
		mail.addCategory(new StringBuilder("coq").append("_").append("zh").toString());
		SendGrid sg = new SendGrid(SENDGRID_KEY);
		sg.buildBody(mail);
		System.out.println(String.format("toAddress=%s,tile=%s,content=%s",toAddress,title,content));
		try {
			SendGrid.Response response = sg.send(mail);
			System.out.println(String.format("mail response code=%s,msg=%s,status=%s  toString=%s",response.getCode(),response.getMessage(),response.getStatus(),response.toString()));
		} catch (SendGridException e) {
			System.out.println(String.format("send mail failed, toAddress=%s errmsg=%s",toAddress,e.toString()));
		}
	}
}
*/
