package com.example.valorant.jogador;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "jogadores")
@Entity(name = "jogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; 
    private String tag; 
    private String url; 
    private String dpR; 
    private String kdr; 
    private String headshot; 
    private String win; 
    private double wins; 
    private String kast; 
    private String dddeltaR; 
    private double kills; 
    private double deaths; 
    private double assists; 
    private String acs; 
    private String kadRatio; 
    private String killsPerRound; 
    private double clutch1v1s; 
    private double flawlessRounds;
    private String currentRating; 
    private String peakRating; 
    private double playtime; 
    private double matches; 
    private String level; 
    private double losses;
    private String topAgent1; 
    private String topAgent2; 
    private String topAgent3; 
    private String topHoursAgent1; 
    private String topHoursAgent2; 
    private String topHoursAgent3; 
    private String topMatchesAgent1; 
    private String topMatchesAgent2; 
    private String topMatchesAgent3; 
    private String topWinAgent1; 
    private String topWinAgent2; 
    private String topWinAgent3; 
    private String topKDAgent1; 
    private String topKDAgent2; 
    private String topKDAgent3; 
    private String topWeapon1; 
    private String topWeaponHeadshot1; 
    private String topWeapon2; 
    private String topWeaponHeadshot2; 
    private String topWeapon3; 
    private String topWeaponHeadshot3;

    // Construtor que recebe JogadorRequestDTO
    public Jogador(JogadorRequestDTO data) {
        this.username = data.username();
        this.tag = data.tag();
        this.url = data.url();
        this.dpR = data.dpR();
        this.kdr = data.kdr();
        this.headshot = data.headshot();
        this.win = data.win();
        this.wins = data.wins();
        this.kast = data.kast();
        this.dddeltaR = data.dddeltaR();
        this.kills = data.kills();
        this.deaths = data.deaths();
        this.assists = data.assists();
        this.acs = data.acs();
        this.kadRatio = data.kadRatio();
        this.killsPerRound = data.killsPerRound();
        this.clutch1v1s = data.clutch1v1s();
        this.flawlessRounds = data.flawlessRounds();
        this.currentRating = data.currentRating();
        this.peakRating = data.peakRating();
        this.playtime = data.playtime();
        this.matches = data.matches();
        this.level = data.level();
        this.losses = data.losses();
        this.topAgent1 = data.topAgent1();
        this.topAgent2 = data.topAgent2();
        this.topAgent3 = data.topAgent3();
        this.topHoursAgent1 = data.topHoursAgent1();
        this.topHoursAgent2 = data.topHoursAgent2();
        this.topHoursAgent3 = data.topHoursAgent3();
        this.topMatchesAgent1 = data.topMatchesAgent1();
        this.topMatchesAgent2 = data.topMatchesAgent2();
        this.topMatchesAgent3 = data.topMatchesAgent3();
        this.topWinAgent1 = data.topWinAgent1();
        this.topWinAgent2 = data.topWinAgent2();
        this.topWinAgent3 = data.topWinAgent3();
        this.topKDAgent1 = data.topKDAgent1();
        this.topKDAgent2 = data.topKDAgent2();
        this.topKDAgent3 = data.topKDAgent3();
        this.topWeapon1 = data.topWeapon1();
        this.topWeaponHeadshot1 = data.topWeaponHeadshot1();
        this.topWeapon2 = data.topWeapon2();
        this.topWeaponHeadshot2 = data.topWeaponHeadshot2();
        this.topWeapon3 = data.topWeapon3();
        this.topWeaponHeadshot3 = data.topWeaponHeadshot3();
    }
}

