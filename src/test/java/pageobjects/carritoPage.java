package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class carritoPage extends util {
    @FindBy(name = "quantity") protected WebElement cmbCantidad;
    @FindBy(xpath = "//input[@value='Buy Now']") protected WebElement btncomprar;

    public carritoPage() {
        PageFactory.initElements(driver, this);
    }

    public void seleccionarCantidad(String cantidad){
        wait.until(ExpectedConditions.visibilityOf(cmbCantidad));
        new Select(cmbCantidad).selectByVisibleText(cantidad);
        //new Select(cmbCantidad).selectByValue(cantidad);
        //new Select(cmbCantidad).selectByIndex(4);
    }

    public void clickComprar(){
        wait.until(ExpectedConditions.elementToBeClickable(btncomprar));
        btncomprar.click();
    }
}
