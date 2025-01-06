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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error1");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rrNumber1", "error2");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rrNumber2", "error3");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "error4");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "error5");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw2", "error6");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email1", "error7");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email2", "error8");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "post", "error9");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addr", "error10");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addr2", "error11");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tel", "error12");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "error13");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "smsClick", "error14");




        Data data=(Data) target;    //유효성 검사할 객체

        String rrNumber1 = data.getRrNumber1();
        String rrNumber2 = data.getRrNumber2();

        if(rrNumber1.length() != 6){
            errors.rejectValue("rrNumber1", "error15");
            //num2길이가 5자리 넘어가면 error4라는 이름으로 에러명 줌
        }
        if(rrNumber2.length() != 7){
            errors.rejectValue("rrNumber2", "error16");
        }
//        if(str2.contains("-")==false){
//            errors.rejectValue("num3","error5");
//        }

    }


}
