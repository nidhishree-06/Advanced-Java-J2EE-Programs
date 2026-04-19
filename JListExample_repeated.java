/* 5a.Develop a Swing program in Java to add the countries USA, India, Vietnam,
Canada,
Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and
display the capital of the countries on console whenever the countries are selected on
the list.
 */

//JList Example developed by Dr.Sm.Badhusha
package lab_5c;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class JListExample_repeated {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Country List");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Countries list
        String countries[] = {
                "USA", "India", "Vietnam", "Canada",
                "Denmark", "France", "Great Britain",
                "Japan", "Africa", "Greenland", "Singapore"
        };

        // Capitals mapping
        HashMap<String, String> capitalMap = new HashMap<>();
        capitalMap.put("USA", "Washington D.C.");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "Addis Ababa");
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // Create JList
        JList<String> list = new JList<>(countries);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add listener
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = list.getSelectedValue();
                    if (selectedCountry != null) {
                        String capital = capitalMap.get(selectedCountry);
                        System.out.println("Capital of " + selectedCountry + " is: " + capital);
                    }
                }
            }
        });

        // Add list to scroll pane
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}