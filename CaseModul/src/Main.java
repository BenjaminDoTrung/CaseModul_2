import ManageTemplates.ManageTemplates;
import SampleType.ManageSampleType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageSampleType.addType();
        String part = "C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\fileTemplateNew.csv";
        ManageTemplates.readFile(part);
        ManageTemplates.checkPassWord();
        while (true){
            System.out.println("Menu:");
            System.out.println("1. AddTemplate (Thêm mẫu mới vào danh sách)");
            System.out.println("2. Delete By CompanyName (xóa mẫu theo tên công ty)");
            System.out.println("3. Delete by id (xóa mẫu theo id)");
            System.out.println("4. Show list template (hiển thị danh sách mẫu)");
            System.out.println("5. EditByID (sửa thông tin mẫu theo id)");
            System.out.println("6. DisPlay By Name (hiển thị mẫu theo tên)");
            System.out.println("7. DisPlay By Price (hiển thị mẫu theo giá)");
            System.out.println("8. Add Sample Type (thêm loại mẫu mới)");
            System.out.println("9. Delete Sample Type (xóa loại mẫu)");
            System.out.println("10. Delete template by sample type (xóa mẫu theo loại mẫu)");
            System.out.println("11. Add file list template new (thêm đồng thời nhiều sản phẩm được lấy từ file)");
            System.out.println("12. Show List Type Template (Hiển thị loại mẫu)");
            System.out.println("0. Log off");
            System.out.println();
            System.out.println("Choose a method");
            int check = 0;
           do {
               try {
                   Scanner scanner = new Scanner(System.in);
                   int choose = Integer.parseInt(scanner.nextLine());

                   switch (choose){
                       case 1:
                           ManageTemplates.addTemplate();
                           check = 6;
                           break;
                       case 2:
                           ManageTemplates.deleteByCompanyName();
                           check = 6;
                           break;
                       case 3:
                           ManageTemplates.deleteByID();
                           check = 6;
                           break;
                       case 4:
                           ManageTemplates.showList();
                           check = 6;
                           break;
                       case 5:
                           ManageTemplates.editByID();
                           check = 6;
                           break;
                       case 6:
                           ManageTemplates.disPlayByName();
                           check = 6;
                           break;
                       case 7:
                           ManageTemplates.disPlayByPrice();
                           check = 6;
                           break;
                       case 8:
                           ManageSampleType.addSampleType();
                           check = 6;
                           break;
                       case 9:
                           ManageSampleType.deleteSampleType();
                           check = 6;
                           break;
                       case 10:
                           ManageTemplates.deleteByType();
                           check = 6;
                           break;
                       case 11:
                           System.out.println("Nhập vào đường dẫn đến file");
                           String partFileRead = scanner.nextLine();
                           ManageTemplates.readFile(partFileRead);
                           ManageTemplates.writeListFile(part,false);
                           check = 6;
                           break;
                       case 12:
                           ManageSampleType.showListTypeTemplate();
                           check = 6;
                           break;
                       case 0:
                           System.exit(0);
                           check = 6;
                           break;
                   }
               } catch (Exception e){
                   System.out.println("Chọn lại");
                   check++;
               }
           } while (check < 2);
        }
    }
}