package com.lxh.repository;

import com.lxh.dto.ProcessScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessScoreRepository extends CrudRepository<ProcessScore,String> {
}
