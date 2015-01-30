package pl.kmi.kblock.view;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow() throws HeadlessException {
        GameView gameView = new GameView();
        setContentPane(gameView);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
        gameView.run();
    }
}
