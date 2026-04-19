/*4c.Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass  is pressed” depending upon the Jbutton with image 
 *  either  Digital Clock or  Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ).
 */

package lab_4c;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample extends JFrame implements ActionListener {

    JButton btnClock, btnHourGlass;
    JLabel label;

    ImageButtonExample() {

        setTitle("Image Button Example");
        setSize(400, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50));

        // Load images
        ImageIcon clockIcon = new ImageIcon(getClass().getResource("clock.png"));
        ImageIcon hourglassIcon = new ImageIcon(getClass().getResource("hourglass.png"));

        // Resize images
        Image img1 = clockIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Image img2 = hourglassIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        clockIcon = new ImageIcon(img1);
        hourglassIcon = new ImageIcon(img2);

        // Buttons with images
        btnClock = new JButton(clockIcon);
        btnHourGlass = new JButton(hourglassIcon);

        // Remove button borders (optional for clean look)
        btnClock.setBorderPainted(false);
        btnHourGlass.setBorderPainted(false);

        // Label for output
        label = new JLabel("Click any image");
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add listeners
        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        // Add components
        add(btnClock);
        add(btnHourGlass);
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnClock) {
            label.setText("You have pressed digital clock");
        } 
        else if (e.getSource() == btnHourGlass) {
            label.setText("You have pressed hour glass");
        }
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}