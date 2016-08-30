package com.epam.perkovdenys.task3.part2.filters;

import com.epam.perkovdenys.task3.part2.DispancerChain;
import com.epam.perkovdenys.task3.part2.Filter;
import com.epam.perkovdenys.task3.part2.TransferList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileNameFilter implements DispancerChain {

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

        System.out.println("Search by name? (0/1)");
        int input = scanner.nextInt();

        if(input== 1) {
            System.out.println("Enter file name");
            String fileName = scanner.next();

            transferList.getList().forEach(item->{
                if (getNameFilter(fileName).apply(item)) {
                    fileList.add(item);
                }
            });

            transferList.setList(fileList);
            System.out.println("\nAfter the filter name");
            transferList.getList().forEach(item-> System.out.println(item.getName()));
        }

        this.chain.dispence(transferList);
    }

    public static Filter getNameFilter(String name){
        filter = new Filter() {
            @Override
            public boolean apply(Object type) {
                File file = (File) type;
                String expectedName = file.getName().replaceFirst("[.][^.]+$", "");
                return expectedName.equals(name);
            }
        };
        return filter;
    }
}
