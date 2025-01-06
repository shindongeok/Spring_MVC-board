package kr.bit.database;

import kr.bit.beans.Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MapperInterface {

    @Insert("insert into spring_table(num1, num2, num3) values (#{num1}, #{num2}, #{num3})")
    void insert_data(Data data);

    @Select("select num1, num2, num3 from spring_table")
    List<Data> select_data();
}
