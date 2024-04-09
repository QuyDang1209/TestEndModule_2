import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private static String filePath = "./data/student.txt";

    public static void writeFile(List<Students> students) {
        File file = new File(filePath);

        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (Students s : students) {
                printWriter.write(s.toString());

            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Students> readFile() {
        List<Students> students = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String[] items = line.split(",");
                Students p = new Students();
                p.setId(Integer.parseInt(items[0]));
                p.setName(items[1]);
                p.setAge(Integer.parseInt(items[2]));
                p.setGender((items[3]));
                p.setAddress(items[4]);
                p.setScore(Float.parseFloat((items[5])));
                students.add(p);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;

    }
}
