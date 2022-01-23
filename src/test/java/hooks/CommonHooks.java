package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.utils.ReadProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonHooks {
	
	private ReadProperties readprop;
	private DriverFactory dfactory;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getprop() {
		readprop=new ReadProperties();
		prop=readprop.readProperties();	
	}
	
	@Before(order=1)
	public void launch() {
		dfactory = new DriverFactory();
		String browsername=prop.getProperty("browser");
		dfactory.setup(browsername );
		driver=DriverFactory.getdriver();
		
	}
	@After(order=0)
	public void teardown() {
		driver.quit();
	}
	@After(order=1)
	public void Screenshotatfailedscenario(Scenario scenario) {
		if(scenario.isFailed()) {
		String scenarioName=	scenario.getName().replaceAll(" ", "_");
		byte[] sourcepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcepath, "image/png", scenarioName);
		}
	}
}
