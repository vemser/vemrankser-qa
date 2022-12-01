package br.com.vemrankser.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public static final By btnDashboard =
            By.cssSelector("main > div > div > a:nth-child(1)");

    public static final By btnUsuarios =
            By.cssSelector("main > div > div > a:nth-child(2)");

    public static final By btnAlunos =
            By.cssSelector("main > div > div > a:nth-child(3)");

    public static final By btnAtividades =
            By.cssSelector("main > div > div > a:nth-child(4)");

    public static final By btnPerfil =
            By.cssSelector("main > div > div > a:nth-child(5)");

    public static final By btnConfiguracoes =
            By.cssSelector("main > div > div > a:nth-child(5)");

    public static final By btnSairDaConta =
            By.cssSelector("div > div.sc-bBABsx.eICJSS");

    public static final By msgContaCadastrada =
            By.cssSelector("#\\31  > div.Toastify__toast-body > div:nth-child(2)");



    @Step("Clicar botão dashboard.")
    public void clicarBtnDashboard() {

        click(btnDashboard);
    }

    @Step("Clicar botão usuarios.")
    public void clicarBtnUsuario() {

        click(btnUsuarios);
    }

    @Step("Clicar botão alunos.")
    public void clicarBtnAlunos() {

        click(btnAlunos);
    }

    @Step("Clicar botão atividades.")
    public void clicarBtnAtividades() {

        click(btnAtividades);
    }

    @Step("Clicar botão perfil.")
    public void clicarBtnPerfil() {

        click(btnPerfil);
    }

    @Step("Clicar botão configurações.")
    public void clicarBtnConfiguracoes() {

        click(btnConfiguracoes);
    }

    @Step("Clicar botão sair da conta.")
    public void clicarBtnSairDaConta() {

        click(btnSairDaConta);
    }

    @Step("Buscar campo toast conta cadastrada.")
    public String buscarCampoToastContaCadastrada() {

        wait.until(ExpectedConditions.visibilityOf(element(msgContaCadastrada)));
        return getText(msgContaCadastrada);
    }
}
