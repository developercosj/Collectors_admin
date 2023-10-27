package com.collectors.admin.emailAuth.interfaces;

import com.collectors.admin.entity.EmailPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoEmailPass  extends JpaRepository<EmailPass, Long> {
}
