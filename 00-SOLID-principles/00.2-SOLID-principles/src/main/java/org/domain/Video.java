package org.domain;

import java.util.Objects;


public class Video implements MaterialBibliotecario {
    private String titulo;
    private String autor;
    private Integer duracao; // Duração em minutos

    public Video(String titulo, String autor, Integer duracao) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracao = duracao;
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

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(titulo, video.titulo) && Objects.equals(autor, video.autor) && Objects.equals(duracao, video.duracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, duracao);
    }

    @Override
    public String toString() {
        return "Video{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", duracao=" + duracao +
                '}';
    }

    @Override
    public String getDetalhes() {
        return String.format("Vídeo: %s\tAutor: %s\tDuração: %d min", getTitulo(), getAutor(), getDuracao());
    }
}