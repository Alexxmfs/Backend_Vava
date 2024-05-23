package com.example.valorant.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    Optional<Jogador> findByUsernameAndTag(String username, String tag);

    @Query(value = "SELECT COUNT(*) > 0 AS result FROM jogadores WHERE username = :username AND tag = :tag", nativeQuery = true)
    List<Object[]> jogadorExiste(@Param("username") String username, @Param("tag") String tag);

    @Query(value = "SELECT username, matches, win FROM jogadores", nativeQuery = true)
    List<Object[]> findWinPercentage();

    @Transactional
    @Modifying
    @Query(value = """
        UPDATE jogadores SET
            url = :url,
            DpR = :dpR,
            Kdr = :kdr, 
            Headshot = :headshot,
            Win = :win,
            Wins = :wins,
            kast = :kast,
            dddeltar = :dddeltar,
            Kills = :kills,
            Deaths = :deaths,
            Assists = :assists,
            acs = :acs,
            kadRatio = :kadRatio,
            kills_per_round = :killsPerRound,
            Clutch1v1s = :clutch1v1s,
            flawless_rounds = :flawlessRounds,
            current_rating = :currentRating,
            peak_rating = :peakRating,
            Playtime = :playtime,
            Matches = :matches,
            Level = :level,
            Losses = :losses,
            top_agent1 = :topAgent1,  
            top_agent2 = :topAgent2,
            top_agent3 = :topAgent3,
            top_hours_agent1 = :topHoursAgent1,
            top_hours_agent2 = :topHoursAgent2,
            top_hours_agent3 = :topHoursAgent3,
            top_matches_agent1 = :topMatchesAgent1,
            top_matches_agent2 = :topMatchesAgent2,
            top_matches_agent3 = :topMatchesAgent3,
            top_win_agent1 = :topWinAgent1,
            top_win_agent2 = :topWinAgent2,
            top_win_agent3 = :topWinAgent3,
            TopKDAgent1 = :topKDAgent1,
            TopKDAgent2 = :topKDAgent2,
            TopKDAgent3 = :topKDAgent3,
            top_weapon1 = :topWeapon1,
            top_weapon_headshot1 = :topWeaponHeadshot1,
            top_weapon2 = :topWeapon2,
            top_weapon_headshot2 = :topWeaponHeadshot2,
            top_weapon3 = :topWeapon3,
            top_weapon_headshot3 = :topWeaponHeadshot3,
            TopMap1 = :topMap1,
            TopMapWinrate1 = :topMapWinrate1,
            TopMapWins1 = :topMapWins1,
            TopMapLosses1 = :topMapLosses1,
            TopMap2 = :topMap2,
            TopMapWinrate2 = :topMapWinrate2,
            TopMapWins2 = :topMapWins2,
            TopMapLosses2 = :topMapLosses2,
            TopMap3 = :topMap3,
            TopMapWinrate3 = :topMapWinrate3,
            TopMapWins3 = :topMapWins3,
            TopMapLosses3 = :topMapLosses3,
            TopMap4 = :topMap4,
            TopMapWinrate4 = :topMapWinrate4,
            TopMapWins4 = :topMapWins4,
            TopMapLosses4 = :topMapLosses4,
            TopMap5 = :topMap5,
            TopMapWinrate5 = :topMapWinrate5,
            TopMapWins5 = :topMapWins5,
            TopMapLosses5 = :topMapLosses5,
            Views = :views
        WHERE username = :username AND tag = :tag
        """, nativeQuery = true)
    void updateJogador(
            @Param("url") String url, 
            @Param("dpR") String dpR, 
            @Param("kdr") String kdr, 
            @Param("headshot") String headshot,
            @Param("win") String win, 
            @Param("wins") double wins,
            @Param("kast") String kast,
            @Param("dddeltar") String dddeltaR,
            @Param("kills") double kills, 
            @Param("deaths") double deaths,
            @Param("assists") double assists,
            @Param("acs") String acs, 
            @Param("kadRatio") String kadRatio,
            @Param("killsPerRound") String killsPerRound,
            @Param("clutch1v1s") double clutch1v1s,
            @Param("flawlessRounds") double flawlessRounds,
            @Param("currentRating") String currentRating,
            @Param("peakRating") String peakRating,
            @Param("playtime") double playtime,
            @Param("matches") double matches, 
            @Param("level") String level, 
            @Param("losses") double losses,
            @Param("topAgent1") String topAgent1, 
            @Param("topAgent2") String topAgent2, 
            @Param("topAgent3") String topAgent3, 
            @Param("topHoursAgent1") String topHoursAgent1, 
            @Param("topHoursAgent2") String topHoursAgent2, 
            @Param("topHoursAgent3") String topHoursAgent3, 
            @Param("topMatchesAgent1") String topMatchesAgent1, 
            @Param("topMatchesAgent2") String topMatchesAgent2, 
            @Param("topMatchesAgent3") String topMatchesAgent3, 
            @Param("topWinAgent1") String topWinAgent1, 
            @Param("topWinAgent2") String topWinAgent2, 
            @Param("topWinAgent3") String topWinAgent3, 
            @Param("topKDAgent1") String topKDAgent1, 
            @Param("topKDAgent2") String topKDAgent2, 
            @Param("topKDAgent3") String topKDAgent3, 
            @Param("topWeapon1") String topWeapon1, 
            @Param("topWeaponHeadshot1") String topWeaponHeadshot1, 
            @Param("topWeapon2") String topWeapon2, 
            @Param("topWeaponHeadshot2") String topWeaponHeadshot2, 
            @Param("topWeapon3") String topWeapon3, 
            @Param("topWeaponHeadshot3") String topWeaponHeadshot3,
            @Param("topMap1") String topMap1,
            @Param("topMapWinrate1") String topMapWinrate1,
            @Param("topMapWins1") String topMapWins1,
            @Param("topMapLosses1") String topMapLosses1,
            @Param("topMap2") String topMap2,
            @Param("topMapWinrate2") String topMapWinrate2,
            @Param("topMapWins2") String topMapWins2,
            @Param("topMapLosses2") String topMapLosses2,
            @Param("topMap3") String topMap3,
            @Param("topMapWinrate3") String topMapWinrate3,
            @Param("topMapWins3") String topMapWins3,
            @Param("topMapLosses3") String topMapLosses3,
            @Param("topMap4") String topMap4,
            @Param("topMapWinrate4") String topMapWinrate4,
            @Param("topMapWins4") String topMapWins4,
            @Param("topMapLosses4") String topMapLosses4,
            @Param("topMap5") String topMap5,
            @Param("topMapWinrate5") String topMapWinrate5,
            @Param("topMapWins5") String topMapWins5,
            @Param("topMapLosses5") String topMapLosses5,
            @Param("views") String views,
            @Param("username") String username,
            @Param("tag") String tag);

    @Query(value = "SELECT username, top_agents_1, top_matches_agent_1, top_win_agent_1 FROM JOGADORES", nativeQuery = true)
    List<Object[]> porcenVitAgent();

    @Query(value = """
                    SELECT
                        username,
                        kills,
                        headshot
                    FROM
                        jogadores
                    WHERE
                        CAST(REPLACE(headshot, '%', '') AS NUMERIC) > 30""", nativeQuery = true)
    List<Object[]> jogadorHeadshotAcima30();

    @Query(value = "SELECT COUNT(*) AS total_jogadores FROM jogadores", nativeQuery = true)
    List<Object[]> totalJogador();

    List<Jogador> findByUsernameContainingIgnoreCase(String username);
}
