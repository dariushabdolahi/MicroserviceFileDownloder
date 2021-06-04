package view;

import common.FileManager;
import controller.ServerConfigImp;

import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {
    private JButton btnStart;
    private JButton btnStop;
    private JLabel labelPath;
    private JTextField textFieldPath;
    private JLabel jLabelToken;
    private JTextField jTextFieldToken;
    private JLabel jLabelServerPort;
    private JTextField jTextFieldServerPort;
    private JLabel jLabelServerStatus;

    public AppView() {
        this.setTitle("DAL FILE SERVICE MS");
        this.setContent();
        this.setJobs();
        this.setVisible(true);
    }

    private void setContent() {
        SwingTools.getInstance().makeFrameBoundsInCenter(this, 500, 400);
        SwingTools.getInstance().resizeAble(this, false);
        SwingTools.getInstance().enableExitOnClose(this);
        this.setLayout(null);
        this.labelPath = new JLabel("PASTE YOUR FILE PATH HERE");
        this.labelPath.setBounds(110, 10, 400, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.labelPath, 16);
        SwingTools.getInstance().setForeGround(this.labelPath, Color.BLACK);
        this.textFieldPath = new JTextField();
        this.textFieldPath.setBounds(10, 60, 450, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.textFieldPath, 18);
        SwingTools.getInstance().setForeGround(this.textFieldPath, Color.BLACK);

        this.jLabelToken = new JLabel("ACCESS TOKEN");
        this.jLabelToken.setBounds(170, 100, 400, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.jLabelToken, 16);
        SwingTools.getInstance().setForeGround(this.jLabelToken, Color.BLACK);
        this.jTextFieldToken = new JTextField();
        this.jTextFieldToken.setBounds(10, 140, 450, 40);
        this.jTextFieldToken.setEnabled(true);
        SwingTools.getInstance().setTahomaBoldFont(this.jTextFieldToken, 18);
        SwingTools.getInstance().setForeGround(this.jTextFieldToken, Color.BLACK);

        this.jLabelServerPort = new JLabel("IP : PORT");
        this.jLabelServerPort.setBounds(190, 180, 400, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.jLabelServerPort, 16);
        SwingTools.getInstance().setForeGround(this.jLabelServerPort, Color.BLACK);
        this.jTextFieldServerPort = new JTextField();
        this.jTextFieldServerPort.setBounds(10, 220, 450, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.jTextFieldServerPort, 18);
        SwingTools.getInstance().setForeGround(this.jTextFieldServerPort, Color.BLACK);

        this.btnStart = new JButton("START SERVICE");
        this.btnStart.setBounds(50, 280, 180, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.btnStart, 16);
        SwingTools.getInstance().setForeGround(this.btnStart, Color.white);
        SwingTools.getInstance().setBackGround(this.btnStart, Color.GREEN);

        this.btnStop = new JButton("STOP");
        this.btnStop.setBounds(260, 280, 180, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.btnStop, 16);
        SwingTools.getInstance().setForeGround(this.btnStop, Color.white);
        SwingTools.getInstance().setBackGround(this.btnStop, Color.RED);
        btnStop.setEnabled(false);

        this.jLabelServerStatus = new JLabel("STOPPED");
        this.jLabelServerStatus.setBounds(10, 325, 400, 40);
        SwingTools.getInstance().setTahomaBoldFont(this.jLabelServerStatus, 13);
        SwingTools.getInstance().setForeGround(this.jLabelServerStatus, Color.RED);

        this.add(this.labelPath);
        this.add(this.textFieldPath);
        this.add(this.jLabelToken);
        this.add(this.jTextFieldToken);
        this.add(this.jLabelServerPort);
        this.add(this.jTextFieldServerPort);
        this.add(this.btnStart);
        this.add(this.btnStop);
        this.add(this.jLabelServerStatus);

    }

    private void setJobs() {
        this.btnStart.addActionListener((e) -> {
            FileManager.getInstance().setPath(textFieldPath.getText());
            FileManager.getInstance().setToken(jTextFieldToken.getText());
            ServerConfigImp.getInstance().start(jTextFieldServerPort.getText());
            jLabelServerStatus.setText("SERVICE IS RUNNING");
            SwingTools.getInstance().setForeGround(this.jLabelServerStatus, Color.GREEN.darker());
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
            jTextFieldToken.setEnabled(false);
            jTextFieldServerPort.setEnabled(false);
            textFieldPath.setEnabled(false);
        });
        this.btnStop.addActionListener((e) -> {
            ServerConfigImp.getInstance().stop();
            this.jLabelServerStatus.setText("STOPPED");
            SwingTools.getInstance().setForeGround(this.jLabelServerStatus, Color.RED.darker());
            this.jTextFieldToken.setEnabled(true);
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            jTextFieldToken.setEnabled(true);
            jTextFieldServerPort.setEnabled(true);
            textFieldPath.setEnabled(true);

        });
    }
}
