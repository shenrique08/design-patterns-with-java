package org.ui;

import org.domain.MaterialBibliotecario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Gerencia a coleção (acervo) de materiais bibliotecários.
 * Aplica o Princípio da Responsabilidade Única (SRP).
 */

public class AcervoService {

    private final List<MaterialBibliotecario> acervo = new ArrayList<>();

    public void adicionarItem(MaterialBibliotecario item) {
        if (item != null) {
            acervo.add(item);
        }
    }

    public String getAcervoDetalhes() {
        if (acervo.isEmpty()) {
            return "Nenhum item cadastrado no acervo.";
        }
        return acervo.stream()
                .map(MaterialBibliotecario::getDetalhes)
                .collect(Collectors.joining("\n"));
    }
}
