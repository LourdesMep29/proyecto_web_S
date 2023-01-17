package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;


public class orderPage extends util {
    @FindBy(xpath = "//*[contains(text(),'Payment successfull!')]") protected WebElement textSuccess;
    @FindBy(xpath = "//*[text()='Order ID']//following::h3/strong") protected WebElement nroOrden;

    public orderPage() {
        PageFactory.initElements(driver,this);
    }

    public void validarMensaje(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(textSuccess));
        Assert.assertEquals(mensaje,textSuccess.getText());
    }

    public void mostrarCodigo(){
        System.out.println(nroOrden.getText());
    }
}
