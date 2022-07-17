package com.example.rodzina.repository;

import com.example.rodzina.domain.dao.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family,Long> {
}
