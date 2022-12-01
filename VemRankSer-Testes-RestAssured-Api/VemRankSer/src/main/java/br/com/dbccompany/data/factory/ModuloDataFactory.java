package br.com.dbccompany.data.factory;

import br.com.dbccompany.dto.TrilhaDTO;
import br.com.dbccompany.model.*;
import br.com.dbccompany.utils.Utils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ModuloDataFactory {

    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    static LocalDateTime future = LocalDateTime.now().plusHours(3);
    static String formatDateTimeNow = now.format(formatter);
    static String formatDateTimeFuture = future.format(formatter);

    public static Modulo novoModulo() {
        return criarModulo();
    }

    private static Modulo criarModulo() {

        Modulo modulo = new ModuloBuilder().
                nome(Utils.faker.name().firstName()).
                dataInicio(formatDateTimeNow).
                dataFim(formatDateTimeFuture).
                build();

        return modulo;
    }
}
