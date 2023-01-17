package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class pagoPage extends util {
    @FindBy(id = "card_nmuber") protected WebElement txttarjeta;
    @FindBy(id = "month") protected WebElement cmbmes;
    @FindBy(id = "year") protected WebElement cmbyear;
    @FindBy(id = "cvv_code") protected WebElement txtcvv;
    @FindBy(name = "submit") protected WebElement btnpagar;

    public pagoPage() {
        PageFactory.initElements(driver,this);
    }

    public void escribirNroTarjeta(String texto){
        wait.until(ExpectedConditions.visibilityOf(txttarjeta));
        txttarjeta.sendKeys(texto);
    }

    public void seleccionarMes(String mes){
        wait.until(ExpectedConditions.elementToBeClickable(cmbmes));
        new Select(cmbmes).selectByVisibleText(mes);
    }

    public void seleccionarAnio(String anio){
        wait.until(ExpectedConditions.elementToBeClickable(cmbyear));
        new Select(cmbyear).selectByVisibleText(anio);
    }

    public void escribirCvvTarjeta(String texto){
        txtcvv.sendKeys(texto);
    }

    public void clickPagar(){
        btnpagar.click();
    }
}
