/*5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and
display the concerned color whenever the specific tab is selected in the Pan
*/
package lab_5d;
import javax.swing.*;
import java.awt.*;

public class TabbedColorsExample {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Tabbed Pane Colors");
        frame.setSize(400,400);  

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels with colors
        JPanel cyanPanel = new JPanel();
        cyanPanel.setBackground(Color.CYAN);

        JPanel magentaPanel = new JPanel();
        magentaPanel.setBackground(Color.MAGENTA);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);

        // Add tabs
        tabbedPane.addTab("Cyan", cyanPanel);
        tabbedPane.addTab("Magenta", magentaPanel);
        tabbedPane.addTab("Yellow", yellowPanel);
        tabbedPane.setBounds(50,50,200,200); 

        // Add tabbed pane to frame
        frame.add(tabbedPane);
        frame.setLayout(null);  


        // Make frame visible
        frame.setVisible(true);
    }
}