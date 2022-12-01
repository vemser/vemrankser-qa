package br.com.vemrankser.steps;

import br.com.vemrankser.pages.UsuarioPage;
import br.com.vemrankser.pages.DashboardPage;
import br.com.vemrankser.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsuarioSteps extends BaseSteps {

    UsuarioPage usuarioPage = new UsuarioPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Test
    @Feature("Cadastro Usuario")
    @Story("Deve criar usuario com sucesso.")
    public void testeDeveCadastrarUsuarioCompletoTipoGestaoComSucesso() {

        Utils.logar();

        dashboardPage.clicarBtnUsuario();

        usuarioPage.clicarBtnCadastrarUsuario();
        usuarioPage.preencherCampoNome(Utils.faker.name().firstName());
        usuarioPage.preencherCampoLogin(Utils.faker.name().firstName()+"."+Utils.faker
                .name().lastName());
        usuarioPage.preencherCampoEmail(Utils.faker.internet().emailAddress());
        usuarioPage.preencherCampoSenha(Utils.faker.internet().password());
        usuarioPage.preencherCampoCidade(Utils.faker.address().cityName());
        usuarioPage.selecionarPerfilGestao();
        usuarioPage.preencherCampoEspecialidade("Gestão de Pessoas");
        usuarioPage.clicarBtnAdicionar();

        Assert.assertEquals(dashboardPage.buscarCampoToastContaCadastrada(), "Pessoa cadastrada com sucesso!");
    }

//    @Test
//    @Feature("Cadastro Usuario")
//    @Story("Deve criar usuario com sucesso.")
//    public void testeDeveCadastrarUsuarioCompletoTipoGestaoComSucesso() {
//
//        Utils.logar();
//
//        dashboardPage.clicarBtnUsuario();
//
//        usuarioPage.clicarBtnCadastrarUsuario();
//        usuarioPage.preencherCampoNome(Utils.faker.name().firstName());
//        usuarioPage.preencherCampoLogin(Utils.faker.name().firstName()+"."+Utils.faker
//                .name().lastName());
//        usuarioPage.preencherCampoEmail(Utils.faker.internet().emailAddress());
//        usuarioPage.preencherCampoSenha(Utils.faker.internet().password());
//        usuarioPage.preencherCampoCidade(Utils.faker.address().cityName());
//        usuarioPage.selecionarPerfilGestao();
//        usuarioPage.preencherCampoEspecialidade("Gestão de Pessoas");
//        usuarioPage.clicarBtnAdicionar();
//
//        Assert.assertEquals(dashboardPage.buscarCampoToastContaCadastrada(), "Pessoa cadastrada com sucesso!");
//    }
}
