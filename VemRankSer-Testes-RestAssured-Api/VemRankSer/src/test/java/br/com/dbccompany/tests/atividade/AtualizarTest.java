package br.com.dbccompany.tests.atividade;

import br.com.dbccompany.client.AtividadeClient;
import br.com.dbccompany.client.ModuloClient;
import br.com.dbccompany.client.TrilhaClient;
import br.com.dbccompany.data.factory.AtividadeDataFactory;
import br.com.dbccompany.data.factory.ModuloDataFactory;
import br.com.dbccompany.data.factory.TrilhaDataFactory;
import br.com.dbccompany.dto.AtividadeDTO;
import br.com.dbccompany.dto.ModuloDTO;
import br.com.dbccompany.dto.TrilhaDTO;
import br.com.dbccompany.model.Atividade;
import br.com.dbccompany.model.Modulo;
import br.com.dbccompany.model.Trilha;
import br.com.dbccompany.tests.base.BaseTest;
import br.com.dbccompany.utils.Utils;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtualizarTest extends BaseTest {

    AtividadeClient atividadeClient = new AtividadeClient();

    ModuloClient moduloClient = new ModuloClient();

    TrilhaClient trilhaClient = new TrilhaClient();

}
