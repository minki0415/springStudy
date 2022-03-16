package dev.bank.bankstatement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.bankstatement.data.BankStatementParser;
import dev.bank.bankstatement.model.BankTransaction;
import dev.bank.bankstatement.service.BankStatementProcessor;


public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/"; // resources 파일 경로

    private final BankStatementParser bankStatementParser;

    public BankStatementAnalyzer(BankStatementParser bankStatementParser) {
        this.bankStatementParser = bankStatementParser;
    }

    public void analyze(String fileName) throws IOException {

        // 파일 입출력
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        
        // 데이터 파싱
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        // 입출금 내역 연산
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        // 입출금 내역 연산 및 출력
        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("총 입출금 내역은 " + bankStatementProcessor.calculateTotalAmount() + " 입니다.");

        System.out.println("1월의 입출금 내역은 " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY) + " 입니다.");

        System.out.println("Salary(급여) 카테고리의 내역은 " + bankStatementProcessor.calculateTotalForCategory("Salary") + " 입니다.");
    }

}