package collection;

import java.util.*;

public class jv09_01_ArrayList {
    
    public static void main(String[] args) {
        
        List<String> list = null;
        
        list = new ArrayList<String>(); //String [] arr = new String[10];
        //list = new LinkedList<String>();
        
        // C: 추가. 검색: "자바 arraylist 추가"
        // MILK, BREAD, BUTTER 순으로 추가
        list.add("MILK");
        list.add("BREAD");
        list.add("BUTTER");
        System.out.println("C: 추가 >> " + list.toString());
        
		// APPLE 삽입. 검색: "자바 arraylist 삽입"
        // 특정 위치에 추가하기
        // "BREAD" 앞에 "APPLE" 삽입
        list.add(1, "APPLE");
        System.out.println("C: BREAD 앞에 APPLE 삽입 >> " + list.toString());
        
        // R: 읽기 
		// BREAD 값을 출력하시오.
        String val = list.get(2);
        System.out.println( "R: 읽기 >> " + val );
        
        // U: 수정. 검색: "자바 arraylist 수정"
        // "BREAD" 를 "GRAPE"로 변경
        int index = list.indexOf( "BREAD" );
        list.set(index, "GRAPE");
        System.out.println("U: BREAD 를 GRAPE로 수정 >> " + list.toString());

        // D: 삭제. 검색: "자바 arraylist 삭제"
        // BUTTER 를 삭제
        list.remove("BUTTER");
        System.out.println("D: BUTTER 를 삭제 >> " + list.toString());
        
        // for문으로 arraylist 값을 출력하기. 
        // 검색: "자바 arraylist for 출력"
        // 검색: "자바 arraylist 크기"
        for (String string : list) {
            System.out.print( string + ", ");
        }
        
        // D: 값으로 찾아서 삭제. 검색: "자바 arraylist for 값으로 삭제"
        // 값으로 MILK를 찾아서 삭제하시오
        list.remove("MILK");
        System.out.println("D: 값으로 MILK를 찾아서 삭제 >> " + list.toString());
        
        
    	// U: 값으로 찾아서 수정. 검색: "자바 arraylist for 값으로 수정"
        // 값으로 GRAPE 찾아서 BANNA로 수정
        index = list.indexOf("GRAPE");
        list.set(index, "BANNA");
        System.out.println( "U: 값으로 GRAPE 찾아서 수정" + list.toString());
        
        
        
        
        // S: 오름차순 정렬. 검색: "자바 ArrayList 오름차순 정렬"
        System.out.println("##오름차순정렬 : " + list);
        Collections.sort(list);
        System.out.println( list.toString());

        // S: 내림차순 정렬. 검색: "자바 ArrayList 내림차순 정렬"
        System.out.println("##내림차순정렬 : " + list);
        Collections.reverse(list);
        System.out.println( list.toString());

        // S: 검색. "자바 ArrayList 검색"        
        for(int i=0; i<4; i++) {
            list.add("APPLE");
            list.add("BANNA");            
        }
		
        // 검색1. apple 이 있으면 "있다"를 
        //        없으면 "없다"를 출력하시오.

        // 검색2. apple 이 몇개 있는지 찾으시오.

        // ArrayList 배열로 변환. "자바 ArrayList 배열 변한" 
		
        // ArrayList 배열로 변환.결과를 for in 문으로 출력.
    }
}
