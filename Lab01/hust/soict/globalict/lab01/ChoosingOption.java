package hust.soict.globalict.lab01;

import javax.swing.JOptionPane;
public class ChoosingOption{
    public static void main(String[] args){
        //exactly the example that teacher gave
        int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket");
        JOptionPane.showMessageDialog(null,"You've chosen: "+ (option == JOptionPane.YES_OPTION?"Yes":"No"));


        //With ONLY 2 Choices
        option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket (2) choices","WARNING",
        JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null,"You've chosen: "+ (option == JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
