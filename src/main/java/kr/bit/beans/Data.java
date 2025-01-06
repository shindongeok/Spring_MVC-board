package kr.bit.beans;

public class Data {
    private String num1;
    private int num2;
    private double num3;
    private boolean num4;

    public Data(String num1, int num2, double num3, boolean num4) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public double getNum3() {
        return num3;
    }

    public void setNum3(double num3) {
        this.num3 = num3;
    }

    public boolean isNum4() {
        return num4;
    }

    public void setNum4(boolean num4) {
        this.num4 = num4;
    }
}
