package com.example.valorant.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

        Optional<Jogador> findByUsernameAndTag(String username, String tag);

        @Query(value = "SELECT COUNT(*) > 0 AS result FROM jogadores WHERE username = :username AND tag = :tag")
        List<Object[]> jogadorExiste(@Param("username") String username, @Param("tag") String tag);

        @Query(value = "SELECT username, matches, win FROM jogadores;\n", nativeQuery = true)
        List<Object[]> findWinPercentage();

        @Modifying
        @Query(value = "UPDATE jogadores SET playtime = :playtime, matches = :matches, rating = :rating, level = :level, loses = :loses, damage_round = :damageRound, headshot = :headshot, win = :win, wins = :wins, kills = :kills, deaths = :deaths, assists = :assists, kad_ratio = :kadRatio, kills_round = :killsRound, clutches = :clutches, top_agents_1 = :topAgents1, top_agents_2 = :topAgents2, top_agents_3 = :topAgents3, top_hours_agent_1 = :topHoursAgent1, top_hours_agent_2 = :topHoursAgent2, top_hours_agent_3 = :topHoursAgent3, top_matches_agent_1 = :topMatchesAgent1, top_matches_agent_2 = :topMatchesAgent2, top_matches_agent_3 = :topMatchesAgent3, top_win_agent_1 = :topWinAgent1, top_win_agent_2 = :topWinAgent2, top_win_agent_3 = :topWinAgent3, top_kd_agent_1 = :topKdAgent1, top_kd_agent_2 = :topKdAgent2, top_kd_agent_3 = :topKdAgent3, top_weapon_1 = :topWeapon1, top_weapon_headshot_1 = :topWeaponHeadshot1, top_weapon_2 = :topWeapon2, top_weapon_headshot_2 = :topWeaponHeadshot2, top_weapon_3 = :topWeapon3, top_weapon_headshot_3 = :topWeaponHeadshot3, top_maps_1 = :topMaps1, top_maps_2 = :topMaps2, top_maps_3 = :topMaps3, top_maps_4 = :topMaps4, top_maps_5 = :topMaps5, top_porcentagem_map_win_1 = :topPorcentagemMapWin1, top_porcentagem_map_win_2 = :topPorcentagemMapWin2, top_porcentagem_map_win_3 = :topPorcentagemMapWin3, top_porcentagem_map_win_4 = :topPorcentagemMapWin4, top_porcentagem_map_win_5 = :topPorcentagemMapWin5 WHERE username = :username AND tag = :tag", nativeQuery = true)
        List<Object[]> updateJogador(@Param("playtime") double playtime, @Param("matches") double matches, @Param("rating") String rating, @Param("level") String level, @Param("loses") String loses, @Param("damageRound") String damageRound, @Param("headshot") String headshot, @Param("win") String win, @Param("wins") double wins, @Param("kills") double kills, @Param("deaths") double deaths, @Param("assists") double assists, @Param("kadRatio") String kadRatio, @Param("killsRound") String killsRound, @Param("clutches") String clutches, @Param("topAgents1") String topAgents1, @Param("topAgents2") String topAgents2, @Param("topAgents3") String topAgents3, @Param("topHoursAgent1") String topHoursAgent1, @Param("topHoursAgent2") String topHoursAgent2, @Param("topHoursAgent3") String topHoursAgent3, @Param("topMatchesAgent1") String topMatchesAgent1, @Param("topMatchesAgent2") String topMatchesAgent2, @Param("topMatchesAgent3") String topMatchesAgent3, @Param("topWinAgent1") String topWinAgent1, @Param("topWinAgent2") String topWinAgent2, @Param("topWinAgent3") String topWinAgent3, @Param("topKdAgent1") String topKdAgent1, @Param("topKdAgent2") String topKdAgent2, @Param("topKdAgent3") String topKdAgent3, @Param("topWeapon1") String topWeapon1, @Param("topWeaponHeadshot1") String topWeaponHeadshot1, @Param("topWeapon2") String topWeapon2, @Param("topWeaponHeadshot2") String topWeaponHeadshot2, @Param("topWeapon3") String topWeapon3, @Param("topWeaponHeadshot3") String topWeaponHeadshot3, @Param("topMaps1") String topMaps1, @Param("topMaps2") String topMaps2, @Param("topMaps3") String topMaps3, @Param("topMaps4") String topMaps4, @Param("topMaps5") String topMaps5, @Param("topPorcentagemMapWin1") String topPorcentagemMapWin1, @Param("topPorcentagemMapWin2") String topPorcentagemMapWin2, @Param("topPorcentagemMapWin3") String topPorcentagemMapWin3, @Param("topPorcentagemMapWin4") String topPorcentagemMapWin4, @Param("topPorcentagemMapWin5") String topPorcentagemMapWin5, @Param("username") String userName, @Param("tag") String tag);

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
