package Templates;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.teqlip.database.DatabaseTemplateDataInserter;
import com.teqlip.excel.ExcelSheet;

public enum TemplateEnum {
	Client_Profile{
		public String getString() {
	        return "client profile";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con) throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertClientProfile(filename, excelSheet, con);
    }
		
	},
	Community_Connections{
		public String getString() {
	        return "community connections";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertCommunityConnections(filename, excelSheet, con);
    }
	},
	Employment{
		public String getString() {
	        return "employment";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertEmploymentTemplateData(filename, excelSheet, con);
    }
	},
	Info_And_Orien{
		public String getString() {
	        return "info&orien`";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertInfoAndOrien(filename, excelSheet, con);
    }
	},
	LT_Client_Enrol{
		public String getString() {
	        return "lt client enrol";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertLTClientEnroll(filename, excelSheet, con);
    }
	},
	LT_Client_Exit{
		public String getString() {
	        return "lt client exit";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertLTClientExit(filename, excelSheet, con);
    }
	},
	LT_Course_Setup{
		public String getString() {
	        return "lt course setup";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertLTCourseSetup(filename, excelSheet, con);
    }
	},
	Needs_Assessment_And_Referrals{
		public String getString() {
	        return "needs assessment&referrals";
	    }

    @Override
    public void insertThisSheet(String filename, ExcelSheet excelSheet, Connection con)
        throws SQLException, ParseException {
      DatabaseTemplateDataInserter.insertNeedsAssessmentReferrals(filename, excelSheet, con);
    }
	};

    public static ArrayList<TemplateEnum> enumIteration() {  
      TemplateEnum[] templateEnums = TemplateEnum.values(); 
      ArrayList<TemplateEnum> alltempEnum = new ArrayList<TemplateEnum>();
      for (TemplateEnum e : templateEnums) {
        alltempEnum.add(e);  
      }
      return alltempEnum;  
    }
	
	public abstract String getString();
	public abstract void insertThisSheet(String filename, ExcelSheet excelSheet,Connection con) throws SQLException, ParseException;

}
