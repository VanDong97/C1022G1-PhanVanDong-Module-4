package com.example.player_management.repository;

import com.example.player_management.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface IPlayerSoccerRepository extends JpaRepository<PlayerSoccer,Integer> {

    @Transactional
    @Query("select pl from PlayerSoccer pl where pl.name like %:name% and (pl.dateOfBirth >= :startDate or : startDate is null " +
            ") and (pl.dateOfBirth <= :endDate or :endDate is null)")
    Page<PlayerSoccer> findAllByNameAAndDateOfBirthBetween(@Param("name") String name, Pageable pageable,@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
}
