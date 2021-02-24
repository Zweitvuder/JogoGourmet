package com.harley.gourmet;

import javax.swing.*;

public class Node {
    protected String question;
    protected Node parentNode, yesNode, noNode;
    protected boolean isYesNode;

    public void setQuestion(String q) {
        question = q;
    }

    public void setParentNode(Node pNode) {
        parentNode = pNode;
    }

    public void setYesNode(Node yNode) {
        yesNode = yNode;
        yesNode.setParentNode(this);
        yesNode.isYesNode = true;
    }

    public void setNoNode(Node nNode) {
        noNode = nNode;
        noNode.setParentNode(this);
        noNode.isYesNode = false;
    }

    public void makeQuestion() {
        boolean positive = JOptionPane.showConfirmDialog(JogoGourmet.INSTANCE, question,
                "Confirm", JOptionPane.YES_NO_OPTION) == 0;

        if (positive) {
            yesNode.makeQuestion();
        } else {
            noNode.makeQuestion();
        }
    }
}