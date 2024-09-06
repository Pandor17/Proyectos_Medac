import javax.swing.*;

public class ElegirElMayor {
    public static void main(String[] args){
        int iNMayor,iNMenor,iAuxiliar;
        iNMayor = Integer.parseInt(JOptionPane.showInputDialog("Digite un número"));
        iNMenor = Integer.parseInt(JOptionPane.showInputDialog("Digite otro número"));
        if (iNMayor<iNMenor){
            iAuxiliar=iNMayor;
            iNMayor=iNMenor;
            iNMenor=iAuxiliar;
            JOptionPane.showMessageDialog(null,"El número "+iNMayor+" es mayor que "+iNMenor);
        } else if (iNMayor==iNMenor) {
            JOptionPane.showMessageDialog(null,"Ambos números son iguales");
        } else{
            JOptionPane.showMessageDialog(null,"El número "+iNMayor+" es mayor que "+iNMenor);
        }
    }
}
