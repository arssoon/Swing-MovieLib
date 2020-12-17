package movielibrary;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class ChangeEffectButton extends Thread {

    JButton[] tabClickButton;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;

    public ChangeEffectButton(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6) {
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.button5 = button5;
        this.button6 = button6;

        tabClickButton = new JButton[2];
    }

    public void run() {
        setHoverButton(button1);
        setHoverButton(button2);
        setHoverButton(button3);
        setHoverButton(button4);
        setHoverButton(button5);
        setHoverButton(button6);
    }

    //---------  CHANGE COLOR BUTTON  -----------------   
    private void setHoverButton(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.decode("#ff5400"));
                button.setFont(new Font("sfgsdf", Font.BOLD, 20));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button.equals(tabClickButton[0])) {
                    button.setBackground(Color.decode("#be1d00"));
                    button.setFont(new Font("sfgsdf", Font.BOLD, 20));
                } else {
                    button.setBackground(new java.awt.Color(54, 57, 75));
                    button.setFont(new Font("sfgsdf", 0, 14));
                }
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                /* obecnie naciśnięty button różny od aktualnie zapisanego (wciśniętego) buttona
                 * lub ostatnio wciśniety button różny od aktualnie wciśniętego
                */
                if (!button.equals(tabClickButton[0]) || !tabClickButton[1].equals(tabClickButton[0])) {
                    tabClickButton[1] = tabClickButton[0]; // tab[1] - ostatnio wciśniety button
                    tabClickButton[0] = button; // tab[0] - aktualnie - ||- button                   
                }
                
                
                if (tabClickButton[1] != null && !tabClickButton[1].equals(tabClickButton[0])) {
                    button.setBackground(Color.decode("#be1d00"));
                    button.setFont(new Font("sfgsdf", Font.BOLD, 20));

                    tabClickButton[1].setBackground(new java.awt.Color(54, 57, 75));
                    tabClickButton[1].setFont(new Font("sfgsdf", 0, 14));
                } else {
                    button.setBackground(Color.decode("#be1d00"));
                    button.setFont(new Font("sfgsdf", 0, 20));
                }
            }
        });
    }
}
