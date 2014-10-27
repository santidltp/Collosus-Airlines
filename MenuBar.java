/*******************************************************************************
 * This class is the representation of the Menu bar that is located in the top *
 * of the client area. This Menu bar has three different choices to choose from*
 * and each Menu choice has a menu item. Each menu item will allow you to      *
 * to perform a particular action depending on what you are choosing:          *
 *                                                                             *
 *      A) File:                                                               *
 *          -About: Will pump up a message giving you directions on how to use *
 *                  this program.                                              *
 *          -Quit: Will ask you if you are sure to exit, if you are the program*
 *                 will close. If you are not so sure if you want to exit the  *
 *                 program will not close.                                     *
 *                                                                             *
 *      B) Ragistration:                                                       *
 *          -Make Reservation:                                                 *
 *                  -Smoking: Is going to ask you for the customer's informa   *
 *                            tion in order to be able to register that person *
 *                            in the smoking area.                             *
 *                  -Non-Smoking:Is going to ask you for the customer's informa*
 *                               tion in order to be able to register that     *
 *                               person in the non-smoking area.               *
 *          -Cancel Reservation: Is going to ask you for a full customer's     *
 *                               information in order to be able to delete that*
 *                               person from the data base.                    *
 *       C) Data Base:                                                         *
 *          -Show Seat in Blueprint: Will promt you for a flight number and    *
 *                                  all the reservations will be printed on the*
 *                                  blue print. It is a graphical solution to  *
 *                                  know which seat is reserved and which one  *
 *                                  is not.                                    *
 *         -Display a Seat Assigment: This choice will promt you for a fligh   *
 *                                    number and for a seat number. If that    *
 *                                    seat is reserved a little window will    *
 *                                    pump up give that person's information.  *
 *                                                                             *
 *                                                                             *
 * Developed by         : Santiago De La Torre.                                *
 * Last Modification    : April 8 2011.                                        *
 * Educational Center   : Bunker Hill Community College.                       *
 *******************************************************************************
 *
 */
package collosusairlines;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.*;


public class MenuBar extends JMenuBar {

    //Menu Choices
    private JMenu file              = new JMenu("File");
    private JMenu reservation       = new JMenu("Reservation");
    private JMenu dataBase          = new JMenu("Data Base");
    private JMenu makeRes           = new JMenu("Make Reservation");
    //Menu Items
    private JMenuItem about         = new JMenuItem("About");
    private JMenuItem quit          = new JMenuItem("Quit");
    private JMenuItem smoking       = new JMenuItem("Smoking");
    private JMenuItem nonSmoking    = new JMenuItem("Non-Smoking");
    private JMenuItem cancelRes     = new JMenuItem("Cancel Reservation");
    private JMenuItem disSeat       = new JMenuItem("Display a seat Assigment");
    private JMenuItem show          = new JMenuItem("Show Seats in Blueprint");
    private JMenuItem disAllSeat    = new JMenuItem("Display all seats Assigments");
    private JMenuItem printPass     = new JMenuItem("Print Boarding Pass");
    //Instance of ActionListener class
    private Click click             = new Click();
    //Instance of the LinkList
    public static LinkedList lList  = new LinkedList();
    //Instance of the Data Base class(JDBC)
    public DataBase data            = new DataBase();

    public MenuBar() throws ClassNotFoundException, SQLException {

        //File MENU
        file.setMnemonic(KeyEvent.VK_F);
        file.add(about);
        file.addSeparator();
        file.add(quit);
        about.addActionListener(click);
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        quit.addActionListener(click);
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        quit.setIcon(new ImageIcon("Icons\\delete_16.png"));
        //Reservation MENU
        reservation.setMnemonic(KeyEvent.VK_R);
        reservation.add(makeRes);
        makeRes.setMnemonic(KeyEvent.VK_S);
        makeRes.add(smoking);
        makeRes.add(nonSmoking);
        reservation.add(cancelRes);
        cancelRes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
        makeRes.setIcon(new ImageIcon("Icons\\clipboard_16.png"));
        nonSmoking.addActionListener(click);
        nonSmoking.setIcon(new ImageIcon("Icons\\non-smoking.png"));
        smoking.addActionListener(click);
        smoking.setIcon(new ImageIcon("Icons\\smoking.png"));
        cancelRes.setIcon(new ImageIcon("Icons\\block_16.png"));
        cancelRes.addActionListener(click);
        //Data Base MENU
        lList = data.Read();
        dataBase.setMnemonic(KeyEvent.VK_D);
        dataBase.add(show);
        show.addActionListener(click);
        show.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        show.setIcon(new ImageIcon("Icons\\icon_seat.png"));
        dataBase.add(disSeat);
        dataBase.add(disAllSeat);
        dataBase.add(printPass);
        disSeat.addActionListener(click);
        disAllSeat.addActionListener(click);
        printPass.addActionListener(click);
        printPass.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
        printPass.setIcon(new ImageIcon("Icons\\print_16.png"));
        add(file);
        add(reservation);
        add(dataBase);
    }

    private class Click implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String sAction = e.getActionCommand();
            //Action to take depending of which Menu Item is been clicked.
            switch (sAction.charAt(0)) {

                case 'A':

                    JOptionPane.showOptionDialog(null,
                            "Welcome to Collosus Airlines Program!\n"
                            + "Please read our directions  to learn how to use our program properly.\n\nDirections:\n"
                            + "In the Menu Bar you will find three menus options to choose from;\n"
                            + "A) File   B) Resevations   C) Data Base\n"
                            + "\nA) In our first menu choice you will find two Menu Items:\n"
                            + "-    About: Which displays the window you are reading\n"
                            + "-    Quit: Will promt you the question if you are sure or not(quit the program).\n"
                            + "\nB) Has two Menu Items:\n"
                            + "-    Make Reservation: Which Allows you to make reservations in a smoking section or non-smoking section. you will have\n"
                            + "     to provide the appropriate information in order to register a customer into a flight.\n"
                            + "-    Cancel Reservation: Allows you to cancel any reservation, it promts you for the right information\n"
                            + "     of cuustomers that you want to delete.\n"
                            + "\nC) Data Base has Four Menu Items:\n"
                            + "-    Show Seats in Blue Print: This menu item allows you to see all the reservations made for a particular flight by promting\n"
                            + "     you the flight number.\n"
                            + "-    Display a Seat Assigment: It will promt you for the FLIGHT NUMBER and SEAT NUMBER in order to print the\n"
                            + "     whole customer's information that is traveling in that seat. If the seat is empty, the program wil pump up\n"
                            + "     a message telling you that the person is not in our data Base.\n"
                            + "-    Display all Seat Assigments: If you click this menu item, a window will pump up showing you all the reservation made for\n"
                            + "     all the flights.\n"
                            + "-    Print Boarding Pass: Will prompt you for a NAME and LAST NAME of a person, if the person is found you will get the entire\n"
                            + "     persons information. Otherwise you will have an error message.",
                            "Collosus Airlines", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, null, null);
                    break;
                case 'Q':
                    int answer = JOptionPane.showOptionDialog(null, "Are you sure you want to quit?",
                            "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (answer == 0) System.exit(0);
                    break;
                case 'S':
                    if (sAction.charAt(1) == 'm')
                        new AddDelete("Add in Smokin Area");
                     else
                        new AddDelete("Show Seats").printSeat();
                    break;
                case 'N':
                    new AddDelete("Add in Non-Smoking Area");
                    break;
                case 'C':
                    new AddDelete("Cancel Reservation");
                    break;
                case 'D':
                    if (sAction.charAt(9) == 'l')
                        displayFrame();
                     else
                        new AddDelete("Display a Seat").showSeat();
                    break;
                case 'P':
                    new AddDelete("Print Boarding Pass").showBasic();
                    break;
            }
        }
    }

    /* The folloewing metho pumps up a little window with a JList that shows
     * you graphically all the customers in this program's data base.
     */
    public void displayFrame() {
        JFrame frame = new JFrame("Display");
        JList list = new JList();

        frame.setSize(500, 460);
        frame.setLocationRelativeTo(this);
        frame.setLayout(null);
        list.setListData(lList.getList());
        JScrollPane SP = new JScrollPane(list);
        SP.setBounds(10, 10, 470, 410);
        frame.add(SP);
        frame.show();
    }
}
