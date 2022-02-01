package com.libraryApp.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryApp.entities.User;
import com.libraryApp.entities.impl.LibraryLibrarian;
import com.libraryApp.entities.impl.LibraryReader;
import com.libraryApp.entities.impl.Membership;
import com.libraryApp.services.UserManagementService;
import com.libraryApp.storage.MySQLDBUtil;

public class MySQLUserManagementService implements UserManagementService {

	private static MySQLUserManagementService instance;

	private MySQLUserManagementService() {
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new MySQLUserManagementService();
		}
		return instance;
	}
	
	@Override
	public String addUser(User user, String userType) {
		String query = "INSERT INTO user (first_name, last_name, email, password, user_type, fk_user_membership ) VALUES (?,?,?,?,?,?)";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psInsert = con.prepareStatement(query);) {
			psInsert.setString(1, user.getFirstName());
			psInsert.setString(2, user.getLastName());
			psInsert.setString(3, user.getEmail());
			psInsert.setString(4, user.getPassword());
			psInsert.setString(5, userType);
			if(userType.equals("reader")) {
			psInsert.setInt(6, user.getMembership().getId());
			}else {
				psInsert.setInt(6,4);
			}
			psInsert.executeUpdate();
			return "";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "User Could Not Be Added";
		}
	}
	
	@Override
	public User getUserById(int userId) {
		String query = "SELECT * FROM user WHERE id = ? ;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			psSelect.setInt(1, userId);
			ResultSet rs = psSelect.executeQuery();
			if(rs.next()) {
				return loadUser(rs);
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User getUserByEmail(String userEmail) {
		String query = "SELECT * FROM user WHERE email = ? ;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			psSelect.setString(1, userEmail);
			ResultSet rs = psSelect.executeQuery();
			if(rs.next()) {
				return loadUser(rs);
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private User loadUser(ResultSet rs) throws SQLException {
		List<Membership> tiers = MembershipLoadingService.getMemberships();
		User user;
		if (rs.getString("user_type").equalsIgnoreCase("reader")) {
			user = new LibraryReader();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name")); 
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email")); 
			user.setPassword(rs.getString("password"));
			user.setFine(rs.getInt("fine"));
			user.setBorrowed(rs.getInt("borrowed"));
			user.setMembership(tiers.get(rs.getInt("fk_user_membership")-1));
		} else {
			user =  new LibraryLibrarian();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("first_name")); 
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email")); 
			user.setPassword(rs.getString("password"));
		}
		return user;
	}

	@Override
	public List<User> getUserWithFine() {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM user WHERE fine <> 0;";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				users.add(loadUser(rs));
			}
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getUsers(String userType) {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM user WHERE user_type = ?";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psSelect = con.prepareStatement(query);) {
			psSelect.setString(1, userType);
			ResultSet rs = psSelect.executeQuery();
			while (rs.next()) {
				users.add(loadUser(rs));
			}
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Boolean PayFine(int userId) {
		String query = "UPDATE user SET fine = 0 WHERE id = ? ";
		try (Connection con = MySQLDBUtil.getConnection(null);
				PreparedStatement psUpdate = con.prepareStatement(query);) {
			psUpdate.setInt(1, userId);
			psUpdate.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

}
