package com.example.valorant.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    @Query(value = "SELECT " +
            "    username,  " +
            "    matches, " +
            "    ROUND( " +
            "        CASE " +
            "            WHEN matches > 0 THEN (wins / matches * 100) " +
            "            ELSE 0 " +
            "        END, " +
            "        2 " +
            "    ) AS winPercentage " +
            "FROM " +
            "    jogadores", nativeQuery = true)
    List<Object[]> findWinPercentage();
}
