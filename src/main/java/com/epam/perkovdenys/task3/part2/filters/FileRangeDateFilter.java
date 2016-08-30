package com.epam.perkovdenys.task3.part2.filters;

import com.epam.perkovdenys.task3.part2.DispancerChain;
import com.epam.perkovdenys.task3.part2.Filter;
import com.epam.perkovdenys.task3.part2.TransferList;
import com.epam.perkovdenys.task3.part2.utils.DateUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRangeDateFilter implements DispancerChain {

    private DispancerChain chain;
    private Scanner scanner;
    private static Filter filter;

    @Override
    public void setNextChain(DispancerChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispence(TransferList transferList) {
        List<File> fileList = new ArrayList<>();
        scanner = new Scanner(System.in);

        System.out.println("Search by file change date range? (0/1)");
        int input = scanner.nextInt();

        if (input == 1) {
            System.out.println("Enter start date in format \"yyyy-MM-dd\"");
            String start = scanner.next();
            System.out.println("Enter finish date in format \"yyyy-MM-dd\"");
            String finish = scanner.next();

            transferList.getList().forEach(item->{
                if(getRangeDateFilter(start, finish).apply(item)){
                    fileList.add(item);
                }
            });

            transferList.setList(fileList);
            System.out.println("\nAfter the filter file change date range:");
            transferList.getList().forEach(item-> System.out.println(item.getName()));
       }
    }

    public static Filter getRangeDateFilter(String start, String finish){
        filter = new Filter() {
            @Override
            public boolean apply(Object type) {
                File file = (File) type;
                long base = file.lastModified();
                return DateUtils.hasDateInRange(base, start, finish);
            }
        };
        return filter;
    }
}
