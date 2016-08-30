package com.epam.perkovdenys.task3.part2.filters;

import com.epam.perkovdenys.task3.part2.DispancerChain;
import com.epam.perkovdenys.task3.part2.Filter;
import com.epam.perkovdenys.task3.part2.TransferList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileFormatFilter implements DispancerChain {

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

        System.out.println("Search by format? (0/1)");
        int input = scanner.nextInt();

        if (input == 1) {
            System.out.println("Enter file format");
            String fileName = scanner.next();

            transferList.getList().forEach(item->{
                if(getFormatFilter(fileName).apply(item)){
                    fileList.add(item);
                }
            });

            transferList.setList(fileList);
            System.out.println("\nAfter the filter format");
            transferList.getList().forEach(item-> System.out.println(item.getName()));
        }
            this.chain.dispence(transferList);
    }

    public static Filter getFormatFilter(String format){
        filter = new Filter() {
            @Override
            public boolean apply(Object type) {
                File file = (File) type;
                int pos = file.getName().indexOf(".") + 1;
                String expectedName = file.getName().substring(pos, file.getName().length());
                return expectedName.equals(format);
            }
        };
        return filter;
    }
}
