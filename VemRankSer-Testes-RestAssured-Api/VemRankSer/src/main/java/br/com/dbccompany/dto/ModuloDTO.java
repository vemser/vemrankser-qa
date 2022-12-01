package br.com.dbccompany.dto;

import br.com.dbccompany.model.Trilha;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@JsonIgnoreProperties
public class ModuloDTO {

    private String nome;
    private String dataInicio;
    private String dataFim;
    private TrilhaDTO trilhas;
    private Integer idModulo;
}
