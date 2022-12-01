package br.com.dbccompany.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AtividadeDTO {

    private Integer idAtividade;
    private Integer idModulo;
    private String titulo;
    private String instrucoes;
    private Integer pesoAtividade;
    private Date dataCriacao;
    private Date dataEntrega;
    private Integer pontuacao;
    private String link;
    private Integer statusAtividade;
    private String nomeInstrutor;
    private List<TrilhaDTO> trilhas;

}
