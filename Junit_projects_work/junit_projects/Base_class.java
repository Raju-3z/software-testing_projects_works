package junit_projects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
	public static WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public static void passText(String txt, WebElement element) {
		element.sendKeys(txt);
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	public static void clickBtn(WebElement element) {
	element.click();
	}
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Rakesh\\eclipse-workspace\\MAVEN_PROJECT\\Img");
		FileUtils.copyFile(image, f);
	}
	public static Actions a;
	public static void moveTheCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
	}
	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement tarWebEle) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoView(true), tarWebEle");
	}
	public static void scroll(WebElement element) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoView(false), tarWebEle");
	}
	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet(sheetName);
		Row r = mySheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int celltype = c.getCellType();

		String value = "";
		if (celltype == 1) {
			String value1 = c.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat();
			String value1 = s.format(dd);
		} 
		else {
			double numericValue = c.getNumericCellValue();
			long longValue = (long) numericValue;
			value = String.valueOf(longValue);
		}
	}
	
	
			public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\Rakesh\\eclipse-workspace\\MAVEN_PROJECT\\Excel Files\\newfile1.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet s = wb.createSheet("new2");
		Row r = s.createRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
					
	public static void createCell(int rowNum, int CellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\Rakesh\\eclipse-workspace\\MAVEN_PROJECT\\Excel Files\\newfile1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("new2");
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(CellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\Rakesh\\eclipse-workspace\\MAVEN_PROJECT\\Excel Files\\newfile1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("new2");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	public static void updateDataToParticularCell(int getTheRow, int getTheCell, String exisitingData,
			String writeNewData) throws IOException {

		File f = new File("C:\\Users\\Rakesh\\eclipse-workspace\\MAVEN_PROJECT\\Excel Files\\newfile1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("new2");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
}







