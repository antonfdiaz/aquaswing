package aswing;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class AFrame extends JFrame {

    public AFrame(String title) {
        super(title);

        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.application.appearance", "system");

        //use san francisco font
        FontUIResource font = new FontUIResource("SF Pro Display", Font.PLAIN, 14);
        Enumeration<Object> keys = UIManager.getDefaults().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key,font);
            }
        }
    }
}