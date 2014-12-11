/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instantmessenger;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Saketh
 */
public class msgRecv extends Thread{
    Socket sock;
    String frnd;
    
    public msgRecv(Socket s, String f){
        this.sock = s;
        this.frnd = InstantMessenger.remUser;
    }
    
    @Override
    public void run(){
        String msg;
        try {
            DataInputStream inp = new DataInputStream(sock.getInputStream());
            while(true){
                msg = inp.readUTF();
                InstantMessenger.chatPage.msgArea.append(frnd+": "+msg+"\n");
            }
        } catch (IOException ex) {
            //Logger.getLogger(msgRecv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
