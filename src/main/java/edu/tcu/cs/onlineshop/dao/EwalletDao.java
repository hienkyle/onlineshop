package edu.tcu.cs.onlineshop.dao;

import edu.tcu.cs.onlineshop.domain.Ewallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EwalletDao extends JpaRepository<Ewallet, String> {
}
