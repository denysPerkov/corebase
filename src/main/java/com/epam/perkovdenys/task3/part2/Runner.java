package com.epam.perkovdenys.task3.part2;

import com.epam.perkovdenys.task3.part2.filters.FileFormatFilter;
import com.epam.perkovdenys.task3.part2.filters.FileNameFilter;
import com.epam.perkovdenys.task3.part2.filters.FileRangeDateFilter;
import com.epam.perkovdenys.task3.part2.filters.FileRangeSizeFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private DispancerChain chain1;
    private static List<File> files = new ArrayList<>();
    private static final String ABSOLUTE_PATH = "E:\\targetFolder";

    public Runner(){

        this.chain1 = new FileNameFilter();
        DispancerChain chain2 = new FileFormatFilter();
        DispancerChain chain3 = new FileRangeSizeFilter();
        DispancerChain chain4 = new FileRangeDateFilter();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);
    }

    public static void main(String[] args) {

        Runner runner = new Runner();
        TransferList transferList = new TransferList();
        final File folder = new File(ABSOLUTE_PATH);

        runner.listFilesForFolder(folder);
        transferList.setList(files);

        runner.chain1.dispence(transferList);
    }


    public void listFilesForFolder(final File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            }
            this.files.add(fileEntry);
        }
    }
}
