package br.com.dbccompany.data.factory;

import br.com.dbccompany.dto.TrilhaDTO;
import br.com.dbccompany.model.*;
import br.com.dbccompany.utils.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AtividadeDataFactory {

    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static LocalDateTime future = LocalDateTime.now().plusHours(1);
    static String formatDateTimeNow = now.format(formatter);
    static String formatDateTimeFuture = future.format(formatter);

    public static Atividade novaAtividade(Integer idModulo, TrilhaDTO trilha) {
        return criarAtividade(idModulo, trilha);
    }

    public static Atividade novaPontuacao() {
        return criarPontuacao();
    }

    public static Atividade novoLink() {
        return criarLink();
    }

    private static Atividade criarPontuacao() {

        Atividade novaPontuacao = new AtividadeBuilder()
                .pontuacao(Utils.faker.number().numberBetween(50, 100))
                .buildPontuacao();

        return novaPontuacao;
    }

    private static Atividade criarLink() {

        Atividade novoLink = new AtividadeBuilder()
                .link(Utils.faker.internet().domainName())
                .buildLink();

        return novoLink;
    }
    private static Atividade criarAtividade(Integer idModulo, TrilhaDTO trilha) {

        Atividade novaAtividade = new AtividadeBuilder()
                .titulo(Utils.faker.company().name())
                .instrucoes(Utils.faker.industrySegments().industry())
                .pesoAtividade(Utils.faker.number().numberBetween(1, 10))
                .dataCriacao(formatDateTimeNow)
                .dataEntrega(formatDateTimeFuture)
                .trilha(List.of(trilha))
                .idModulo(idModulo)
                .build();

        return novaAtividade;
    }
}
