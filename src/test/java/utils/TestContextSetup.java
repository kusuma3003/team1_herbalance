package utils;


import driverfactory.DriverFactory;
import pageobjects.PageObjectManager;


public class TestContextSetup  {
	
	private DriverFactory driverFactory;
	private PageObjectManager pageobjectmanager; 
    private Excel_Reader excelreader;
    
	public TestContextSetup()
	{
		driverFactory = new DriverFactory();
		pageobjectmanager = new PageObjectManager(DriverFactory.Driver());
		excelreader = new Excel_Reader();
		
	}
	
	public DriverFactory getdriverFactory() {
		return driverFactory;
	}
	
	public PageObjectManager getpageobjectmanager() {
		return pageobjectmanager;
	}
	
	public Excel_Reader getexcelreader() {
	return excelreader;
	}
	

	
}