package com.example.valorant.jogador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "jogadores")
@Entity(name = "jogadores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String tag;
    private double playtime;
    private double matches;
    private String rating;
    private String level;
    private String loses;
    private String damage_round;
    private String headshot;
    private String win;
    private double wins;
    private double kills;
    private double deaths;
    private double assists;
    private String kad_ratio;
    private String kills_round;
    private String clutches;
    private String top_agents_1;
    private String top_agents_2;
    private String top_agents_3;
    private String top_hours_agent_1;
    private String top_hours_agent_2;
    private String top_hours_agent_3;
    private String top_matches_agent_1;
    private String top_matches_agent_2;
    private String top_matches_agent_3;
    private String top_win_agent_1;
    private String top_win_agent_2;
    private String top_win_agent_3;
    private String top_kd_agent_1;
    private String top_kd_agent_2;
    private String top_kd_agent_3;
    private String top_weapon_1;
    private String top_weapon_headshot_1;
    private String top_weapon_2;
    private String top_weapon_headshot_2;
    private String top_weapon_3;
    private String top_weapon_headshot_3;
    private String top_maps_1;
    private String top_maps_2;
    private String top_maps_3;
    private String top_maps_4;
    private String top_maps_5;
    private String top_porcentagem_map_win_1;
    private String top_porcentagem_map_win_2;
    private String top_porcentagem_map_win_3;
    private String top_porcentagem_map_win_4;
    private String top_porcentagem_map_win_5;

    public Jogador(JogadorRequestDTO data){
        this.username = data.username();
        this.tag = data.tag();
        this.playtime = data.playtime();
        this.matches = data.matches();
        this.rating = data.rating();
        this.level = data.level();
        this.loses = data.loses();
        this.damage_round = data.damage_round();
        this.headshot = data.headshot();
        this.win = data.win();
        this.wins = data.wins();
        this.kills = data.kills();
        this.deaths = data.deaths();
        this.assists = data.assists();
        this.kad_ratio = data.kad_ratio();
        this.kills_round = data.kills_round();
        this.clutches = data.clutches();
        this.top_agents_1 = data.top_agents_1();
        this.top_agents_2 = data.top_agents_2();
        this.top_agents_3 = data.top_agents_3();
        this.top_hours_agent_1 = data.top_hours_agent_1();
        this.top_hours_agent_2 = data.top_hours_agent_2();
        this.top_hours_agent_3 = data.top_hours_agent_3();
        this.top_matches_agent_1 = data.top_matches_agent_1();
        this.top_matches_agent_2 = data.top_matches_agent_2();
        this.top_matches_agent_3 = data.top_matches_agent_3();
        this.top_win_agent_1 = data.top_win_agent_1();
        this.top_win_agent_2 = data.top_win_agent_2();
        this.top_win_agent_3 = data.top_win_agent_3();
        this.top_kd_agent_1 = data.top_kd_agent_1();
        this.top_kd_agent_2 = data.top_kd_agent_2();
        this.top_kd_agent_3 = data.top_kd_agent_3();
        this.top_weapon_1 = data.top_weapon_1();
        this.top_weapon_headshot_1 = data.top_weapon_headshot_1();
        this.top_weapon_2 = data.top_weapon_2();
        this.top_weapon_headshot_2 = data.top_weapon_headshot_2();
        this.top_weapon_3 = data.top_weapon_3();
        this.top_weapon_headshot_3 = data.top_weapon_headshot_3();
        this.top_maps_1 = data.top_maps_1();
        this.top_maps_2 = data.top_maps_2();
        this.top_maps_3 = data.top_maps_3();
        this.top_maps_4 = data.top_maps_4();
        this.top_maps_5 = data.top_maps_5();
        this.top_porcentagem_map_win_1 = data.top_porcentagem_map_win_1();
        this.top_porcentagem_map_win_2 = data.top_porcentagem_map_win_2();
        this.top_porcentagem_map_win_3 = data.top_porcentagem_map_win_3();
        this.top_porcentagem_map_win_4 = data.top_porcentagem_map_win_4();
        this.top_porcentagem_map_win_5 = data.top_porcentagem_map_win_5();
    }

    public void setUsername(String username) {this.username = username;}

    public void setTag(String tag) {this.tag = tag;}

    public void setPlaytime(double playtime) {this.playtime = playtime;}

    public void setMatches(double matches) {this.matches = matches;}

    public void setRating(String rating) {this.rating = rating;}

    public void setLevel(String level) {this.level = level;}

    public void setLoses(String loses) {this.loses = loses;}

    public void setDamage_round(String damage_round) {this.damage_round = damage_round;}

    public void setHeadshot(String headshot) {this.headshot = headshot;}

    public void setWin(String win) {this.win = win;}

    public void setWins(double wins) {this.wins = wins;}

    public void setKills(double kills) {this.kills = kills;}

    public void setDeaths(double deaths) {this.deaths = deaths;}

    public void setAssists(double assists) {this.assists = assists;}

    public void setKad_ratio(String kad_ratio) {this.kad_ratio = kad_ratio;}

    public void setKills_round(String kills_round) {this.kills_round = kills_round;}

    public void setClutches(String clutches) {this.clutches = clutches;}

    public void setTop_agents_1(String top_agents_1) {this.top_agents_1 = top_agents_1;}

    public void setTop_agents_2(String top_agents_2) {this.top_agents_2 = top_agents_2;}

    public void setTop_agents_3(String top_agents_3) {this.top_agents_3 = top_agents_3;}

    public void setTop_hours_agent_1(String top_hours_agent_1) {this.top_hours_agent_1 = top_hours_agent_1;}

    public void setTop_hours_agent_2(String top_hours_agent_2) {this.top_hours_agent_2 = top_hours_agent_2;}

    public void setTop_hours_agent_3(String top_hours_agent_3) {this.top_hours_agent_3 = top_hours_agent_3;}

    public void setTop_matches_agent_1(String top_matches_agent_1) {this.top_matches_agent_1 = top_matches_agent_1;}

    public void setTop_matches_agent_2(String top_matches_agent_2) {this.top_matches_agent_2 = top_matches_agent_2;}

    public void setTop_matches_agent_3(String top_matches_agent_3) {this.top_matches_agent_3 = top_matches_agent_3;}

    public void setTop_win_agent_1(String top_win_agent_1) {this.top_win_agent_1 = top_win_agent_1;}

    public void setTop_win_agent_2(String top_win_agent_2) {this.top_win_agent_2 = top_win_agent_2;}

    public void setTop_win_agent_3(String top_win_agent_3) {this.top_win_agent_3 = top_win_agent_3;}

    public void setTop_kd_agent_1(String top_kd_agent_1) {this.top_kd_agent_1 = top_kd_agent_1;}

    public void setTop_kd_agent_2(String top_kd_agent_2) {this.top_kd_agent_2 = top_kd_agent_2;}

    public void setTop_kd_agent_3(String top_kd_agent_3) {this.top_kd_agent_3 = top_kd_agent_3;}

    public void setTop_weapon_1(String top_weapon_1) {this.top_weapon_1 = top_weapon_1;}

    public void setTop_weapon_headshot_1(String top_weapon_headshot_1) {this.top_weapon_headshot_1 = top_weapon_headshot_1;}

    public void setTop_weapon_2(String top_weapon_2) {this.top_weapon_2 = top_weapon_2;}

    public void setTop_weapon_headshot_2(String top_weapon_headshot_2) {this.top_weapon_headshot_2 = top_weapon_headshot_2;}

    public void setTop_weapon_3(String top_weapon_3) {this.top_weapon_3 = top_weapon_3;}

    public void setTop_weapon_headshot_3(String top_weapon_headshot_3) {this.top_weapon_headshot_3 = top_weapon_headshot_3;}

    public void setTop_maps_1(String top_maps_1) {this.top_maps_1 = top_maps_1;}

    public void setTop_maps_2(String top_maps_2) {this.top_maps_2 = top_maps_2;}

    public void setTop_maps_3(String top_maps_3) {this.top_maps_3 = top_maps_3;}

    public void setTop_maps_4(String top_maps_4) {this.top_maps_4 = top_maps_4;}

    public void setTop_maps_5(String top_maps_5) {this.top_maps_5 = top_maps_5;}

    public void setTop_porcentagem_map_win_1(String top_porcentagem_map_win_1) {this.top_porcentagem_map_win_1 = top_porcentagem_map_win_1;}

    public void setTop_porcentagem_map_win_2(String top_porcentagem_map_win_2) {this.top_porcentagem_map_win_2 = top_porcentagem_map_win_2;}

    public void setTop_porcentagem_map_win_3(String top_porcentagem_map_win_3) {this.top_porcentagem_map_win_3 = top_porcentagem_map_win_3;}

    public void setTop_porcentagem_map_win_4(String top_porcentagem_map_win_4) {this.top_porcentagem_map_win_4 = top_porcentagem_map_win_4;}

    public void setTop_porcentagem_map_win_5(String top_porcentagem_map_win_5) {this.top_porcentagem_map_win_5 = top_porcentagem_map_win_5;}

}
