package com.teqlip.database;

import java.sql.*;
import java.util.ArrayList;

public class ExportData {
	
	/**
	 * Export a csv file that contain all the data of the given query.
	 * Stored in "C:\ProgramData\MySQL\MySQL Server 8.0\Data" (maybe different for different machine)
	 * @param query that to be executed
	 * @param newfilename the new file name that will be written as
	 */
	public static void exportCSV(String query, String newfilename) {
		try {
			Connection con = DatabaseDriverHelper.connectDataBase();
			newfilename = "./" + newfilename;
			String sql = query + " INTO OUTFILE '" + newfilename + "' FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			System.out.print("File has been created. ");
		} catch(Exception e){
			System.out.print(e);
		}
	}
	
	/**
	 * Export a csv file that contain all the data of the given query with corresponding headers.
	 * @param columns that corresponding to the data retrieved
	 * @param query that to be executed
	 * @param path with the new file name that will be written as
	 */
	public static void exportCSVwHeader(ArrayList columns, String query, String newfilename) {
		String header = "(SELECT ";
		try {
			Connection con = DatabaseDriverHelper.connectDataBase();
			newfilename = "./" + newfilename;
			// get header query part
			for (int i=0; i<columns.size() ;i++) {
				header += "'" + columns.get(i) + "'";
				if (i != columns.size()-1) {
					header += ", ";
				} else {
					header += ")";
				}
			}
			
			String sql = header + " UNION " + query + " INTO OUTFILE '" + newfilename + "' FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			System.out.print("File has been created.");
		} catch(Exception e){
			System.out.print(e);
		}		
	}
}
