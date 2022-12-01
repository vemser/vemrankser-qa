package br.com.dbccompany.client;

import br.com.dbccompany.data.changeless.ModuloData;
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
}
