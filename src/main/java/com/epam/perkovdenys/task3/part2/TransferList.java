package com.epam.perkovdenys.task3.part2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TransferList {

    private List<File> files;

    public TransferList(){
        files = new ArrayList<>();
    }

    public List<File> getList() {
        return files;
    }

    public void setList(List<File> list) {
        this.files = list;
    }

}
