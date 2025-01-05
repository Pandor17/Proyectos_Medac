package com.mycompany.interfazinmobiliaria;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    private static String lastErrorMessage = null;
    private static final List<String> calledMethods = new ArrayList<>();

    /**
     * Obtiene el valor de un campo privado o protegido de una clase.
     *
     * @param obj       La instancia del objeto donde buscar el campo.
     * @param fieldName El nombre del campo.
     * @return El valor del campo.
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo acceder al campo " + fieldName, e);
        }
    }

    /**
     * Simula la captura de un mensaje de error mostrado al usuario.
     *
     * @param message El mensaje de error mostrado.
     */
    public static void setLastErrorMessage(String message) {
        lastErrorMessage = message;
    }

    /**
     * Obtiene el último mensaje de error registrado.
     *
     * @return El último mensaje de error.
     */
    public static String getLastErrorMessage() {
        return lastErrorMessage;
    }

    /**
     * Registra una llamada a un método.
     *
     * @param methodName El nombre del método llamado.
     */
    public static void registerMethodCall(String methodName) {
        calledMethods.add(methodName);
    }

    /**
     * Verifica si un método fue llamado.
     *
     * @param methodName El nombre del método.
     * @return True si el método fue llamado, false de lo contrario.
     */
    public static boolean wasMethodCalled(String methodName) {
        return calledMethods.contains(methodName);
    }

    /**
     * Resetea los métodos y mensajes registrados.
     */
    public static void reset() {
        lastErrorMessage = null;
        calledMethods.clear();
    }
}