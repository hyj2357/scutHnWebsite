package com.scuthnweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.scuthnweb.dao.interf.MessageDao;
import com.scuthnweb.domain.Message;

public class MessageDaoImpl implements MessageDao{

	private Connection DbConnection = null;
	
	
	/*
	 * provide the default construct method
	 * when construct the class of MessageDaoImpl
	 * open the connection to the database
	 * 
	 * when the class is about to gc by JVM
	 * close the connection to the database
	 * in the method "finalize"
	 * 
	 */
	public MessageDaoImpl() /*throws SQLException, ClassNotFoundException*/{
		/*
		String DBDriver = "org.gjt.mm.mysql.Driver";
		Class.forName(DBDriver);
		
		String User = "root";
		String password = "123456";
		String DBURL = "jdbc:mysql://localhost:3306/scut_hn_web_site";
				
		this.setDbConnection( DriverManager.getConnection(DBURL,User,password) );
		*/
	}
	
	
	
	public void createMessage(int message_id, String message_content) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Message findByMessage_ID(int message_id) {
		// TODO Auto-generated method stub
		return null;
	}



	public Connection getDbConnection() {
		return DbConnection;
	}



	public void setDbConnection(Connection dbConnection) {
		DbConnection = dbConnection;
	}

	
	
	/*
	 * just close the connection before JVM 
	 * gc this class
	 * 
	 * @param noneParam
	 * 
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() throws SQLException{
		this.DbConnection.close();
	}



	@Override
	public void updateMessage(int message_id, int message_idM,
			String message_content) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Message> findMessageM(int message_i, String message_content) {
		// TODO Auto-generated method stub
		return null;
	};
}
