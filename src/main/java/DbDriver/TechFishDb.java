package DbDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class TechFishDb {

//JDBC Connection Driver with MYSQL Docker URL
static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://elastic.rapidtestpro.com:2777/Vayu1";

//for php admin use the below link and the user credentials declared in USER & PASSWORD
//http://elastic.rapidtestpro.com:8065/sql.php?server=1&db=test&table=info&pos=0

static final String USER = "belitypi";
static final String PASSWORD = "47GWrkhPknA3";

public static LinkedList<String>names = new LinkedList<>();

public static LinkedList<String> getFromDB() throws ClassNotFoundException, SQLException {
Connection connection = null;
Statement statement = null;

Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);

statement = connection.createStatement();

String query = "SELECT * FROM Varun ;";

ResultSet results = statement.executeQuery(query);

while(results.next()) {

	names.add(results.getString("description"));

	System.out.print(results.getString("name")); System.out.print("    ");
	System.out.print(results.getString("description")); System.out.print("  ");
	System.out.print(results.getString("emailId")); System.out.print("  ");
	System.out.print(results.getInt("phonenumber")); System.out.print(" ");
	System.out.print(results.getInt("accnumber")); System.out.print(" ");
	System.out.println();


}

results.close();
statement.close();
connection.close();

return names;

}

public static void main(String[] args) throws ClassNotFoundException, SQLException {

LinkedList<String>gnames = new LinkedList<>();
gnames = getFromDB();

System.out.println("   ");
for(String name: gnames) {
System.out.print(name);
System.out.print(" ");
}
}

}
	
	

	
	
