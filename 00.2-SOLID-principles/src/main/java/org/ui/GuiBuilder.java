package org.ui;

import org.domain.Livro;
import org.domain.MaterialBibliotecario;
import org.domain.Revista;
import org.domain.Video;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Responsável por construir a interface gráfica.
 * Aplica SRP, mantendo a lógica de UI separada.
 * Aplica DRY ao criar painéis de forma genérica.
 */

public class GuiBuilder {

    private final AcervoService acervoService;
    private final JTextArea listagemTextArea = new JTextArea(15, 50);

    public GuiBuilder(AcervoService acervoService) {
        this.acervoService = acervoService;
    }

    public void criarEExibirGui() {
        JFrame frame = new JFrame("Controle Bibliotecário (Refatorado)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Define os formulários a serem criados
        Map<String, Class<?>> formularios = new LinkedHashMap<>();
        formularios.put("Livro", Livro.class);
        formularios.put("Revista", Revista.class);
        formularios.put("Vídeo", Video.class);

        // Cria as abas dinamicamente
        formularios.forEach((nome, tipo) -> {
            String[] campos = getCamposParaTipo(tipo);
            JPanel panel = criarPainelDeInclusao(nome, tipo, campos);
            tabbedPane.addTab("Incluir " + nome, panel);
        });

        // Aba de Listagem
        JPanel listagemPanel = new JPanel(new BorderLayout());
        listagemTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listagemTextArea);
        listagemPanel.add(scrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Listagem", listagemPanel);

        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()).equals("Listagem")) {
                listagemTextArea.setText(acervoService.getAcervoDetalhes());
            }
        });

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    /**
     * Método genérico para criar um painel de formulário. Elimina a duplicação de código.
     */
    private JPanel criarPainelDeInclusao(String nome, Class<?> tipo, String[] labels) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        List<JTextField> textFields = new ArrayList<>();

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(labels[i] + ":"), gbc);

            gbc.gridx = 1;
            JTextField textField = new JTextField(20);
            textFields.add(textField);
            panel.add(textField, gbc);
        }

        JButton incluirButton = new JButton("Incluir");
        gbc.gridx = 1;
        gbc.gridy = labels.length;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(incluirButton, gbc);

        // ActionListener genérico
        incluirButton.addActionListener(e -> {
            String[] values = textFields.stream().map(JTextField::getText).toArray(String[]::new);
            for (String value : values) {
                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Todos os campos devem ser preenchidos.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            MaterialBibliotecario item = MaterialFactory.criar(tipo, values);
            if (item != null) {
                acervoService.adicionarItem(item);
                JOptionPane.showMessageDialog(panel, nome + " incluído com sucesso!");
                textFields.forEach(tf -> tf.setText(""));
                textFields.get(0).requestFocus();
            } else {
                JOptionPane.showMessageDialog(panel, "Erro nos dados. Verifique os valores numéricos.",
                        "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    private String[] getCamposParaTipo(Class<?> tipo) {
        if (tipo == Livro.class) return new String[]{"Título", "Autor", "Ano"};
        if (tipo == Revista.class) return new String[]{"Título", "Organização", "Volume", "Número", "Ano"};
        if (tipo == Video.class) return new String[]{"Título", "Autor", "Duração (min)"};
        return new String[0];
    }
}
