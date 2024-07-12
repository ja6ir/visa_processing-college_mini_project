package com.visaprocessing.visaprocessing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visaprocessing.visaprocessing.entity.Visa;
@Repository
public interface VisaRepository extends JpaRepository<Visa, Long> {
    List<Visa> findByVisastatus(String visastatus);

	List<Visa> findByVisastatusAndUsername(String string, String username);

	Visa findByUsername(String username);
}
