package practice.singleton;



class Singleton{
	private static Singleton instance;
	private static String dataBaseURL;
	
	private Singleton(String dbUrl){
		dataBaseURL = dbUrl;
	}
	
	public String getUrl(){
		return dataBaseURL;
	}
	public static Singleton getInstance(String dbUrl ){
		if(instance != null ){
			System.out.println("Database connection already present");
			return instance;
		}
		else{
			instance = new Singleton(dbUrl);
			System.out.println("Database Connection at "  + dataBaseURL +  " Created");
			return instance;
		}
			
	}
}

public class SingletonTest {

	public static void main(String[] args) {
		
		String dbUrl = "http://mongodn.com/user1/db1";
		Singleton s = Singleton.getInstance(dbUrl);
		
		
		System.out.println(s.getUrl());
		
		dbUrl = "http://mongodn.com/user1/db2";
		Singleton b = Singleton.getInstance(dbUrl);
		
		System.out.println(b.getUrl());
		
		// OUTPUT
		/*	Database Connection at http://mongodn.com/user1/db1 Created
			http://mongodn.com/user1/db1
			Database connection already present
			http://mongodn.com/user1/db1
		*/

	}

}
