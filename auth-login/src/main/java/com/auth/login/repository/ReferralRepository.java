package com.auth.login.repository;

import com.auth.login.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralRepository extends JpaRepository<Referral, Long> {
}
