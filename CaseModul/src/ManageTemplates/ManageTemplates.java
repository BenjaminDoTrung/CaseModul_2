package ManageTemplates;

import SampleType.ManageSampleType;
import SampleType.SampleType;
import Template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManageTemplates implements Serializable{

    public static List<Template> listTemplate = new ArrayList<>();
    public static List<Integer> listIdDelete = new ArrayList<>();


    public static void readFile(String path) {

        try {
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            SampleType type;
            while (true) {
                line = bf.readLine();
                if (line == null) {
                    break;
                }
                String[] csv = line.split(",");
                String name = csv[0];
                int id = ManageTemplates.addIdNew();
                int price = Integer.parseInt(csv[1]);
                type = new SampleType(String.format(csv[2]));
                String condition = csv[3];
                String company = csv[4];
                Template template = new Template(name, id, price, type, condition, company);
                ManageTemplates.listTemplate.add(template);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeListFile(String part, boolean trueAndFlase){
        try {
            FileWriter fr = new FileWriter(part, trueAndFlase);
            BufferedWriter br = new BufferedWriter(fr);

            for (int i = 0; i < listTemplate.size();i++) {
               String noiDung = listTemplate.get(i).getName() + "," + listTemplate.get(i).getPrice() +
                        "," + listTemplate.get(i).getType().getName() + "," + listTemplate.get(i).getCondition() +
                        "," + listTemplate.get(i).getCompanyName() + "\n";
               br.write(noiDung);
            }
            br.close();
        } catch (Exception e){
            System.err.println("Mọe mày lỗi");
        }
    }
    public static void writeOneObject(String noiDung, String part, boolean trueAndFlase){
        try {
            FileWriter fw = new FileWriter(part, trueAndFlase);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(noiDung);
            bw.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addTemplate() {          // phương thức thêm mẫu mới vào danh sách
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a name:"); // nhập vào tên
            String name = scanner.nextLine();

            int id = ManageTemplates.addIdNew();

            System.out.println("Enter price");      // Nhập vào giá
            int price = Integer.parseInt(scanner.nextLine());

            System.out.println("Choose a template type");  // chọn loại mẫu
            ManageSampleType.showListTypeTemplate();
            int number = Integer.parseInt(scanner.nextLine());
            SampleType type = ManageSampleType.listSampleType.get(number - 1);

            System.out.println("Select status");        //Chọn trạng thái
            System.out.println("1. " + "unanalyzed" + "\n"
                    + "2. " + "analyzed" + "\n"
                    + "3. " + "doneAnalyzed" + "\n");
            int number1 = Integer.parseInt(scanner.nextLine());
            String condition = "";
            switch (number1) {
                case 1:
                    condition = "unanalyzed";
                    break;
                case 2:
                    condition = "analyzed";
                    break;
                case 3:
                    condition = "doneAnalyzed";
                    break;
            }
            System.out.println("Enter a company name");      //Nhập vào tên công ty
            String companyName = scanner.nextLine();

            Template template = new Template(name, id, price, type, condition, companyName);
            listTemplate.add(template);
            ManageTemplates.showList();
            String noiDung = name + "," + price + "," + type.getName() + "," + condition + "," + companyName + "\n";
            String part = "C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\fileTemplateNew.csv";
            ManageTemplates.writeOneObject(noiDung, part, true);
        } catch (Exception x) {
            System.out.println("Incorrect entry (Lỗi rồi)");          //Nhập không đúng
            x.printStackTrace();
        }
    }

    public static int addIdNew() {
        int id = 0;
        if (listTemplate.size() == 0) {
            id = 0;
        } else {
            if (0 == listIdDelete.size()) {
                id = listTemplate.size();
            } else {
                listIdDelete.sort((o1, o2) -> o1 - o2);
                id = listIdDelete.get(0);
                listIdDelete.remove(0);
            }
        }
        return id;
    }

    public static void checkPassWord() {       // Phương thức check đăng nhập
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println("Enter a Username");
            String use = scanner.nextLine();
            Pattern p = Pattern.compile("^[A-Z]{1}[a-z0-9]{4,30}(@gmail.com)$");
            String useName = "Trung96@gmail.com";

            System.out.println("Enter pass word");
            String passWord = scanner.nextLine();
            Pattern p1 = Pattern.compile("^[a-z0-9]*$");
            String pass = "123456";
            if (p.matcher(use).matches() && p1.matcher(passWord).matches()
                    && passWord.equals(pass) && use.equals(useName)) {
                check = false;
            } else {
                System.out.println("Wrong password or username");
            }
        } while (check);
    }

    public static void deleteByCompanyName() {           // phương thức xóa theo tên công ty
      try {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter the company name you want to delete");      // nhập vào tên công ty muốn xóa
          String companyName = scanner.nextLine();
          for (int i = 0; i < listTemplate.size(); i++) {
              if (companyName.equals(listTemplate.get(i).getCompanyName())) {
                  listIdDelete.add(listTemplate.get(i).getId());
                  listTemplate.remove(i);
              }
          }
          String part = "C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\newFileTemplate.csv";
          ManageTemplates.writeListFile(part, true);
      } catch (Exception e){
          System.err.println("Chọn lại");
      }
    }

    public static void deleteByID() {       // phương thức xóa theo id
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id you want to delete");      // nhập vào id muốn xóa
        int id = scanner.nextInt();
        String part = "C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\newFileTemplate.csv";
        for (int i = 0; i < listTemplate.size(); i++) {
            if (listTemplate.get(i).getId() == id) {
                listIdDelete.add(listTemplate.get(i).getId());
                listTemplate.remove(i);
                ManageTemplates.writeListFile(part, false);
            }
        }
    }

    public static void showList() {          // phương thức hiển thị danh sách mẫu
        for (int i = 0; i < listTemplate.size(); i++) {
            System.out.println(i + " Name: " + listTemplate.get(i).getName() + ";" +
                    " Id: " + listTemplate.get(i).getId() + ";" + " Price: " + listTemplate.get(i).getPrice() + ";" + " Sample Type: " +
                    listTemplate.get(i).getType().getName() + ";" + " Condition: "
                    + listTemplate.get(i).getCondition() + ";" + " Company: " +
                    listTemplate.get(i).getCompanyName());
        }
    }

    public static void editByID() {          // sửa theo id
        ManageTemplates.showList();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter id template you want to edit (Nhập vào id bạn muốn sửa)");
        int id = scanner.nextInt();
        for (int i = 0; i < listTemplate.size(); i++) {
            if (id == listTemplate.get(i).getId()) {

                System.out.println("Enter a new name");     // nhập vào tên
                listTemplate.get(i).setName(scanner1.nextLine());

                System.out.println("Entrer new price template");    // nhập vào giá
                listTemplate.get(i).setPrice(scanner.nextInt());

                System.out.println("Choose a template type");  // chọn loại mẫu
                ManageSampleType.showListTypeTemplate();
                int number = scanner.nextInt();
                SampleType type = new SampleType(ManageSampleType.listSampleType.get(number-1).getName());
                listTemplate.get(i).setType(type);

                System.out.println("Select status");                   //Chọn trạng thái
                System.out.println("1. " + "unanalyzed" + "\n"
                        + "2. " + "analyzed" + "\n"
                        + "3. " + "doneAnalyzed" + "\n");

                int number1 = scanner.nextInt();
                String condition = "";
                switch (number1) {
                    case 1:
                        condition = "unanalyzed";
                        break;
                    case 2:
                        condition = "analyzed";
                        break;
                    case 3:
                        condition = "doneAnalyzed";
                        break;
                }
                listTemplate.get(i).setCondition(condition);

                System.out.println("Enter new name company");       // nhập vào tên công ty
                listTemplate.get(i).setCompanyName(scanner1.nextLine());

                String part = "C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\newFileTemplate.csv";
                ManageTemplates.writeListFile(part, false);
            }
        }
    }

    public static void disPlayByName() {        // phương thức hiển thị theo tên
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name");
        String name = scanner.nextLine();
        for (int i = 0; i < listTemplate.size(); i++) {
            if (name.equals(listTemplate.get(i).getName())) {
                System.out.println(listTemplate.get(i).toString());
            } else {
                System.out.println("Template Does not exist");
            }
        }
    }

    public static void disPlayByPrice() {       // phương thức hiển thị theo giá
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a price");
        int name = scanner.nextInt();
        for (int i = 0; i < listTemplate.size(); i++) {
            if (name == listTemplate.get(i).getPrice()) {
                System.out.println(listTemplate.get(i).toString());
            } else {
                System.out.println("Price Does not exist");
            }
        }
    }

    public static void deleteByType() {         // phương thức xóa theo loại mẫu
        int check = 0;
       do {
           try {
               Scanner scanner = new Scanner(System.in);
               ManageSampleType.showListTypeTemplate();
               System.out.println("Nhập vào loại");
               String name = scanner.nextLine();
               String part = "C:\\Users\\admin\\Desktop\\java\\CaseModul\\src\\File\\newFileTemplate.csv";
               for (int i = 0; i < listTemplate.size(); i++) {
                   if (name.equals(listTemplate.get(i).getType().getName())) {
                       listIdDelete.add(listTemplate.get(i).getId());
                       listTemplate.remove(i);
                       check = 3;
                       ManageTemplates.writeListFile(part, true);
                       System.out.println("Deleted");
                   }
               }
           }catch (Exception e){
               e.printStackTrace();
               check++;
           }
       }while (check < 2);
    }
    public static void suaTrangThai(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập vào id");
        int id = scanner.nextInt();
        for (int i = 0; i < listTemplate.size(); i++) {
            if (id == listTemplate.get(i).getId()){
                System.out.println("Chọn trạng thái");
                for (int j = 0; j < ManageSampleType.listSampleType.size(); j++) {
                    System.out.println((i + 1) + ": " + ManageSampleType.listSampleType.get(i).getName());
                }
                int number = scanner.nextInt();
                if (number == 1){
                    listTemplate.get(i).setCondition(ManageSampleType.listSampleType.get(number - 1).getName());
                } else if (number == 2){
                    listTemplate.get(i).setCondition(ManageSampleType.listSampleType.get(number - 1).getName());
                } else if (number == 3){
                    listTemplate.get(i).setCondition(ManageSampleType.listSampleType.get(number - 1).getName());
                }
            }
        }
    }
}
