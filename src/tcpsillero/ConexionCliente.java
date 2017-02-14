/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsillero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafa
 */
public class ConexionCliente {

    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        String Host = "localhost";
        int Puerto = 6000;//puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket s = new Socket(Host, Puerto);
//Flujo de entrada para objetos
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
//Se recibe un objeto
        List listaCliente = (ArrayList) ois.readObject();//recibo objeto
        System.out.println("Recibo: " + listaCliente);
//FLUJO DE salida para objetos
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
// Se envia el objeto 
        List listaClienteEnviar = new ArrayList<String>();
        listaClienteEnviar.add("adios");
        listaClienteEnviar.add("jesus");
        oos.writeObject(listaClienteEnviar);

        System.out.println("Envio: " + listaClienteEnviar);

// CERRAR STREAMS Y SOCKETS 
        ois.close();
        oos.close();
        s.close();
    }
}
