import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    public static void menuStudents(){
        List<Students> students = ReadWriteFile.readFile();
        if(students == null){
            students = new ArrayList<>();
        }
        boolean check = true;
        while (check) {

            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
            System.out.println("Chọn chức năng để tiếp tục");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    StudentsController.showListStudents();
                    break;
                case 2:
                    StudentsController.addNewStudent();
                    break;
                case 3:
                    StudentsController.changeStudents();
                    break;
                case 4:
                    StudentsController.deleteStudents(students);
                    break;
                case 5:
                    StudentsController.arrgeStudents(students);
                    break;
                case 8:
                    check = false;
                    break;

            }
        }
    }

}
