package pl.kmi.kblock.view;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow(String name, Component parent) throws HeadlessException {
        super(name);
        setupWindow(parent);
        setVisible(true);
    }

    private void setupWindow(Component parent) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(parent, BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }

}
