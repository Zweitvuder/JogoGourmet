package com.harley.gourmet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JogoGourmet extends JFrame {
    public static JogoGourmet INSTANCE;
    private Node rootNode;

    public static void main(String[] args) {
        (INSTANCE = new JogoGourmet()).createGame();
    }

    public JogoGourmet() {
        super("Jogo Gourmet");
    }

    public void createGame() {
        FinalNode lasagnaNode = new FinalNode();
        lasagnaNode.setQuestion("O prato que você pensou é Lasanha?");
        lasagnaNode.setName("Lasanha");

        FinalNode chocolateCakeNode = new FinalNode();
        chocolateCakeNode.setQuestion("O prato que você pensou é Bolo de Chocolate?");
        chocolateCakeNode.setName("Bolo de Chocolate");

        rootNode = new Node();
        rootNode.setQuestion("O prato que você pensou é massa?");
        rootNode.setYesNode(lasagnaNode);
        rootNode.setNoNode(chocolateCakeNode);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(15, 0, 15, 0));

        JLabel label = new JLabel("Pense em um prato que gosta");
        label.setAlignmentX(0.5F);
        JButton button = new JButton("OK");
        button.setAlignmentX(0.5F);
        button.addActionListener(listener -> startGame());

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(button);

        setSize(290,130);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setVisible(true);
    }

    private void startGame() {
        rootNode.makeQuestion();
    }
}