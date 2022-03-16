package dev.bank.bankstatement;

import dev.bank.bankstatement.data.BankStatementCSVParser;
import dev.bank.bankstatement.data.BankStatementParser;

public class BankStatementFactory {
    public BankStatementAnalyzer bankStatementAnalyzer() {
        BankStatementParser bankStatementParser = new BankStatementCSVParser();

        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer(bankStatementParser);

        return bankStatementAnalyzer;
    }
}
