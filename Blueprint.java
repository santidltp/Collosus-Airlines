/*******************************************************************************
 * This class is the "Wall paper" of the client area; gives the white          *
 * color, and add a couple of images to give a realistic aspect.               *
 * It is called blue print because it cointains an image that looks like a     *
 * an airplane's blue print. The reason why I included that is to              *
 * give a graphical touch to the reservations.                                 *
 * Every time the user makes a reservation, the flight number is printed on the*
 * client area and a circle will be placed on the seat reserved.               *
 *                                                                             *
 * Developed by         : Santiago De La Torre.                                *
 * Last Modification    : April 8 2011                                         *
 * Educational Center   : Bunker Hill community College                        *
 * *****************************************************************************
 */

package collosusairlines;
import java.awt.*;
import javax.swing.*;

public class Blueprint extends JPanel {

private Image seats          = new ImageIcon("Images\\seats.jpg").getImage();
private byte bDiameter       = 25;
private Node nodi            = null;
private int nflight          = 0;
    public Blueprint(){
        setBackground(Color.white);
    }
public void setFlight(int n){
    nflight = n;
     nodi   = MenuBar.lList.getFirst();
     repaint();
}
  @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(seats, 0, 0, null);

        if(nodi != null)
        g.drawString("Flight: " + nflight, 370, 40);
        else
         g.drawString("Flight: ", 370, 40);
         g.drawString("Smoking Area", 370, 17);
         g.drawString("Non-Smoking Area", 530, 17);
         g.drawString("1", 265,185 );
         g.drawString("2", 265, 136);
         g.drawString("3", 320, 185);
         g.drawString("4", 320, 136);
         g.drawString("5", 370, 185);
         g.drawString("6", 370, 136);
         g.drawString("7", 420, 185);
         g.drawString("8", 420, 136);
         g.drawString("9", 475, 185);
         g.drawString("10", 470, 140);
         g.setColor(Color.red);
         g.fillOval(340, 0, bDiameter, bDiameter);//display
         //smokers
         g.setColor(Color.red);
         g.fillOval(340, 0, bDiameter, bDiameter);//display
               g.setColor(Color.green);
                       g.fillOval(500, 0, bDiameter, bDiameter);//display
            while(nodi!= null){
           if(nodi.iFlight == nflight){
                g.setColor(Color.red);
        if(nodi.iSeat == 1)g.fillOval(237, 167, bDiameter, bDiameter);//1
        if(nodi.iSeat == 2)g.fillOval(237, 120, bDiameter, bDiameter);//2
        if(nodi.iSeat == 3)g.fillOval(290, 167, bDiameter, bDiameter);//3
        if(nodi.iSeat == 4)g.fillOval(290, 120, bDiameter, bDiameter);//4
        if(nodi.iSeat == 5)g.fillOval(340, 167, bDiameter, bDiameter);//5
        //nonsmokerssssssss
        g.setColor(Color.green);
        if(nodi.iSeat == 6)g.fillOval(340, 120, bDiameter, bDiameter);//6
        if(nodi.iSeat == 7) g.fillOval(393, 167, bDiameter, bDiameter);//7
        if(nodi.iSeat == 8)g.fillOval(393, 120, bDiameter, bDiameter);//8
        if(nodi.iSeat == 9) g.fillOval(447, 167, bDiameter, bDiameter);//9
        if(nodi.iSeat == 10) g.fillOval(447, 125, bDiameter, bDiameter);//10
               }
           nodi = nodi.next;
        }
    }  
  }