package br.com.dbccompany.tests.atividade;

import br.com.dbccompany.client.AtividadeClient;
import br.com.dbccompany.client.ModuloClient;
import br.com.dbccompany.client.TrilhaClient;
import br.com.dbccompany.data.factory.AtividadeDataFactory;
import br.com.dbccompany.data.factory.ModuloDataFactory;
import br.com.dbccompany.data.factory.TrilhaDataFactory;
import br.com.dbccompany.dto.AtividadeDTO;
import br.com.dbccompany.dto.ModuloDTO;
import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.TrilhaDTO;
import br.com.dbccompany.model.Atividade;
import br.com.dbccompany.model.Modulo;
import br.com.dbccompany.model.Trilha;
import br.com.dbccompany.tests.base.BaseTest;
import br.com.dbccompany.utils.Utils;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtualizarTest extends BaseTest {

    AtividadeClient atividadeClient = new AtividadeClient();

    ModuloClient moduloClient = new ModuloClient();

    TrilhaClient trilhaClient = new TrilhaClient();

    @Test
    @Story("Deve retornar mensagem erro")
    public void testeDeveRetornarMensagemErroAoCadastrarAtividadeComTrilhaInexistente() {

        Modulo novoModulo = ModuloDataFactory.novoModulo();
        ModuloDTO moduloCadastrato = moduloClient.cadastrar(Utils.convertModuloToJson(novoModulo))
                .then()
                .extract().as(ModuloDTO.class);

        Atividade novaAtividade = AtividadeDataFactory.novaAtividade(moduloCadastrato.getIdModulo(), new TrilhaDTO());
        novaAtividade.setTrilha(null);

        ResponseDTO cadastroAtividade = atividadeClient.cadastrar(moduloCadastrato.getIdModulo(),
                        0, Utils.converterAtividadeToJson(novaAtividade))
                .then()
                .extract().as(ResponseDTO.class);

        Assertions.assertEquals(cadastroAtividade.getStatus(), HttpStatus.SC_BAD_REQUEST);
        Assertions.assertEquals(cadastroAtividade.getMessage(), "Trilha não encontrada.");
    }

}
