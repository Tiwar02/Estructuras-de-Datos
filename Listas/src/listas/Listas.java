/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author s208e19
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        // TODO code application logic here
//        Node n1 = new Node(55);
//        Node n2 = new Node(66);
//        Node n3 = new Node(77);
//        Node n4 = new Node(88);
//        Node n5 = new Node(99);
//        
//        n1.setNextNode(n2);
//        n2.setNextNode(n3);
//        n3.setNextNode(n4);
//        n4.setNextNode(n5);
        
        SinglyLinkedList<Integer> miListaMaxToMin = new SinglyLinkedList<>();

        SinglyLinkedList<Integer> miLista = new SinglyLinkedList<>();
        miLista.addOrdered(11);
        miLista.addOrdered(33);
        miLista.addOrdered(4);
        miLista.addOrdered(88);
        miLista.addOrdered(99);
        miLista.addOrdered(22);
//        miLista.addOrderedMaxToMin(89);
//        miLista.addOrderedMaxToMin(17);
//        miLista.addOrderedMaxToMin(58);
//        miLista.addOrderedMaxToMin(34);
//        miLista.addOrderedMaxToMin(45);
        
        SinglyLinkedList<Double> miListica = new SinglyLinkedList<>();
        miListica.addOrdered(1.1);
        miListica.addOrdered(3.3);
        miListica.addOrdered(4.0);
        miListica.addOrdered(8.8);
        miListica.addOrdered(9.9);
        miListica.addOrdered(2.2);
        miListica.addLast(6.6);
        miListica.addLast(7.7);
        
        try {
            miListica.deleteLast();
            miListica.deleteLast();
            miListica.deleteLast();
        } catch (Exception ex) {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Mostrar la lista
        System.out.println("Datos de la lista: \n"+ miLista.showData());
        //Mostrar la cantidad de datos de la lista
        System.out.println("Cantidad de datos de la lista: \n" + miLista.cantidadDatos());
        //Mostrar el mayor dato de la lista
        System.out.println("Mayor dato: \n" + miLista.masMayor());
        //Mostrar el menor dato de la lista
        System.out.println("Menor dato: \n" + miLista.masMenor());
        //Mostrar el promedio de la lista
        System.out.println("Promedio de datos: \n" + miLista.promedio());
        //Buscar un numero y decir si existe en la lista
        System.out.println("Ingrese el numero a buscar: ");
        int n = teclado.nextInt();
        String salida = "";
        if (miLista.buscar(n)) {
            salida="El dato existe en la lista";
        } else {
            salida="El dato no existe en la lista";
        }
        System.out.println(salida);
        //Insertar un numero al final de la lista
        System.out.println("Ingrese el numero a insertar al final de la lista");
        int n1 = teclado.nextInt();
        miLista.addLastVerificado(n1);
        //Crear una nueva lista con datos organizados de mayor a menor
        System.out.println("Ingrese el numero de nuevos datos para agregar a la nueva Lista ");
        int nDatos = teclado.nextInt();
        for (int i = 0; i < nDatos ; i++) {
            System.out.println("Ingrese el dato " + (i+1));
            int dato = teclado.nextInt();
            miListaMaxToMin.addOrderedMaxToMin(dato);
        }
        //Mostrar la lista organizada con datos de mayor a menor
        System.out.println("Datos de la lista: \n"+ miListaMaxToMin.showData());
        //Eliminar un dato especifico de la lista
        System.out.println("Ingrese el dato a eliminar");
        int borrar = teclado.nextInt();
        miLista.eliminarEspecifico(borrar);
        //Mostrar la lista despues de borrar el dato
        System.out.println("Nueva lista \n"+ miLista.showData());
        //Cambiar un dato de la lista
        System.out.println("Ingrese el numero a cambiar de la lista");
        int cambiar = teclado.nextInt();
        System.out.println("Nuevo numero ");
        int nuevo = teclado.nextInt();
        miLista.buscarCambiar(cambiar, nuevo);
        //Mostrar como quedo la listasss
        System.out.println("Nueva lista \n"+miLista.showData());
        miLista.mismoTamaño(nDatos);
    }
}
