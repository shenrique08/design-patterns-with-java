package domain;

public class Pizza {
    private String size;
    private boolean cheese;
    private boolean peperoni;

    private Pizza(Builder builder) {
        size = builder.size;
        cheese = builder.cheese;
        peperoni = builder.peperoni;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", cheese=" + cheese +
                ", peperoni=" + peperoni +
                '}';
    }

    public static final class Builder {
        private String size;
        private boolean cheese;
        private boolean peperoni;

        public Builder() {
        }

        public Builder size(String val) {
            size = val;
            return this;
        }

        public Builder cheese(boolean val) {
            cheese = val;
            return this;
        }

        public Builder peperoni(boolean val) {
            peperoni = val;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
