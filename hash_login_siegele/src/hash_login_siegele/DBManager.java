package hash_login_siegele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DBManager {

	private static DBManager instance;

	private String DBuser;
	private String DBdriver;
	private String url;
	private String pwd;
	
	private DataSource dataSource = null;
	public void init(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		try {
			Class.forName(this.DBdriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/hash_login", "postgres", "noah2000");
		//Connection c = dataSource.getConnection();
		
		return c;
	}

	public static void dropConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void init(String DBdriver, String DBuser, String url, String pwd) throws ClassNotFoundException {
		this.DBdriver = DBdriver;
		this.DBuser = DBuser;
		this.url = url;
		this.pwd = pwd;

		Class.forName(this.DBdriver);
	}

	public static void addUser(Connection c, String username, String pwd)
			throws SQLException, ClassNotFoundException {
		String u = BCrypt.hashpw(pwd, BCrypt.gensalt());
		String s = "Insert into users(user_name, pwd) values(?,?)";
		PreparedStatement stm = c.prepareStatement(s);

		try {
			stm.setString(1, username);
			stm.setString(2, u);
			stm.executeUpdate();
			stm.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkUser(Connection c, String username, String password)
			throws SQLException, ClassNotFoundException {
		String sql = "Select * from users where user_name = ?";
		PreparedStatement stm = c.prepareStatement(sql);
		stm.setString(1, username);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("user_id");
			String user_name = rs.getString("user_name");
			String pwd = rs.getString("pwd");

			if (user_name.contentEquals(username) && BCrypt.checkpw(password, pwd)) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	public static void main(String[] args) throws SQLException {
		DBManager db = new DBManager();

		db = DBManager.getInstance();
		try {
			db.init("org.postgresql.Driver", "postgres", "jdbc:postgresql://127.0.0.1:5432/login_db", "noah2000");
			Connection c = db.getConnection();
			System.out.println(DBManager.checkUser(c, "noah2000", "noah1234"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
