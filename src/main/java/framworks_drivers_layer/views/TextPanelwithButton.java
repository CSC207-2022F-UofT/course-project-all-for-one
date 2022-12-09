package framworks_drivers_layer.views;

import javax.swing.*;

// Frameworks/Drivers layer

// create a text-field with a button attached to it
public class TextPanelwithButton extends JPanel {
    public TextPanelwithButton(JTextField textField, JButton button) {
        this.add(textField);
        this.add(button);
    }
}
