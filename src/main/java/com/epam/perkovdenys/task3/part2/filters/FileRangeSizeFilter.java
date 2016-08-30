package com.epam.perkovdenys.task3.part2.filters;

import com.epam.perkovdenys.task3.part2.DispancerChain;
import com.epam.perkovdenys.task3.part2.Filter;
import com.epam.perkovdenys.task3.part2.TransferList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRangeSizeFilter implements DispancerChain {

    private DispancerChain chain;
    private Scanner scanner;
    private static Filter filter;
    private static final int BYTES_IN_KILOBYTES = 1024;

    @Override
    public void setNextChain(DispancerChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispence(TransferList transferList) {
        scanner = new Scanner(System.in);
        System.out.println("Search by range of size? (0/1)");
        int input = scanner.nextInt();

        if (input == 1) {
            List<File> fileList = new ArrayList<>();

            System.out.println("Enter starting value in kilobytes");
            int start = scanner.nextInt();
            System.out.println("Enter finishing value in kilobytes");
            int finish = scanner.nextInt();

            transferList.getList().forEach(item->{
                if(getRangeSizeFilter(start, finish).apply(item)){
                    fileList.add(item);
                }
            });

            transferList.setList(fileList);
            System.out.println("\nAfter the filter size range:");
            transferList.getList().forEach(item -> System.out.println(item.getName()));

        }
        this.chain.dispence(transferList);
    }

    public static Filter getRangeSizeFilter(int start, int finish){
        filter = new Filter() {
            @Override
            public boolean apply(Object type) {
                File file = (File) type;
                long kilobytes = file.length() / BYTES_IN_KILOBYTES;
                return kilobytes > start && kilobytes < finish;
            }
        };
        return filter;
    }
}
