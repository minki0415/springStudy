package dev.bank.bankstatement.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.bankstatement.model.BankTransaction;

// 입출금 관련 도메인(비즈니스) 로직을 처리하는 클래스
public class BankStatementProcessor {

    // 추후 모든 연산에서 입출금 내역 목록을 사용할 것이기 때문에 Processor 클래스의 필드로 설정
    // static 변수의 역할 : 
    private final  List<BankTransaction> bankTransactions;
    
    
    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    // findTransactionsInJanuary() 다른 월도 조회할 수 있도록 변경
    public List<BankTransaction> calculateTotalInMonth(Month month){
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) bankTransactionsInMonth.add(bankTransaction);
        }

        return bankTransactionsInMonth;
    }

    public double calculateTotalForCategory(String category) {
        double total = 0d;
        for(BankTransaction bankTransaction : bankTransactions) {
            if(bankTransaction.getDescription().equals(category)){
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }
}