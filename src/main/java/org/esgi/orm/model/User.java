package org.esgi.orm.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.esgi.orm.ORM;
import org.esgi.orm.annotations.ORM_AUTO_INCREMENT;
import org.esgi.orm.annotations.ORM_PK;
import org.esgi.orm.annotations.ORM_TABLE;

import javax.xml.bind.DatatypeConverter;

@ORM_TABLE("users")
public class User {
	
	
	@ORM_PK
	@ORM_AUTO_INCREMENT
	public Integer id;
	public String login;
	public String teamname;
	public String role;
	
	public String getLogin() {
		return login;
	}

	public String getTeamname() {
		return teamname;
	}

	private String password;
	public volatile Date connectedAt;
	
	@Override
	public String toString() {
		return "User [id="+ id +", login=" + login + ", password=" + password
				+ ", connectedAt=" + connectedAt + "]";
	}
	
	public void setPassword(String password){
		this.password = hashPassword(password);
	}
	
	public static String hashPassword(String password){
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			return DatatypeConverter.printHexBinary(digest.digest(password.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static User checkPassword(String login, String password){
		if(login != null && password != null){
			HashMap<String, Object> checkpassword = new HashMap<>();
			checkpassword.put("login", login);
			checkpassword.put("password", hashPassword(password));
			List<Object> finded = ORM.find(User.class, null, checkpassword, null, 1, null);
			if(finded.size() == 1){
				return (User) finded.get(0);
			}
		}
		return null;
	}
}
