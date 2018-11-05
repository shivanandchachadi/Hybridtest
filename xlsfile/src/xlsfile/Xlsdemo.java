package xlsfile;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Xlsdemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://accounts.google.com/signin/v2/identifier?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&followup=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        File xlsfile= new File("c:\\xls\\Testdata.xls");
		
		FileInputStream infile= new FileInputStream(xlsfile);
		
	    HSSFWorkbook file2=new HSSFWorkbook(infile);	
	
		HSSFSheet sheet1=file2.getSheetAt(0);
		
		String uname=sheet1.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(uname);
		String pname=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println(uname);
		
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pname);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		
		
		
		
		
		
	}

}
