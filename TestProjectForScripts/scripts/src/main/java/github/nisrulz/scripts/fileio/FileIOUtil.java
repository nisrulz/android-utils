package github.nisrulz.scripts.fileio;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class FileIOUtil {

  public static void saveHashMapToFile(Context context, String fileName,
      HashMap<String, String> h) {
    String filePath = context.getFilesDir().getPath().toString() + "/" + fileName;
    File f = new File(filePath);
    try {
      if (!f.exists()) {
        f.createNewFile();
      }

      ObjectOutputStream objOSt = new ObjectOutputStream(new FileOutputStream(f));
      objOSt.writeObject(h);
      objOSt.flush();
      objOSt.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static HashMap<String, String> loadHashMapFromFile(Context context, String fileName) {
    String filePath = context.getFilesDir().getPath().toString() + "/" + fileName;
    File f = new File(filePath);
    try {
      if (f.exists()) {

        ObjectInputStream objISt = new ObjectInputStream(new FileInputStream(f));

        HashMap<String, String> h = (HashMap<String, String>) objISt.readObject();
        objISt.close();
        System.out.println(h.get("c"));
        return h;
      } else {
        System.out.println("FILE DOESNOT EXIST !!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return new HashMap<>(1);
  }
}
