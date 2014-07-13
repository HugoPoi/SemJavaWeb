package org.esgi.orm;

import org.esgi.orm.model.User;


public class Application {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		//ORM.mysqlHost 		= "localhost";
		//ORM.mysqlDatabase 	= "test";
		//ORM.mysqlUser 		= "test";
		//ORM.mysqlPassword 	= "PrJuHXpQn6XSntuN";
		
		User u = new User();
		u.id = 1;
		u.login = "hugo@leanforge.dev";
		u.setPassword("toto");
		ORM.save(u);
		System.out.println(User.checkPassword("hugo", "toto"));
		//u = (User) ORM.load(User.class, 5);
	}
}
