package test;


import java.sql.*;
public class testeight {
	public static void main(String [] args) throws Exception {
 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=QACS";
	  String userName="song";
	  String userPwd="song";
	  Connection dbConn = null;
	  Statement sat = null;
	 try
	{
		Class.forName(driverName);
		System.out.println("加载驱动成功！");
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("加载驱动失败！");
	}
	try{
		 dbConn= DriverManager.getConnection(dbURL,userName,userPwd);
		 sat = dbConn.createStatement();
			System.out.println("连接数据库成功！");
	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.print("SQL Server连接失败！");
	}
	
	new testeight().updateda(dbConn);
	String sql = "select * from CUSTOMER where CustomerID = 1";
	
	ResultSet rs = sat.executeQuery(sql);
	while (rs.next()){
		System.out.println("xingming:"+rs.getString(2));
	}
	
	new testeight().delll(dbConn, 1);
	
	}

		public  void updateda(Connection con) throws Exception{  
			 try {  
			 CallableStatement cstmt = con.prepareCall("{call dbo.updata(?, ?)}");  
			 /*cstmt.registerOutParameter("@divid", java.sql.Types.INTEGER); */
			 cstmt.setInt(1, 1);  
			/* cstmt.registerOutParameter(2, java.sql.Types.CHAR);*/
			 cstmt.setString(2, "songyi");
			 cstmt.execute();  
			//System.out.println(" name : " + cstmt.getString(2));  
			 System.out.println("success");
			 }  
			 catch (Exception e){  
			 e.printStackTrace();  
		 }  
			}
		
		public void delll(Connection conn,int id)throws Exception{
			try{
				CallableStatement csmt = conn.prepareCall("{call dbo.del(?)}");
				csmt.setInt(1, id);
				csmt.executeQuery();
				System.out.println("success");
			}catch (Exception e){
				e.printStackTrace();
			}
		}

	}
	



