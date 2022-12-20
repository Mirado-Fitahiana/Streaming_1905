package controler;
import java.awt.event.*;

import javax.swing.JButton;

import affichage.FrameClient;
public class ListenerClient implements ActionListener {
    FrameClient frame ;

    public ListenerClient(FrameClient frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton play = frame.getButton();
        if (e.getSource() == play) {
            frame.setChoix(frame.getList().getSelectedIndex());
            System.out.println(frame.getChoix());
        }  
    }
    
}

