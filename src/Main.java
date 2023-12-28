import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.lang.StringBuilder;

public class Main {
    static StringBuilder builder;

    public static void main(String[] args) {

        List<String> directories = List.of(
                "C:/Users/Виталий/netology/Games/src/",
                "C:/Users/Виталий/netology/Games/res",
                "C:/Users/Виталий/netology/Games/savegames",
                "C:/Users/Виталий/netology/Games/temp",
                "C:/Users/Виталий/netology/Games/src/main",
                "C:/Users/Виталий/netology/Games/src/test",
                "C:/Users/Виталий/netology/Games/res/drawables",
                "C:/Users/Виталий/netology/Games/res/vectors",
                "C:/Users/Виталий/netology/Games/res/icons");

        createDirectory(directories);

        List<String> folders = List.of(
                "C:/Users/Виталий/netology/Games/src/main/Main.java",
                "C:/Users/Виталий/netology/Games/src/main/Utils.java",
                "C:/Users/Виталий/netology/Games/temp/temp.txt");

        createFile(folders);

    }

    public static void createDirectory(List<String> directories) {
        Date date = new Date();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < directories.size(); i++) {
            File f = new File(directories.get(i));
            boolean created = f.mkdir();
            if (created) {
                builder.append(date).append(" папка ").append(directories.get(i)).append(" успешно создана ").append("\n");

            } else builder.append(date).append(" папка ").append(directories.get(i)).append(" не создана ").append("\n");

        }
        creatLog(builder);
    }

    public static void createFile(List<String> folders) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < folders.size(); j ++) {
            File newFile = new File(folders.get(j));
            Date date = new Date();

            try {
                boolean created = newFile.createNewFile();
                if (created) {
                    builder.append(date).append(" файл ").append(folders.get(j)).append(" успешно создана").append("\n");
                } else builder.append(date).append(" файл ").append(folders.get(j)).append(" не создан").append("\n");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }creatLog(builder);
    }

    public static void creatLog(StringBuilder builder) {
        try (FileWriter writer = new FileWriter("C:/Users/Виталий/netology/Games/temp/temp.txt", true)) {
            writer.write(String.valueOf(builder));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}