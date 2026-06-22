package com.eswarr.expensetracker.repository;

import com.eswarr.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

      List<Expense> findByDateBetween(LocalDate from, LocalDate to);

      List<Expense> findByCategory(String category);

      @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.date BETWEEN :from AND :to")
      BigDecimal sumAmountBetween(@Param("from") LocalDate from, @Param("to") LocalDate to);

      List<Expense> findByAmountGreaterThan(BigDecimal amount);

      List<Expense> findByDescriptionContainingIgnoreCase(String keyword);
  }
