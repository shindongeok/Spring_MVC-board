package kr.bit.beans;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {

    // 사용자 정보 필드
    private int user_idx;

    @Size(min=2, max=4)
    @Pattern(regexp = "[가-힣]*")     // 한글만 가능
    private String user_name;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")   // 영어와 숫자만 가능
    private String user_id;

    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw;

    //비번확인 필드
    @Size(min=4, max=10)
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String user_pw2;

    //로그인 여부 확인을 위한 필드
    private boolean existId;
    private boolean userLogin;

    public User(){
        // 중복확인검사 안할걸로 초기화해줌 -> 중복확인검사 해야되니까!
        this.existId=false;
        // 로그인 여부 -> 록인 안되어있는 걸로 초기화
        this.userLogin=false;
    }
}
