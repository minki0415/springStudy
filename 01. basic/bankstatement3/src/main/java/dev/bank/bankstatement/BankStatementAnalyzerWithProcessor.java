package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementTSVParser;
import dev.bank.bankstatement.model.BankTransaction;
import dev.bank.bankstatement.service.BankStatementProcessor;

/**
 * 관심사 
 * 1. 파일 입출력
 * 2. 입출력된 파일 파싱(String, Double, LocalDate -> BankTransaction 객체)
 * 3. 입출금 내역 연산 처리 (BankStatementProcessor)
 * 4. 입출금 내역 결과 출력
 */
// BankStatement2 에서 구현한 내용
public class BankStatementAnalyzerWithProcessor {
    private static final String RESOURCES = "src/main/resources/"; // resources 파일 경로

    public static void main(String[] args) throws IOException {

        // 파일 입출력
        final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
        final List<String> lines = Files.readAllLines(path); // Ctrl + . -> 빠른수정, 예외처리        
        
        // 데이터 파싱
        // BankStatementTSVParser bankStatementTSVParser = new BankStatementTSVParser();
        // List<BankTransaction> bankTransactions = bankStatementTSVParser.parseLinesFromTSV(lines);

        // 입출금 내역 연산
        // BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        // 입출금 내역 연산 및 출력
        // collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("총 입출금 내역은 " + bankStatementProcessor.calculateTotalAmount() + " 입니다.");

        System.out.println("1월의 입출금 내역은 " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY) + " 입니다.");

        System.out.println("Salary(급여) 카테고리의 내역은 " + bankStatementProcessor.calculateTotalForCategory("Salary") + " 입니다.");
    }

}