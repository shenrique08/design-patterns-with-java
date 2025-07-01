package org.domain;

import java.util.Objects;

public class Revista implements MaterialBibliotecario {
    private final String titulo;
    private final String org;
    private final Integer vol;
    private final Integer nro;
    private final Integer ano;

    private Revista(Builder builder) {
        titulo = builder.titulo;
        org = builder.org;
        vol = builder.vol;
        nro = builder.nro;
        ano = builder.ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getOrg() {
        return org;
    }

    public Integer getVol() {
        return vol;
    }

    public Integer getNro() {
        return nro;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String getDetalhes() {
        return String.format("Revista: %s\tOrg: %s\tVol: %d\tNro: %d\tAno: %d",
                getTitulo(), getOrg(), getVol(), getNro(), getAno());
    }

    public static final class Builder {
        private String titulo;
        private String org;
        private Integer vol;
        private Integer nro;
        private Integer ano;

        public Builder() {
        }

        public Builder titulo(String val) {
            titulo = val;
            return this;
        }

        public Builder org(String val) {
            org = val;
            return this;
        }

        public Builder vol(Integer val) {
            vol = val;
            return this;
        }

        public Builder nro(Integer val) {
            nro = val;
            return this;
        }

        public Builder ano(Integer val) {
            ano = val;
            return this;
        }

        public Revista build() {
            return new Revista(this);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(titulo, builder.titulo) && Objects.equals(org, builder.org) && Objects.equals(ano, builder.ano);
        }

        @Override
        public int hashCode() {
            return Objects.hash(titulo, org, ano);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "titulo='" + titulo + '\'' +
                    ", org='" + org + '\'' +
                    ", vol=" + vol +
                    ", nro=" + nro +
                    ", ano=" + ano +
                    '}';
        }
    }
}