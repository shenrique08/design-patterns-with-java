package org.application;

import org.ui.AcervoService;
import org.ui.GuiBuilder;

import javax.swing.*;

/**
 * Ponto de entrada da aplicação.
 * Responsável apenas por instanciar e coordenar as partes do sistema (SRP).
 */
public class App {

    public static void main(String[] args) {
        // Garante que a GUI seja executada na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            AcervoService acervoService = new AcervoService();
            GuiBuilder guiBuilder = new GuiBuilder(acervoService);
            guiBuilder.criarEExibirGui();
        });
    }
}