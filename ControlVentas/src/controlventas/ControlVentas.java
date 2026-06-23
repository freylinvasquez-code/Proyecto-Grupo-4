/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlventas;
import java.util.Scanner;
import java.util.Random;

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
 * 
 * @author freyvas
 */
public class ControlVentas {
    //Declaración de variables globales
    static String codigos[] = new String[1000];
    static String nombres[] = new String[1000];
    static String categorias[] = new String[1000];
    static int existencias[] = new int[1000];
    static double costos[] = new double[1000];
    static double precios[] = new double[1000];
    static int vendidos[] = new int[1000];
    static int totalProductos = 0;
    static double totalVentas = 0;
    static int totalFacturas = 0;

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
        System.out.println("\n");
        System.out.print("Seleccione una opción: ");
        
        //El return de esta función se utiliza en otra función -> SelecAccion
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
                case 2:
                    buscarProducto(input);
                    break;
	
                case 3:
                    actualizarInventario(input);
                    break;
                case 4:
                    generarFactura(input);
                    break;
                case 5:
                    verInventario(input);
                    break;
                case 6:
                    productoMasVendido(input);
                    break;
                case 7:
                    productoMenosVendido(input);
                    break;
                case 8:
                    productoBajoInventario(input);
                    break;
                case 9:
                    resumenVentas(input);
                    break;
                case 10:
                    estadisticasGenerales(input);
                    break;
                case 11:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción Invalida");
            }//Fin de Switch
        }while(opcion != 11);//Fin de Do While
        return opcion;
    }//Fin de Función SelecAccion
    
    //Función que se utiliza para permitir regresar al menú principal
    public static boolean volverMenu(Scanner input){
    int opcion;

    System.out.println("\n¿Qué desea hacer?");
    System.out.println("1. Volver al menú principal");
    System.out.println("2. Salir");
    System.out.print("Seleccione una opción: ");
    opcion = input.nextInt();

    return opcion == 1;
    }//Fin de Función volverMenu
    
    //Función utilizada para registrar productos
    public static void registrarProducto(Scanner input){
        int n = 0;
        double ganancias = 0;
        
        System.out.print("¿Cuántos productos desea registrar? ");
        n = input.nextInt();
        
        for(int i = 0; i < n; i++){
            System.out.println("\nProducto #" + (i + 1));
            
            System.out.print("Código: ");
            input.nextLine();//Limpieza de Buffer
            codigos[totalProductos] = input.nextLine().toUpperCase();
            
            System.out.print("Nombre: ");
            nombres[totalProductos] = input.nextLine().toUpperCase();
            
            System.out.print("Categoría: ");
            categorias[totalProductos] = input.nextLine().toUpperCase();
            
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
            //WHILE para validar que el precio sea mayor que el costo
            while(precios[totalProductos] <= costos[totalProductos]){
                System.out.println("El precio debe ser mayor que el costo.");
                System.out.print("Ingrese nuevamente el precio: ");
                precios[totalProductos] = input.nextDouble();   
            }//Fin de While
            
            ganancias = precios[totalProductos] - costos[totalProductos];
            System.out.println("Producto registrado correctamente.");
            System.out.println("Ganancia por unidad L. " + ganancias);
            
            totalProductos++;
        }//Fin de Ciclo For
        
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
    }//Fin de Función registrarProducto
    
    //Función que le permite al usuario buscar un producto
    public static void buscarProducto(Scanner input){
        int ops = 0;
        String codigo = "";
        String nombre = "";
        boolean encontrado = false;
        
        System.out.println("Opciones: ");
        System.out.println("1. Código");
        System.out.println("2. Nombre");
        System.out.print("¿Desea buscar el producto por código o nombre? ");
        ops = input.nextInt(); 
        input.nextLine();//Limpieza de Buffer
        
        switch(ops){
            case 1:
                System.out.print("Ingrese el código del producto: ");
                codigo = input.nextLine();
                
                for(int i = 0; i < totalProductos; i++){
                    if(codigos[i].equalsIgnoreCase(codigo)){
                        System.out.println("\nProducto encontrado.");
                        encontrado = true;
                        System.out.println("Código: " + codigos[i]);
                        System.out.println("Nombre: " + nombres[i]);
                        System.out.println("Categoría: " + categorias[i]);
                        System.out.println("Existencias: " + existencias[i]);
                        System.out.println("Costo L: " + costos[i]);
                        System.out.println("Precio L: " + precios[i]);
                    }//Fin de If
                }//Fin de Ciclo For
                
                if(!encontrado){
                    System.out.println("Producto no encontrado.");
                }//Fin de If
                break;
                
            case 2: 
                System.out.print("Ingrese el nombre del producto: ");
                nombre = input.nextLine();
                
                for(int i = 0; i < totalProductos; i++){
                    if(nombres[i].equalsIgnoreCase(nombre)){
                        System.out.println("\nProducto encontrado.");
                        encontrado = true;
                        System.out.println("Código: " + codigos[i]);
                        System.out.println("Nombre: " + nombres[i]);
                        System.out.println("Categoría: " + categorias[i]);
                        System.out.println("Existencias: " + existencias[i]);
                        System.out.println("Costo L: " + costos[i]);
                        System.out.println("Precio L: " + precios[i]);
                    }//Fin de If
                }//Fin de Ciclo For
                
                if(!encontrado){
                    System.out.println("Producto no encontrado.");
                }//Fin de if
                break;

                default:
                    System.out.println("Opción invalida");
        }//Fin de Switch
        
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
    }//Fin de Función buscarProducto
    
    //Función que le permite al usuario actualizar el inventario
    public static void actualizarInventario(Scanner input){
	input.nextLine();
	
	System.out.print("Ingrese el código del producto: ");
	String codigo = input.nextLine();
        boolean encontrado = false;
	
	for(int i = 0; i < totalProductos; i++){
            if(codigos[i].equalsIgnoreCase(codigo)){
            encontrado = true;
            System.out.println("Producto: " + nombres[i]);
            System.out.println("Existencia actual: " + existencias[i]);
	
            System.out.print("Ingrese nueva existencia: ");
            existencias[i] = input.nextInt();
	
            while(existencias[i] < 0){
                System.out.println("La existencia no puede ser negativa.");
                System.out.print("Ingrese nuevamente: ");
                existencias[i] = input.nextInt();
            }//Fin de While
	
	System.out.println("Inventario actualizado correctamente.");
	}//Fin de If
	}//Fin de For
	
	if(!encontrado){
            System.out.println("Producto no encontrado.");
        }//Fin del If
        
    if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If    
    
    return;
    }//Fin de Función actualizarInventario
	
    //Función que permite generar una factura
    public static void generarFactura(Scanner input){
	input.nextLine();

	if(totalProductos == 0){
            System.out.println("No hay productos registrados para vender.");
	
            return;
            }//Fin de If
	
	Random random = new Random();
	int numeroFactura = random.nextInt(9000) + 1000;
        double subtotal = 0;
	String continuar;

	System.out.println("\n========= FACTURA #" + numeroFactura + " =========");

	do{
            System.out.print("Ingrese código del producto: ");
            String codigo = input.nextLine();
	
	int posicion = -1;
	
	for(int i = 0; i < totalProductos; i++){
            if(codigos[i].equalsIgnoreCase(codigo)){
                posicion = i;
                break;
		}//Fin de If
	}//Fin de For
	
	if(posicion == -1){
            System.out.println("Producto no encontrado.");
        }else{
            System.out.println("Producto: " + nombres[posicion]);
            System.out.println("Precio: L. " + precios[posicion]);
            System.out.println("Disponible: " + existencias[posicion]);
            System.out.print("Cantidad: ");
            
            int cantidad = input.nextInt();
            input.nextLine();
	
	if(cantidad <= 0){
            System.out.println("La cantidad debe ser mayor que cero.");
        }else if(cantidad > existencias[posicion]){
            System.out.println("No hay suficiente inventario.");
        }else{
            double totalProducto = cantidad * precios[posicion];
            
            existencias[posicion] -= cantidad;	
            vendidos[posicion] += cantidad;
	
            subtotal += totalProducto;
            
            System.out.println("Agregado: " + nombres[posicion] + " x " + cantidad + " = L. " + totalProducto);
        }
	}
	
	System.out.print("¿Desea agregar otro producto? si/no: ");
	continuar = input.nextLine();

	}while(continuar.equalsIgnoreCase("si"));//Fin de Do While
	
	double impuesto = subtotal * 0.15;
	double total = subtotal + impuesto;

	totalVentas += total;	
	totalFacturas++;

	System.out.println("\nSubtotal: L. " + subtotal);
	System.out.println("ISV 15%: L. " + impuesto);
	System.out.println("Total a pagar: L. " + total);
	System.out.println("====================================");
        
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
    }//Fin de Función generarFactura
	
    //Función que permite ver el inventario
    public static void verInventario(Scanner input){
        if(totalProductos == 0){
            System.out.println("No hay productos registrados.");
        }//Fin de If

	System.out.println("\n========= INVENTARIO =========");
	
	for(int i = 0; i < totalProductos; i++){
            System.out.println("\nCódigo: " + codigos[i]);
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Categoría: " + categorias[i]);
            System.out.println("Existencias: " + existencias[i]);
            System.out.println("Costo: L. " + costos[i]);
            System.out.println("Precio: L. " + precios[i]);
            System.out.println("Vendidos: " + vendidos[i]);
	}//Fin de For
        
	if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
        return;
    }//Fin de Función verInventario
	
    //Función que permite ver el producto más vendido
    public static void productoMasVendido(Scanner input){
	if(totalProductos == 0){
            System.out.println("No hay productos registrados.");
	}//Fin de If

	int mayor = 0;

	for(int i = 1; i < totalProductos; i++){
            if(vendidos[i] > vendidos[mayor]){
            mayor = i;
	}//Fin de If
	
	}//Fin de For

	System.out.println("\nProducto más vendido: " + nombres[mayor]);
	System.out.println("Cantidad vendida: " + vendidos[mayor]);
	
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
        return;
    }//Fin de Función productoMasVendido
	
    //Función que permite ver el producto menos vendido
    public static void productoMenosVendido(Scanner input){
	if(totalProductos == 0){
            System.out.println("No hay productos registrados.");
	}//Fin de If

	int menor = 0;
	
	for(int i = 1; i < totalProductos; i++){
            if(vendidos[i] < vendidos[menor]){
                menor = i;
            }//Fin de If
	
	}//Fin de For

	System.out.println("\nProducto menos vendido: " + nombres[menor]);
	System.out.println("Cantidad vendida: " + vendidos[menor]);
	
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
        return;
    }//Fin de Función productoMenosVendido
	
    //Función que permite ver los productos bajos en inventario
    public static void productoBajoInventario(Scanner input){
	boolean encontrado = false;

	System.out.println("\n========= PRODUCTOS BAJOS EN INVENTARIO =========");
	
        for(int i = 0; i < totalProductos; i++){
            if(existencias[i] <= 5){
                System.out.println(nombres[i] + " - Existencias: " + existencias[i]);
                encontrado = true;
	}//Fin de If
	
	}//Fin de For
	
	if(!encontrado){
	
	System.out.println("No hay productos bajos en inventario.");
	
	}//Fin de If
	
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
        return;
    }//Fin de Función productoBajoInventario
	
    //Función que permite ver un resumen de ventas
    public static void resumenVentas(Scanner input){
	System.out.println("\n========= RESUMEN DE VENTAS =========");
	System.out.println("Facturas realizadas: " + totalFacturas);
	System.out.println("Total vendido: L. " + totalVentas);
        
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
        return;
    }//Fin de Función resumenVentas
	
    //Función que permite ver estadísticas generales
    public static void estadisticasGenerales(Scanner input){
	int totalUnidades = 0;
	double valorInventario = 0;
	double gananciaEsperada = 0;
	
	for(int i = 0; i < totalProductos; i++){
            totalUnidades += existencias[i];
            valorInventario += existencias[i] * costos[i];
            gananciaEsperada += existencias[i] * (precios[i] - costos[i]);
	}//Fin de For

	System.out.println("\n========= ESTADÍSTICAS GENERALES =========");	
	System.out.println("Productos registrados: " + totalProductos);
	System.out.println("Unidades disponibles: " + totalUnidades);
	System.out.println("Valor del inventario: L. " + valorInventario);
	System.out.println("Ganancia esperada del inventario: L. " + gananciaEsperada);
	System.out.println("Ventas realizadas: L. " + totalVentas);
	
        if(!volverMenu(input)){
        System.out.println("Gracias por utilizar el sistema.");
        System.exit(0);
        }//Fin de If
        return;
    }//Fin de Función estadisticasGenerales
    
}//Fin de Class
