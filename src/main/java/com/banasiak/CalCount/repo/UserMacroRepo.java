package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.user.UserMacro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMacroRepo extends JpaRepository<UserMacro, Long> {
}
