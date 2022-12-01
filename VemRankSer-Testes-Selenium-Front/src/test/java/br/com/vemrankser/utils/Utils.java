package br.com.vemrankser.utils;

import br.com.vemrankser.pages.LoginPage;
import br.com.vemrankser.steps.BaseSteps;
import net.datafaker.Faker;

import java.util.Locale;

public class Utils extends BaseSteps {

    private static LoginPage loginPage = new LoginPage();

    public static Faker faker = new Faker(new Locale("pt-BR"));

    public static void logar() {

        loginPage.preencherCampoEmail(Manipulation.getProp().getProperty("prop.email"));
        loginPage.preencherCampoSenha(Manipulation.getProp().getProperty("prop.password"));
        loginPage.clicarBtnEntrar();
    }
}
