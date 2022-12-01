package br.com.vemrankser.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UsuarioPage extends BasePage{

    private static final By inputNome =
            By.id("nome");

    private static final By inputLogin =
            By.id("login");

    private static final By inputEmail =
            By.id("email");

    private static final By inputSenha =
            By.id("senha");

    private static final By inputCidade =
            By.id("cidade");

    private static final By btnTipoPerfil =
            By.id("tipoPerfil");

    private static final By btnGestaoPessoa =
            By.cssSelector("#menu-tipoPerfil > div > ul > li:nth-child(1)");

    private static final By btnCoordenador =
            By.cssSelector("#menu-tipoPerfil > div > ul > li:nth-child(2)");

    private static final By btnInstrutor =
            By.cssSelector("#menu-tipoPerfil > div > ul > li:nth-child(3)");

    private static final By btnAluno =
            By.cssSelector("#menu-tipoPerfil > div > ul > li:nth-child(4)");

    private static final By inputEspecialidade =
            By.id("especialidade");

    private static final By btnCadastraUsuario =
            By.id("botao-adiciona-usuario");

    private static final By btnAdicionarUsuario =
            By.id("button-adiciona-usuario");

    private static final By btnCancelar =
            By.id("button-cancela-usuario");


    @Step("Preencher campo nome.")
    public String preencherCampoNome(String input) {

        sendKeys(inputNome, input);
        return input;
    }

    @Step("Preencher campo login.")
    public String preencherCampoLogin(String input) {

        sendKeys(inputLogin, input);
        return input;
    }

    @Step("Preencher campo email.")
    public String preencherCampoEmail(String input) {

        sendKeys(inputEmail, input);
        return input;
    }

    @Step("Preencher campo senha.")
    public String preencherCampoSenha(String input) {

        sendKeys(inputSenha, input);
        return input;
    }

    @Step("Preencher campo cidade.")
    public String preencherCampoCidade(String input) {

        sendKeys(inputCidade, input);
        return input;
    }

    @Step("Preencher campo especialidade.")
    public String preencherCampoEspecialidade(String input) {

        sendKeys(inputEspecialidade, input);
        return input;
    }

    @Step("Selecionar tipo de perfil Gestao.")
    public void selecionarPerfilGestao() {

        click(btnTipoPerfil);
        click(btnGestaoPessoa);
    }

    @Step("Selecionar tipo de perfil Coordenador.")
    public void selecionarPerfilCoordenador() {

        click(btnTipoPerfil);
        click(btnCoordenador);
    }

    @Step("Selecionar tipo de perfil Instrutor.")
    public void selecionarPerfilInstrutor() {

        click(btnTipoPerfil);
        click(btnInstrutor);
    }

    @Step("Selecionar tipo de perfil Aluno.")
    public void selecionarPerfilAluno() {

        click(btnTipoPerfil);
        click(btnAluno);
    }

    @Step("Clicar botao cadastrar usuario.")
    public void clicarBtnCadastrarUsuario() {

        click(btnCadastraUsuario);
    }

    @Step("Clicar botao adicionar usuario.")
    public void clicarBtnAdicionar() {

        click(btnAdicionarUsuario);
    }

    @Step("Clicar botao cancelar.")
    public void clicarBtnCancelar() {

        click(btnCancelar);
    }
}
