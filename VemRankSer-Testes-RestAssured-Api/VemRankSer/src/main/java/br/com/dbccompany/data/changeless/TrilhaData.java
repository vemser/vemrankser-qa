package br.com.dbccompany.data.changeless;

public class TrilhaData {

    public static final String ID_TRILHA = "idTrilha";
    public static final String EDICAO = "edicao";
    public static final String CADASTRO_TRILHA = String.format("/trilha");
    public static final String VINCULAR_TRILHA_AO_ALUNO = String.format("/trilha/adicionar-aluno-trilha");
    public static final String VINCULAR_TRILHA_AO_INSTRUTOR = String.format("/trilha/adicionar-instrutor-trilha");
    public static final String LISTAR_TRILHAS_COM_USUARIOS = String.format("/trilha/lista-alunos-trilha/");
    public static final String LISTAR_TRILHA_POR_NOME = String.format("/trilha/lista-trilha-nome/");
    public static final String LISTAR_RANKING_TRILHA = String.format("/trilha/lista-ranking/");
    public static final String LISTAR_TRILHA_POR_EDICAO = String.format("/trilha/find-edicao/");
    public static final String BUSCAR_ID_TRILHA = String.format("/trilha/find-id-trilha");
}
