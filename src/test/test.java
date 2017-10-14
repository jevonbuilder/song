package test;

public class test {
	public static final String DBDRIVER = "com.mysql.Dirver";
	public static void main(String[] args){
		try{
			Class.forName(DBDRIVER);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
