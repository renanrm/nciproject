package com.rhodenrenan.nciproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhodenrenan.nciproject.models.DailyReports;

@Repository
public interface DailyReportsRepository extends JpaRepository<DailyReports, Integer> {

}
