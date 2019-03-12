package mgureken.runner;

import java.sql.SQLException;

import mgureken.communication.server;

public class Runner {

	public static void main(String[] args) {
		try {
			new server(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
