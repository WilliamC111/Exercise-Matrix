import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Presenter {
    private Matriz model;
    private View view;

    
    public Presenter(int size) {
        model = new Matriz(size);
        view = new View(size,this);
    }

    public void onTransposeButtonClicked() {
        ArrayList<Integer> originalVector = model.getVector();
        int size = model.getSize();
        ArrayList<Integer> transposedVector = new ArrayList<>(size * size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedVector.add(originalVector.get(j * size + i));
            }
        }

        displayTransposedMatriz(transposedVector, size);
    }

    
    private void displayTransposedMatriz(ArrayList<Integer> vector, int size) {
        JButton[][] buttons = view.getButtons();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value = vector.get(i * size + j);
                buttons[i][j].setText(Integer.toString(value));
            }
        }
    }

    public void showView() {
        view.setVisible(true);
    }

    public void setElement(int row, int col, int value) {
        model.setElement(row, col, value);
    }

    public int getModelSize() {
        return model.getSize();
    }
}