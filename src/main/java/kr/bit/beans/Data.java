package kr.bit.beans;


import javax.validation.constraints.*;

public class Data {

    @NotEmpty   //값의 길이가 0이면 오류발생(공백도 글자로 인식)
    private String num1;

    @NotBlank   //공백제거하고 길이가 0이면 오류발생
    private String num2;

    @Positive   //양수아니면 오류
    private int num3;

    @PositiveOrZero //양수또는 0
    private int num4;

    @Negative
    private int num5;

    @Email  //@기호
    private String num6;

    private Data(){
        this.num1="aa";
        this.num2="aa";
        this.num3=40;
        this.num4=40;
        this.num5=-3;
    }

    public @NotEmpty String getNum1() {
        return num1;
    }

    public void setNum1(@NotEmpty String num1) {
        this.num1 = num1;
    }

    public @NotBlank String getNum2() {
        return num2;
    }

    public void setNum2(@NotBlank String num2) {
        this.num2 = num2;
    }

    @Positive
    public int getNum3() {
        return num3;
    }

    public void setNum3(@Positive int num3) {
        this.num3 = num3;
    }

    @PositiveOrZero
    public int getNum4() {
        return num4;
    }

    public void setNum4(@PositiveOrZero int num4) {
        this.num4 = num4;
    }

    @Negative
    public int getNum5() {
        return num5;
    }

    public void setNum5(@Negative int num5) {
        this.num5 = num5;
    }

    @Email
    public String getNum6() {
        return num6;
    }

    public void setNum6(@Email String num6) {
        this.num6 = num6;
    }
}
