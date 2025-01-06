package kr.bit.vaildator;


import kr.bit.beans.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//<validator 커스터 마이징>
//1. Validator 인터페이스 구현
//2. 컨트롤러에 인터페이스 등록
public class DataValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz){
        //유효성 검사할 데이터를 가지고 있는 객체가 유효성 검사가 가능한지 확인
        //Data 클래스가 유표성 검사 대상인지 확인(true : 유효성검사 가능 / false : 가능 x)
        return Data.class.isAssignableFrom(clazz);
    }

    @Override   //유효성 검사하는 핵심 메소드
    public void validate(Object target, Errors errors){

        ValidationUtils.rejectIfEmpty(errors, "num2", "error2");
        //num2가 empty 면 에러이름을 error2로 함
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "num3", "error3");
        //num2가 empty or 공백문자만 있다면 에러이름을 error3로 함
                    //다운 케스팅
        Data data=(Data) target;    //유효성 검사할 객체

        String str1 = data.getNum2();
        String str2 = data.getNum3();

        if(str1.length() > 5){
            errors.rejectValue("num2", "error4");
            //num2길이가 5자리 넘어가면 error4라는 이름으로 에러명 줌
        }
        if(str2.contains("-")==false){
            errors.rejectValue("num3","error5");
        }

    }


}
