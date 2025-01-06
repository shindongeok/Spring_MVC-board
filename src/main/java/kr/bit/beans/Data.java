package kr.bit.beans;


import javax.validation.constraints.*;

public class Data {

    @AssertTrue //true가 아닌 값이 들어오면 오류
    private  boolean num1;

    @AssertFalse //false가 아닌 값이 들어오면 오류
    private  boolean num2;

    @Max(200)
    @Min(20)
    private String num3;

    @Null   //값이 들어오면 오류
    private String num4;

    @NotNull    //값이 들어오지 않으면 오류
    private String num5;

    @Digits(integer = 3, fraction = 2)  //정수는 3, 실수 2자릿수
    private String num6;

    @Size(min=2, max=10)    //지정된 글자수보다 짧거나 길면 오류
    private String num7;

    @Pattern(regexp = "[a-zA-Z]*")
    private String num8;

    public Data(){
        this.num1=true;
        this.num2=false;
        this.num3="50";
        this.num4=null;
        this.num5="spring";
        this.num6="222.22";
        this.num7="java";
    }

    @AssertTrue
    public boolean isNum1() {
        return num1;
    }

    public void setNum1(@AssertTrue boolean num1) {
        this.num1 = num1;
    }

    @AssertFalse
    public boolean isNum2() {
        return num2;
    }

    public void setNum2(@AssertFalse boolean num2) {
        this.num2 = num2;
    }

    public @Max(200) @Min(20) String getNum3() {
        return num3;
    }

    public void setNum3(@Max(200) @Min(20) String num3) {
        this.num3 = num3;
    }

    public @Null String getNum4() {
        return num4;
    }

    public void setNum4(@Null String num4) {
        this.num4 = num4;
    }

    public @NotNull String getNum5() {
        return num5;
    }

    public void setNum5(@NotNull String num5) {
        this.num5 = num5;
    }

    public @Digits(integer = 3, fraction = 2) String getNum6() {
        return num6;
    }

    public void setNum6(@Digits(integer = 3, fraction = 2) String num6) {
        this.num6 = num6;
    }

    public @Size(min = 2, max = 10) String getNum7() {
        return num7;
    }

    public void setNum7(@Size(min = 2, max = 10) String num7) {
        this.num7 = num7;
    }

    public @Pattern(regexp = "[a-zA-Z]*") String getNum8() {
        return num8;
    }

    public void setNum8(@Pattern(regexp = "[a-zA-Z]*") String num8) {
        this.num8 = num8;
    }
}
