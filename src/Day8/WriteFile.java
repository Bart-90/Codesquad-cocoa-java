package Day8;

import java.io.*;

public class WriteFile {

    public static void main(String[] args) {

         String directory = "c:\\AccountBook\\test1.csv";

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bfw = null;

        try {
            fos = new FileOutputStream(directory);
            osw = new OutputStreamWriter(fos, "MS949");
            bfw = new BufferedWriter(osw);
            bfw.write("test");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(fos != null) { try { fos.close(); } catch (IOException e) { e.printStackTrace(); }}
            if(osw != null) { try { fos.close(); } catch (IOException e) { e.printStackTrace(); }}
            if(bfw != null) { try { fos.close(); } catch (IOException e) { e.printStackTrace(); }}
        }




    }

}
