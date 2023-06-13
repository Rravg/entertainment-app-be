package com.project.entertainment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TitlesRepository extends JpaRepository<Titles, Long> {
    Titles findByName(String name);
}
