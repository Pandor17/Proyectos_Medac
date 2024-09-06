import javax.swing.*;

public class MayusculasMinusculas {
    public static void  main(String[] args){
        char cletra;
        cletra = JOptionPane.showInputDialog("Teclee una letra").charAt(0);
        if (Character.isUpperCase(cletra)){
            JOptionPane.showMessageDialog(null,"es mayúscula");
        }
        else{
            JOptionPane.showMessageDialog(null,"es minúscula");
        }
    }
}
