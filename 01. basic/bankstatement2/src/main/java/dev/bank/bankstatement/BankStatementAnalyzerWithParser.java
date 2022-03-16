package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementTSVParser;
import dev.bank.bankstatement.model.BankTransaction;


public class BankStatementAnalyzerWithParser {
    private static final String RESOURCES = "src/main/resources/"; // resources 파일 경로

    public static void main(String[] args) throws IOException {

        // 파일 입출력
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        final List<String> lines = Files.readAllLines(path); // Ctrl + . -> 빠른수정, 예외처리        
        
        // 데이터 파싱
        BankStatementTSVParser bankStatementTSVParser = new BankStatementTSVParser();
        List<BankTransaction> bankTransactions = bankStatementTSVParser.parseLinesFromTSV(lines);

        // 입출금 내역 연산 및 출력
        System.out.println("입출금 내역의 총합은 " + calculateTotalAmount(bankTransactions) + " 입니다.");

        // 2번째 요구사항, 월별 입출금 내역 구하기
        System.out.println("1월의 입출금 내역은 " + selectInMonth(bankTransactions, Month.JANUARY) + " 입니다.");

    }

    // 메서드 명을 통해 해당 메서드가 수행하는 일을 바로 이해할 수 있도록, 자체적인 문서화를 제공하는 
    // 메서드 명으로 작성한느 것이 좋음
    public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    // findTransactionsInJanuary() 다른 월도 조회할 수 있도록 변경
    public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) bankTransactionsInMonth.add(bankTransaction);
        }

        return bankTransactionsInMonth;
    }
}
