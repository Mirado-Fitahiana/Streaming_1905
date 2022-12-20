package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import controler.ListenerClient;

public class FrameClient extends JFrame {
    JPanel liste;
    JPanel bouton;
    JButton button;
    ListenerClient LC;
    JList list;
    int choix = -1;
    public FrameClient(String[] listeFile){
        this.setTitle("Deezer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,800);
        this.setLocationRelativeTo(null);
        LC = new ListenerClient(this);
        liste = new JPanel();
        liste.setBackground(Color.blue);
        liste.setPreferredSize(new Dimension(500,700));
        list = new JList<>(listeFile);
        list.setPreferredSize(new Dimension(400,700));
        liste.add(list);
        bouton = new JPanel();
        bouton.setBackground(Color.CYAN);
        bouton.setPreferredSize(new Dimension(500,200));
        button = new JButton("Ecouter");
        button.addActionListener(LC);
        bouton.add(button);
        this.add(liste,BorderLayout.NORTH);
        this.add(bouton);
        this.setVisible(true);
    }
    public JPanel getListe() {
        return liste;
    }
    public void setListe(JPanel liste) {
        this.liste = liste;
    }
    public JPanel getBouton() {
        return bouton;
    }
    public void setBouton(JPanel bouton) {
        this.bouton = bouton;
    }
    public JButton getButton() {
        return button;
    }
    public void setButton(JButton button) {
        this.button = button;
    }
    public ListenerClient getLC() {
        return LC;
    }
    public void setLC(ListenerClient lC) {
        LC = lC;
    }
    public JList getList() {
        return list;
    }
    public void setList(JList list) {
        this.list = list;
    }
    public int getChoix() {
        return choix;
    }
    public void setChoix(int choix) {
        this.choix = choix;
    }
}
