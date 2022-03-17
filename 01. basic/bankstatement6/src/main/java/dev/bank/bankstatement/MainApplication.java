package dev.bank.bankstatement;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        // Before
        // BankStatementParser bankStatementParser = new BankStatementCSVParser();
        // BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);
        
        // After
        // BankStatementFactory bankStatementFactory = new BankStatementFactory();
        // BankStatementAnalyzer bankStatementAnalyzer = bankStatementFactory.bankStatementAnalyzer();

        // After Spring
        // Bean 구성 정보(Bean 객체 리스트)를 스프링한테 넘김
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BankStatementFactory.class);
        BankStatementAnalyzer bankStatementAnalyzer = applicationContext.getBean(BankStatementAnalyzer.class);

        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }
}