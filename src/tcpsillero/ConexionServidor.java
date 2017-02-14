/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpsillero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafa
 */
public class ConexionServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente:");
        Socket s = servidor.accept();
// Se prepara un flujo de salida para objetos
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()); // Se prepara un objeto y se envia 
        List lista = new ArrayList<String>();
        lista.add("hola");
        oos.writeObject(lista); //enviando objeto
        System.out.println("Envio: " + lista);
// Se obtiene un stream para leer objetos
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        List listaRecibida = (List) ois.readObject();
        System.out.println("Recibo: " + listaRecibida);
// CERRAR STREAMS Y SOCKETS 
        oos.close();
        ois.close();
        s.close();
        servidor.close();
    }
}
