package com.meteora.xero.api.repository;

import com.meteora.xero.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
