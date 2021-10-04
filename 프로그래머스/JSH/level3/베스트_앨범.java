package study_of_hell.프로그래머스.JSH.level3;

import java.util.*;

public class 베스트_앨범 {
    public static void main(String[] args) {
        String[] g = {"classic", "pop", "classic", "classic", "pop"};
        int[] p = {500, 600, 150, 800, 2500};
        int[] r = new 베스트_앨범().solution(g, p);
        for (int i = 0; i < r.length; i++) {
            System.out.println("i = " + r[i]);
        }
    }

    public class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        // 1. 장르 선정
        ArrayList<String> genres_ordered = new ArrayList<>();
        while(map.size()!=0){
            int max = -1;
            String max_key = "";
            for(String key : map.keySet()){
                int tmp_cnt = map.get(key);
                if(tmp_cnt>max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key);
        }

        // 2. 장르 내 노래 선정
        ArrayList<Music> result = new ArrayList<>();
        for(String gern : genres_ordered){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(gern)){
                    list.add(new Music(gern, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅
            result.add(list.get(0)); 	// 1개는 무조건 수록
            if(list.size()!=1){ 	// 더 수록할 곡이 있으면(==장르 내의 노래가 1개보다 많으면) 수록
                result.add(list.get(1));
            }
        }

        // print result
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }
}
