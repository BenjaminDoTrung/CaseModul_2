package SampleType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageSampleType {

    public static List<SampleType> listSampleType = new ArrayList<>();

    public static void addType(){
        try {
            FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\fileSamplateType.csv");
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                SampleType sampleType = new SampleType(line);
                listSampleType.add(sampleType);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addSampleType(){         //Phương thức thêm loại mẫu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the template type");          // Nhập vào loại mẫu
        String name = scanner.nextLine();
        SampleType sampleType = new SampleType(name);
        listSampleType.add(sampleType);
    }
    public static void deleteSampleType(){            // phương thức xóa loại mẫu
        System.out.println("Enter the type you want to delete");            // Nhập vào loại muốn xóa
        for (int i = 0; i < listSampleType.size(); i++) {
            System.out.println((i + 1) + ": " + listSampleType.get(i).getName());
        }
        int check = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                int number = scanner.nextInt();
                for (int i = 0; i < listSampleType.size(); i++) {
                    if (number == (i + 1)) {
                        listSampleType.remove(number -1);
                        check = 4;
                        System.err.println("Deleted");
                        break;
                    }
                }
            } catch (Exception e){
                System.err.println("Yêu cầu nhập lại bằng số");
                check++;
            }
        }while (check < 3);
    }
    public static void showListTypeTemplate() {        // Phương thức hiển thị danh sách loại mẫu
        for (int i = 0; i < ManageSampleType.listSampleType.size(); i++) {
            System.out.println("kind " + (i + 1) + ": " + ManageSampleType.listSampleType.get(i).getName()); // kind: loại
        }
    }
}
