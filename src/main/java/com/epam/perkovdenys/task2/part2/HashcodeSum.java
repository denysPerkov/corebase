package com.epam.perkovdenys.task2.part2;


public class HashcodeSum {

    private String str;

    public HashcodeSum(String str){
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

        HashcodeSum that = (HashcodeSum) o;

        return !(str != null ? !str.equals(that.str) : that.str != null);

    }

    @Override
    public int hashCode() {
        int sum = 0;
        char []elements = new char[4];
        for(int i = 0; i < str.length() && i < 4; i++){
            elements[i] = str.charAt(i);
            sum += elements[i];
        }

        return str != null ? sum : 0;
    }

    @Override
    public String toString() {
        return "HashcodeSum{" +
                "str='" + str + '\'' +
                '}';
    }
}