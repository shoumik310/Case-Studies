package com.libraryApp.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libraryApp.entities.impl.Membership;
import com.libraryApp.storage.MySQLDBUtil;

public class MembershipLoadingService {

	private static List<Membership> memberships = new ArrayList<Membership>();
	
	private static void loadMemberships() {
		String query = "SELECT * FROM membership";
		try(Connection conn = MySQLDBUtil.getConnection(null);PreparedStatement psSelect = conn.prepareStatement(query);){
			ResultSet rs = psSelect.executeQuery();
			while(rs.next()) {
				Membership membership = new Membership();
				membership.setId(rs.getInt("id"));
				membership.setName(rs.getString("name"));
				membership.setBorrowLimit(rs.getInt("borrow_limit"));
				membership.setDuration(rs.getString("duration"));
				membership.setPrice(rs.getBigDecimal("price"));
				memberships.add(membership);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Membership> getMemberships(){	
		if(memberships.isEmpty()) {
			loadMemberships();
		}
		return memberships;
	}
}
