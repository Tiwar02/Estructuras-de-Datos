/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author s208e19
 */
public class SinglyLinkedList<T extends Comparable> implements Ilist<T> {

    private Node<T> head;
    private int x;
    private int count;

    public SinglyLinkedList() {
        this.head = null;
    }

    @Override
    public void add(T d) {
        //crear el nuevo nodo
        //el siguiente del nuevo nodo = cabeza
        //actualizar cabeza = nuevo nodo

        Node<T> newNode = new Node<>(d);
        newNode.setNextNode(this.head);
        this.head = newNode;

    }

    @Override
    public void addOrdered(T d) {
        /*
         Crear un nodo para el nuevo dato.
         Si la lista esta vacía, o el valor del primer elemento de la lista 
         es mayor que el nuevo, insertar el nuevo nodo en la primera posición 
         de la lista y modificar la cabecera respectivamente.
        
         */

        Node<T> newNode = new Node<>(d);
        //Contar los elementos de la lista
        count++;

        if (isEmpty() || d.compareTo(this.head.getData()) == -1) {
            newNode.setNextNode(this.head);
            this.head = newNode;
        } else {
            /* 
             Si no se cumple el caso anterior, buscar el lugar adecuado 
             para la inserción: recorrer la lista conservando el nodo actual. 
             Inicializar nodo actual con el valor de primera posición, 
             y avanzar mientras el siguiente nodo no sea nulo y el dato 
             que contiene la siguiente posición sea menor o igual que 
             el dato a insertar.

             */
            Node<T> current = this.head;//
            while (current.getNextNode() != null
                    && d.compareTo(current.getNextNode().getData()) == 1) {
                current = current.getNextNode();

            }


            /*
             Con esto se señala al nodo adecuado, 
             a continuación insertar el nuevo nodo a continuación de él.
             */
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);

        }

    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String showData() {
        String data = "";
        Node<T> current = this.head;
        while (current != null) {
            data = data + current.getData() + " ";
            current = current.getNextNode();
        }
        return data;
    }

    @Override
    public void addLast(T d) {
        if (isEmpty()) {
            add(d);
        } else {
            Node<T> newNode = new Node<>(d);
            Node<T> current = this.head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);

        }

    }

    @Override
    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar");
        } else {
            this.head = head.getNextNode();
        }
    }

    @Override
    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("No existen datos por borrar");
        } else {
            Node<T> current = this.head;
            while (current.getNextNode().getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(null);
        }
    }

    //Mostrar la cantidad de datos de la lista
    public int cantidadDatos() {
        return count;
    }

    //Obtener el mayor numero de la lista
    public T masMayor() {
        T mayor = this.head.getData();
        Node<T> current = this.head;

        while (current != null) {

            if (mayor.compareTo(current.getData()) == -1) {
                mayor = current.getData();
            }
            current = current.getNextNode();
        }
        return mayor;
    }

    //Obtener el menor numero de la lista
    public T masMenor() {
        T menor = this.head.getData();
        Node<T> current = this.head;

        while (current != null) {

            if (menor.compareTo(current.getData()) == 1) {
                menor = current.getData();
            }
            current = current.getNextNode();
        }
        return menor;
    }

    //Obtener el promedio de la lista
    public double promedio() {

        double suma = 0;
        Node<T> current = this.head;

        while (current != null) {
            suma += Double.parseDouble(current.getData().toString());
            current = current.getNextNode();
        }
        double prom = suma / count;
        return prom;
    }

//    Buscar un dato en la lista
    public boolean buscar(T d) {
        Node<T> current = this.head;
        boolean encontrado = false;
        while (current != null) {

            if (d.compareTo(current.getData()) == 0) {
                encontrado = true;
            }
            current = current.getNextNode();
        }
        return encontrado;
    }
    // Añadir un nodo al final de la lista, comprobando si ya existe
    public void addLastVerificado(T d) {
        if (isEmpty()) {
            add(d);
        } else {
            if (buscar(d)) {
                System.out.println("El dato ya existe");
            } else {
                Node<T> newNode = new Node<>(d);
                Node<T> current = this.head;
                while (current.getNextNode() != null) {
                    current = current.getNextNode();
                }
                current.setNextNode(newNode);
                System.out.println("El dato fue agregado correctamente");
            }
        }
    }

    // Crear una lista con datos de mayor a menor
    public void addOrderedMaxToMin(T d) {
        Node<T> newNode = new Node<>(d);
        count++;
        if (buscar(d)) {
            System.out.println("El dato ya existe");
        } else {
            if (isEmpty() || d.compareTo(this.head.getData()) == 1) {
                newNode.setNextNode(this.head);
                this.head = newNode;
            } else {
                Node<T> current = this.head;
                while (current.getNextNode() != null
                        && d.compareTo(current.getNextNode().getData()) == -1) {
                    current = current.getNextNode();
                }
                newNode.setNextNode(current.getNextNode());
                current.setNextNode(newNode);
            }
            System.out.println("El dato fue agregado correctamente");
        }
    }
    // Cambiar un nodo en especifico por un nuevo dato
    public boolean buscarCambiar(T d, T n) {
        Node<T> current = this.head;
        boolean encontrado = false;
        while (current != null) {

            if (d.compareTo(current.getData()) == 0) {
                encontrado = true;
                current.setData(n);
            }
            current = current.getNextNode();
        }
        return encontrado;
    
    } 

    //Eliminar un nodo especifico 
    public void eliminarEspecifico(T d)
    {
        Node<T> current = this.head;
        if(current.getData()==d)
        {
            this.head= current.getNextNode();
        }
        else
        {
            while (current.getNextNode().getData()!=d) {
                current= current.getNextNode();
            }
            current.setNextNode(current.getNextNode().getNextNode());
        }
    }
    // Verificar si las listas tienen el mismo tamaño
    public void mismoTamaño(int d)
    {
        
        if(count==d)
        {
            System.out.println("Las listas tienen el mismo tamaño \n");
        }
        else
        {
            System.out.println("Las listas son de diferente tamaño \n");
        }
    }
    
   
}
