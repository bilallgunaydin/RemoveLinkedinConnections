package Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class CheckForConnectionValues {

    public static void main(String[] args) throws Exception {
//    getNormalList();
//        getPositionList();
//        getConnectionListForRemove();
//        DeletewithRowNumber(0);// The number is example. Do not use the number.
//        ArrayList<Integer> RowNumberList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));// The numbers are examples. Do not use these Numbers.
//        DeleteWithRowNumberList(RowNumberList);
//        typePositionsForFilter();
    }

    public static void getNormalList() throws IOException {
        Utils.getNormalList().forEach(System.out::println);
    }

    public static void getPositionList() throws IOException {
        Utils.getPositionList();
    }

    public static void getConnectionListForRemove() throws Exception {
        System.out.println("Possible number of Connections. to be deleted: " + Utils.getConnectionListForRemove().size());
        Utils.getConnectionListForRemove().forEach(System.out::println);
    }

    public static void DeletewithRowNumber(int rowNumber) throws IOException {
        Utils.DeletewithRowNumber(rowNumber);
    }

    public static void DeleteWithRowNumberList(ArrayList<Integer> rowNumberList) throws IOException {
        Utils.DeleteWithRowNumberList(rowNumberList);
    }

    public static void typePositionsForFilter() {
        Utils.typePositionsForFilter();
    }
}
