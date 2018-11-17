package com.esvconnect.qa.base;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;

    public void switchToFrame0() {
        driver.switchTo().frame("PegaGadget0Ifr");
    }
    public void switchToFrame1() {
        driver.switchTo().frame("PegaGadget1Ifr");
    }
    public void switchToFrame2() {
        driver.switchTo().frame("PegaGadget2Ifr");
    }

}
