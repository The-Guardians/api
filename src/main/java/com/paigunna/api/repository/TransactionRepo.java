package com.paigunna.api.repository;

import com.paigunna.api.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author armme : 15/03/2018
 */
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
