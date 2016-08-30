package com.epam.perkovdenys.task6.part3;

import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;

public class SequnceByte implements Callable {

    private byte []data;
    private Exchanger exchanger;

    public SequnceByte(Exchanger exchanger){
        this.exchanger = exchanger;
    }

    @Override
    public Object call() throws InterruptedException {
        this.data = (byte[]) exchanger.exchange(true);
        return longestDuplicate();
    }

    public int[] longestDuplicate() throws InterruptedException {
        boolean[][] sequenceMatrix = new boolean[data.length][data.length];
        buildMatrix(data, sequenceMatrix);
        int [] result = new int[3];

        for (int i = 1; i < sequenceMatrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequenceMatrix[i][j]) {
                    int tempIndexFirst = j;
                    int tempIndexSecond = i;
                    int tempLength = 1;

                    int row = j;
                    int col = i;
                    while (true) {
                        if ((++row < sequenceMatrix.length && ++col < sequenceMatrix.length)
                                && sequenceMatrix[row][col]) {
                            tempLength++;
                            continue;
                        }
                        if (tempLength > result[2]) {
                            result[0] = tempIndexFirst;
                            result[1] = tempIndexSecond;
                            result[2] = tempLength;
                            exchanger.exchange(result[2]);
                        }
                        break;
                    }
                }
            }
        }
        exchanger.exchange(Status.DONE);
        return result;
    }

    private static void buildMatrix(byte[] data, boolean[][] sequenceMatrix) {
        for (int i = 0; i < sequenceMatrix.length; i++) {
            for (int j = 0; j < sequenceMatrix.length; j++) {
                if (data[i] == data[j]) {
                    sequenceMatrix[i][j] = sequenceMatrix[j][i] = true;
                }
            }
        }
    }

}


