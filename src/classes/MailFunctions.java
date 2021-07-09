package classes;


import java.util.*;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
public class MailFunctions {
//	public static void sendMail(String recepient) {
//		// email ID of Recipient.
//	      //String recipient = "recipient@gmail.com";
//	  
//	      // email ID of  Sender.
//	      String sender = "gayatribasude@gmail.com";
//	  
//	      // using host as localhost
//	      String host = "127.0.0.1";
//	  
//	      // Getting system properties
//	      Properties properties = System.getProperties();
//	  
//	      // Setting up mail server
//	      properties.setProperty("mail.smtp.host", host);
//	  
//	      // creating session object to get properties
//	      Session session = Session.getDefaultInstance(properties);
//	  
//	      try 
//	      {
//	         // MimeMessage object.
//	         MimeMessage message = new MimeMessage(session);
//	  
//	         // Set From Field: adding senders email to from field.
//	         message.setFrom(new InternetAddress(sender));
//	  
//	         // Set To Field: adding recipient's email to from field.
//	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
//	  
//	         // Set Subject: subject of the email
//	         message.setSubject("This is Suject");
//	  
//	         // set body of the email.
//	         message.setContent("<h1>This is a HTML text</h1>","text/html");
//	  
//	         // Send email.
//	         Transport.send(message);
//	         System.out.println("Mail successfully sent");
//	      }
//	      catch (MessagingException mex) 
//	      {
//	         mex.printStackTrace();
//	      }
//	}

	public static void sendMail(String recepient, String headingString, String subheadingString, Date time,
			String detailString,int todo_id) {
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myEmailString="gayatribasude@gmail.com";
		String myPasswordString="ansarisana";
		
		Session session=Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmailString, myPasswordString);
				};
			});
		Message message=prepareMessage(session, myEmailString, recepient,headingString,subheadingString,time,detailString,todo_id);
		try {
			Transport.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Message prepareMessage(Session session,String myEmailString,String recepient, String headingString, String subheadingString, Date date, String detailString,int todo_id) {
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myEmailString));
			message.setRecipient(RecipientType.TO,new InternetAddress(recepient));
			message.setSubject("Toders:"+headingString);
			String contentString="<h1>"+headingString+"</h1>";
			contentString+="<h3"+subheadingString+"</h3>";
			contentString+="<p>"+detailString+"</p>";
			contentString+="Time:"+date;
			message.setContent(emailContent(headingString,subheadingString,date,detailString,todo_id),"text/html; charset=utf-8");
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	private static String emailContent(String headingString, String subheadingString, Date date, String detailString,int todo_id) {
		// TODO Auto-generated method stub
		int user_id=10;
		String contentString="<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "\n"
				+ "<head>\n"
				+ "    <title></title>\n"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
				+ "    <style type=\"text/css\">\n"
				+ "        @media screen {\n"
				+ "            @font-face {\n"
				+ "                font-family: 'Lato';\n"
				+ "                font-style: normal;\n"
				+ "                font-weight: 400;\n"
				+ "                src: local('Lato Regular'), local('Lato-Regular'), url(https://fonts.gstatic.com/s/lato/v11/qIIYRU-oROkIk8vfvxw6QvesZW2xOQ-xsNqO47m55DA.woff) format('woff');\n"
				+ "            }\n"
				+ "\n"
				+ "            @font-face {\n"
				+ "                font-family: 'Lato';\n"
				+ "                font-style: normal;\n"
				+ "                font-weight: 700;\n"
				+ "                src: local('Lato Bold'), local('Lato-Bold'), url(https://fonts.gstatic.com/s/lato/v11/qdgUG4U09HnJwhYI-uK18wLUuEpTyoUstqEm5AMlJo4.woff) format('woff');\n"
				+ "            }\n"
				+ "\n"
				+ "            @font-face {\n"
				+ "                font-family: 'Lato';\n"
				+ "                font-style: italic;\n"
				+ "                font-weight: 400;\n"
				+ "                src: local('Lato Italic'), local('Lato-Italic'), url(https://fonts.gstatic.com/s/lato/v11/RYyZNoeFgb0l7W3Vu1aSWOvvDin1pK8aKteLpeZ5c0A.woff) format('woff');\n"
				+ "            }\n"
				+ "\n"
				+ "            @font-face {\n"
				+ "                font-family: 'Lato';\n"
				+ "                font-style: italic;\n"
				+ "                font-weight: 700;\n"
				+ "                src: local('Lato Bold Italic'), local('Lato-BoldItalic'), url(https://fonts.gstatic.com/s/lato/v11/HkF_qI1x_noxlxhrhMQYELO3LdcAZYWl9Si6vvxL-qU.woff) format('woff');\n"
				+ "            }\n"
				+ "        }\n"
				+ "\n"
				+ "        /* CLIENT-SPECIFIC STYLES */\n"
				+ "        body,\n"
				+ "        table,\n"
				+ "        td,\n"
				+ "        a {\n"
				+ "            -webkit-text-size-adjust: 100%;\n"
				+ "            -ms-text-size-adjust: 100%;\n"
				+ "        }\n"
				+ "\n"
				+ "        table,\n"
				+ "        td {\n"
				+ "            mso-table-lspace: 0pt;\n"
				+ "            mso-table-rspace: 0pt;\n"
				+ "        }\n"
				+ "\n"
				+ "        img {\n"
				+ "            -ms-interpolation-mode: bicubic;\n"
				+ "        }\n"
				+ "\n"
				+ "        /* RESET STYLES */\n"
				+ "        img {\n"
				+ "            border: 0;\n"
				+ "            height: auto;\n"
				+ "            line-height: 100%;\n"
				+ "            outline: none;\n"
				+ "            text-decoration: none;\n"
				+ "        }\n"
				+ "\n"
				+ "        table {\n"
				+ "            border-collapse: collapse !important;\n"
				+ "        }\n"
				+ "\n"
				+ "        body {\n"
				+ "            height: 100% !important;\n"
				+ "            margin: 0 !important;\n"
				+ "            padding: 0 !important;\n"
				+ "            width: 100% !important;\n"
				+ "        }\n"
				+ "\n"
				+ "        /* iOS BLUE LINKS */\n"
				+ "        a[x-apple-data-detectors] {\n"
				+ "            color: inherit !important;\n"
				+ "            text-decoration: none !important;\n"
				+ "            font-size: inherit !important;\n"
				+ "            font-family: inherit !important;\n"
				+ "            font-weight: inherit !important;\n"
				+ "            line-height: inherit !important;\n"
				+ "        }\n"
				+ "\n"
				+ "        /* MOBILE STYLES */\n"
				+ "        @media screen and (max-width:600px) {\n"
				+ "            h1 {\n"
				+ "                font-size: 32px !important;\n"
				+ "                line-height: 32px !important;\n"
				+ "            }\n"
				+ "        }\n"
				+ "\n"
				+ "        /* ANDROID CENTER FIX */\n"
				+ "        div[style*=\"margin: 16px 0;\"] {\n"
				+ "            margin: 0 !important;\n"
				+ "        }\n"
				+ "    </style>\n"
				+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.8/css/all.css\">\n"
				+ "</head>\n"
				+ "\n"
				+ "<body style=\"background-color: #f4f4f4; margin: 0 !important; padding: 0 !important;\">\n"
				+ "    <!-- HIDDEN PREHEADER TEXT -->\n"
				+ "    <div style=\"display: block; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\"> We're thrilled to have you here! Get ready to dive into your new account. </div>\n"
				+ "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
				+ "        <!-- LOGO -->\n"
				+ "        <tr>\n"
				+ "            <td bgcolor=\"#333A40\" align=\"center\">\n"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n"
				+ "                    <tr>\n"
				+ "                        <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\"> </td>\n"
				+ "                    </tr>\n"
				+ "                </table>\n"
				+ "            </td>\n"
				+ "        </tr>\n"
				+ "        <tr>\n"
				+ "            <td bgcolor=\"#333A40\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;\">\n"
				+ "                            <h1 style=\"font-size: 48px; font-weight: 400; margin: 2;\">Hey Toder!</h1> \n"
				+ "                            <h3 style=\"font-size: 28px; font-weight: 200; margin: 0.2;\">"+headingString+":"+subheadingString+"</h3> \n"
				+ "                             <i class=\"fa fa-tasks\" aria-hidden=\"true\"></i>\n"
				+ "                        </td>\n"
				+ "                    </tr>\n"
				+ "                </table>\n"
				+ "            </td>\n"
				+ "        </tr>\n"
				+ "        <tr>\n"
				+ "            <td bgcolor=\"#333A40\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n"
				+ "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n"
				+ "                            <p style=\"margin: 0;\">"+detailString+"</p>\n"
				+ "                            <p style=\"margin: 0;\">Date and Time:"+date+"</p>\n"
				+ "                         </td>\n"
				+ "                    </tr>\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"left\">\n"
				+ "                            <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
				+ "                                <tr>\n"
				+ "                                    <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\n"
				+ "                                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n"
				+ "                                            <tr>\n"
				+ "												<form action=\"MarkTodoAsDone.java\" type=\"post\">"
				+ "                                                <input type=\"hidden\" name=\"todo_id\" value=\"+todo_id+\">"
				+ "												   <input type=\"hidden\" name=\"user_id\" value=\"+user_id+\">"
				+ "                                                <td align=\"center\" style=\"border-radius: 3px;\" >"
				+ 														"<a href=\"http://localhost:8080/Toder/MarkTodoAsDone?todo_id="+todo_id+"\" target=\"_blank\" style=\"font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none;  text-decoration: none; padding: 15px 25px; border-radius: 2px; border: 1px solid;background-color:#666666\">Done?</a></td>"
				+ "                                            <form>"
				+ "                                            </tr>\n"
				+ "                                        </table>\n"
				+ "                                    </td>\n"
				+ "                                </tr>\n"
				+ "                            </table>\n"
				+ "                        </td>\n"
				+ "                    </tr> <!-- COPY -->\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 0px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n"
				+ "                            <p style=\"margin: 0;\">If that doesn't work, copy and paste the following link in your browser:</p>\n"
				+ "                        </td>\n"
				+ "                    </tr> <!-- COPY -->\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n"
				+ "                            <p style=\"margin: 0;\"><a href=\"http://localhost:8080/Toder/login.jsp\" target=\"_blank\" style=\"color: #FFA73B;\">Toder Login Page</a></p>\n"
				
				+ "                        </td>\n"
				+ "                    </tr>\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n"
				+ "                            <p style=\"margin: 0;\">If you have any questions, just reply to this email—we're always happy to help out.</p>\n"
				+ "                        </td>\n"
				+ "                    </tr>\n"
				+ "                    <tr>\n"
				+ "                        <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;\">\n"
				+ "                            <p style=\"margin: 0;\">Cheers,<br>Team Toder</p>\n"
				+ "                        </td>\n"
				+ "                    </tr>\n"
				+ "                </table>\n"
				+ "            </td>\n"
				+ "        </tr>\n"

				+ "    </table>\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>";
		
		
		
		return contentString;
	}

	public static void sendMailForPassword(String recepient, String password) {
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myEmailString="gayatribasude@gmail.com";
		String myPasswordString="ansarisana";
		
		Session session=Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmailString, myPasswordString);
				};
			});
		Message message=prepareMessageForPassword(session, myEmailString, recepient,password);
		try {
			Transport.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Message prepareMessageForPassword(Session session,String myEmailString,String recepient, String password) {
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myEmailString));
			message.setRecipient(RecipientType.TO,new InternetAddress(recepient));
			message.setSubject("Toders: ");
			String body="<h1>Toders: Get Your Password</h1><br>";
			
			body+="<a href='http://127.0.0.1:8080/Toder/login.jsp'>Login</a><br>";
			body+="Password: ";
			message.setContent(body+password,"text/html; charset=utf-8");
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void sendMailTodo(String recepientString, Todo createdTodo) {
		// TODO Auto-generated method stub
		Properties properties=new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myEmailString="gayatribasude@gmail.com";
		String myPasswordString="ansarisana";
		
		Session session=Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmailString, myPasswordString);
				};
			});
		Message message=prepareMessageTodo(session, myEmailString,recepientString,createdTodo);
		try {
			Transport.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Message prepareMessageTodo(Session session, String myEmailString, String recepientString, Todo createdTodo) {
		// TODO Auto-generated method stub
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myEmailString));
			message.setRecipient(RecipientType.TO,new InternetAddress(recepientString));
			message.setSubject("Toders:"+createdTodo.getHeadingString());
			String contentString="<h1>"+createdTodo.getHeadingString()+"</h1>";
			contentString+="<h3"+createdTodo.getSubheadingString()+"</h3>";
			contentString+="<p>"+createdTodo.getDetailsString()+"</p>";
			contentString+="Time:"+createdTodo.getDatetimeTimestamp();
			message.setContent(emailContent(createdTodo.getHeadingString(),createdTodo.getSubheadingString(),createdTodo.getDatetimeTimestamp(),createdTodo.getDetailsString(),createdTodo.getTodo_idInt()),"text/html; charset=utf-8");
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}