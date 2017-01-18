package com.spring11.dao;

import java.util.*;

import com.spring11.model.*;

public interface IDaoPerson {

    /*
     * 특정 PERSON의 총 게시물 갯수 구하기
     */
    public int getTotalRecord(Map<String, String> map);

    
    /*
     * PERSON 목록
     */
    public List<ModelPerson> getPersonList(Map<String, String> map);
    

    /*
     * PERSON이름 구하기
     */
    public String getPersonName(String boardcd);

    /*
     * PERSON 모델 객체 구하기
     */
    public ModelPerson getPersonOne(String boardcd);   
    
    /*
     * PERSON  추가
     */
    public int insertPerson(ModelPerson board);

    /*
     * PERSON  추가
     */
    public int insertMultiPerson(List<ModelPerson> list);
    
    /*
     * PERSON  수정
     */
    public int updatePerson(ModelPerson board);
    
    /*
     * PERSON  삭제
     */
    public int deletePerson(String boardcd);

    /*
     * 조회수 증가
     */
    public int increaseHit(int articleNo);
    
    /*
     * 다음글 보기 articleNo,boardCd,searchWord->HahMap 에 담는다
     */
    public ModelPerson getNextPerson(Map<String, String> map); 

    /*
     * 이전글 보기 articleNo,boardCd,searchWord->HahMap 에 담는다
     */
    public ModelPerson getPrevPerson(Map<String, String> map);


}
