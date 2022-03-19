package task131;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[][] df = {
                {"Games\\src", ""},
                {"Games\\rec", ""},
                {"Games\\savegames", ""},
                {"Games\\temp", ""},
                {"Games\\src\\main", ""},
                {"Games\\src\\test", ""},
                {"Games\\src\\main", "Main.java"},
                {"Games\\src\\main", "Utils.java"},
                {"Games\\rec\\drawables", ""},
                {"Games\\rec\\vectors", ""},
                {"Games\\rec\\icons", ""},
                {"Games\\temp", "temp.txt"}
        };

        for (int i = 0; i < df.length; i++) {
            if (df[i][1].equals("")) {
                createDir(df[i][0]);
            } else {
                createFile(df[i][0], df[i][1]);
            }
        }

        String ss = sb.toString();
        try (FileWriter writer = new FileWriter("Games\\temp\\temp.txt")) {
            writer.write(ss);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createFile(String path, String name) {
        File file = new File(path, name);
        try {
            if (file.createNewFile()) {
                sb.append("File " + file.getName() + " is created\n");
            } else {
                System.out.println("Error");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void createDir(String path) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            sb.append("Folder " + dir.getName() + " is created\n");
        } else {
            System.out.println("Error");
        }
    }
}
