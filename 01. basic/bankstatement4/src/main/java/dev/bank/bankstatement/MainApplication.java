package dev.bank.bankstatement;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        // Before
        // BankStatementParser bankStatementParser = new BankStatementCSVParser();
        // BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);
        
        // After
        BankStatementFactory bankStatementFactory = new BankStatementFactory();

        BankStatementAnalyzer bankStatementAnalyzer = bankStatementFactory.bankStatementAnalyzer();

        bankStatementAnalyzer.analyze("bank-data-simple.csv");
    }
}
