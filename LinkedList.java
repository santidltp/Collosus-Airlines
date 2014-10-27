/* The Link List class is the data structure used in this project. This class
 * performs actions like; add, delete, check, and other actions. This class
 * does not interact with the Data base class.
 * 
 * Developed by         : Santiago De La Torre.
 * Last Modification    : April 8 2011.
 * Educational Center   : Bunker Hill Community College.
 */
package collosusairlines;
import javax.swing.JOptionPane;

class Node {

    String sName, sLstName, sstAddress, sCity, sState, sZip;
    int iFlight, iSeat;
    Node next;

    Node(String name, String lastname, String address, String city,
            String state, String zip, int flight, int seat) {
        sName        = name;
        sstAddress   = address;
        sLstName     = lastname;
        sCity        = city;
        sState       = state;
        sZip         = zip;
        iFlight      = flight;
        iSeat        = seat;
    }
}

class LinkedList {

    Node first, last;

    public LinkedList() {
        first = last = null;
    }
    //Add a customer by order: Flight Number, Last Name, and Name
    public boolean addCustomer(Node newNode) {
        Node nPrev = null;
        Node nTmp = first;
        while (nTmp != null) {
            if (nTmp.iFlight == newNode.iFlight
                    && nTmp.iSeat == newNode.iSeat) {
                JOptionPane.showOptionDialog(null, "The Seat you just chose has been booked\n"
                        + "please try it again",
                        "Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
                return false;
            }
            nTmp = nTmp.next;
        }
        nTmp = first;
        while (nTmp != null && (nTmp.iFlight < newNode.iFlight || (nTmp.iFlight == newNode.iFlight
                && nTmp.sLstName.compareToIgnoreCase(newNode.sLstName) < 0)
                || (nTmp.sLstName.compareToIgnoreCase(newNode.sLstName) == 0
                && nTmp.sName.compareToIgnoreCase(newNode.sName) < 0))) {
            nPrev = nTmp;
            nTmp = nTmp.next;
        }
        if (nPrev == null)
            first = newNode;
         else
            nPrev.next = newNode;
        newNode.next = nTmp;
        return true;
    }

    // Deletes the customer from the link list no matter what the position is.
    public boolean deleteCustomer(String name, String lastname, String address, String city,
            String state, String zip, int flight, int seat) {

        Node temp = first;
        if (temp == null)
            return false;
        if (check(temp, name, lastname, address, city, state, zip, flight, seat)) {
            if (first == last)
                last = first.next;

            first = first.next;
            return true;
        }
        while (temp.next != null) {
            if (check(temp.next, name, lastname, address, city, state, zip, flight, seat)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    //How many records are in the link list?
    public int Length() {
        Node iTmp = first;
        int Length = 0;
        while (iTmp != null) {
            Length++;
            iTmp = iTmp.next;
        }
        return Length;
    }
    /* Gets the list of the entire linklist in an array of strings to be
     * displayed.
     */
    public String[] getList() {
        Node temp = first;
        String[] sList = new String[Length()];
        int x = 0;
        while (temp != null) {
            sList[x] = temp.sName + " " + temp.sLstName + " " + temp.sstAddress + " " + temp.sCity + " " + temp.sState + " " + temp.sZip + " " + temp.iFlight + " " + temp.iSeat;
            x++;
            temp = temp.next;
        }
        return sList;
    }
    //Checks if the customer is in the link list.
    private boolean check(Node nTemp, String name, String lastname, String address, String city,
            String state, String zip, int flight, int seat) {

        if (nTemp.sName.equalsIgnoreCase(name))
            if (nTemp.sLstName.equalsIgnoreCase(lastname))
                if (nTemp.sstAddress.equalsIgnoreCase(address))
                    if (nTemp.sCity.equalsIgnoreCase(city))
                        if (nTemp.sState.equalsIgnoreCase(state))
                            if (nTemp.sZip.equalsIgnoreCase(zip))
                                if (nTemp.iFlight == flight)
                                    if (nTemp.iSeat == seat)
                                        return true;
        return false;
    }
    //Accesor
    public Node getFirst() {
        return first;
    }
    /* Method that looke either for a name and last name or flight number and seat number.
     * if is found, is returned the entire node.
     */
    public Node isInList(Object A, Object B) {
        Node temp = first;

        while (temp != null) {
            if (temp.sName.equalsIgnoreCase(A.toString()) && temp.sLstName.equalsIgnoreCase(B.toString())
                    || temp.iFlight == A && temp.iSeat == B) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
