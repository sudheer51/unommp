package org.iitwforce.healthcare.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppLibrary {
	public static String getfutureDate(int noofDays,String format)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String expected = sdf.format(d);
		return expected;
//		String dateArr[] = expected.split("/");
//		System.out.println(dateArr);
//		System.out.println(dateArr[0]);
//		System.out.println(dateArr[1]);
//		System.out.println(dateArr[2]);
//		return dateArr.toString();
	}
	public static void main(String[] args) throws IOException {
		 String result[][] = readXLSX("config//data.xlsx");
	}
	public static String randomString()
	{
			String str="";
			Random rand = new Random();
			int value = 65+rand.nextInt(26);//uppercase
			char upperCaseCh = (char)value;
			value = 97+rand.nextInt(26);//lowercase
			char lowerCaseCh = (char)value;
			return str+upperCaseCh+lowerCaseCh;
	}
	
	public static String randomInteger() {
		Random rand = new Random();
		String str = "";
		int value = 48+rand.nextInt(2);
		char digit1 = (char)value;
			
		value = 48+rand.nextInt(10);
		char digit2 = (char)value;
		
		return str+digit1+digit2;
	}	
	
	public static String[][] readXLSX(String fileName) throws IOException
	{
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("data");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of rows" + rows);
		System.out.println("number of cols" + cols);
		String inputData[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				 XSSFCell cell = sheet.getRow(i).getCell(j);
				 inputData[i][j]= cell.getStringCellValue();
				 System.out.print(inputData[i][j]);
			}
			 System.out.println();
		}
		return inputData;
		
	}
	public static String[][] getDBValues(String uname,String pword,String dbname,String hostip) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	//	Driver driver = new Driver();
		/*
		 * url a database url of the form jdbc:subprotocol:subnameuser 
		 * the database user on whose behalf the connection is being madepassword 
		 * the user's password
		 */
		String url="jdbc:mysql://localhost:3306/"+dbname;
		String username="root";
		String password="root";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
											 ResultSet.CONCUR_READ_ONLY);
		//int  value = stmt.executeUpdate("INSERT INTO `mmp`.`patient_data` VALUES (11,'James','22/11/2021');");
		//System.out.println("The rows are updated "+ value);
		
		ResultSet rs =  stmt.executeQuery("Select * from mmp.patient_data");
		rs.last();
		
		int rows = rs.getRow();
		System.out.println("Number of rows " + rows);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		System.out.println("Number of cols: "+ cols);
		
		String data[][]= new String[rows][cols];
		
		int i=0;
		rs.first();
		while(rs.next())
		{
			for(int j=0;j<cols;j++)
			{
				data[i][j]=rs.getString(j+1);
				System.out.println(data[i][j]);
				System.out.println("i :::"  + i +"@@@@"+"j:::::" + j);
			}
			i++;
		}	
		return data;
	}
	
	 
	
	
	

}
