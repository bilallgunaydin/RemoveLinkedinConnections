package Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class CheckForConnectionValues {

    public static void main(String[] args) throws Exception {
//        getNormalList();
//        getPositionList();
//        getConnectionListForRemove();
//        DeletewithRowNumber(0);// The number is example. Do not use the number.
//        ArrayList<Integer> RowNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));// The numbers are examples. Do not use these Numbers.
//        DeleteWithRowNumberList(RowNumberList);
        typePositionsForFilter();
    }

    /**
     * This method is used to write the Connections list to the console.
     * Our links come sequentially for First Name.
     * If there is no copy of your Connections file under the ExcelTools folder, it will also create a Connections Copy.xlsx file for you.
     * Because when our Connections list deletes people who do not match our position preferences, it will also be deleted from Excel.
     */
    public static void getNormalList() throws IOException {
        Utils.getNormalList().forEach(System.out::println);
    }

    /**
     * This method is used to write the data in the Position column in the Connections list to the console without repeating it.
     * The data is sorted by the name Position.
     */
    public static void getPositionList() throws IOException {
        Utils.getPositionList();
    }

    public static void getConnectionListForRemove() throws Exception {
        System.out.println("Possible number of Connections. to be deleted: " + Utils.getConnectionListForRemove().size());
        Utils.getConnectionListForRemove().forEach(System.out::println);
    }

    public static void DeletewithRowNumber(int number) throws IOException {
        Utils.DeletewithRowNumber(number);
    }

    public static void DeleteWithRowNumberList(ArrayList<Integer> rowNumber) throws IOException {
        Utils.DeleteWithRowNumberList(rowNumber);
    }

    public static void typePositionsForFilter() {
        Utils.typePositionsForFilter();
    }

}
