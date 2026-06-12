/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlventas;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author freyvas
 */
public class ControlVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Bienvenida();
        Menu(input);
        
    }//Fin de Main
    
    public static void Bienvenida(){
        System.out.println("===============================");
        System.out.println("    \u2615BIENVENIDO A PANADERíA");
        System.out.println("            WELCHEZ\u2615");
        System.out.println("\n    Río Piedras, SPS");
        System.out.println("    Tel.: 2557-1028");
        System.out.println("===============================");  
    }//Fin de Función Bienvenida
    
    public static int Menu(Scanner input){
        int num = 1;
        
        System.out.println("\n     \u2729\u2729 MENÚ  PRINCIPAL \u2729\u2729");
        System.out.printf("%-4s %-5s",num++ + ".","Registrar producto");
        System.out.printf("%n%-4s %-5s",num++ + ".","Buscar producto");
        System.out.printf("%n%-4s %-5s",num++ + ".","Actualizar inventario");
        System.out.printf("%n%-4s %-5s",num++ + ".","Generar factura");
        System.out.printf("%n%-4s %-5s",num++ + ".","Ver inventario");
        System.out.printf("%n%-4s %-5s",num++ + ".","Producto más vendido");
        System.out.printf("%n%-4s %-5s",num++ + ".","Producto menos vendido");
        System.out.printf("%n%-4s %-5s",num++ + ".","Producto bajo en inventario");
        System.out.printf("%n%-4s %-5s",num++ + ".","Resumen de ventas");
        System.out.printf("%n%-4s %-5s",num++ + ".","Estadísticas generales");
        System.out.printf("%n%-4s %-5s",num++ + ".","Salir");
        
        System.out.println("\n\nSeleccione una opción:");
        return input.nextInt();
    }//Fin de Función Menu
    
    public static void SelecAccion(){
        
        
        
    }
    
}//Fin de Class
