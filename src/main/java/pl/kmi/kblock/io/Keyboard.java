package pl.kmi.kblock.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Keyboard implements KeyListener {

    private ConcurrentMap<Integer, Boolean> keyState = new ConcurrentHashMap<Integer, Boolean>() {
        {
            put(KeyEvent.VK_UP, false);
            put(KeyEvent.VK_DOWN, false);
            put(KeyEvent.VK_LEFT, false);
            put(KeyEvent.VK_RIGHT, false);
        }
    };

    @Override
    public void keyTyped(KeyEvent e) {
        if (keyState.containsKey(e.getKeyCode())) {
            keyState.replace(e.getKeyCode(), true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keyState.containsKey(e.getKeyCode())) {
            keyState.replace(e.getKeyCode(), true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keyState.containsKey(e.getKeyCode())) {
            keyState.replace(e.getKeyCode(), false);
        }
    }

    public synchronized List<Map.Entry<Integer, Boolean>> getState() {
        HashMap<Integer, Boolean> tempStates = new HashMap<>();

        keyState.forEach((key, value) -> {
            int keyCode = key;
            boolean pressed = value;
            tempStates.put(keyCode, pressed);
//            System.out.println("Putting " + pressed + " for key " + keyCode);
//            keyState.replace(key, false);
        });
        keyState.forEach((key, value) -> {
            keyState.replace(key, false);
        });


        return tempStates.entrySet().stream().collect(Collectors.toList());
    }


}
