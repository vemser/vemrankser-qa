package br.com.dbccompany.model;

import br.com.dbccompany.dto.TrilhaDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Atividade {

    private String titulo;
    private String instrucoes;
    private Integer pesoAtivdade;
    private Date dataCriacao;
    private Date dataEntrega;
    private Integer idModulo;
    private List<TrilhaDTO> trilha;

    public Atividade(String titulo, String instrucoes, Integer pesoAtivdade, Date dataCriacao, Date dataEntrega, Integer idModulo, List<TrilhaDTO> trilha) {
        this.titulo = titulo;
        this.instrucoes = instrucoes;
        this.pesoAtivdade = pesoAtivdade;
        this.dataCriacao = dataCriacao;
        this.dataEntrega = dataEntrega;
        this.idModulo = idModulo;
        this.trilha = trilha;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "titulo='" + titulo + '\'' +
                ", instrucoes='" + instrucoes + '\'' +
                ", pesoAtivdade=" + pesoAtivdade +
                ", dataCriacao=" + dataCriacao +
                ", dataEntrega=" + dataEntrega +
                ", idModulo=" + idModulo +
                ", trilha=" + trilha +
                '}';
    }
}
