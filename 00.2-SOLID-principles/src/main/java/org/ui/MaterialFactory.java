package org.ui;

import lombok.extern.log4j.Log4j2;
import org.domain.Livro;
import org.domain.MaterialBibliotecario;
import org.domain.Revista;
import org.domain.Video;

/**
 * Fábrica para criar instâncias de MaterialBibliotecario.
 * Ajuda a desacoplar a UI da criação de objetos de domínio (DIP)
 * e facilita a adição de novos tipos (OCP).
 */

@Log4j2
public class MaterialFactory {

    public static MaterialBibliotecario criar(Class<?> tipo, String... values) {
        try {
            if (tipo == Livro.class)
                return new Livro(values[0], values[1], Integer.parseInt(values[2]));

            if (tipo == Revista.class) {
                return new Revista.Builder()
                        .titulo(values[0])
                        .org(values[1])
                        .vol(Integer.parseInt(values[2]))
                        .nro(Integer.parseInt(values[3]))
                        .ano(Integer.parseInt(values[4]))
                        .build();
            }
            if (tipo == Video.class)
                return new Video(values[0], values[1], Integer.parseInt(values[2]));

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            log.error("Erro ao criar material", e);
            return null;
        }
        throw new IllegalArgumentException("Tipo de material desconhecido: " + tipo.getName());
    }
}
