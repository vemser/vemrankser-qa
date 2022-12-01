package br.com.vemrankser.steps;

import br.com.vemrankser.browserHandler.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseSteps extends Browser {

    @BeforeMethod
    public void abrirNavegador() {
        browserUp("https://vemrankser.vercel.app/");
    }

    @AfterMethod
    public void fecharNavegador() {
        browserDown();
    }

}