package com.harley.gourmet;

import javax.swing.*;

public class FinalNode extends Node {
    @Override
    public void makeQuestion() {
        boolean isYes = JOptionPane.showConfirmDialog(JogoGourmet.INSTANCE, question,
                "Confirm", JOptionPane.YES_NO_OPTION) == 0;

        JOptionPane.showMessageDialog(null, isYes ? "Acertei de novo!" : "Errou!!",
                isYes ? "Jogo Gourmet" : "Desisto", JOptionPane.INFORMATION_MESSAGE);
    }
}