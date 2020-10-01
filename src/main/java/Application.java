import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Application{
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 2011년 일어난 모든 트랜잭션 -> 오름차순
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("================================");
        // 거래자가 근무하는 모든 도시를 중복없이 나열
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("================================");
        // 케임브리지에서 근무하는 모든 거래자 찾아서 이름순 정렬
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);


        System.out.println("================================");
        // 모든 거래자의 이름을 알파벳순으로 정렬
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);


        System.out.println("================================");
        // 밀라노에 거래자가 있는가?
        boolean isMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("isMilan: " + isMilan);

        System.out.println("================================");
        // 케임브리지에 거주하는 거래자의 모든 트랜잭션 값
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);

        System.out.println("================================");
        // 전체 트랜잭션 중 최댓값
        transactions.stream()
                .reduce((a,b) -> a.getValue()<b.getValue()? b: a)
                .ifPresent(System.out::println);
                ;

        System.out.println("================================");
        // 전체 트랜잭션 중 최솟값
        transactions.stream()
                .reduce((a,b) -> a.getValue()<b.getValue()? a: b)
                .ifPresent(System.out::println);
        ;
    }
}