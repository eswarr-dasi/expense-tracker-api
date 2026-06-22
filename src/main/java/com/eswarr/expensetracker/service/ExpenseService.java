package com.eswarr.expensetracker.service;

import com.eswarr.expensetracker.model.Expense;
import com.eswarr.expensetracker.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public Page<Expense> getAllExpenses(Pageable pageable) {
              return expenseRepository.findAll(pageable);
    }

    public Expense getExpenseById(Long id) {
              return expenseRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Expense not found: " + id));
    }

    @Transactional
    public Expense createExpense(Expense expense) {
              return expenseRepository.save(expense);
    }

    @Transactional
    public Expense updateExpense(Long id, Expense updated) {
        Expense existing = getExpenseById(id);
        existing.setAmount(updated.getAmount());
        existing.setCategory(updated.getCategory());
        existing.setDescription(updated.getDescription());
        existing.setDate(updated.getDate());
        return expenseRepository.save(existing);
    }

    @Transactional
    public void deleteExpense(Long id) {
              Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }

    public Map<String, BigDecimal> getByCategory(LocalDate from, LocalDate to) {
              return expenseRepository.findByDateBetween(from, to).stream()
                            .collect(Collectors.groupingBy(
                                Expense::getCategory,
                                Collectors.reducing(BigDecimal.ZERO,
                                    Expense::getAmount, BigDecimal::add)));
    }
}
