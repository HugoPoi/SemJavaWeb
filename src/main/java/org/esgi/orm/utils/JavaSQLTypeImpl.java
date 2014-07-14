package org.esgi.orm.utils;

import java.sql.Types;

public class JavaSQLTypeImpl {
	
	public static JavaSqlTypeMap typesMapping;
	
	static{
		typesMapping = new JavaSqlTypeMap();
		
		typesMapping.add(new JavaSqlTypeBindItem(Integer.class, Types.INTEGER, 11));
		typesMapping.add(new JavaSqlTypeBindItem(String.class, Types.VARCHAR, 300));
		typesMapping.add(new JavaSqlTypeBindItem(java.sql.Date.class, Types.TIMESTAMP, null));
		//typesMapping.add(new JavaSqlTypeBindItem(Date.class, Types.TIMESTAMP, null));
	}

}
