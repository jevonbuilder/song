package test;
import java.sql.*;
import test.eightmain;
public class eight {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=QACS";
	String username = "song";
	String pwsd = "song";
	public static Connection con = null;
	PreparedStatement pst = null;
	//Statement pst = null;
	public void connection() throws Exception{
	try{
		Class.forName(driver);
		System.out.println("�������سɹ�");
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("��������ʧ��");
	}
	try{
		con = DriverManager.getConnection(url,username,pwsd);
		//this.pst = this.con.createStatement();
		
		System.out.println("link suecc");
	}catch(Exception ee){
		ee.printStackTrace();
		System.out.println("link fall");
	}
	}
	/*public void updata(int id) throws SQLException{
		
	String sql = "select * from CUSTOMER where CustomerID = 2";
	//pst.setInt(1, id);
	ResultSet rs = pst.executeQuery(sql);
	while (rs.next()){
		System.out.println("name:"+rs.getString(2));
	}
	}*/
	
	public  void updateda(Connection con,String name) throws Exception{  
		 try {  
		 CallableStatement cstmt = con.prepareCall("{call dbo.updata(?, ?)}");  
		 /*cstmt.registerOutParameter("@divid", java.sql.Types.INTEGER); */
		 cstmt.setInt(1, 1); 
		 cstmt.setString(2, name);
		// cstmt.execute();  
		//System.out.println(" name : " + cstmt.getString(2));  
		
		 String sql = "select * from CUSTOMER where CustomerID = 1" ;
		 this.pst = this.con.prepareStatement(sql);
		 /*ResultSet rs = cstmt.executeQuery();*/
		 ResultSet rs = pst.executeQuery();
		 
		while(rs.next()){
			System.out.println("id= "+rs.getString(1));
			System.out.println("firstname ="+ rs.getString(2));
			System.out.println("lastname="+rs.getString(3));
		}
		 System.out.println("�������ݳɹ�");
		 System.out.println("=========");
		 }  
		 
		 catch (Exception e){  
		 e.printStackTrace();  
	 }  
	}
	public void inserttt(Connection con,eightmain em) throws Exception{
		try{
			System.out.println("�������ݿ�ʼ");
		CallableStatement csmt = con.prepareCall("{call dbo.inserttt(?,?,?,?,?,?,?,?)}");
		csmt.setString(1, em.getFname());
		csmt.setString(2, em.getLname());
		csmt.setString(3, em.getAddress());
		csmt.setString(4, em.getCity());
		csmt.setString(5, em.getState());
		csmt.setString(6, em.getZip());
		csmt.setString(7, em.getPhone());
		csmt.setString(8, em.getEmail());
		csmt.execute();
		String sql = "select * from CUSTOMER";
		this.pst = this.con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.print(" name="+rs.getString(2).trim()+rs.getString(3).trim());
			System.out.print("    address="+rs.getString(4).trim());
			System.out.println("");
		}
		System.out.println("�������ݳɹ�");
		System.out.println("=========");
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	//��ѯָ����������
	public void sel(Connection con,eightmain em) throws Exception{
		try {
			System.out.println("��ѯָ�����ڼ�����ݿ�ʼ");
			CallableStatement csmt = con.prepareCall("{call dbo.song(?,?)}");
			csmt.setString(1, em.getBegindate());
			csmt.setString(2, em.getLastdate());
			//csmt.execute();
			ResultSet rs = csmt.executeQuery();
			while(rs.next()){
				
				System.out.print("id="+rs.getString(1).trim());
				System.out.print("  name="+rs.getString(2).trim());
				System.out.print("  phone= "+rs.getString(3).trim());
				System.out.print("  ������="+rs.getString(4).trim());
				System.out.println("");
			}
			System.out.println("��ѯָ�����ڼ����ݳɹ�");
			
		}catch (Exception e){
			
		}
	}
	
	//�ϲ�����
	public void getname(Connection con,int id) throws Exception {
		try{
		CallableStatement csmt = con.prepareCall("{call dbo.getnamee(?)}");
			csmt.setInt(1, id);
			csmt.execute();
			//ResultSet rs = csmt.executeQuery();
			String sql = "select * from CUSTOMER where CustomerID = ?";
			
			this.pst = this.con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				System.out.println("name="+rs.getString(2).trim()+","+rs.getString(3).trim());
			}
			System.out.println("�ϲ�name�ɹ�");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//����
	public void discount(Connection con,float dis,String date) throws Exception{
		try{
			CallableStatement csmt = con.prepareCall("{call dbo.discoun(?,?)}");
			csmt.setString(1,date );
			csmt.setFloat(2, dis);
			csmt.execute();
			System.out.println("�޸ļ۸�ɹ�");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
				eight ee = new eight();
				eightmain em = new eightmain();
				ee.connection();
				
				//���²���
				try{
				ee.updateda(con,"songhui");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
				//�������
				em.setter();
				try{
					ee.inserttt(con, em);
				}catch (Exception e){
					e.printStackTrace();
				}
				
				//��ѯָ�����ڲ���
				try{
					ee.sel(con, em);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//�ϲ����ֲ���
				try{
					ee.getname(con, 1);
				}catch(Exception e){
					e.printStackTrace();
				}
				
				//discount
				try{
					ee.discount(con, (float) 0.6, em.getLastdate());
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
}
