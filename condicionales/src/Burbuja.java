import javax.swing.*;

public class Burbuja {
    public static void main(String[] args){
        int iDia,iMes,iAno;
        iDia = Integer.parseInt(JOptionPane.showInputDialog("Digite un día"));
        iMes = Integer.parseInt(JOptionPane.showInputDialog("Digite un mes"));
        iAno = Integer.parseInt(JOptionPane.showInputDialog("Digite un año"));

        if ((iDia>=1) && (iDia<=30) && (iMes<13) && (iMes>0) && (iAno<2024)) {
            JOptionPane.showMessageDialog(null, "La fecha es válida.");
        } else {
            JOptionPane.showMessageDialog(null,"la fecha introducida no es válida.");
        }
    }
}
