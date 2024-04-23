package com.example.valorant.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    @Query(value = "SELECT username, matches, win FROM jogadores;\n", nativeQuery = true)
    List<Object[]> findWinPercentage();

    @Query(value = "SELECT username, top_agents_1, top_matches_agent_1, top_win_agent_1 FROM JOGADORES;", nativeQuery = true)
    List<Object[]> porcenVitAgent();

    @Query(value = "SELECT\n" +
            "    username,\n" +
            "    kills,\n" +
            "    headshot\n" +
            "FROM\n" +
            "    jogadores\n" +
            "WHERE\n" +
            "    CAST(REPLACE(headshot, '%', '') AS NUMERIC) > 30; ", nativeQuery = true)
    List<Object[]> jogadorHeadshotAcima30();

    @Query(value = "SELECT COUNT(*) AS total_jogadores\n" +
            "FROM jogadores;\n", nativeQuery = true)
    List<Object[]> totalJogador();

    List<Jogador> findByUsernameContainingIgnoreCase(String username);

}
