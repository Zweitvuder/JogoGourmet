package com.harley.gourmet;

import javax.swing.*;

public class Node {
    protected String question;
    protected Node parentNode, yesNode, noNode;

    public void setQuestion(String q) {
        question = q;
    }

    public void setParentNode(Node pNode) {
        parentNode = pNode;
    }

    public void setYesNode(Node yNode) {
        yesNode = yNode;
        yesNode.setParentNode(this);
    }

    public void setNoNode(Node nNode) {
        noNode = nNode;
        noNode.setParentNode(this);
    }

    public void makeQuestion() {
        boolean isYes = JOptionPane.showConfirmDialog(JogoGourmet.INSTANCE, question,
                "Confirm", JOptionPane.YES_NO_OPTION) == 0;

        if (isYes) {
            yesNode.makeQuestion();
        } else {
            noNode.makeQuestion();
        }
    }
}