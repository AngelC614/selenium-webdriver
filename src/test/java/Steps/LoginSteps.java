package Steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	@Before
	public void Inicializacion() {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@After
	public void Finalizacion() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
	WebDriver driver;
	UsuarioContraseña user = new UsuarioContraseña();
	By username = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/section[2]/div/form/section[1]/div[1]/input");
	By password = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/section[2]/div/form/section[1]/div[2]/div/input");
	By ButtonComencemos = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/section[2]/div/form/section[2]/div/div/button");
	
	@Given("El usuario entra en la pagina")
	public void EntrarPagina() {
		driver.navigate().to("https://eva.idat.edu.pe/login");
	}
	@When("El (.*) ingresa su cuenta")
	public void cuentaPagina(String User) {
		driver.findElement(username).sendKeys(User);
		driver.findElement(password).sendKeys(user.getContraseña());
	}
	@And("El usuario preciona en Comencemos")
	public void precinarPagina() {
		driver.findElement(ButtonComencemos).click();
	}
	@Then("El usuario Entra en la pagina")
	public void entrarPagina() throws InterruptedException{
		Thread.sleep(4000);
		assertNotEquals(driver.getCurrentUrl(), "https://eva.idat.edu.pe/login");
	}
}
