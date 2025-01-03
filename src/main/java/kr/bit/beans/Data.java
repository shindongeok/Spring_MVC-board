package kr.bit.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@lombok.Data
public class Data {

    @Max(100)
    private int num1;

    @Size(min=4, max=10)
    private String num2;


}
