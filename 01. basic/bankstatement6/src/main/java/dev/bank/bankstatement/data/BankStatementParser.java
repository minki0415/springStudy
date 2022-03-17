package dev.bank.bankstatement.data;

import java.util.List;

import dev.bank.bankstatement.model.BankTransaction;

// 입출금 내역 데이터를 파싱하는 메서드(사용법)명을 가지고 있는 설계도
public interface BankStatementParser {

    /**
     * 메서드의 선언부만 작성하고,
     * 구현부(몸체, 실제 코드)는 구현 클래스에서 작성해야함.
     */
    BankTransaction parseFrom(String line); // 함수 선언부
    // {}; // 함수구현부(실제 내용 작성하는 부분, 인터페이스에서는 작성 불가.)
    List<BankTransaction> parseLinesFrom(List<String> lines);
            
}
