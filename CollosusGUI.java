/*******************************************************************************
 * Collosus Airlines program is a software application that is made to keep a  *
 * collection of costumers. This program has a menu bar that is the key to     *
 * "Drive this car". The appropriate documentation about the menu bar is locat-*
 * ed in the menu bar class.                                                   *
 *                                                                             *
 * This program uses the Link List as data structure and a MYSQL table under   *
 * the name of customers as a data base. The data base is include in this fo-  *
 * der as well.                                                                *
 * The porpuse of this class is to the appropriate Graphical User Interface,   *
 * the print is there for a specific reason that is documented in the blue     *
 * print class.                                                                *
 *                                                                             *
 * Developed by         : Santiago De La Torre.                                *
 * Last Modification    : April 8 2011.                                        *
 * Educational Center   : Bunker Hill Community College.                       *
 *******************************************************************************
 *      
 */
package collosusairlines;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.*;

public class CollosusGUI extends JFrame {

    private int fHeight                 = 600;
    private int fWidth                  = 800;
    private JLabel logo                 = new JLabel(new ImageIcon("Images\\LOGO.jpg"));
    public static Blueprint blueprint   = new Blueprint();
    private Container container;

    public CollosusGUI() throws ClassNotFoundException, SQLException {
        setSize(fWidth, fHeight);
        setTitle("Collosus Airlines");
        setLayout(null);
        setResizable(false);
        container = getContentPane();
        container.setBackground(Color.white);
        setLocation(fWidth / 3, fHeight / 5);
        setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\Icon.png"));
        logo.setBounds(fWidth - 270, 0, 270, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        blueprint.setBounds(0, fHeight - 320, fWidth, 300);
        setJMenuBar(new MenuBar());
        add(blueprint);
        add(logo);
        setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new CollosusGUI();
    }
}
