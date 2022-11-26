package UI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Frameworks/Drivers layer

public class LabelTextAreaPanel extends JPanel {
    public LabelTextAreaPanel(JLabel label, JTextArea textArea) {
        this.add(label);
        this.add(textArea);
        textArea.setLineWrap(true);       // wrap line
        textArea.setWrapStyleWord(true);  // wrap line at word boundary
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);

    }
}