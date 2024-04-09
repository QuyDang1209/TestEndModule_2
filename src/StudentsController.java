import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentsController {
    public static void addNewStudent(){
        List<Students> students = ReadWriteFile.readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sinh viên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Giới tính (nam/nữ)");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập điểm trung bình");
        double score = Double.parseDouble(scanner.nextLine());
        students.add(new Students(id, name,age,gender,address,score));

        ReadWriteFile.writeFile(students);
    }
    public static void changeStudents(){
        List<Students> students = ReadWriteFile.readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên cần sửa ");
        int checkId = Integer.parseInt(scanner.nextLine());
        for (Students st : students){
            if(st.getId() == checkId){
                System.out.println("Nhập id mới" + st.getId());
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập tên mới của sinh viên "+st.getName());
                String name = scanner.nextLine();
                System.out.println("Nhập tuổi mới của sinh viên " +st.getName());
                int age = Integer.parseInt(scanner.nextLine()) ;
                System.out.println("Nhập giới tính (nam/nữ) " + st.getGender());
                String gender = (scanner.nextLine());
                System.out.println("Nhập số địa chỉ của sinh viên " + st.getAddress());
                String address =(scanner.nextLine());
                System.out.println("Nhập điểm trung binh của sinh viên " + st.getScore());
                double score = Double.parseDouble(scanner.nextLine());

                st.setId(id);
                st.setName(name);
               st.setAge(age);
               st.setGender(gender);
               st.setAddress(address);
               st.setScore(score);

                break;

            }

        }

    }
    public static void deleteStudents(List<Students> students){
        System.out.println("Nhập id sinh viên muốn xóa");
        Scanner scanner = new Scanner(System.in);
        String delete = scanner.nextLine();
        for(Students p: students){
            if(p.getName().equals(delete)){
                students.remove(p);
                break;
            }
        }
    }

    public static void arrgeStudents(List<Students> students){
        boolean check1 = true;
        while (check1){
            System.out.println("----Sắp xếp sinh viên theo điểm trung bình----");
            System.out.println("Chọn chức năng sắp xếp");
            System.out.println("1. Sắp xếp theo điểm trung bình tăng dần");
            System.out.println("2. Sắp xếp theo điểm trung bình giảm dần");
            System.out.println("3. thoát");
            Scanner scanner = new Scanner(System.in);
            int choose1= Integer.parseInt(scanner.nextLine());
            switch (choose1){
                case 1:
                    sortAvgD();
                case 2:
                   sortAvgU();
                    break;
                case 3:
                    check1 = false;
                    break;
            }
        }
    }
    public static void sortAvgD() {
        List<Students> students = ReadWriteFile.readFile();
        students.sort(Comparator.comparingDouble(Students::getScore));
        showListStudents();
    }
    public static void sortAvgU() {
        List<Students> students = ReadWriteFile.readFile();
        students.sort(Comparator.comparingDouble(Students::getScore).reversed());
        showListStudents();
    }
    public static void showListStudents(){
        List<Students> students = ReadWriteFile.readFile();
        System.out.printf("%10s|%10s|%10s|%10s|%10s|%10s","ID","NAME", "AGE","GENDER","ADDRESS","SCORE" +"\n");
        for (Students s : students){
            System.out.printf("%10s|%10s|%10s|%10s|%10s|%10s", s.getId(),s.getName(),s.getAge(),s.getGender(),s.getAddress(),s.getScore()+"\n");
        }
    }
}
