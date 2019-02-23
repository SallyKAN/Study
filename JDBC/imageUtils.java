package java.JDBC;

import java.io.*;

public class imageUtils {
    private static File file = null;
    public static FileInputStream getImageByte(String path){
        FileInputStream imageByte = null;
        file = new File(path);
        try {
            imageByte = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageByte;
    }
    public static void readBlob(InputStream inputStream, String path){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            inputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
