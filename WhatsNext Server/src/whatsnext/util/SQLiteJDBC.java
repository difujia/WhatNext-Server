package whatsnext.util;

import java.sql.*;

import whatsnext.bean.Mission;
import whatsnext.bean.MissionConstants;

public class SQLiteJDBC implements MissionConstants {
	private static final String WEIGHT = null;
	private static final String IMAGE_LIBRARIES = null;

	public static void main(String args[]) {
		createTable();

	}

	public static void createTable() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:whatsnext.db");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE MISSION " 
	                + "(ID INT PRIMARY KEY     NOT NULL," +NAME 
	                + "           TEXT    NOT NULL, " + YEAR
	                + "           INTEGER NOT NULL, " + AGENCY
					+ "           TEXT    NOT NULL, " + LAUNCH_SITE
					+ "           TEXT    NOT NULL, " + TYPE
					+ "           TEXT    NOT NULL, " + EARTH_WEIGHT
					+ "           TEXT    NOT NULL, " + SIZE
					+ "           TEXT    NOT NULL, " + KEY_IMAGES
					+ "       	  REAL    NOT NULL, " + IMAGES					
					+ "           TEXT    NOT NULL, " + KEY_FINDINGS
					+ "           TEXT    NOT NULL, " + ENABLING_TECHNOLOGIES
					+ "           TEXT    NOT NULL, " + PROBLEMS
					+ "           TEXT    NOT NULL, " + START_DATE
					+ "      	  TEXT    NOT NULL, " + END_DATE
					+ "        	  TEXT    NOT NULL, " + SISTER_MISSIONS
					+ "           TEXT    NOT NULL, " + RELATED_MISSIONS
					+ "           TEXT    NOT NULL, " + MUSIC
					+ "           TEXT    NOT NULL, " + MORE_INFO
					+ "      	  TEXT    NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
//	public static void addMission(Mission mission){
//		Connection c = null;
//	    Statement stmt = null;
//	    try {
//	      Class.forName("org.sqlite.JDBC");
//	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
//	      c.setAutoCommit(false);
//	      System.out.println("Opened database successfully");
//
//	      stmt = c.createStatement();
////	      String sql = "INSERT INTO MISSION(ID,"+NAME+","+YEAR,AGENCY,LAUNCH_SITE,TYPE,EARTH_WEIGHT,SIZE,KEY_IMAGES,IMAGES,KEY_FINDINGS,,,) " +
////	                   "VALUES (1, 'Paul', 32, 'California', 20000.00 );"; 
//	      stmt.executeUpdate(sql);
//	      stmt.close();
//	      c.commit();
//	      c.close();
//	    } catch ( Exception e ) {
//	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//	      System.exit(0);
//	    }
//	    System.out.println("Records created successfully");
//	}
}













