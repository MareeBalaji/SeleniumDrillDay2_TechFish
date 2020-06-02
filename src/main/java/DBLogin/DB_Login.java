package DBLogin;

	import java.sql.Connection;
	import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

	public class DB_Login {
		
		//JDBC Connection Driver with MYSQL Docker URL
		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";

		//for php admin use the below link and the user credentials declared in USER & PASSWORD
		//http://elastic.rapidtestpro.com:8065/sql.php?server=1&db=test&table=info&pos=0

		static final String USER = "belitypi";
		static final String PASSWORD = "47GWrkhPknA3";
		private static final String By = null;
		public static String baseurl = "http://demo.guru99.com/test/newtours/register.php";
		public static String user_name, pswd;
		
		public static LinkedList<String>names = new LinkedList<String>();
		
		public static LinkedList<String> getFromDB() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Statement statement = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);

		statement = connection.createStatement();

		String query = "SELECT * FROM Suresh ;";

		ResultSet results = statement.executeQuery(query);

		while(results.next()) {

		user_name = results.getString("UserName");
		pswd = results.getString("Password");
		
		names.add(results.getString("Results"));
		
		System.out.println(results.getString("UserName"));System.out.println("   ");
		System.out.println(results.getString("Password"));System.out.println("   ");
		System.out.println(results.getString("Result"));System.out.println("   ");
		System.out.println();
		WebDriver driver;
		WebDriverManager.chromedriver().step();
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php\");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name'UserName']")).sendkeys(result.getString("SureshS"));
		driver.findElement(By.xpath("//input[@name'UserName']")).sendkeys(result.getString("SSuresh"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		try
		{
		    String msg=driver.findElement(By.xpath("//div@class='container-lg px-2]")).getText();
		    String Expectedmsg="Incorrect username or password";
		    
		
		Link_Login(user_name,pswd);
		String query1 = "UPDATE Login SET result = 'Pass' where UserName='SureshS':";
		PreparedStatement preparedstmt = connection.prepareStatement(query1);
		preparedstmt.executeUpdate();
		//preparedstmt.set
		
		results.close();
		statement.close();
		connection.close();
		
		return names;
		
		}

		private static void Link_Login(String user_name2, String pswd2) {
			// TODO Auto-generated method stub
			
		}

		public static void main(String[] args) throws ClassNotFoundException, SQLException {

		LinkedList<String>gnames = new LinkedList<String>();
		gnames = getFromDB();

		System.out.println("   ");
		for(String name: gnames) {
		System.out.print(name);
		System.out.print(" ");
		}
		}

		}





