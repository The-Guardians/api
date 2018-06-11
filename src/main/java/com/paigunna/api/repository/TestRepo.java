package com.paigunna.api.repository;

import com.paigunna.api.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Arm
 */
public interface TestRepo extends JpaRepository<Test, Long> {
}
