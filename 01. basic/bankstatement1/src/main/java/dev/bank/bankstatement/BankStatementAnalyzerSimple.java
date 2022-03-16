package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class BankStatementAnalyzerSimple 
{
    private static final String RESOURCES = "src/main/resources/";

    public static void main( String[] args ) throws IOException
    {
        // 1번째 기능 요구사항, 모든 거래 내역의 합 계산하기 / Phase 1
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        // System.out.println(path);

        final List<String> lines = Files.readAllLines(path); // Ctrl + . -> 빠른수정, 예외처리
        // System.out.println(lines);
        // System.out.println(lines.get(0));

        double total = 0d;
        for(String line : lines) {
            final String[] columns = line.split("\t");
            // System.out.println(columns[0] + columns[1] + columns[2]);
            // break;

            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        //1번째 기능 요구사항 출력
        System.out.println("총 사용 금액은 " + total + " 입니다.");

        //2번째 기능 요구사항 출력
        System.out.println("1월의 총 사용 금액은 " + findtransactionsInJauary() +" 입니다.");

    }

    // 2번째 기능 요구사항 : 특정 달에 몇건의 입출금 내역이 발생하였을까? / Phase 1-1
    public static double findtransactionsInJauary() throws IOException {
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");

        final List<String> lines = Files.readAllLines(path); // Ctrl + . -> 빠른수정, 예외처리

        double total = 0d;

        // 01/02/2017, 01.02.2018, 01-02-2017 다양한 데이트 타임 포맷 존재
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for(String line : lines) {
            final String[] columns = line.split("\t");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            System.out.println(date);
            // break;

            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;

            }
        }

        return total;
    }   
}
