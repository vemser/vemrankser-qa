package br.com.dbccompany.client;

import br.com.dbccompany.data.changeless.ModuloData;
import br.com.dbccompany.data.changeless.TrilhaData;
import br.com.dbccompany.specs.AuthSpecs;


import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class ModuloClient {


    public Response cadastrar(String modulo) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .body(modulo)
                    .when()
                        .post(ModuloData.ADICIONAR_MODULO)
                ;
    }

    public Response vincularModuloETrilha(Integer idModulo, Integer idTrilha, String vinculacao) {

        return
                given()
                        .log().all()
                        .spec(AuthSpecs.requestSpecAdmin())
                        .pathParam(ModuloData.ID_MODULO, idModulo)
                        .pathParam(TrilhaData.ID_TRILHA, idTrilha)
                        .body(vinculacao)
                    .when()
                        .post(ModuloData.VINCULAR_MODULO_TRILHA+"{"+ModuloData.ID_MODULO+"}"+"/{"+TrilhaData.ID_TRILHA+"}")
                ;
    }
}
