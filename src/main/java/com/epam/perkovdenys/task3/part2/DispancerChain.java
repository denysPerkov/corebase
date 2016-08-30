package com.epam.perkovdenys.task3.part2;

public interface DispancerChain {

    void setNextChain(DispancerChain nextChain);

    void dispence(TransferList transferList);

}
