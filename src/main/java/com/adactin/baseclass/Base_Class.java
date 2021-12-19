package com.adactin.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {

	public static WebDriver driver; // ---> null

	public static String value;

	// Browser Launch --->

	public static WebDriver get_Driver(String type) {

		if (type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Driver//chromedriver.exe");

			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();

		return driver;

	}

	// get --->

	public static void get(String url) {

		driver.get(url);

	}

	public static void get_CurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void get_Title() {

		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void get_Text(WebElement element) {

		String text = element.getText();
		System.out.println(text);

	}

	public static void get_Attribute(WebElement element, String name) {

		String attribute = element.getAttribute(name);
		System.out.println(attribute);

	}

	// Click --->

	public static void clickOnElement(WebElement element) {

		element.click();

	}

	// SendKeys --->

	public static void inputValueElement(WebElement element, String value) {

		element.sendKeys(value);

	}

	// Close and Quit --->

	public static void close() {

		driver.close();

	}

	public static void quit() {

		driver.quit();

	}

	// Navigate --->

	public static void navigate_To(String url) {

		driver.navigate().to(url);

	}

	public static void navigate_Back() {

		driver.navigate().back();

	}

	public static void navigate_Forward() {

		driver.navigate().forward();

	}

	public static void navigate_Refresh() {

		driver.navigate().refresh();

	}

	// DropDown --->

	public static void drop_Down(WebElement element, String type, String value) {

		Select s = new Select(element);

		if (type.equalsIgnoreCase("value")) {

			s.selectByValue(value);

		}

		else if (type.equalsIgnoreCase("index")) {

			s.selectByIndex(Integer.parseInt(value));

		}

		else if (type.equalsIgnoreCase("visibletext")) {

			s.selectByVisibleText(value);

		}

	}

	public static void is_Multiple(WebElement element) {

		Select s = new Select(element);

		boolean multiple = s.isMultiple();
		System.out.println(multiple);

	}

	public static void get_Options(WebElement element) {

		Select s = new Select(element);

		List<WebElement> options = s.getOptions();
		for (WebElement all : options) {
			String text = all.getText();
			System.out.println(text);
		}

	}

	public static void get_All(WebElement element) {

		Select s = new Select(element);

		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement allselected : allSelectedOptions) {
			String text = allselected.getText();
			System.out.println(text);
		}

	}

	public static void get_First(WebElement element) {

		Select s = new Select(element);

		WebElement first = s.getFirstSelectedOption();
		String text = first.getText();
		System.out.println(text);

	}

	// Alert --->

	public static void alert(WebElement element, String type) {

		Alert a = driver.switchTo().alert();

		if (type.equalsIgnoreCase("accept")) {

			a.accept();

		}

		else if (type.equalsIgnoreCase("dismiss")) {

			a.dismiss();

		}

		else if (type.equalsIgnoreCase("sendkeys")) {

			element.sendKeys(type);

		}

		else if (type.equalsIgnoreCase("text")) {

			String text = a.getText();
			System.out.println(text);
		}

	}

	// Frame --->

	public static void frame(WebElement element, String type) {

		if (type.equalsIgnoreCase("single")) {

			driver.switchTo().frame(element);
		}

	}

	public static void frames(String type) {

		if (type.equalsIgnoreCase("parent frame")) {

			driver.switchTo().parentFrame();

		}

		else if (type.equalsIgnoreCase("main page")) {

			driver.switchTo().defaultContent();

		}

	}

	// Actions --->

	public static void actions(WebElement element, String type) {

		Actions act = new Actions(driver);

		if (type.equalsIgnoreCase("click")) {

			act.click(element).build().perform();

		}

		else if (type.equalsIgnoreCase("context")) {

			act.contextClick(element).build().perform();

		}

		else if (type.equalsIgnoreCase("double")) {

			act.doubleClick(element).build().perform();

		}

		else if (type.equalsIgnoreCase("move")) {

			act.moveToElement(element).build().perform();

		}

	}

	public static void drag_Drop(WebElement source, WebElement target) {

		Actions act = new Actions(driver);

		act.dragAndDrop(source, target);

	}

	// Robot class --->

	public static void robot_Class(WebElement element, String type) throws Throwable {

		Robot r = new Robot();

		if (type.equalsIgnoreCase("up")) {

			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

		else if (type.equalsIgnoreCase("down")) {

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

		else if (type.equalsIgnoreCase("left")) {

			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

		else if (type.equalsIgnoreCase("right")) {

			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

		else if (type.equalsIgnoreCase("enter")) {

			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);

		}

	}

	// Windows Handling --->

	public static void window(String type, String type1) {

		if (type.equalsIgnoreCase("single")) {

			String windowHandle = driver.getWindowHandle();

			String title = driver.switchTo().window(windowHandle).getTitle();

			System.out.println(title);

		}

		else if (type.equalsIgnoreCase("multi")) {

			Set<String> windowHandles = driver.getWindowHandles();

			for (String str : windowHandles) {

				String title = driver.switchTo().window(str).getTitle();

				System.out.println(title);

			}

			String s = type1;

			for (String str : windowHandles) {

				if (driver.switchTo().window(str).getTitle().equals(s)) {

					break;

				}

			}

		}

	}

	// JavaScript --->

	public static void js_Click(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

	}

	public static void js_UpDown(WebElement element) throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", element);

		Thread.sleep(3000);

	}

	// Waits --->

	public static void implicit_Wait(int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void explicit_Wait(int time, WebElement element) {

		WebDriverWait expwait = new WebDriverWait(driver, time);

		expwait.until(ExpectedConditions.visibilityOf(element));

	}

	// Screenshot --->

	public static void screenshot(String type) throws Throwable {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"C:\\Users\\keerthana kumari\\eclipse-workspace\\Adactin_Cucumber\\Screenshot\\" + type + ".png");
		FileUtils.copyFile(src, dest);

		Thread.sleep(3000);

	}

	// Boolean Methods --->

	public static void is_Displayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		System.out.println(displayed);

	}

	public static void is_Selected(WebElement element) {

		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void is_Enabled(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println(enabled);
}
}