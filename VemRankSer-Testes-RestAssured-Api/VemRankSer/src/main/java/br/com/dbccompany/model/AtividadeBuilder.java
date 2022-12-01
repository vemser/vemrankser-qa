package br.com.dbccompany.model;

import br.com.dbccompany.dto.TrilhaDTO;

import java.util.Date;
import java.util.List;

public class AtividadeBuilder {

    private String titulo;
    private String instrucoes;
    private Integer pesoAtivdade;
    private Date dataCriacao;
    private Date dataEntrega;
    private Integer idModulo;
    private List<TrilhaDTO> trilha;

    public AtividadeBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public AtividadeBuilder instrucoes(String instrucoes) {
        this.instrucoes = instrucoes;
        return this;
    }

    public AtividadeBuilder pesoAtivdade(Integer pesoAtivdade) {
        this.pesoAtivdade = pesoAtivdade;
        return this;
    }


    public AtividadeBuilder dataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public AtividadeBuilder dataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
        return this;
    }

    public AtividadeBuilder idModulo(Integer idModulo) {
        this.idModulo = idModulo;
        return this;
    }

    public AtividadeBuilder trilha(List<TrilhaDTO> trilha) {
        this.trilha = trilha;
        return this;
    }


    public Atividade build() {
        return new Atividade(titulo, instrucoes, pesoAtivdade, dataCriacao, dataEntrega, idModulo, trilha);
    }
}
