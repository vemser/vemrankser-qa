package br.com.dbccompany.tests.modulo;

import br.com.dbccompany.client.ModuloClient;
import br.com.dbccompany.data.factory.ModuloDataFactory;
import br.com.dbccompany.data.factory.TrilhaDataFactory;
import br.com.dbccompany.dto.ModuloDTO;
import br.com.dbccompany.model.Modulo;
import br.com.dbccompany.model.Trilha;
import br.com.dbccompany.tests.base.BaseTest;
import br.com.dbccompany.utils.Utils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Cadastro Tests")
@Feature("Modulo")
@DisplayName("Cadastro Modulo")
public class CadastrarTest extends BaseTest {

    ModuloClient moduloClient = new ModuloClient();


    @Test
    @Story("Deve cadastrar com sucesso")
    public void testeDeveCadastrarModuloComSucesso() {

        Modulo novoModulo = ModuloDataFactory.novoModulo();

        ModuloDTO moduloCadastrado = moduloClient.cadastrar(Utils.convertModuloToJson(novoModulo))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().all()
                .extract().as(ModuloDTO.class)
        ;

        Assertions.assertEquals(moduloCadastrado.getNome(), novoModulo.getNome());
        Assertions.assertEquals(moduloCadastrado.getDataInicio(), novoModulo.getDataInicio());
        Assertions.assertEquals(moduloCadastrado.getDataFim(), novoModulo.getDataFim());
    }
}
