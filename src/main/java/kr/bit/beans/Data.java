package kr.bit.beans;


import javax.validation.constraints.*;

@lombok.Data
public class Data {


    @Pattern(regexp = "^[가-힣]+$", message = "한글만 가능합니다")
    private String userName;


    private String rrNumber1;
    private String rrNumber2;


    @Pattern(regexp = "^[a-zA-Z]+$", message = "아이디는 영문만 가능합니다.")
    @Size(min = 4, message = "아이디는 최소 4글자 이상이어야 합니다.")
    private String userId;


    @Pattern(regexp = "[a-zA-Z]")
    private String pw;

    private String pw2;


    @Size(max=10)
    private String email1;


    private String Email2;


    private String post;


    @Pattern(regexp = "[가-힣]")
    private String addr;


    private String addr2;


    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
    private String tel;

    private String job;

    private String smsClick;


}
