/*
 * This class is just a little windos that promts the user for the customers
 * information, which is going to be used for registration, cancelation, or
 * displays.
 *
 * Developed by             : Santiago De La Torre.
 * Last Modification        : April 8 2011.
 * Educational Center       : Bunker Hill Community College.
 */
package collosusairlines;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddDelete {

    //Labels
    private JLabel lName            = new JLabel("Name:", JLabel.RIGHT);
    private JLabel lLstName         = new JLabel("Last Name:", JLabel.RIGHT);
    private JLabel lstAddress       = new JLabel("Street Address:", JLabel.RIGHT);
    private JLabel lCity            = new JLabel("City:", JLabel.RIGHT);
    private JLabel lState           = new JLabel("State:", JLabel.RIGHT);
    private JLabel lZip             = new JLabel("Zip Code:", JLabel.RIGHT);
    private JLabel lFlight          = new JLabel("Flight:", JLabel.RIGHT);
    private JLabel lSeat            = new JLabel("Seat Number:", JLabel.RIGHT);
    //TextFields
    private JTextField tName        = new JTextField();
    private JTextField tLstName     = new JTextField();
    private JTextField tstAddress   = new JTextField();
    private JTextField tCity        = new JTextField();
    private JTextField tZip         = new JTextField();
    //ComboBoxes
    private JComboBox cFlight       = new JComboBox();
    private JComboBox cSeat         = new JComboBox();
    private JComboBox cState        = new JComboBox();
    //JButtons
    private JButton bSubmit         = new JButton("Submit");
    private JButton bCancel         = new JButton("Cancel");
    //JFrame
    private JFrame frame            = new JFrame();
    private Click click             = new Click();
    private String[] comboList = {
        "Select State", "Alabama", "Alaska", "Arizona", "Arkansas", "California",
        "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho",
        "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
        "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
        "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
        "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
        "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
        "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
        "Wisconsin", "Wyoming"
    };
    DataBase data                   = new DataBase();

    public AddDelete(String caption) {

        frame.setTitle(caption);
        frame.setSize(300, 260);
        frame.setLayout(new GridLayout(9, 2, 4, 4));
        frame.setResizable(false);
        frame.setLocation(500, 250);

        cSeat.addItem("Select Seat");
        cFlight.addItem("Select Flight");
        for (int index = 0; index < comboList.length; index++) {
            //Add the flight numbers to the cFlight ComboBox
            if (index < 5) {
                cFlight.addItem((index + 1) * 100);
            }
            /* Add the seat numbers to the cSeat ComboBox according to the area
             * where the customer wants to seat which are either smoking or
             * non-smoking. For cancel reservation and print boarding pass we
             * show all the seat from the two areas.
             */
            if (caption.equals("Add in Smokin Area") && index < 5) {
                cSeat.addItem(index + 1);
            } else if (caption.equals("Add in Non-Smoking Area") && index >= 5 && index < 10) {
                cSeat.addItem(index + 1);
            }
            if (caption.equals("Cancel Reservation") || caption.equals("Display a Seat")) {
                if (index < 10) {
                    cSeat.addItem(index + 1);
                }
            }
            cState.addItem(comboList[index]);//Add the states to cState ComboBox
        }

        bSubmit.addActionListener(click);
        bCancel.addActionListener(click);
        frame.add(lName);
        frame.add(tName);
        frame.add(lLstName);
        frame.add(tLstName);
        frame.add(lstAddress);
        frame.add(tstAddress);
        frame.add(lCity);
        frame.add(tCity);
        frame.add(lState);
        frame.add(cState);
        frame.add(lZip);
        frame.add(tZip);
        frame.add(lFlight);
        frame.add(cFlight);
        frame.add(lSeat);
        frame.add(cSeat);
        frame.add(bSubmit);
        frame.add(bCancel);
        frame.show();
    }

    public void showBasic() {
        lstAddress.setEnabled(false);
        lCity.setEnabled(false);
        lState.setEnabled(false);
        lZip.setEnabled(false);
        lFlight.setEnabled(false);
        lSeat.setEnabled(false);
        //TextFields
        tstAddress.setEnabled(false);
        tCity.setEnabled(false);
        tZip.setEnabled(false);
        //ComboBoxes
        cFlight.setEnabled(false);
        cSeat.setEnabled(false);
        cState.setEnabled(false);
        //JFrame
    }

    public void printSeat() {
        tName.setEnabled(false);
        tLstName.setEnabled(false);
        tstAddress.setEnabled(false);
        tCity.setEnabled(false);
        tZip.setEnabled(false);
        cSeat.setEnabled(false);
        cState.setEnabled(false);
    }

    public void showSeat() {

        tName.setEnabled(false);
        tLstName.setEnabled(false);
        tstAddress.setEnabled(false);
        tCity.setEnabled(false);
        tZip.setEnabled(false);
        cState.setEnabled(false);

    }

    class Click implements ActionListener {

        private String sMsg;
        private boolean bFlag;

        public void actionPerformed(ActionEvent e) {


            String sButton = e.getActionCommand();
            sMsg = "";

            if (sButton.equals("Cancel")) {
                frame.setVisible(false);
            }
            if (sButton.equals("Submit")) {
                if (tName.getText().equals("")) {
                    sMsg += "- Name\n";
                }
                if (tLstName.getText().equals("")) {
                    sMsg += "- Last Name\n";
                }
                if (tstAddress.getText().equals("")) {
                    sMsg += "- Address\n";
                }
                if (tCity.getText().equals("")) {
                    sMsg += "- City\n";
                }
                if (cState.getSelectedItem().toString().equals("Select State")) {
                    sMsg += "- State\n";
                }
                if (tZip.getText().equals("")) {
                    sMsg += "- Zip Code\n";
                }
                if (cFlight.getSelectedItem().toString().equals("Select Flight")) {
                    sMsg += "- Flight Number\n";
                }
                if (cSeat.getSelectedItem().toString().equals("Select Seat")) {
                    sMsg += "- Seat Number\n";
                }
                if (sMsg.length() != 0 && frame.getTitle().charAt(0) == 'A' && frame.getTitle().charAt(0) == 'C') {
                    JOptionPane.showOptionDialog(frame, "You forgot to provide the following Information:\n\n" + sMsg,
                            "Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                    return;
                }

                switch (frame.getTitle().charAt(0)) {

                    case 'S':
                        if (cFlight.getSelectedItem().toString().equals("Select Flight")) {
                            msg("The flight you chose is incorrect", "Input Error", 0);
                        }
                        CollosusGUI.blueprint.setFlight(Integer.parseInt(cFlight.getSelectedItem().toString()));
                        break;
                    case 'D':
                        Node found = MenuBar.lList.isInList(cFlight.getSelectedItem(), cSeat.getSelectedItem());

                        if (found == null) {
                            msg("The following person is not in our database: ", "Input Error", 0);

                            cFlight.setSelectedIndex(0);
                            cSeat.setSelectedIndex(0);
                            return;
                        }
                        msgBoardingPass(found);
                        frame.setVisible(false);

                        break;
                    case 'P':
                        Node find = MenuBar.lList.isInList(tName.getText(), tLstName.getText());

                        if (find == null) {
                            msg("The following person is not in our database: ", "Input Error", 0);

                            tName.setText("");
                            tLstName.setText("");
                            return;
                        }
                        msgBoardingPass(find);
                        frame.setVisible(false);
                        break;
                    case 'A':
                        Node nodi = new Node(tName.getText(), tLstName.getText(), tstAddress.getText(), tCity.getText(),
                                cState.getSelectedItem().toString(), tZip.getText(),
                                Integer.parseInt(cFlight.getSelectedItem().toString()),
                                Integer.parseInt(cSeat.getSelectedItem().toString()));

                        if (!MenuBar.lList.addCustomer(nodi)) {
                            return;
                        }
                        CollosusGUI.blueprint.setFlight(nodi.iFlight);
                        frame.setVisible(false);
                        try {
                            data.Save(new Node(tName.getText(), tLstName.getText(), tstAddress.getText(), tCity.getText(), cState.getSelectedItem().toString(), tZip.getText(), Integer.parseInt(cFlight.getSelectedItem().toString()), Integer.parseInt(cSeat.getSelectedItem().toString())));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AddDelete.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(AddDelete.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.setVisible(false);

                        break;
                    case 'C':

                        bFlag = MenuBar.lList.deleteCustomer(tName.getText(), tLstName.getText(), tstAddress.getText(), tCity.getText(),
                                cState.getSelectedItem().toString(), tZip.getText(),
                                Integer.parseInt(cFlight.getSelectedItem().toString()),
                                Integer.parseInt(cSeat.getSelectedItem().toString()));
                        if (!bFlag) {

                            msg("The following person is not in our database: ", "Input Error", 0);
                            tName.setText("");
                            tLstName.setText("");
                            tstAddress.setText("");
                            tCity.setText("");
                            tZip.setText("");
                            cState.setSelectedIndex(0);
                            cFlight.setSelectedIndex(0);
                            cSeat.setSelectedIndex(0);
                            return;
                        }
                        msg("The following person has been deleted succesfully: ", "Job Delete Success", 1);
                        CollosusGUI.blueprint.setFlight(Integer.parseInt(cFlight.getSelectedItem().toString()));

                        try {
                            data.Delete(tName.getText());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(AddDelete.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(AddDelete.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        frame.setVisible(false);
                        break;

                }
            }
        }
    }

    public void msg(String ms, String title, int type) {
        String MSG = "\n\n";

        if (!tName.getText().isEmpty()) {
            MSG += "Name: " + tName.getText();
        }
        if (!tLstName.getText().isEmpty()) {
            MSG += "\nLast Name: " + tLstName.getText();
        }
        if (!tstAddress.getText().isEmpty()) {
            MSG += "\nAddress: " + tstAddress.getText();
        }
        if (!tCity.getText().isEmpty()) {
            MSG += "\nCity: " + tCity.getText();
        }
        if (!tZip.getText().isEmpty()) {
            MSG += "\nZip Code: " + tZip.getText();
        }
        if (!cState.getSelectedItem().toString().equals("Select State")) {
            MSG += "\nState: " + cState.getSelectedItem().toString();
        }

        if (!cFlight.getSelectedItem().toString().equals("Select Flight")) {
            MSG += "\nFlight Number: " + cFlight.getSelectedItem().toString();
        }
        if (!cSeat.getSelectedItem().toString().equals("Select Seat")) {
            MSG += "\nSeat Number: " + cSeat.getSelectedItem().toString();
        }
        if (type == 0) {
            MSG += "\nPlease try it again!";
        }

        JOptionPane.showOptionDialog(frame, ms + MSG,
                title, JOptionPane.DEFAULT_OPTION, type, null, null, null);

    }

    public void msgBoardingPass(Node msg) {

        JOptionPane.showOptionDialog(frame, "                    Collosus Airlines\n\nName: "
                + msg.sName + "\nLast Name: " + msg.sLstName
                + "\nStreen Address: " + msg.sstAddress
                + "\nCity: " + msg.sCity + "\nState: " + msg.sState + "\nZip Code: " + msg.sZip
                + "\nFlight Number: " + msg.iFlight + "\nSeat Number: " + msg.iSeat,
                "Boarding Pass", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

    }
}
