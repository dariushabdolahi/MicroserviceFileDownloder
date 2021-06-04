package view;


import javax.swing.*;


public class MainView {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException var2) {
            var2.printStackTrace();
        }
        new AppView();
    }
}
