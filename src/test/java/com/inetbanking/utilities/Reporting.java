package com.inetbanking.utilities;


//Listener class used to generate Extent reports
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	

	public ExtentReports extentReports;
	 ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	
	public void onStart(ITestContext testcontext) {
	String timestamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
	String repName="Test-Report-"+timestamp+" .html";
	
	 extentReports = new ExtentReports();
	 File file=new File("report.html");
	 sparkReporter=new ExtentSparkReporter(file);
	 
	 
	 extentReports.attachReporter(sparkReporter);
     extentReports.setSystemInfo("Host name","localhost");
	extentReports.setSystemInfo("Environment","QA");
	extentReports.setSystemInfo("user","jyotsna");
	
	
	sparkReporter.config().setDocumentTitle("InetBanking Test Projet");//Title of report
	sparkReporter.config().setReportName("Functional Test Automaton Report");//name of the report
	sparkReporter.config().setTheme(Theme.DARK);
	
	
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		 
	    extentReports.createTest(tr.getName());
	    test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		 extentReports.createTest(tr.getName());
		  test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		  
		 String SreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		 
		 File f=new File(SreenshotPath);
		 
		 if(f.exists()) {
			 
			 try {
				 test.fail("Screenshot is below:" +test.addScreenCaptureFromBase64String(SreenshotPath));
				 
			 } catch(Exception e)
					 {
						 e.printStackTrace();
					 }
				 }
				 
	}
	
		

	@Override
	public void onTestSkipped(ITestResult tr) {
		extentReports.createTest(tr.getName());
	    test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extentReports.flush();
	}
	
	
}
