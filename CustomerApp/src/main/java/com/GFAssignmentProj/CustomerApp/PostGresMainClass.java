package com.GFAssignmentProj.CustomerApp;

public class PostGresMainClass {

	public static void main(String[] args) {
		TestConnection.createConnectionToPostgre();
		//PostgresOperation.createCustomerData();
		PostgresOperation.getCustomerData();

	}

}
