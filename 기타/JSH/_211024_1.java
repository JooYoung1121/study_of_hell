package study_of_hell.기타.JSH;


public class _211024_1 {
    public static void main(String[] args) {
        String[] d1 = {"03/01 5 15000", "05/15 2 9527", "11/30 9 10000"},
                d2 = {"01/01 2 50000", "01/03 1 999", "01/31 9 10000", "02/05 5 6547",
                        "02/05 6 1", "06/30 5 5000", "10/15 5 2529", "12/30 4 10000"};

        System.err.println(new _211024_1().solution(d1));
        System.err.println(new _211024_1().solution(d2));
    }

    public class Deposit{
        private String date;
        private Integer rate;
        private Integer money;

        public Deposit(String d, String rate, String money){
            this.date = d;
            this.rate = Integer.valueOf(rate);
            this.money = Integer.valueOf(money);
        }

        public Integer getSumOfMoney(){
            Double rateMoney = (this.money * ((double)rate/100)) * (double)((double)getDaysTo1231()/(double)365);
            Double answer = rateMoney + this.money;
            return answer.intValue();
        }

        public Integer getDaysTo1231(){
            String[] days = date.split("/");

            Integer month=Integer.parseInt(days[0]);
            Integer answer = 0;

            for (int i = 1; i < month ; i++) {
                answer += getMonthDays(i);
            }
            answer+=Integer.parseInt(days[1]);

            return 365-answer;
        }

        public Integer getMonthDays(Integer month){
            Integer answer = 0;
            switch(month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12: answer = 31; break;
                case 2: answer=28; break;
                case 4: case 6: case 9: case 11: answer=30; break;
            }
            return answer;
        }

        @Override
        public String toString() {
            return "Deposit{" +
                    "date=" + date +
                    ", days=" + getDaysTo1231() +
                    ", money=" + getSumOfMoney() +
                    "}";
        }
    }

    public int solution(String[] deposits) {
        Deposit[] depositList = new Deposit[deposits.length];
        for (int i = 0; i < deposits.length; i++) {
            String[] obj = deposits[i].split(" ");

            Deposit deposit = new Deposit(obj[0], obj[1], obj[2]);
            depositList[i] = deposit;
        }

        Integer answer = 0;
        for (Deposit d: depositList) {
            answer +=d.getSumOfMoney();
        }


        return answer;
    }
}
