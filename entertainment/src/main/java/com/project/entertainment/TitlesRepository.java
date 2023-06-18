package com.project.entertainment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TitlesRepository extends JpaRepository<Titles, Long> {
    Titles findByName(String name);

    List<Titles> findByNameContaining(String keyword);
}
