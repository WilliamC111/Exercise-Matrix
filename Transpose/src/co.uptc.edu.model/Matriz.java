import java.util.ArrayList;

public class Matriz {
    private ArrayList<Integer> matrix;
    private int size;

    public Matriz(int size) {
        this.size = size;
        this.matrix = new ArrayList<>(size * size);
        for (int i = 0; i < size * size; i++) {
            matrix.add(0);
        }
    }

    public void setElement(int row, int col, int value) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
        matrix.set(row * size + col, value);
    }

    public ArrayList<Integer> getVector() {
        return matrix;
    }

    public int getSize() {
        return size;
    }
}