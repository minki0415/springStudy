package dev.bank.bankstatement.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BankTransaction {
    private LocalDate date; // 거래 날짜
    private double amount; // 금액
    private String description; // 거래처 명세

    // 생성자(Constructor) : 우클릭 -> 소스작업 -> Generate Constructor
    // Getter(), Setter() 생성 lombok 안쓰는 경우 : 우클릭 -> 소스작업 -> Generate Getter and Setters
    // ToString : 우클릭 -> 소스작업 -> Generate ToString
    
}
