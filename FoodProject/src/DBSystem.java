import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBSystem {
	public static Connection conn;

	private static void setDBSystemDir() {
	    // Decide on the db system directory: <userhome>/.addressbook/
	    String userHomeDir = System.getProperty("user.currentUser", ".");
	    String systemDir = userHomeDir + "/.Food";

	    // Set the db system directory.
	    System.setProperty("derby.system.home", systemDir);
	}
	private static boolean createTables(Connection dbConnection) {
		String strCreateAddressTable = 
				"CREATE table APP.FOODITEM (" +
			    "ID          INTEGER NOT NULL " +  
			    "            PRIMARY KEY GENERATED ALWAYS AS IDENTITY " +  
			    "            (START WITH 1, INCREMENT BY 1), " + 
			    "NAME         VARCHAR(30),  " + 
			    "CATAGORY     VARCHAR(30), " + 
			    "SMALLPRICE   decimal(10,2), " + 
			    "MEDPRICE     decimal(10,2), " + 
			    "LARGEPRICE   decimal(10,2))  ";
	    boolean bCreatedTables = false;
	    Statement statement = null;
	    try {
	        statement = dbConnection.createStatement();
	        statement.execute(strCreateAddressTable);
	        bCreatedTables = true;
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    
	    return bCreatedTables;
	}
	public static int createRecord(Connection conn, FoodItem record) {
		String stmtSaveNewRecord = 
			    "INSERT INTO APP.FOODITEM " +
			    "   (NAME, CATAGORY, SMALLPRICE, " +
			    "    MEDPRICE, LARGEPRICE) " +
			    "VALUES (?, ?, ?, ?, ?)";
		
	    int id = -1;
	    try {
	    	// this is JavaDB/Derby specific, other databases may not work this way
		    PreparedStatement stmt = conn.prepareStatement(stmtSaveNewRecord, Statement.RETURN_GENERATED_KEYS);
	    	stmt.clearParameters();
	    	stmt.setString(1, record.getName());
	    	stmt.setString(2, record.getCatagory());
	    	stmt.setDouble(3, record.getSmallPrice());//.setString(3, ""+record.getSmallPrice());
	    	stmt.setDouble(4, record.getMedPrice());
	    	stmt.setDouble(5, record.getLargePrice());
	        int rowCount = stmt.executeUpdate();
	        System.out.println("rowCount = " + rowCount);
	        ResultSet results = stmt.getGeneratedKeys();
	        // this is not working as advertised, creating a record but next() is getting null 
	        while (results.next()) {
	            id = results.getInt(1);
	        }
	    } catch(SQLException sqle) {
	        sqle.printStackTrace();
	    }
	    return id;
	} 
	public static void readRecord(Connection conn) {
		String sql = "select * from APP.FOODITEM";
	    try {
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		    	int id = rs.getInt(1);
		    	String Name = rs.getString("NAME");
		    	String Catagory = rs.getString("Catagory");
		    	System.out.println(id + " " + Name + ", " + Catagory);
		    }
	    } catch(SQLException sqle) {
	        sqle.printStackTrace();
	    }
	}  
	public static FoodItem [] readFromRecord(Connection conn) {
		String sql = "select * from APP.FOODITEM";
		FoodItem [] out = new FoodItem [10];
		for (int x = 0; x < out.length;x++)
		{
			out[x] = new FoodItem(null);
		}
	    try {
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    int y = 0;
		    while (rs.next()) {
		    	int id = rs.getInt(1);
		    	if (out.length == id)
		    	{
		    		FoodItem [] outa = new FoodItem [out.length + 1];
		    		for (int x = 0; x<outa.length;x++)
		    		{
		    			if (x < out.length)
		    			{
		    			outa[x] = out[x];
		    			}
		    			else
		    			{
		    			outa[x] = new FoodItem(null);	
		    			}
		    		}
		    		out = outa;
		    	}
		    	String Name = rs.getString("NAME");
		    	String Catagory = rs.getString("CATAGORY");
		    	double SmallPrice = rs.getDouble("SMALLPRICE");
		    	double MedPrice = rs.getDouble("MEDPRICE");
		    	double LargePrice = rs.getDouble("LARGEPRICE");
		    	System.out.println(id + " " + Name + ", " + Catagory);
		    	FoodItem outitem = new FoodItem (Name, Catagory, SmallPrice, MedPrice, LargePrice);
		    	out [y] = outitem;
		    	y++;
		    }
	    } catch(SQLException sqle) {
	        sqle.printStackTrace();
	    }  
		return out;
	}  
	public static boolean editRecord(Connection conn, FoodItem record) {
		String stmtUpdateExistingRecord = 
			    "UPDATE APP.FOODITEM " +
			    "SET NAME = ?, " +
			    "    CATAGORY = ?, " +
			    "    SMALLPRICE = ?, " +
			    "    MEDPRICE = ?, " +
			    "    LARGEPRICE = ?" +
			    "WHERE id = ?";
		boolean bEdited = false;
	    try {
		    PreparedStatement stmt = conn.prepareStatement(stmtUpdateExistingRecord);
		    stmt.clearParameters();
		    stmt.setString(1, record.getName());
		    stmt.setString(2, record.getCatagory());
		    stmt.setDouble(3, record.getSmallPrice());
		    stmt.setDouble(4, record.getMedPrice());
		    stmt.setDouble(5, record.getLargePrice());;
		    stmt.executeUpdate();
	        bEdited = true;
	    } catch(SQLException sqle) {
	        sqle.printStackTrace();
	    }
	    return bEdited;   
	}  
	
	public static boolean deleteRecord(Connection conn, int id) {
	    boolean bDeleted = false;
		String delstmt = 
		        "DELETE FROM APP.FOODITEM " +
		        "WHERE ID = ?";
	    PreparedStatement stmt = null;
		try {
	    	stmt = conn.prepareStatement(delstmt);
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	        bDeleted = true;
	    } catch (SQLException sqle) {
	        sqle.printStackTrace();
	    }   
	    return bDeleted;
	}
	public static Connection innit()
	{
		conn = null;
		String strUrl = "jdbc:derby:Food;create=true;";
		try {
		    conn = DriverManager.getConnection(strUrl);
		} catch (SQLException sqle) {
		    sqle.printStackTrace();
		}
		return conn;
		}
	public static void main (String[] args) throws SQLException {
		setDBSystemDir();
		Connection conn = innit();
			// One Time
		 //boolean created = createTables(conn);
			//if (created) System.out.println("Tables created");
		    new OperatorGUI(conn);
		   
		    
		    //FoodItem fi1 = new FoodItem("Fried Chicken", "Entree", 2.00, 4.00, 6.00);
		    
		    // creating duplicates on purpose
		    //createRecord(conn,fi1);
		    //createRecord(conn,address1);
		    
		  //FoodItem fi2 = new FoodItem();
		    //createRecord(conn,address2);
		    //createRecord(conn,address2);

		    // display list of records
		    //System.out.println("Current Address List:");
		    //readRecord(conn);

		    // delete second record of each
		    //deleteRecord(conn,2);
		    //deleteRecord(conn,4);

		    // display list of records after deletes
		    //System.out.println("Current Address List:");
		    readRecord(conn);
	}
}
