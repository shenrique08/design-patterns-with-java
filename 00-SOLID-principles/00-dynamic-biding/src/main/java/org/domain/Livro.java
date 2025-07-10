package org.domain;

import java.util.Objects;

public class Livro implements MaterialBibliotecario {
    private String titulo;
    private String autor;
    private Integer ano;

    public Livro(String titulo, String autor, Integer ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.titulo) && Objects.equals(autor, livro.autor) && Objects.equals(ano, livro.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, ano);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                '}';
    }

    @Override
    public String getDetalhes() {
        return String.format("Livro: %s\tAutor: %s\tAno: %d", getTitulo(), getAutor(), getAno());
    }
}