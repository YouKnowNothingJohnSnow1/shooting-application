package com.niewiadoma.shooting_application.repository;

import com.niewiadoma.shooting_application.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
