package collection;

import java.util.*;

public class jv09_03_HashMap {
    public static void main(String[] args) {
        
        Map<Integer, String> map = null;
        
        map = new HashMap<Integer, String>();

        /* C: 추가. 검색: "자바 HashMap 추가"
         *
         * 송중기
         * 이광수
         * 송혜교
         * */
        map.put(10939, "송중기");
        map.put(88484, "이광수");
        map.put(8845738, "송혜교");
        System.out.println(map.toString()); // 모든 항목을 출력한다.        
        
		/* C: 삽입. 검색: "자바 HashMap 삽입"
         *
         * 유재석 삽입
         * */
        map.put(3434, "유재석");
        System.out.println(map.toString()); // 모든 항목을 출력한다.  

        /* R: 읽기
         *
         * 송혜교만  출력
         * */
        String str =map.get(8845738);
        System.out.println( str /* 송혜고만 출력 */ );

        /* U: 수정.변경. 검색: "자바 HashMap 수정"
         *
         * 이광수를 하하로 변경
         * */
        map.put(88484, "하하");
        System.out.println(map.toString());
        
        /* D: 키 값으로 삭제. 검색: "자바 HashMap 삭제"
         *
         * 송혜교를 삭제
         * */
        map.remove(8845738);
        System.out.println(map.toString());
		
        
        // for문으로 Map 출력하기. 방법1
        // iterator()를 이용하는 방식은 루프안에서 map 데이터를 삭제할때 사용.
        // http://stove99.tistory.com/96
        for( Iterator<Integer> keys = map.keySet().iterator() ; keys.hasNext() ; ){
            Integer key = keys.next();
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
        }
        
        // foreach문으로 Map 출력하기. 방법2
        // keySet() 보다 빠르다. 
        // http://stove99.tistory.com/96
        for( Map.Entry<Integer, String> elem : map.entrySet() ){
            System.out.println( String.format("키 : %s, 값 : %s", elem.getKey(), elem.getValue()) );
        }
        // foreach문으로 Map 출력하기. 방법3
        // http://stove99.tistory.com/96
        for( Integer key : map.keySet() ){
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
        }
        
        // S: HashMap 오름차순 정렬. 검색: "자바 HashMap 오름차순 정렬"
        // http://huskdoll.tistory.com/5
        

        // S: HashMap 내림차순 정렬. 검색: "자바 HashMap 내림차순 정렬"
        // http://huskdoll.tistory.com/5
        TreeMap<Integer, String> treeMapReverse = new TreeMap<Integer, String>(Collections.reverseOrder());
        treeMapReverse.putAll(map);
 
        Iterator<Integer> treeMapReverseIter = treeMapReverse.keySet().iterator();
         for( ; treeMapReverseIter.hasNext(); ) {
 
             Integer key = treeMapReverseIter.next();
            String value = treeMapReverse.get( key );
 
            System.out.println(key+" : "+value);
 
        }        

        // S: HashMap 검색. "자바 HashMap 검색"  
        // Arrays.binarySearch( map.values().toArray(), "하하2");
	
    }    
}
