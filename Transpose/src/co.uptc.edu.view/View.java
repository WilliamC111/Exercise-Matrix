import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JButton[][] buttons;
    private JButton transposeButton;
    private Presenter presenter;

    public View(int rows, int cols, Presenter presenter) {
        this.presenter = presenter;
        buttons = new JButton[rows][cols];

        JPanel buttonPanel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton("");
                buttonPanel.add(buttons[i][j]);
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int value = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor:"));
                        presenter.setElement(row, col, value);
                    }
                });
            }
        }

        transposeButton = new JButton("Obtener Traspuesta");
        transposeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.onTransposeButtonClicked();
            }
        });

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        add(transposeButton, BorderLayout.SOUTH);

        setTitle("Matriz Numeros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public JButton[][] getButtons() {
        return buttons;
    }
}