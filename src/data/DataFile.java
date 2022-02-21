package data;

import utilities.Xls_Reader;

public class DataFile {
	Xls_Reader d = new Xls_Reader("E:\\testing\\NikulTest.xlsx");
	
	//We can save all data inside this data file and where we need it we need to create an object and call this file
	
	
	//login Page
	public String incorrectEmail = d.getCellData("Data1", "UserName", 3); 
	public String incorrectPassword = d.getCellData("Data1", "Password", 2);
	public String inValidEmail = d.getCellData("Data1", "UserName", 4);
	public String globalErr = d.getCellData("Data1", "Global Error", 2);
	public String emailSpecialCharErr =  d.getCellData("Data1", "Email Error", 5);
	public String emptyEmailErr =d.getCellData("Data1", "Email Error", 4);
	public String emptyPassErr = d.getCellData("Data1", "Password Error", 3);
	

}
