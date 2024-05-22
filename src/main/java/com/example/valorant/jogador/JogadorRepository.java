package com.example.valorant.jogador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

        Optional<Jogador> findByUsernameAndTag(String username, String tag);

        @Query(value = "SELECT COUNT(*) > 0 AS result FROM jogadores WHERE username = :username AND tag = :tag", nativeQuery = true)
        List<Object[]> jogadorExiste(@Param("username") String username, @Param("tag") String tag);

        @Query(value = "SELECT username, matches, win FROM jogadores", nativeQuery = true)
        List<Object[]> findWinPercentage();

        @Modifying
        @Query(value = """
            UPDATE jogadores SET
                Playtime = :playtime,
                Matches = :matches,
                peak_rating = :peakRating,
                current_rating = :currentRating,
                Level = :level,
                Losses = :losses,
                DpR = :dpR,
                Headshot = :headshot,
                Win = :win,
                Wins = :wins,
                Kills = :kills,
                Deaths = :deaths,
                Assists = :assists,
                Kdr = :kdr,
                kills_per_round = :killsPerRound,
                Clutch1v1s = :clutch1v1s,
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
                url = :url,
                kast = :kast,
                dddeltar = :dddeltar,
                acs = :acs,
                flawless_rounds = :flawlessRounds
            WHERE username = :username AND tag = :tag
            """, nativeQuery = true)
        void updateJogador(
                @Param("playtime") String playtime,
                @Param("matches") String matches,
                @Param("peakRating") String peakRating,
                @Param("currentRating") String currentRating,
                @Param("level") String level,
                @Param("losses") String losses,
                @Param("dpR") String dpR,
                @Param("headshot") String headshot,
                @Param("win") String win,
                @Param("wins") String wins,
                @Param("kills") String kills,
                @Param("deaths") String deaths,
                @Param("assists") String assists,
                @Param("kdr") String kdr,
                @Param("killsPerRound") String killsPerRound,
                @Param("clutch1v1s") String clutch1v1s,
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
                @Param("url") String url,
                @Param("kast") String kast,
                @Param("dddeltar") String dddeltaR,
                @Param("acs") String acs,
                @Param("flawlessRounds") String flawlessRounds,
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