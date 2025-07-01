package org.application;

import domain.Livro;
import domain.MaterialBibliotecario;
import domain.Revista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final List<MaterialBibliotecario> acervo = new ArrayList<>();
    private static final JTextArea listagemTextArea = new JTextArea(15, 50);

    public static void main(String[] args) {
        // Configurações da janela principal
        JFrame frame = new JFrame("Controle Bibliotecário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); // Centraliza a janela

        JTabbedPane tabbedPane = new JTabbedPane();

        // --- PAINEL DE LIVROS (com GridBagLayout) ---
        JPanel livroPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcLivro = new GridBagConstraints();
        gbcLivro.insets = new Insets(5, 5, 5, 5); // Espaçamento
        gbcLivro.fill = GridBagConstraints.HORIZONTAL;

        JTextField livroTituloField = new JTextField(20);
        JTextField autorField = new JTextField(20);
        JTextField livroAnoField = new JTextField(20);
        JButton incluirLivroButton = new JButton("Incluir");

        // Título
        gbcLivro.gridx = 0;
        gbcLivro.gridy = 0;
        livroPanel.add(new JLabel("Título:"), gbcLivro);
        gbcLivro.gridx = 1;
        livroPanel.add(livroTituloField, gbcLivro);

        // Autor
        gbcLivro.gridx = 0;
        gbcLivro.gridy = 1;
        livroPanel.add(new JLabel("Autor:"), gbcLivro);
        gbcLivro.gridx = 1;
        livroPanel.add(autorField, gbcLivro);

        // Ano
        gbcLivro.gridx = 0;
        gbcLivro.gridy = 2;
        livroPanel.add(new JLabel("Ano:"), gbcLivro);
        gbcLivro.gridx = 1;
        livroPanel.add(livroAnoField, gbcLivro);

        // Botão
        gbcLivro.gridx = 1;
        gbcLivro.gridy = 3;
        gbcLivro.anchor = GridBagConstraints.EAST; // Alinha à direita
        gbcLivro.fill = GridBagConstraints.NONE;
        livroPanel.add(incluirLivroButton, gbcLivro);


        // --- PAINEL DE REVISTAS (com GridBagLayout) ---
        JPanel revistaPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcRevista = new GridBagConstraints();
        gbcRevista.insets = new Insets(5, 5, 5, 5);
        gbcRevista.fill = GridBagConstraints.HORIZONTAL;

        JTextField revistaTituloField = new JTextField(20);
        JTextField orgField = new JTextField(20);
        JTextField volField = new JTextField(5);
        JTextField nroField = new JTextField(5);
        JTextField revistaAnoField = new JTextField(5);
        JButton incluirRevistaButton = new JButton("Incluir");

        // Título
        gbcRevista.gridx = 0;
        gbcRevista.gridy = 0;
        revistaPanel.add(new JLabel("Título:"), gbcRevista);
        gbcRevista.gridx = 1;
        gbcRevista.gridwidth = 3; // Ocupa 3 colunas
        revistaPanel.add(revistaTituloField, gbcRevista);

        // Organização
        gbcRevista.gridy = 1;
        gbcRevista.gridx = 0;
        gbcRevista.gridwidth = 1;
        revistaPanel.add(new JLabel("Org.:"), gbcRevista);
        gbcRevista.gridx = 1;
        gbcRevista.gridwidth = 3;
        revistaPanel.add(orgField, gbcRevista);

        // Vol, Nro, Ano (na mesma linha)
        gbcRevista.gridy = 2;
        gbcRevista.gridx = 0;
        gbcRevista.gridwidth = 1;
        revistaPanel.add(new JLabel("Vol.:"), gbcRevista);

        gbcRevista.gridx = 1;
        revistaPanel.add(volField, gbcRevista);

        gbcRevista.gridx = 2;
        // Adiciona um JLabel para "Nro.:"
        JPanel nroPanel = new JPanel();
        nroPanel.add(new JLabel("Nro.:"));
        nroPanel.add(nroField);
        revistaPanel.add(nroPanel, gbcRevista);

        gbcRevista.gridx = 3;
        // Adiciona um JLabel para "Ano:"
        JPanel anoPanel = new JPanel();
        anoPanel.add(new JLabel("Ano:"));
        anoPanel.add(revistaAnoField);
        revistaPanel.add(anoPanel, gbcRevista);

        // Botão
        gbcRevista.gridy = 3;
        gbcRevista.gridx = 3;
        gbcRevista.anchor = GridBagConstraints.EAST;
        gbcRevista.fill = GridBagConstraints.NONE;
        revistaPanel.add(incluirRevistaButton, gbcRevista);


        // --- PAINEL DE LISTAGEM ---
        JPanel listagemPanel = new JPanel(new BorderLayout());
        listagemTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listagemTextArea);
        listagemPanel.add(scrollPane, BorderLayout.CENTER);


        // Adiciona as abas
        tabbedPane.addTab("Incluir Livro", livroPanel);
        tabbedPane.addTab("Incluir Revista", revistaPanel);
        tabbedPane.addTab("Listagem", listagemPanel);

        // Adiciona um listener para atualizar a listagem quando a aba é selecionada
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 2) { // Índice da aba "Listagem"
                listarAcervo();
            }
        });

        frame.add(tabbedPane);
        frame.setVisible(true);

        // Ações dos botões
        incluirLivroButton.addActionListener(e -> {
            try {
                if (livroTituloField.getText().isEmpty() || autorField.getText().isEmpty() || livroAnoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String titulo = livroTituloField.getText();
                String autor = autorField.getText();
                int ano = Integer.parseInt(livroAnoField.getText());
                acervo.add(new Livro(titulo, autor, ano));
                JOptionPane.showMessageDialog(frame, "Livro incluído com sucesso!");
                livroTituloField.setText("");
                autorField.setText("");
                livroAnoField.setText("");
                livroTituloField.requestFocus();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um ano válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });

        incluirRevistaButton.addActionListener(e -> {
            try {
                if (revistaTituloField.getText().isEmpty() || orgField.getText().isEmpty() || volField.getText().isEmpty() || nroField.getText().isEmpty() || revistaAnoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Revista revista = new Revista.Builder()
                        .titulo(revistaTituloField.getText())
                        .org(orgField.getText())
                        .vol(Integer.parseInt(volField.getText()))
                        .nro(Integer.parseInt(nroField.getText()))
                        .ano(Integer.parseInt(revistaAnoField.getText()))
                        .build();
                acervo.add(revista);
                JOptionPane.showMessageDialog(frame, "Revista incluída com sucesso!");
                revistaTituloField.setText("");
                orgField.setText("");
                volField.setText("");
                nroField.setText("");
                revistaAnoField.setText("");
                revistaTituloField.requestFocus();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos para Vol., Nro. e Ano.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private static void listarAcervo() {
        StringBuilder sb = new StringBuilder();
        if (acervo.isEmpty()) {
            sb.append("Nenhum item cadastrado no acervo.");
        } else {
            for (MaterialBibliotecario item : acervo) {
                sb.append(item.getDetalhes()).append("\n");
            }
        }
        listagemTextArea.setText(sb.toString());
    }
}