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

    @Query(value = "SELECT\n" +
            "    username,\n" +
            "    kills,\n" +
            "    ROUND((kills / (SELECT SUM(kills) FROM jogadores)) * 100, 2) AS kill_percentage\n" +
            "FROM\n" +
            "    jogadores;", nativeQuery = true)
    List<Object[]> porcenKillJogador();

    @Query(value = "SELECT\n" +
            "    username,\n" +
            "    kills,\n" +
            "    headshot\n" +
            "FROM\n" +
            "    jogadores\n" +
            "WHERE\n" +
            "    CAST(REPLACE(headshot, '%', '') AS NUMERIC) > 30; ", nativeQuery = true)
    List<Object[]> jogadorHeadshotAcima30();
}
