package org.example.gridPrinting;

import java.util.ArrayList;
import java.util.List;

public class TestCaseGrid {
    public static void main(String[] args) {
        List<Data> list = new ArrayList<>();
        list.add(new Data("testClickOnCloseOptionsButtonDisplayed_TR_C1203_TR_C1204", "TC739798"));
        list.add(new Data("testClickableListAndGuideView_TR_C2267_TR_C2851", "TC739796"));
        list.add(new Data("testMultiPackageMileageMilestones_TR_C1199", "TC739804"));
        list.add(new Data("testShowDetailsButtonDisplay_TR_C1192_TR_C2847", "TC739797"));
        int n = 3;

        printGrid(list);
    }

    public static void printGrid(List<Data> list) {

        int maxTestNameLength = "Test Case Name".length();
        int maxTestIdLength = "Test ID".length();

        for (Data d : list) {
            maxTestNameLength = Math.max(maxTestNameLength, d.getTestCaseName().length());
            maxTestIdLength = Math.max(maxTestIdLength, d.getTestId().length());
        }


        String headlineBorder = "+"+"=".repeat(8)+ "+" + "=".repeat(maxTestNameLength + 2)
                + "+" + "=".repeat(maxTestIdLength + 2) + "+";

        System.out.println(headlineBorder);

        String sno = "%-7s";
        String testCaseName = "%-"+(maxTestNameLength)+"s";

        System.out.printf("| "+sno+"| "+testCaseName+" | %-"+maxTestIdLength+"s |%n","S.no", "Test Case Name", "Test ID");
        System.out.println(headlineBorder);
        int i=1;
        for (Data d : list) {
            System.out.printf("| "+"%-7d"+"| %-"+maxTestNameLength+"s | %-"+maxTestIdLength+"s |%n", i++,d.getTestCaseName(), d.getTestId());
        }

        System.out.println(headlineBorder);
    }
}
