package modulos.paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProdutoPage {
    private WebDriver navegador;

    public ProdutoPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public ProdutoPage selecionarVoltagem(String voltagem){
        this.navegador.findElement(By.id("variation-label")).click();

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        this.navegador.findElement(By.xpath("//*[text()=' " + voltagem + "  ']")).click();

        return this;
    }

    public ProdutoPage adicionarNaSacola(){
        this.navegador.findElement(By.className("js-add-cart-button")).click();

        return this;
    }

}
