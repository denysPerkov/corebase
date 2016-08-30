package com.epam.perkovdenys.task2.part2;

public class HashcodeLength {

    private String str;

    public HashcodeLength(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashcodeLength that = (HashcodeLength) o;

        return str != null ? str.equals(that.str) : that.str == null;

    }

    @Override
    public int hashCode() {
        return str != null ? str.length() : 0;
    }

    @Override
    public String toString() {
        return "HashcodeLength{" +
                "str='" + str + '\'' +
                '}';
    }
}