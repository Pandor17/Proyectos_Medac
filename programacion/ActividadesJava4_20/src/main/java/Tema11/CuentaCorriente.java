/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema11;

/**
 *
 * @author beapa
 */

/**
 * Clase que representa una cuenta corriente de un banco
 */
public class CuentaCorriente 
{
    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    /**
     * Constructor por defecto
     */
    public CuentaCorriente() 
    {
        this.nombre = "";
        this.cuenta = "";
        this.saldo = 0;
        this.tipoInteres = 0;
    }

    /**
     * Constructor con parámetros
     * @param nombre Nombre del titular de la cuenta
     * @param cuenta Número de cuenta
     * @param saldo Saldo de la cuenta
     * @param tipoInteres Tipo de interés de la cuenta
     */
    public CuentaCorriente(String nombre, String cuenta, double saldo, double tipoInteres) 
    {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.saldo = saldo;
        this.tipoInteres = tipoInteres;
    }

    /**
     * Obtiene el nombre del titular de la cuenta
     * @return Nombre del titular de la cuenta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del titular de la cuenta
     * @param nombre Nombre del titular de la cuenta nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de cuenta
     * @return Número de cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Modifica el número de la cuenta
     * @param cuenta Nuevo número de cuenta
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Obtiene el saldo de la cuenta
     * @return Saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Modifica el saldo de la cuenta
     * @param saldo Nuevo saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el tipo de interés
     * @return Tipo de interés
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * Modifica el tipo de interés de la cuenta
     * @param tipoInteres Nuevo tipo de interés
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    /**
     * Ingresa dinero en la cuenta corriente
     * @param cantidad Cantidad a ingresar en la cuenta
     * @throws CantidadNegativaException si se introduce una cantidad negativa a ingresar
     */
    public void ingresarDinero (double cantidad) throws CantidadNegativaException
    {
        if(cantidad<0){
            throw new CantidadNegativaException("No es posible ingresar una cantidad negativa");
        }
        saldo = saldo + cantidad;
    }
    
    /**
     * Retira dinero de la cuenta corriente
     * @param cantidad Cantidad a retirar de la cuenta
     * @throws CantidadNegativaException si se introduce una cantidad negativa a retirar
     */
    public void retirarDinero (double cantidad) throws CantidadNegativaException
    {
        if(cantidad<0){
            throw new CantidadNegativaException("No es posible retirar una cantidad negativa.");
        }
        saldo = saldo - cantidad;
    }
}

