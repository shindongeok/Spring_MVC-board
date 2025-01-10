package kr.bit.beans;


import lombok.Data;

@Data
public class Page {

    private int min;    //페이지 최소번호
    private int max;    //페이지 최대번호
    private int prePage;    //이전페이지
    private int nextPage;   //다음페이지
    private int pageCnt;    //페이지 수
    private int currentPage;    //현재 페이지

    //               전체게시글 수     현재페이지        페이지당 게시글수   페이지버튼 개수
    public Page(int contentCnt, int currentPage, int contentPageCnt, int pa){
        this.currentPage=currentPage;

        //전체 게시글 수에서 10  나누기?
        pageCnt=contentCnt/contentPageCnt;
        //553/10 =53..3
        if(contentCnt % contentPageCnt > 0){    //
            pageCnt++;
        }
        //((10-1)/10) *10+1 = 1
        min=((currentPage-1) / contentPageCnt) * contentPageCnt +1;
        max=min+pa-1;

        if(max > pageCnt){
            max=pageCnt;
        }
        prePage=min-1;
        nextPage=max+1;

        if(nextPage > pageCnt){
            nextPage=pageCnt;
        }
    }
}
