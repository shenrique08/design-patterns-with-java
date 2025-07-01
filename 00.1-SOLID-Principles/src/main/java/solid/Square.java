package solid;

public class Square implements Shape {
    private Double length;

    public Square(Double length) {
        this.length = length;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Override
    public Double area() {
        return Math.pow(length, 2);
    }
}
