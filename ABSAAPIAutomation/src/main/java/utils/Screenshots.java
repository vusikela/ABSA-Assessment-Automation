package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constant.Constant;



public class Screenshots {
	
	 public  static String captureScreenShots(WebDriver driver, String screenShotName) {

	        try {

	            //below line is just to append the date format with the screenshot name to avoid duplicate names
	            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	            String destination = Constant.TAKE_SCREEN_SHOT +screenShotName+dateName+".png";
	            File finalDestination = new File(destination);
	            FileUtils.copyFile(source, finalDestination);
	            return destination;

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return "false";
	    }

}
