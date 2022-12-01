package br.com.dbccompany.model;

import br.com.dbccompany.dto.TrilhaDTO;
import org.joda.time.DateTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class ModuloBuilder {

    private String nome;
    private String dataInicio;
    private String dataFim;

    public ModuloBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ModuloBuilder dataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public ModuloBuilder dataFim(String dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public Modulo build() {
        return new Modulo(nome, dataInicio, dataFim);
    }
}
