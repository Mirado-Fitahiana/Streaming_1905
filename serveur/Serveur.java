package serveur;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javazoom.jl.player.Player;

public class Serveur {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("En attente d'un client");
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        /*song directory */
        File song = new File("./playlist");
        File[] listeSong = song.listFiles();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeInt(listeSong.length);
        for (int i = 0; i < listeSong.length; i++) {
                oos.writeObject(listeSong[i].getName());
                System.out.println(listeSong[i].getName());            
        }
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String title = dis.readUTF();
        File file = new File(title);
        System.out.println(file.getName());
        String dir = "./playlist/";
        FileInputStream fileInputStream = new FileInputStream(dir+file);
        DataOutputStream dos = new DataOutputStream(outputStream);
        if (file.getName().endsWith(".mp4") || file.getName().endsWith(".mp3") ) {
            while (true) {
                byte[] array = new byte[1024];
                fileInputStream.read(array);
                dos.write(array); 
                dos.flush();
                System.out.println(fileInputStream.available());
                if (fileInputStream.available() == 0) {
                    System.out.println("envoyee");
                    break;
                }
            } 
        }
        if (file.getName().endsWith(".JPG") || file.getName().endsWith(".jpg")) {
           
            BufferedInputStream in=new BufferedInputStream(fileInputStream);
            byte[] b=in.readAllBytes();
            ByteArrayInputStream inputStream=new ByteArrayInputStream(b);
            BufferedImage Bi =  ImageIO.read(inputStream);
            System.out.println(Bi.getClass());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(Bi, "JPG", baos);
            byte[] size = ByteBuffer.allocate(4).putInt(baos.size()).array();
            dos.write(size);
            dos.write(baos.toByteArray());
            dos.flush();
           
        }
        // outputStream.close();
        // fileInputStream.read(array);
        // outputStream.write(array);
    }
}