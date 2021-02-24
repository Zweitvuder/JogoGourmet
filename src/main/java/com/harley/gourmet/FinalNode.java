package com.harley.gourmet;

import javax.swing.*;

public class FinalNode extends Node {
    private String name;

    public void setName(String n) {
        name = n;
    }

    @Override
    public void makeQuestion() {
        boolean positive = JOptionPane.showConfirmDialog(JogoGourmet.INSTANCE, question,
                "Confirm", JOptionPane.YES_NO_OPTION) == 0;

        if (positive) {
            JOptionPane.showMessageDialog(JogoGourmet.INSTANCE, "Acertei de novo!",
                    "Jogo Gourmet", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String dish = JOptionPane.showInputDialog(JogoGourmet.INSTANCE, "Qual prato você pensou?",
                    "Desisto", JOptionPane.QUESTION_MESSAGE);

            String type = JOptionPane.showInputDialog(JogoGourmet.INSTANCE,
                    dish + " é _________ mas " + name + " não.",
                    "Complete", JOptionPane.QUESTION_MESSAGE);

            FinalNode nFinalNode = new FinalNode();
            nFinalNode.setQuestion("O prato que você pensou é " + dish);
            nFinalNode.setName(dish);

            Node higherNode = new Node();
            higherNode.setQuestion("O prato que você pensou é " + type);
            if (isYesNode) {
                parentNode.setYesNode(higherNode);
            } else {
                parentNode.setNoNode(higherNode);
            }
            higherNode.setYesNode(nFinalNode);
            higherNode.setNoNode(this);
        }
    }
}