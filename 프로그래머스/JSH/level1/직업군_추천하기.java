package study_of_hell.프로그래머스.JSH.level1;

import java.util.ArrayList;
import java.util.List;

public class 직업군_추천하기 {
    public static void main(String[] args) {
        String[] t1={"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                t2={"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] l1={"PYTHON", "C++", "SQL"}, l2={"JAVA", "JAVASCRIPT"};
        int[] p1={7,5,5}, p2={7,5};
//        System.err.println(new 직업군_추천하기().solution(t1, l1, p1));
        System.err.println(new 직업군_추천하기().solution(t2, l2, p2));
    }

    public class Developer{
        private String language;
        private int prefer;

        public Developer(String l, int p){
            language=l;
            prefer=p;
        }
    }

    public class Job{
        private String job;
        private int score;

        public Job(){
            this.score=0;
        }

        public Job(String job, int score) {
            this.job = job;
            this.score = score;
        }

    }

    public String solution(String[] table, String[] languages, int[] preference) {

        List<Developer> developers = new ArrayList<>();
        for (int i = 0; i < languages.length; i++) {
            developers.add(new Developer(languages[i], preference[i]));
        }

        Job job = new Job();
        for (int i = 0; i < table.length; i++) {
            String[] temp =table[i].split(" ");
            int score = 0;

            for (int j = 1; j < temp.length; j++) {
                for (Developer d:developers) {
                    if (temp[j].equals(d.language)) {
                        score += (6 - j) * d.prefer;
                    }
                }
            }

            if(job.score < score || (job.score==score && job.job.compareTo(temp[0])>0)){
                job=new Job(temp[0], score);
            }
        }

        return job.job;
    }
}
