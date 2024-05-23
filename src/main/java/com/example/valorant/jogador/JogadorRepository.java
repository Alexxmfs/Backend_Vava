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
            top_weapon_bodyshot1 = :topWeaponBodyshot1,
            top_weapon_legshot1 = :topWeaponLegshot1,
            top_weapon_kills1 = :topWeaponKills1,
            top_weapon2 = :topWeapon2,
            top_weapon_headshot2 = :topWeaponHeadshot2,
            top_weapon_bodyshot2 = :topWeaponBodyshot2,
            top_weapon_legshot2 = :topWeaponLegshot2,
            top_weapon_kills2 = :topWeaponKills2,
            top_weapon3 = :topWeapon3,
            top_weapon_headshot3 = :topWeaponHeadshot3,
            top_weapon_bodyshot3 = :topWeaponBodyshot3,
            top_weapon_legshot3 = :topWeaponLegshot3,
            top_weapon_kills3 = :topWeaponKills3,
            top_map1 = :topMap1,
            top_map_Winrate1 = :topMapWinrate1,
            Top_Map_Wins1 = :topMapWins1,
            Top_Map_Losses1 = :topMapLosses1,
            Top_Map2 = :topMap2,
            Top_Map_Winrate2 = :topMapWinrate2,
            Top_Map_Wins2 = :topMapWins2,
            Top_Map_Losses2 = :topMapLosses2,
            Top_Map3 = :topMap3,
            Top_Map_Winrate3 = :topMapWinrate3,
            Top_Map_Wins3 = :topMapWins3,
            Top_Map_Losses3 = :topMapLosses3,
            Top_Map4 = :topMap4,
            Top_Map_Winrate4 = :topMapWinrate4,
            Top_Map_Wins4 = :topMapWins4,
            Top_Map_Losses4 = :topMapLosses4,
            Top_Map5 = :topMap5,
            Top_Map_Winrate5 = :topMapWinrate5,
            Top_Map_Wins5 = :topMapWins5,
            Top_Map_Losses5 = :topMapLosses5,
            Top_Map6 = :topMap6,
            Top_Map_Winrate6 = :topMapWinrate6,
            Top_Map_Wins6 = :topMapWins6,
            Top_Map_Losses6 = :topMapLosses6,
            Top_Map7 = :topMap7,
            Top_Map_Winrate7 = :topMapWinrate7,
            Top_Map_Wins7 = :topMapWins7,
            Top_Map_Losses7 = :topMapLosses7,
            Top_Map8 = :topMap8,
            Top_Map_Winrate8 = :topMapWinrate8,
            Top_Map_Wins8 = :topMapWins8,
            Top_Map_Losses8 = :topMapLosses8,
            Top_Map9 = :topMap9,
            Top_Map_Winrate9 = :topMapWinrate9,
            Top_Map_Wins9 = :topMapWins9,
            Top_Map_Losses9 = :topMapLosses9,
            Top_Map10 = :topMap10,
            Top_Map_Winrate10 = :topMapWinrate10,
            Top_Map_Wins10 = :topMapWins10,
            Top_Map_Losses10 = :topMapLosses10,
            Views = :views,
            rank = :rank
        WHERE username = :username AND tag = :tag
        """, nativeQuery = true)
    void updateJogador(
            @Param("url") String url, 
            @Param("dpR") double dpR, 
            @Param("kdr") double kdr, 
            @Param("headshot") double headshot,
            @Param("win") double win, 
            @Param("wins") double wins,
            @Param("kast") double kast,
            @Param("dddeltar") double dddeltaR,
            @Param("kills") double kills, 
            @Param("deaths") double deaths,
            @Param("assists") double assists,
            @Param("acs") double acs, 
            @Param("kadRatio") double kadRatio,
            @Param("killsPerRound") double killsPerRound,
            @Param("clutch1v1s") double clutch1v1s,
            @Param("flawlessRounds") double flawlessRounds,
            @Param("currentRating") double currentRating,
            @Param("peakRating") double peakRating,
            @Param("playtime") double playtime,
            @Param("matches") double matches, 
            @Param("level") double level, 
            @Param("losses") double losses,
            @Param("topAgent1") String topAgent1, 
            @Param("topAgent2") String topAgent2, 
            @Param("topAgent3") String topAgent3, 
            @Param("topHoursAgent1") double topHoursAgent1, 
            @Param("topHoursAgent2") double topHoursAgent2, 
            @Param("topHoursAgent3") double topHoursAgent3, 
            @Param("topMatchesAgent1") double topMatchesAgent1, 
            @Param("topMatchesAgent2") double topMatchesAgent2, 
            @Param("topMatchesAgent3") double topMatchesAgent3, 
            @Param("topWinAgent1") double topWinAgent1, 
            @Param("topWinAgent2") double topWinAgent2, 
            @Param("topWinAgent3") double topWinAgent3, 
            @Param("topKDAgent1") double topKDAgent1, 
            @Param("topKDAgent2") double topKDAgent2, 
            @Param("topKDAgent3") double topKDAgent3, 
            @Param("topWeapon1") String topWeapon1, 
            @Param("topWeaponHeadshot1") double topWeaponHeadshot1, 
            @Param("topWeaponBodyshot1") double topWeaponBodyshot1,
            @Param("topWeaponLegshot1") double topWeaponLegshot1,
            @Param("topWeaponKills1") double topWeaponKills1,
            @Param("topWeapon2") String topWeapon2, 
            @Param("topWeaponHeadshot2") double topWeaponHeadshot2, 
            @Param("topWeaponBodyshot2") double topWeaponBodyshot2,
            @Param("topWeaponLegshot2") double topWeaponLegshot2,
            @Param("topWeaponKills2") double topWeaponKills2,
            @Param("topWeapon3") String topWeapon3, 
            @Param("topWeaponHeadshot3") double topWeaponHeadshot3,
            @Param("topWeaponBodyshot3") double topWeaponBodyshot3,
            @Param("topWeaponLegshot3") double topWeaponLegshot3,
            @Param("topWeaponKills3") double topWeaponKills3,
            @Param("topMap1") String topMap1,
            @Param("topMapWinrate1") double topMapWinrate1,
            @Param("topMapWins1") double topMapWins1,
            @Param("topMapLosses1") double topMapLosses1,
            @Param("topMap2") String topMap2,
            @Param("topMapWinrate2") double topMapWinrate2,
            @Param("topMapWins2") double topMapWins2,
            @Param("topMapLosses2") double topMapLosses2,
            @Param("topMap3") String topMap3,
            @Param("topMapWinrate3") double topMapWinrate3,
            @Param("topMapWins3") double topMapWins3,
            @Param("topMapLosses3") double topMapLosses3,
            @Param("topMap4") String topMap4,
            @Param("topMapWinrate4") double topMapWinrate4,
            @Param("topMapWins4") double topMapWins4,
            @Param("topMapLosses4") double topMapLosses4,
            @Param("topMap5") String topMap5,
            @Param("topMapWinrate5") double topMapWinrate5,
            @Param("topMapWins5") double topMapWins5,
            @Param("topMapLosses5") double topMapLosses5,
            @Param("topMap6") String topMap6,
            @Param("topMapWinrate6") double topMapWinrate6,
            @Param("topMapWins6") double topMapWins6,
            @Param("topMapLosses6") double topMapLosses6,
            @Param("topMap7") String topMap7,
            @Param("topMapWinrate7") double topMapWinrate7,
            @Param("topMapWins7") double topMapWins7,
            @Param("topMapLosses7") double topMapLosses7,
            @Param("topMap8") String topMap8,
            @Param("topMapWinrate8") double topMapWinrate8,
            @Param("topMapWins8") double topMapWins8,
            @Param("topMapLosses8") double topMapLosses8,
            @Param("topMap9") String topMap9,
            @Param("topMapWinrate9") double topMapWinrate9,
            @Param("topMapWins9") double topMapWins9,
            @Param("topMapLosses9") double topMapLosses9,
            @Param("topMap10") String topMap10,
            @Param("topMapWinrate10") double topMapWinrate10,
            @Param("topMapWins10") double topMapWins10,
            @Param("topMapLosses5") double topMapLosses10,
            @Param("views") double views,
            @Param("rank") String rank,
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
