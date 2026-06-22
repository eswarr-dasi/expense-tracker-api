package com.eswarr.expensetracker.model;

  import jakarta.persistence.*;
  import jakarta.validation.constraints.*;
  import java.math.BigDecimal;
  import java.time.LocalDate;
  import java.time.LocalDateTime;

  @Entity
  @Table(name = "expenses")
  public class Expense {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @NotNull
      @DecimalMin(value = "0.01")
      @Column(nullable = false, precision = 10, scale = 2)
      private BigDecimal amount;

      @NotBlank
      @Column(nullable = false)
      private String description;

      @NotNull
      @Column(nullable = false)
      private LocalDate date;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "category_id")
      private Category category;

      @Column(name = "created_at", nullable = false, updatable = false)
      private LocalDateTime createdAt;

      @PrePersist
      protected void onCreate() { this.createdAt = LocalDateTime.now(); }

      public Long getId() { return id; }
      public void setId(Long id) { this.id = id; }
      public BigDecimal getAmount() { return amount; }
      public void setAmount(BigDecimal amount) { this.amount = amount; }
      public String getDescription() { return description; }
      public void setDescription(String d) { this.description = d; }
      public LocalDate getDate() { return date; }
      public void setDate(LocalDate date) { this.date = date; }
      public Category getCategory() { return category; }
      public void setCategory(Category c) { this.category = c; }
      public LocalDateTime getCreatedAt() { return createdAt; }
  }
