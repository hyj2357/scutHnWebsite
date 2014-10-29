package com.scuthnweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.scuthnweb.dao.interf.CustomerDao;
import com.scuthnweb.domain.Customer;




public class CustomerDaoImpl implements CustomerDao{
	
	private Connection DbConnection = null;
	
	public   CustomerDaoImpl() {
		/*
		String DBDriver = "org.gjt.mm.mysql.Driver";
		Class.forName(DBDriver);
		
		String User = "root";
		String password = "123456";
		String DBURL = "jdbc:mysql://localhost:3306/scut_hn_web_site";
				
		this.setDbConnection( DriverManager.getConnection(DBURL,User,password) );
	*/
	}

	
	
	/*
	 * search the customer by name and password
	 * 
	 * @param 
	 * @see com.scuthnweb.dao.interf.CustomerDao#findByNameAndPassword(java.lang.String, java.lang.String)
	 */
	public Customer findByNameAndPassword(String customer_name, String customer_password) throws SQLException {
		// TODO Auto-generated method stub
		/*
		String sql = "select * from customer where customer_name=? and customer_password=?;";
		
		PreparedStatement p1 = this.DbConnection.prepareStatement(sql);
		
		p1.setString(1, customer_name);
		p1.setString(2, customer_password);
		
		ResultSet rs = p1.executeQuery();
		
		//set the temp class to get the return data
		Customer  CosInfo = null;
		
		this.setCostomerInfo(rs, CosInfo);		
		p1.close();
		
		return CosInfo;
	*/
		return null;
	}

	
	/*
	 * 
	 * @see com.scuthnweb.dao.interf.CustomerDao#createCustomer(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String)
	 */
	public Customer createCustomer( String customer_name, 
			                        String customer_password,
			                        int    customer_sex, 
			                        String customer_email, 
			                        String customer_grade,
			                        String customer_major, 
			                        int    customer_phone, 
			                        int    customer_qq,
			                        String customer_room){
/*
		// TODO Auto-generated method stub
		//注册之后用户具有相应权限
        String sql = "insert into customer(customer_name,customer_password,customer_sex,customer_email,customer_grade,customer_major,customer_phone,customer_qq,customer_room)" +
		             "values(?,?,?,?,?,?,?,?,?,0);";
		
		PreparedStatement p1 = this.DbConnection.prepareStatement(sql);
		
		p1.setString(1, customer_name);
		p1.setString(2, customer_password);
		p1.setInt   (3, customer_sex);
		p1.setString(4, customer_email);
		p1.setString(5, customer_grade);
		p1.setString(6, customer_major);
		p1.setInt   (7, customer_phone);
		p1.setInt   (8, customer_qq);
		p1.setString(9, customer_room);
		
		Customer cs = new Customer();
		
		try{
			p1.executeUpdate();
		}catch( SQLException e){
			return null;
		}
		
		p1.close();
		
		//search for the cusomer's id after create 
		String sql_query = "select customer_id from customer where customer_name=?;";
		PreparedStatement Q1 = this.DbConnection.prepareStatement(sql_query);
		Q1.setString(1, customer_name);
		
		ResultSet query_result = Q1.executeQuery();
		
		
		//为避免同名同姓导致用户获取非法信息
		//选取结果集中最后一个结果，即最近一个创建的账户
		//则为当前创建的用户账户
		int customer_id = 0;
		while( query_result.next())  customer_id  = query_result.getInt("customer_id");
		
		//
		cs.setAll(customer_name, customer_id, customer_sex, customer_email, customer_grade, customer_major, customer_phone, customer_qq, customer_room);
		
		return cs;
*/
		return null;
	}


	@Override
	public Customer findCustomerByCustomerEmail(String customer_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerByCustomerID(int customer_id) {
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
	 * to help set customer info
	 */
	public void setCostomerInfo( ResultSet rs, Customer cs) {
	/*
		while( rs.next()){
			   cs.setId   ( rs.getInt("customer_id"));
			   cs.setName ( rs.getString("customer_name"));
			   cs.setSex  ( rs.getInt("customer_sex"));
			   cs.setEmail( rs.getString("customer_email"));
			   cs.setGrade( rs.getString("customer_grade"));
			   cs.setMajor( rs.getString("customer_major"));
			   cs.setPhone( rs.getInt("customer_name"));
			   cs.setQq   ( rs.getInt("customer_qq"));
			   cs.setRoom ( rs.getString("customer_room"));
    	}
	*/
    }
	
	
	/**
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
	public Customer findByIdAndPassword(int customer_id,
			String customer_password) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Customer updateCustomer(int customer_id, int customer_idM,
			String customer_name, String customer_password, int customer_sex,
			String customer_email, String customer_grade,
			String customer_major, int customer_phone, int customer_qq,
			String customer_room, int customer_state) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Customer> findCustomerM(int customer_id, String customer_name,
			String customer_password, int customer_sex, String customer_email,
			String customer_grade, String customer_major, int customer_phone,
			int customer_qq, String customer_room, int customer_state) {
		// TODO Auto-generated method stub
		return null;
	};
}
