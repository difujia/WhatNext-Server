package whatsnext.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import whatsnext.bean.Mission;
import whatsnext.bean.MissionConstants;

public class MissionDao implements MissionConstants {

	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private static Gson gson = new GsonBuilder().setPrettyPrinting()
			.setDateFormat("yyyy-MM-dd").create();
	private static final String SEPERATOR="\\|\\|\\|";
	public static void main(String args[]) {
		// createTable();
//		Mission m = new Mission();
//		m.setId(0);
//		m.setValue(NAME, "test1");
//		m.setValue(YEAR, "1991");
//		m.setValue(AGENCY, "test1");
//		m.setValue(LAUNCH_SITE, "test1");
//		m.setValue(TYPE, "test1");
//		m.setValue(EARTH_WEIGHT, "test1");
//		m.setValue(SIZE, "test1");
//		m.setValue(KEY_IMAGES, "test1");
//		m.setValue(IMAGES, "test1");
//		m.setValue(KEY_FINDINGS, "test1");
//		m.setValue(ENABLING_TECHNOLOGIES, "test1");
//		m.setValue(PROBLEMS, "test1");
//		m.setValue(START_DATE, "test1");
//		m.setValue(END_DATE, "test1");
//		m.setValue(SISTER_MISSIONS, "test1");
//		m.setValue(RELATED_MISSIONS, "test1");
//		m.setValue(MUSIC, "test1");
//		m.setValue(MORE_INFO, "test1");
//		// System.out.println(m.getValue(NAME));
//		addMission(m);
		System.out.println(getAllMissionsAsJson());
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
					+ "(ID INT PRIMARY KEY     NOT NULL,"
					+ NAME
					+ "           TEXT    NOT NULL, "
					+ YEAR
					+ "           TEXT , "
					+ AGENCY
					+ "           TEXT    , "
					+ LAUNCH_SITE
					+ "           TEXT    , "
					+ TYPE
					+ "           TEXT    , "
					+ EARTH_WEIGHT
					+ "           TEXT    , "
					+ SIZE
					+ "           TEXT    , "
					+ KEY_IMAGES
					+ "       	  TEXT    , "
					+ IMAGES
					+ "           TEXT    , "
					+ KEY_FINDINGS
					+ "           TEXT    , "
					+ ENABLING_TECHNOLOGIES
					+ "           TEXT    , "
					+ PROBLEMS
					+ "           TEXT    , "
					+ START_DATE
					+ "      	  TEXT    , "
					+ END_DATE
					+ "        	  TEXT    , "
					+ SISTER_MISSIONS
					+ "           TEXT    , "
					+ RELATED_MISSIONS
					+ "           TEXT    , "
					+ MUSIC
					+ "           TEXT    , "
					+ MORE_INFO + "      	  TEXT    )";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	public static void addMission(Mission mission) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:whatsnext.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			// String sql = "INSERT INTO MISSION "+"VALUES("
			// + mission.getId()+",'"
			// + mission.getValue(NAME) + "','"
			// + mission.getValue(YEAR)+ "',"
			// + mission.getValue(AGENCY) + ","
			// + mission.getValue(LAUNCH_SITE) + ","
			// + mission.getValue(TYPE) + ","
			// + mission.getValue(EARTH_WEIGHT) + ","
			// + mission.getValue(SIZE) + ","
			// + mission.getValue(KEY_IMAGES) + ","
			// + mission.getValue(IMAGES) + ","
			// + mission.getValue(KEY_FINDINGS)+ ","
			// + mission.getValue(ENABLING_TECHNOLOGIES) + ","
			// + mission.getValue(PROBLEMS) + ","
			// + mission.getValue(START_DATE)+ ","
			// + mission.getValue(END_DATE) + ","
			// + mission.getValue(SISTER_MISSIONS) + ","
			// + mission.getValue(RELATED_MISSIONS)+ ","
			// + mission.getValue(MUSIC) + ","
			// + mission.getValue(MORE_INFO)+");";

			// String
			// sql="INSERT INTO MISSION VALUES(0,\"a\",1991,\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\",\"a\")";
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MISSION VALUES(");
			sb.append(mission.getId());
			for (String key : mission.getKeys()) {
				sb.append(",\"");
				sb.append((String) mission.getValue(key));
				sb.append("\"");
			}
			sb.append(")");
			stmt.execute(sb.toString());
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

	public static List<Mission> getAllMissionList() {
		List<Mission> list = new ArrayList<Mission>();
		Connection c = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:whatsnext.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			String sql = "select * from MISSION order by id";
			pstmt = c.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Mission mission = null;
			while (rs.next()) {
				int i = 1;
				mission = new Mission();
				mission.setId(rs.getInt(i++));
				mission.setValue(NAME, rs.getString(i++));
				mission.setValue(YEAR, rs.getString(i++));
				mission.setValue(AGENCY, rs.getString(i++));
				mission.setValue(LAUNCH_SITE, rs.getString(i++));
				mission.setValue(TYPE, rs.getString(i++));
				mission.setValue(EARTH_WEIGHT, rs.getString(i++));
				mission.setValue(SIZE, rs.getString(i++));
				mission.setValue(KEY_IMAGES, rs.getString(i++).split(SEPERATOR));
				mission.setValue(IMAGES, rs.getString(i++).split(SEPERATOR));
				mission.setValue(KEY_FINDINGS, rs.getString(i++).split(SEPERATOR));
				mission.setValue(ENABLING_TECHNOLOGIES, rs.getString(i++).split(SEPERATOR));
				mission.setValue(PROBLEMS, rs.getString(i++).split(SEPERATOR));
				mission.setValue(START_DATE, rs.getString(i++));
				mission.setValue(END_DATE, rs.getString(i++));
				mission.setValue(SISTER_MISSIONS, rs.getString(i++).split(SEPERATOR));
				mission.setValue(RELATED_MISSIONS, rs.getString(i++).split(SEPERATOR));
				mission.setValue(MUSIC, rs.getString(i++));
				mission.setValue(MORE_INFO, rs.getString(i++));
				list.add(mission);
			}
			pstmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {

		}
		System.out.println("Records created successfully");
		return list;
	}

	public static String getAllMissionsAsJson() {
		List<Mission> allMissions = getAllMissionList();
		List<Map<String, Object>> infoList = new ArrayList<>();
		for (Mission m : allMissions) {
			infoList.add(m.getInfo());
		}
		return gson.toJson(infoList);
	}
}
