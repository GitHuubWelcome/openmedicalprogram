package openmrspackage;		
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;		
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.WebElement;		
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;		
		
public class OpenmrsClassProgram {		
    WebDriver driver;	
    ExtentReports extent;
    ExtentTest test;
    
    
     @BeforeTest
    public void init()
    {
        extent = new ExtentReports(System.getProperty("D:\\MavenProject")+"ExtentReportResults.html", true);
    }    
    
	@Test (priority=1,enabled=true)	
	public void LaunchBrowser() {
		test = extent.startTest("Openmrs URL Launch");
		System.setProperty("webdriver.chrome.driver","D:\\SELENIUM\\DRIVERS\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://qa-refapp.openmrs.org/openmrs/login.htm");
		test.log(LogStatus.PASS, " Browser launching Successfully ");
		
		}
		
	@Test(priority=2,enabled=true)	
	public void LoginPortal() {	
		test = extent.startTest("Login into the Portal");
		driver.findElement(By.xpath("//input[@id='username']")).click();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Outpatient Clinic']")).click();
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		String expectedUrl = "https://qa-refapp.openmrs.org/openmrs/referenceapplication/home.page";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Dashboard page redirection failed");    
		test.log(LogStatus.PASS, " Browser launching Successfully ");
	}	
		
	@Test(priority=3,enabled=true)	
	public void RegisterPatient() {	
		test = extent.startTest("Register into the Portal");
		driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();
		driver.findElement(By.xpath("//input[@name='givenName']")).click();
		
		WebElement nameElement=driver.findElement(By.xpath("//input[@name='givenName']"));
		String Name = "User2";
		nameElement.sendKeys(Name);
		String ActualName = nameElement.getAttribute("value");
		System.out.println(ActualName);
		
		
		driver.findElement(By.xpath("//input[@name='familyName']")).click();
		WebElement FamilyName=driver.findElement(By.xpath("//input[@name='familyName']"));
		String Familyname = "smith";
		FamilyName.sendKeys(Familyname);
		String ActualFamilyName = FamilyName.getAttribute("value");
		System.out.println(ActualFamilyName);
				
		driver.findElement(By.xpath("//icon[@class='fas fa-chevron-right']")).click();
		WebElement Gender=driver.findElement(By.xpath("//label[@for='gender-field']"));
		Gender.click();
		WebElement GenderClick=driver.findElement(By.xpath("//option[@value='M']"));
		GenderClick.click();
		String ActualGender=GenderClick.getAttribute("value");
		System.out.println(ActualGender);		
		
		
		driver.findElement(By.xpath("//icon[@class='fas fa-chevron-right']")).click();
		driver.findElement(By.xpath("//input[@id='birthdateDay-field']")).click();
		WebElement Birth=driver.findElement(By.xpath("//input[@id='birthdateDay-field']"));
		String Birthdate = "05";
		Birth.sendKeys(Birthdate);
		String ActualBirthdate = Birth.getAttribute("value");
		System.out.println(ActualBirthdate);			
		
	
		driver.findElement(By.xpath("//select[@id='birthdateMonth-field']")).click();
		WebElement Month=driver.findElement(By.xpath("//select[@id='birthdateMonth-field']"));
		String BirthMonth = "September";
		Month.sendKeys(BirthMonth);
		String ActualMonth = Month.getAttribute("value");
		System.out.println(ActualMonth);		
		
	
		driver.findElement(By.xpath("//input[@id='birthdateYear-field']")).click();
		WebElement BirthYear=driver.findElement(By.xpath("//input[@id='birthdateYear-field']"));
		String Year = "1995";
		BirthYear.sendKeys(Year);
		String ActualYear = BirthYear.getAttribute("value");
		System.out.println(ActualYear);		
		
		
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		driver.findElement(By.xpath("//input[@id='address1']")).click();
		WebElement Address=driver.findElement(By.xpath("//input[@id='address1']"));
		String add = "01 CityTower";
		Address.sendKeys(add);
		String ActualAdd = Address.getAttribute("value");
		System.out.println(ActualAdd);			
      
        
		WebElement Address2=driver.findElement(By.xpath("//input[@id='address2']"));
		Address2.click();		
		String add2 = "NewJerseyCity";
		Address2.sendKeys(add2);
		String ActualAdd2 = Address2.getAttribute("value");
		System.out.println(ActualAdd2);	
		
	
		WebElement CityVillage=driver.findElement(By.xpath("//input[@id='cityVillage']"));
		CityVillage.click();
		String city = "NewhamptonCity";
		CityVillage.sendKeys(city);
		String ActualCity = CityVillage.getAttribute("value");
		System.out.println(ActualCity);		
		

		WebElement state=driver.findElement(By.xpath("//input[@id='stateProvince']"));
		state.click();
		String statename = "Newyork";
		state.sendKeys(statename);
		String Actualstate = state.getAttribute("value");
		System.out.println(Actualstate);		
		
	
		WebElement country=driver.findElement(By.xpath("//input[@id='country']"));
		country.click();
		String countryname = "UnitedState";
		country.sendKeys(countryname);
		String ActualCountry = country.getAttribute("value");
		System.out.println(ActualCountry);
		

		WebElement postal=driver.findElement(By.xpath("//input[@id='postalCode']"));
		postal.click();
		String postalcode = "74523";
		postal.sendKeys(postalcode);
		String Actualpostalcode = postal.getAttribute("value");
		System.out.println(Actualpostalcode);
		

		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		WebElement phone=driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		phone.click();
		String phonenumber = "7452385250";
		phone.sendKeys(phonenumber);
		String ActualPhonenumber = phone.getAttribute("value");
		System.out.println(ActualPhonenumber);	
		
		// Define the expected values
		String expectedName = "User2";
		String expectedFamilyName = "smith";
        String expectedGender = "M";
        String expecteddate = "05";
        String expectedmonth = "9";
        String expectedYear = "1995";
        String expectedAddress = "01 CityTower";
        String expectedAddress2 = "NewJerseyCity";
        String expectedAddress3 = "NewhamptonCity";
        String expectedAddress4 = "Newyork";
        String expectedAddress5 = "UnitedState";
        String expectedZipcode = "74523";
        String expectedPhoneNumber = "7452385250";
        
     // Assert the values using assertions
        Assert.assertEquals(ActualName, expectedName, "Name is not populated correctly");
        Assert.assertEquals(ActualFamilyName, expectedFamilyName, "FamilyName is not populated correctly");
        Assert.assertEquals(ActualGender, expectedGender, "Gender is not populated correctly");
        Assert.assertEquals(ActualBirthdate, expecteddate, "Birthdate is not populated correctly");
        Assert.assertEquals(ActualMonth, expectedmonth, "BirthMonth is not populated correctly");
        Assert.assertEquals(ActualYear, expectedYear, "BirthYear is not populated correctly");
        Assert.assertEquals(ActualAdd, expectedAddress, "Address is not populated correctly");
        Assert.assertEquals(ActualAdd2, expectedAddress2, "Address2 is not populated correctly");
        Assert.assertEquals(ActualCity, expectedAddress3, "CityName is not populated correctly");
        Assert.assertEquals(Actualstate, expectedAddress4, "State is not populated correctly");
        Assert.assertEquals(ActualCountry, expectedAddress5, "Country is not populated correctly");
        Assert.assertEquals(Actualpostalcode, expectedZipcode, "Zipcode is not populated correctly");        
        Assert.assertEquals(ActualPhonenumber, expectedPhoneNumber, "Phone number is not populated correctly");
    	driver.findElement(By.xpath("//icon[@class='fas fa-chevron-right']")).click();
		driver.findElement(By.xpath("//icon[@class='fas fa-chevron-right']")).click();
		WebElement Summit=driver.findElement(By.xpath("//input[@id='submit']"));
		Summit.click();		
		test.log(LogStatus.PASS, " Browser launching Successfully ");
	}
	
	
	@Test(priority=4,enabled=true)	
	public void StartVisit() throws InterruptedException, AWTException {
		test = extent.startTest("Start Visit into the Portal");
		driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]")).click();
		driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']")).click();
		Thread.sleep(1000);
		// Upload Attachment //
		driver.findElement(By.xpath("//a[@id='attachments.attachments.visitActions.default']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Click or drop a file here.']")).click();		
		String path="C:\\Users\\Admin\\Downloads\\Test Data.pdf";
	    StringSelection s = new StringSelection(path);	
	      // Clip board copy	
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);	
	      //identify element and click	
	      Robot r = new Robot();	
	      //pressing enter	
	      r.keyPress(KeyEvent.VK_CONTROL);	
	      r.keyPress(KeyEvent.VK_V);	
	      r.keyRelease(KeyEvent.VK_V);	
	      r.keyRelease(KeyEvent.VK_CONTROL);	
	      Thread.sleep(3000);	
	      r.keyPress(KeyEvent.VK_ENTER);	
	      r.keyRelease(KeyEvent.VK_ENTER);	
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']")).click();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//textarea[@placeholder='Enter a caption']")).sendKeys("Test Data");
	      WebElement Upload= driver.findElement(By.xpath("//button[normalize-space()='Upload file']"));
	      Upload.click();
	      Thread.sleep(1000);
	      Upload.click();
	      Thread.sleep(6000);	        
	
	     driver.findElement(By.xpath("//span[@class='PersonName-givenName']")).click();
	     test.log(LogStatus.PASS, " Browser launching Successfully ");
	}
	
	@Test(priority=5,enabled=true)	
	public void EndVisit() throws InterruptedException {
		test = extent.startTest("End Visit into the Portal");
		driver.findElement(By.xpath("//ul[@class='float-left d-none d-lg-block']//div[@class='col-11 col-lg-10'][normalize-space()='End Visit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='end-visit-dialog']//button[@class='confirm right'][normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]")).click();
		driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, " Browser launching Successfully ");
	}
	@Test(priority=6,enabled=true)	
	public void CaptureVitals() throws InterruptedException {
		test = extent.startTest("CaptureVitals into the Portal");
		driver.findElement(By.xpath("//a[@id='referenceapplication.realTime.vitals']")).click();
		driver.findElement(By.xpath("//input[@id='w8']")).click();
		driver.findElement(By.xpath("//input[@id='w8']")).sendKeys("178");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		driver.findElement(By.xpath("//input[@id='w10']")).click();
		driver.findElement(By.xpath("//input[@id='w10']")).sendKeys("75");
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		driver.findElement(By.xpath("//a[@id='save-form']")).click();
		WebElement Saveform=driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		Saveform.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='End Visit']")).click();
		driver.findElement(By.xpath("//div[@id='end-visit-dialog']//button[@class='confirm right'][normalize-space()='Yes']")).click();
		Thread.sleep(1000);	
		test.log(LogStatus.PASS, " Browser launching Successfully ");
	}
	
	@Test(priority=7,enabled=true)	
	public void MergeVisits() throws InterruptedException {
		test = extent.startTest("MergeVisits into the Portal");
		driver.findElement(By.xpath("//span[@class='PersonName-givenName']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Merge Visits')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='mergeVisitsBtn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Return']")).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Browser launching Successfully ");
		
	}
	@Test(priority=8,enabled=true)	
	public void AddPastVisit() throws InterruptedException {
		test = extent.startTest("AddPastVisit into the Portal");
		driver.findElement(By.xpath("//div[contains(text(),'Add Past Visit')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr[3]/td[4]")).click();
		//driver.findElement(By.xpath("//*[@id=\"retrospectiveVisitStopDate-wrapper\"]/span/i")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"retrospective-visit-creation-dialog\"]/div[2]/button[1]")).click();	
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Browser launching Successfully ");
		
}	
	@Test(priority=9,enabled=true)	
	public void DeletePatient() throws InterruptedException {
		test = extent.startTest("DeletePatient Details into the Portal");
		driver.findElement(By.xpath("//div[contains(text(),'Delete Patient')]")).click();
		driver.findElement(By.xpath("//input[@id='delete-reason']")).click();
		driver.findElement(By.xpath("//input[@id='delete-reason']")).sendKeys("Testing Process");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='delete-patient-creation-dialog']//button[@class='confirm right'][normalize-space()='Confirm']")).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, " Browser launching Successfully ");
	}
	@Test(priority=10,enabled=true)	
	public void Search() throws InterruptedException {
		test = extent.startTest("Search Details into the Portal");
		driver.findElement(By.xpath("//input[@id='patient-search']")).click();
		driver.findElement(By.xpath("//input[@id='patient-search']")).sendKeys("100J");
		test.log(LogStatus.PASS, " Browser launching Successfully ");
	}
	


	
	@AfterMethod		
	public void getResult(ITestResult result) throws IOException {		
		if (result.getStatus() == ITestResult.SUCCESS) {	
			//String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
			test.log(LogStatus.PASS, "Test case is passed " + result.getStatus());
			
			
		} else {	
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
				test.log(LogStatus.FAIL, "Test case is failed at below location " + result.getThrowable());
				test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
	
			}}
		}	
		
			
	@AfterTest		
	public void endreport() {		
		extent.flush();	
		extent.endTest(test);	
	}
}

