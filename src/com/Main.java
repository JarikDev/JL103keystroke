package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Main {
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
        jFrame.add(jPanel);
        AbstractAction myAction=new MyAction();
        AbstractAction myAction2=new MyAction2();

        JButton jButton = new JButton(myAction);
        jButton.setText("BUTTON");
        jPanel.add(jButton);
        JButton jButton2 = new JButton(myAction2);
        jButton2.setText("KNOPKA");
        jPanel.add(jButton2);

        KeyStroke keyStroke2=KeyStroke.getKeyStroke("ctrl N");
        InputMap inputMap2=jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap2.put(keyStroke2,"changeColor");
        ActionMap actionMap2=jPanel.getActionMap();
        actionMap2.put("changeColor",myAction2);

        KeyStroke keyStroke=KeyStroke.getKeyStroke("ctrl B");
        InputMap inputMap=jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke,"changeColor");
        ActionMap actionMap=jPanel.getActionMap();
        actionMap.put("changeColor",myAction);


    }

    static class MyAction extends AbstractAction {
        MyAction(){
            putValue(AbstractAction.SHORT_DESCRIPTION,"My small action");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.BLUE);
        }
    }
    static class MyAction2 extends AbstractAction {
        MyAction2(){
            putValue(AbstractAction.SHORT_DESCRIPTION,"Moja knopka");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(Color.BLACK);
        }
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 500);
        return jFrame;

    }
}