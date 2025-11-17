package com.GFAssignmentProj.CustomerApp;
import java.sql.*;
import java.util.Scanner;

public class PostgresOperation {
	
 public static void createCustomerData(){
		try {
			Connection conn = TestConnection.createConnectionToPostgre();
			String CustId, CustName, CustAddress,CustInfo;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Customer Id :");	
			CustId = sc.nextLine();
			System.out.println("Enter Customer Name : ");
			CustName = sc.nextLine();
			System.out.println("Enter Customer Address : ");
			CustAddress = sc.nextLine();
			System.out.println("Enter Customer Information : ");
			CustInfo = sc.nextLine();
			PreparedStatement stat = conn.prepareStatement("INSERT INTO public.\"CustomerRec\"(\"Cust_Id\", \"Cust_Name\", \"Cust_Address\", \"Cust_Info\")VALUES (?, ?, ?, ?)");
			stat.setString(1, CustId);
			stat.setString(2, CustName);
			stat.setString(3, CustAddress);
			stat.setString(4, CustInfo);
			stat.executeUpdate();
			System.out.println("Record Created Successfully");
			sc.close();
			stat.close();
			conn.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
 public static void getCustomerData() {
	 try {
		 Connection con = TestConnection.createConnectionToPostgre();
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM public.\"CustomerRec\"\r\n");
			while(rs.next()) {
				String CustId = rs.getString("Cust_Id");
				String CustName = rs.getString("Cust_Name");
				String CustAddress = rs.getString("Cust_Address");
				String  CustInfo = rs.getString("Cust_Info");
				System.out.println("Customer Detail "+CustId+" "+CustName+" "+CustAddress+" "+CustInfo);
			}
			rs.close();
			state.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
 }
}
