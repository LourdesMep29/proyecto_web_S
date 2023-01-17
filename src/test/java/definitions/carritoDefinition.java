package definitions;

import io.cucumber.java.es.*;
import pageobjects.*;

import java.io.IOException;

import static support.util.evidencias;

public class carritoDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;

    orderPage order;
    public carritoDefinition() {
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago = new pagoPage();
        order = new orderPage();
    }

    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("https://demo.guru99.com/payment-gateway/index.php");
    }

    @Cuando("se genera el numero de tarjeta")
    public void seGeneraElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerCvvTarjeta();
        tarjeta.obtenerExpTarjeta();
        evidencias();
        tarjeta.ventanaInicial();

    }

    @Y("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cantidad) throws IOException {
        carrito.seleccionarCantidad(cantidad);
        evidencias();
    }

    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @E("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() throws IOException {
        pago.escribirNroTarjeta(tarjetaPage.nro_tarjeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarAnio(tarjetaPage.anio);
        pago.escribirCvvTarjeta(tarjetaPage.cvv);
        evidencias();


    }

    @Y("paga el producto")
    public void pagaElProducto() {
        pago.scrollVertical();
        pago.clickPagar();
    }

    @Entonces("validar el mensaje {string}")
    public void validarElMensaje(String mensaje) throws IOException {
        order.validarMensaje(mensaje);
        evidencias();
        order.mostrarCodigo();
    }

    @Y("selecciona el mes {string}")
    public void seleccionaElMes(String mes) {
        pago.seleccionarMes(mes);

    }

    @Y("selecciona el año {string}")
    public void seleccionaElAño(String anio) {
        pago.seleccionarAnio(anio);
    }

    @Entonces("validar el mensaje del cuadro de dialogo {string}")
    public void validarElMensajeDelCuadroDeDialogo(String msj) {

    }
}
