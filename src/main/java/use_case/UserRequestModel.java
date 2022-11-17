package use_case;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserRequestModel {
     private JButton action = new JButton();


    public UserRequestModel(ActionEvent e){
        this.action = (JButton) e.getSource();
    }

   public JButton getAction(){return action;}

   public void setAction(ActionEvent e){this.action = (JButton) e.getSource();
   }
}
