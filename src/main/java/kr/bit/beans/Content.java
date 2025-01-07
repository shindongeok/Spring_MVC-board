package kr.bit.beans;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Content {

    //게시글 정보 필드
    private int content_idx;

    @NotBlank   //비여있으면 안됨
    private String content_subject;

    @NotBlank
    private String content_text;

    private int content_writer_idx;
    private int content_board_idx;
    private String content_date;

    //글쓴이 이름 필드
    private String content_writer_name;
}
