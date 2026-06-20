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
     * Panadería Welchez necesita llevar un control eficiente del inventario y
     * las ventas. El propósito de este programa es que sea una opción viable,
     * eficiente y no costoso para suplir esta necesidad de Welchez. El programa
     * contará de un menú principal que cuente con las siguientes opciones:
     * 1. Registrar producto.
     * 2. Buscar producto.
     * 3. Actualizar inventario.
     * 4. Generar factura.
     * 5. Ver inventario.
     * 6. Producto más vendido.
     * 7. Producto menos vendido.
     * 8. Producto bajo en inventario.
     * 9. Resumen de ventas.
     * 10. Estadísticas generales.
     * 11. Salir.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Espacio para mandar a llamar las funciones
        Bienvenida();
        SelecAccion(input);
        
        
    }//Fin de Main
    
    //Función que da la bienvenida al usuario
    public static void Bienvenida(){
        System.out.println("===============================");
        System.out.println("    \u2615BIENVENIDO A PANADERíA");
        System.out.println("            WELCHEZ\u2615");
        System.out.println("\n    Río Piedras, SPS");
        System.out.println("    Tel.: 2557-1028");
        System.out.println("===============================");  
    }//Fin de Función Bienvenida
    
    //Función que muestra las opciones del menú principal
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
        
        //El return de esta función se utiliza en otra función -> SelecAccion
        System.out.println("\n");
        System.out.print("Seleccione una opción: ");
        return input.nextInt();
    }//Fin de Función Menu
    
    //Función que se utiliza para redirigir al usuario a la función preferida
    public static int SelecAccion(Scanner input){
        int opcion = 0;
        
        do{
            opcion = Menu(input);
            switch(opcion){
                case 1:
                    registrarProducto(input);
                    break;
                default:
                    System.out.println("Opción Invalida");
            }//Fin de Switch
        }while(opcion <= 11);//Fin de Do While
        return opcion;
    }
    
    //Función utilizada para registrar productos
    public static void registrarProducto(Scanner input){
        int n = 0;
        String codigos[] = new String[1000];
        String nombres[] = new String[1000];
        String categorias[] = new String[1000];
        int existencias[] = new int[1000];
        double costos[] = new double[1000];
        double precios[] = new double[1000];
        double ganancias = 0;
        int totalProductos = 0;
        
        System.out.print("¿Cuántos productos desea registrar? ");
        n = input.nextInt();
        
        for(int i = 0; i < n; i++){
            System.out.println("\nProducto #" + (i + 1));
            
            System.out.print("Código: ");
            input.nextLine();
            
            codigos[totalProductos] = input.nextLine();
            System.out.print("Nombre: ");
            nombres[totalProductos] = input.nextLine();
            
            System.out.print("Categoría: ");
            categorias[totalProductos] = input.nextLine();
            
            System.out.print("Existencias: ");
            existencias[totalProductos] = input.nextInt();
            //WHILE para validar que no se ingresen existencias negativas o cero
            while(existencias[totalProductos] <= 0){
                System.out.println("Las existencias no pueden ser negativas o cero.");
                System.out.print("Ingrese existencias nuevamente: ");
                existencias[totalProductos] = input.nextInt();
            }//Fin de While
            
            System.out.print("Costo: ");
            costos[totalProductos] = input.nextDouble();
            //WHILE para validar que el costo sea mayor que cero
            while(costos[totalProductos] <= 0){
                System.out.println("El costo debe ser mayor que cero.");
                System.out.print("Ingrese nuevamente el costo: ");
                costos[totalProductos] = input.nextDouble();
            }//Fin de While
            
            System.out.print("Precio de venta: ");
            precios[totalProductos] = input.nextDouble();
            //WHILE para validar que el precio sea mayor que 0 y mayor que el costo
            while(precios[totalProductos] <= 0 || precios[totalProductos] <= costos[totalProductos]){
                System.out.println("El precio debe ser mayor a 0 y mayor que el costo.");
                System.out.print("Ingrese nuevamente el precio: ");
                precios[totalProductos] = input.nextDouble();   
            }//Fin de While
            
            ganancias = precios[totalProductos] - costos[totalProductos];
            System.out.println("Producto registrado correctamente.");
            System.out.println("Ganancia por unidad L. " + ganancias);
            
            totalProductos++;
        }//Fin de Ciclo For
    }
    
}//Fin de Class
