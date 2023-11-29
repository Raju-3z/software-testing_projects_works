package junit_projects;

	//import static org.junit.Assert.assertEquals;

import java.util.Date;

	import org.junit.After;
	import org.junit.AfterClass;
	//import org.junit.Assert;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Ignore;
	import org.junit.Test;

import pojo_class.Fb_pojo_way1;

	public class simple_projects extends Base_class {
		@Test
		public void tc1() {
			System.out.println("test case 1");
			launchUrl("https://www.facebook.com/login/");
			//String Title = pageTitle();
			//String Url = pageUrl();
			Fb_pojo_way1 f =new Fb_pojo_way1();
			passText("1111111111", f.getEmail());
			passText("1111111111", f.getPassword());
			//assertEquals("-------CHECK THE PAGE url-------",Url ,Url.contains("Gmail.com"));

			//Assert.assertTrue("-------CHECK THE PAGE TITLE-------", Title.contains("Gmail"));
		}
		@Before
		public void Start_Date() {
			Date d = new Date();	
			System.out.println("Start-Date & Time = "+ d);
		}
		@Test
		public void tc3() {
			launchUrl("https://www.inmakes.com");
			System.out.println("test case 3");
		}
		@BeforeClass
		public static void start() {
			launchBrowser();
			windowMaximize();
			System.out.println("Lunching Browser");
		}
		@Test
		public void tc4() {
			launchUrl("https://www.youtube.com");
			System.out.println("test case 4");
		}
		@After
		public void End_Date() {
			System.out.println("End-Date & Time = ");
		}
		@AfterClass
		public static void end() {
			closeEntireBrowser();
			System.out.println("closing browser.....");
		}
		@Ignore
		@Test
		public void tc5() {
			launchUrl("https://www.flipkart.com");
			System.out.println("test case 5");
		}
		@Test
		public void tc2() {
			launchUrl("https://aniwatch.ph");
			System.out.println("test case 2");
		}}