package aswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AButton extends JButton {

    public AButton(String text) {
        super(text);
        setFocusPainted(false);

        addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) != 0) {
                JRootPane rootPane = SwingUtilities.getRootPane(this);
                if (rootPane != null) {
                    rootPane.addPropertyChangeListener("defaultButton", new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            updateForeground();
                        }
                    });
                    updateForeground();
                }
            }
        });

        getModel().addChangeListener(e -> updateForeground());
    }

    private void updateForeground() {
        JRootPane rootPane = SwingUtilities.getRootPane(this);
        boolean isDefault = rootPane != null && rootPane.getDefaultButton() == this;
        boolean isPressed = getModel().isArmed() && getModel().isPressed();

        if (isDefault && isPressed) {
            setForeground(Color.BLACK);
        } else if (isDefault) {
            setForeground(Color.WHITE);
        } else {
            setForeground(Color.BLACK);
        }
    }
}