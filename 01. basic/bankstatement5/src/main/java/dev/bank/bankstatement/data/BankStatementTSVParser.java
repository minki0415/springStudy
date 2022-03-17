package dev.bank.bankstatement.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.model.BankTransaction;

public class BankStatementTSVParser implements BankStatementParser{
    // 멤버 필드
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // 한 줄만 파싱하기, 이 클래스 내에서만 사용되기 때문에 접근 제어자는 private
    public BankTransaction parseFrom(final String line) {
        String[] columns = line.split("\t");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    // 한 줄씩 파싱 후, 리스트에 추가.
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();

        for(String line:lines) {
            bankTransactions.add(parseFrom(line));
        }

        return bankTransactions;
    }
}