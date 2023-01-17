package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class tarjetaPage extends util {
    public static String nro_tarjeta;
    public static String cvv;
    public static String mes;
    public static String anio;
    @FindBy(xpath = "//*[contains(text(),'Card Number:')]") protected WebElement lblNroTarjeta;
    @FindBy(xpath = "//*[contains(text(),'CVV')]") protected WebElement lblCvvTarjeta2;
    @FindBy(xpath = "//*[contains(text(),'Exp:')]") protected WebElement lblExpTarjeta3;

    public tarjetaPage() {
        PageFactory.initElements(driver, this);
    }

    public void obtenerNroTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(lblNroTarjeta));
        String texto = lblNroTarjeta.getText();
        nro_tarjeta = texto.replace("Card Number:- ","");
        System.out.println(nro_tarjeta);
    }

    public void obtenerCvvTarjeta(){
        String texto = lblCvvTarjeta2.getText();
        cvv = texto.replace("CVV:- ","");
        System.out.println(cvv);
    }

    public void obtenerExpTarjeta(){
        String texto = lblExpTarjeta3.getText();
        String fecha[] = texto.replace("Exp:- ","").split("/");
        mes = fecha[0];
        anio = fecha[1];
        System.out.println(mes);
        System.out.println(anio);
    }
}
