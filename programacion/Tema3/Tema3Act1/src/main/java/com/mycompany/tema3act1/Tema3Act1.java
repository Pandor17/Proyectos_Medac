/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema3act1;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *Escribe un programa en Java que pida al usuario el día y el mes de su nacimiento y le diga su signo del
zodíaco.
 */
public class Tema3Act1 {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //pedir y grabar datos
        int diaNacimiento = parseInt(JOptionPane.showInputDialog("Digite el día de su nacimiento"));
        int mesNacimiento = parseInt(JOptionPane.showInputDialog("Digite el mes de su nacimiento"));
        //mostrar por pantalla los datos recogidos
        JOptionPane.showMessageDialog(null, "Nació el día "+diaNacimiento+" y el mes "+mesNacimiento);
        
        //clasificar por mes y día
        String signoZodiaco = null;
        switch (mesNacimiento){
            case 1 -> {
                signoZodiaco = (diaNacimiento <21)? "capricornio":"acuario";
            }
            case 2 -> {
                signoZodiaco = (diaNacimiento <20)? "acuario":"piscis";
            }
            case 3 -> {
                signoZodiaco = (diaNacimiento <21)? "piscis":"aries";
            }
            case 4 -> {
                signoZodiaco = (diaNacimiento <21)? "aries":"tauro";
            }
            case 5 -> {
                signoZodiaco = (diaNacimiento <22)? "tauro":"geminis";
            }
            case 6 -> {
                signoZodiaco = (diaNacimiento <21)? "geminis":"cáncer";
            }
            case 7 -> {
                signoZodiaco = (diaNacimiento <24)? "cáncer":"leo";
            }
            case 8 -> {
                signoZodiaco = (diaNacimiento <24)? "leo":"virgo";
            }
            case 9 -> {
                signoZodiaco = (diaNacimiento <24)? "virgo":"libra";
            }
            case 10 -> {
                signoZodiaco = (diaNacimiento <24)? "libra":"escorpio";
            }
            case 11 -> {
                signoZodiaco = (diaNacimiento <22)? "escorpio":"sagitario";
            }
            case 12 -> {
                signoZodiaco = (diaNacimiento <22)? "sagitario":"capricornio";
            }
        }
        JOptionPane.showMessageDialog(null, "Su signo del zodiaco es "+ signoZodiaco);
    }
}
