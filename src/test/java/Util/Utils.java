package Util;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    static String excelFilePath = "src/test/java/ExcelTools/Connections.xlsx";
    static String FilePath = "C:\\Users\\Bilal\\Downloads\\Basic_LinkedInDataExport_04-20-2023\\Connections.xlsx";

    /**
     * This method returns a list of connections.
     * Our links come sequentially for First Name.
     * If there is no copy of your Connections file under the ExcelTools folder, it will also create a Connections Copy.xlsx file for you.
     * Because when our Connections list deletes people who do not match our position preferences, it will also be deleted from Excel.
     *
     * @return: List <'Person'>
     */
    public static List<Person> getNormalList() throws IOException {
        List<Person> personList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int Column_first_Name = 0;
        int Column_last_Name = 0;
        int Column_Company_Name = 0;
        int Column_Position_Name = 0;
        Row row = sheet.getRow(0);
        for (Cell cell : row) {
            // Column header names.
            switch (cell.getStringCellValue()) {
                case "First Name" -> Column_first_Name = cell.getColumnIndex();
                case "Last Name" -> Column_last_Name = cell.getColumnIndex();
                case "Company" -> Column_Company_Name = cell.getColumnIndex();
                case "Position" -> Column_Position_Name = cell.getColumnIndex();
            }
        }

        for (Row r : sheet) {
            if (r.getRowNum() == 0) continue; //hearders
            Cell Cell_first_Name = r.getCell(Column_first_Name);
            Cell Cell_last_Name = r.getCell(Column_last_Name);
            Cell Cell_Company_Name = r.getCell(Column_Company_Name);
            Cell Cell_Position_Name = r.getCell(Column_Position_Name);

            Person person = new Person();
            person.First_Name = Cell_first_Name.toString();
            person.Last_Name = Cell_last_Name.toString();
            person.Company_Name = Cell_Company_Name == null ? "" : Cell_Company_Name.toString();
            person.Position_Name = Cell_Position_Name == null ? "" : Cell_Position_Name.toString();
            person.rowNumber = r.getRowNum();
            personList.add(person);
        }

        String sourceFile = excelFilePath;
        String destFile = "src/test/java/ExcelTools/Connections Copy.xlsx";

        File source = new File(sourceFile);
        File dest = new File(destFile);


        if (!dest.exists()) {
            try {
                Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return personList.stream()
                .sorted(Comparator.comparing(Person::getFirst_Name))
                .collect(Collectors.toList());
    }

    /**
     * This method is used to write the data in the Position column in the Connections list to the console without repeating it.
     * The data is sorted by the name Position.
     */
    public static void getPositionList() throws IOException {
        List<Person> personList = getNormalList()
                .stream()
                .distinct()
                .filter(person -> !person.getPosition_Name().isEmpty())
                .sorted(Comparator.comparing(Person::getPosition_Name))
                .toList();

        for (Person person : personList) {
            System.out.println("rowNumber: " + person.getRowNumber() + " - Position_Name: " + person.getPosition_Name());
        }
    }

    public static List<Person> getConnectionListForRemove() throws IOException {
        Properties properties = ConfigReader.initialize_Properties();
        List<Person> filteredPersons = getNormalList().stream()
                .filter(person -> !person.getFirst_Name().isEmpty() && !person.getFirst_Name().contains("?")
                        && !person.getLast_Name().isEmpty() && !person.getLast_Name().contains("?"))
                .collect(Collectors.toList());
        String positions = properties.getProperty("Positions").replaceAll(",+", ",")
                .endsWith(",") ? properties.getProperty("Positions") : properties.getProperty("Positions") + ",";

        filteredPersons.removeIf(person -> Arrays.stream(positions.split("\s*,\s*"))
                .anyMatch(needle -> find(person.getPosition_Name(), needle)));

        return filteredPersons.stream()
                .sorted(Comparator.comparing(Person::getFirst_Name))
                .collect(Collectors.toList());


//        Object[][] data = new Object[filteredPersons.size()][4];
//        for (int i = 0; i < filteredPersons.size(); i++) {
//            Person person = filteredPersons.get(i);
//            Object[] obj = new Object[5];
//            obj[0] = person.First_Name;
//            obj[1] = person.Last_Name;
//            obj[2] = person.Company_Name;
//            obj[3] = person.Position_Name;
//            obj[4] = person.rowNumber;
//            data[i] = obj;
//        }
//        Arrays.sort(data, (o1, o2) -> {
//            String name1 = (String) o1[0];
//            String name2 = (String) o2[0];
//            return name1.compareTo(name2);
//        });
////        if (DeleteList.size() > 0)
////            DeletewithRowNumberList(DeleteList);
//
//        return data;
    }

//    static List<Integer> DeleteList;

    public static Object[][] setConnectionListForRemove() throws Exception {

        List<Person> filteredPersons = getConnectionListForRemove();
        Object[][] data = new Object[filteredPersons.size()][4];
        for (int i = 0; i < filteredPersons.size(); i++) {
            Person person = filteredPersons.get(i);
            Object[] obj = new Object[5];
            obj[0] = person.First_Name;
            obj[1] = person.Last_Name;
            obj[2] = person.Company_Name;
            obj[3] = person.Position_Name;
            obj[4] = person.rowNumber;
            data[i] = obj;
        }


//        Properties properties = ConfigReader.initialize_Properties();
//        List<Person> filteredPersons = getNormalList().stream()
//                .filter(person -> !person.getFirst_Name().isEmpty() && !person.getFirst_Name().contains("?")
//                        && !person.getLast_Name().isEmpty() && !person.getLast_Name().contains("?"))
//                .collect(Collectors.toList());
//
//        Arrays.stream(properties.getProperty("Positions").split(","))
//                .forEach(position -> filteredPersons.removeIf(person -> find(person.getPosition_Name(), position)));


//        List<Person> personList = new ArrayList<>();
//        FileInputStream inputStream = new FileInputStream(excelFilePath);
//        Workbook workbook = WorkbookFactory.create(inputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//        DeleteList = new ArrayList<>();
//        int Column_first_Name = 0;
//        int Column_last_Name = 0;
//        int Column_Company_Name = 0;
//        int Column_Position_Name = 0;
//        Row row = sheet.getRow(0);
//        for (Cell cell : row) {
//            // Column header names.
//            switch (cell.getStringCellValue()) {
//                case "First Name" -> Column_first_Name = cell.getColumnIndex();
//                case "Last Name" -> Column_last_Name = cell.getColumnIndex();
//                case "Company" -> Column_Company_Name = cell.getColumnIndex();
//                case "Position" -> Column_Position_Name = cell.getColumnIndex();
//            }
//        }
//
//        for (Row r : sheet) {
//            if (r.getRowNum() == 0) continue;//hearders
//            Cell Cell_first_Name = r.getCell(Column_first_Name);
//            Cell Cell_last_Name = r.getCell(Column_last_Name);
//            Cell Cell_Company_Name = r.getCell(Column_Company_Name);
//            Cell Cell_Position_Name = r.getCell(Column_Position_Name);
//
//
//            if (Cell_first_Name != null && Cell_first_Name.getCellType() != CellType.BLANK && !Cell_first_Name.toString().contains("?") &&
//                    Cell_last_Name != null && Cell_last_Name.getCellType() != CellType.BLANK && !Cell_last_Name.toString().contains("?")) {
//                boolean check = false;
//
//                if (Cell_Position_Name != null)
//                    check = Arrays.stream(properties.getProperty("Positions")
//                            .split(",")).anyMatch(position -> find(Cell_Position_Name.toString(), position));
//
//                if (!check) {
//                    Person person = new Person();
//                    person.First_Name = Cell_first_Name.toString();
//                    person.Last_Name = Cell_last_Name.toString();
//                    person.Company_Name = Cell_Company_Name == null ? "" : Cell_Company_Name.toString();
//                    person.Position_Name = Cell_Position_Name == null ? "" : Cell_Position_Name.toString();
//                    person.rowNumber = r.getRowNum();
//                    if (!person.Company_Name.contains("?") &&
//                            !person.Position_Name.contains("?"))
//                        personList.add(person);
//                } else
//                    DeleteList.add(r.getRowNum());
//            } else
//                DeleteList.add(r.getRowNum());
//        }

//        Object[][] data = new Object[getConnectionListForRemove().size()][4];
//        for (int i = 0; i < getConnectionListForRemove().size(); i++) {
//            Person person = getConnectionListForRemove().get(i);
//            Object[] obj = new Object[5];
//            obj[0] = person.First_Name;
//            obj[1] = person.Last_Name;
//            obj[2] = person.Company_Name;
//            obj[3] = person.Position_Name;
//            obj[4] = person.rowNumber;
//            data[i] = obj;
//        }
//        Arrays.sort(data, (o1, o2) -> {
//            String name1 = (String) o1[0];
//            String name2 = (String) o2[0];
//            return name1.compareTo(name2);
//        });
////        if (DeleteList.size() > 0)
////            DeletewithRowNumberList(DeleteList);
//
        return data;
    }

    public static void typePositionsForFilter() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder positions = new StringBuilder();
        Properties prop = new Properties();
        int i = 1;

        System.out.print("Do you want to add positions to existing positions? (1: Yes, 2: No): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            try (InputStream input = new FileInputStream("Configs/Positions.properties")) {
                prop.load(input);
                String existingPositions = prop.getProperty("Positions");
                if (existingPositions != null && !existingPositions.trim().isEmpty()) {
                    positions.append(existingPositions).append(", ");
                }
            } catch (IOException io) {
                System.err.println("File read error: " + io.getMessage());
            }
        }

        while (true) {
            System.out.print("Position " + i + ": ");
            String position = scanner.nextLine();
            positions.append(position).append(",");

            System.out.print("Add another position? (1: Yes, 2: No): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                break;
            }
            i++;
        }

        prop.setProperty("Positions", positions.toString());

        try (OutputStream output = new FileOutputStream("Configs/Positions.properties")) {
            prop.store(output, "Position Information");
            System.out.println("Data successfully written to file.");
        } catch (IOException io) {
            System.err.println("File write error: " + io.getMessage());
        }
        scanner.close();
    }


    public static void DeleteWithRowNumberList(List<Integer> rowNumber) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        rowNumber.forEach(number -> sheet.removeRow(sheet.getRow(number)));
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public static void DeletewithRowNumber(int rowNumber) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        sheet.removeRow(sheet.getRow(rowNumber));
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }


    public static boolean find(String haystack, String needle) {
        Pattern p = Pattern.compile(needle, Pattern.LITERAL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(haystack);
        return m.find();
    }
}
