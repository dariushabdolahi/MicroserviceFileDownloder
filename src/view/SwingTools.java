package view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingTools {
    private static final SwingTools swingTools = new SwingTools();

    private SwingTools() {
    }

    public static SwingTools getInstance() {
        return swingTools;
    }

    public void enableExitOnClose(JFrame frame) {
        frame.setDefaultCloseOperation(3);
    }

    public void makeFrameBoundsInCenter(JFrame frame, int width, int height) {
        int h = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int w = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        frame.setBounds(w / 2 - width / 2, h / 2 - height / 2, width, height);
    }

    public void setTahomaPlainFont(JComponent component, int size) {
        component.setFont(new Font("Tahoma", 0, size));
    }

    public void setTahomaBoldFont(JComponent component, int size) {
        component.setFont(new Font("Tahoma", 1, size));
    }

    public void setBackGround(Component component, Color color) {
        component.setBackground(color);
    }

    public void setForeGround(Component component, Color color) {
        component.setForeground(color);
    }

    public void resizeAble(JFrame jFrame, boolean status) {
        jFrame.setResizable(status);
    }

    public ImageIcon setIcon(String src, Object component) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(src);
        ImageIcon icon = new ImageIcon(resource);
        if (component instanceof JButton) {
            ((JButton) component).setIcon(icon);
            ((JButton) component).setOpaque(true);
            ((JButton) component).setFocusPainted(true);
            ((JButton) component).setBorderPainted(false);
            ((JButton) component).setContentAreaFilled(false);
        }

        return icon;
    }
}
