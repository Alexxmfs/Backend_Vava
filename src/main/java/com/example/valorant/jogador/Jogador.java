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
    private double dpR; 
    private double kdr; 
    private double headshot; 
    private double win; 
    private double wins; 
    private double kast; 
    private double dddeltaR; 
    private double kills; 
    private double deaths; 
    private double assists; 
    private double acs; 
    private double kadRatio; 
    private double killsPerRound; 
    private double clutch1v1s; 
    private double flawlessRounds;
    private double currentRating; 
    private double peakRating; 
    private double playtime; 
    private double matches; 
    private double level; 
    private double losses;
    private String topAgent1; 
    private String topAgent2; 
    private String topAgent3; 
    private double topHoursAgent1; 
    private double topHoursAgent2; 
    private double topHoursAgent3; 
    private double topMatchesAgent1; 
    private double topMatchesAgent2; 
    private double topMatchesAgent3; 
    private double topWinAgent1; 
    private double topWinAgent2; 
    private double topWinAgent3; 
    private double topKDAgent1; 
    private double topKDAgent2; 
    private double topKDAgent3; 
    private String topWeapon1; 
    private double topWeaponHeadshot1; 
    private double topWeaponBodyshot1; 
    private double topWeaponLegshot1;
    private double topWeaponKills1; 
    private String topWeapon2; 
    private double topWeaponHeadshot2;
    private double topWeaponBodyshot2; 
    private double topWeaponLegshot2; 
    private double topWeaponKills2;
    private String topWeapon3; 
    private double topWeaponHeadshot3;
    private double topWeaponBodyshot3; 
    private double topWeaponLegshot3;
    private double topWeaponKills3;

    private String topMap1;
    private double topMapWinrate1;
    private double topMapWins1;
    private double topMapLosses1;
    private String topMap2;
    private double topMapWinrate2;
    private double topMapWins2;
    private double topMapLosses2;
    private String topMap3;
    private double topMapWinrate3;
    private double topMapWins3;
    private double topMapLosses3;
    private String topMap4;
    private double topMapWinrate4;
    private double topMapWins4;
    private double topMapLosses4;
    private String topMap5;
    private double topMapWinrate5;
    private double topMapWins5;
    private double topMapLosses5;
    private double views;

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
        this.topWeaponBodyshot1 = data.topWeaponBodyshot1();
        this.topWeaponLegshot1 = data.topWeaponLegshot1();
        this.topWeaponKills1 = data.topWeaponKills1();
        this.topWeapon2 = data.topWeapon2();
        this.topWeaponHeadshot2 = data.topWeaponHeadshot2();
        this.topWeaponBodyshot2 = data.topWeaponBodyshot2();
        this.topWeaponLegshot2 = data.topWeaponLegshot2();
        this.topWeaponKills2 = data.topWeaponKills2();
        this.topWeapon3 = data.topWeapon3();
        this.topWeaponHeadshot3 = data.topWeaponHeadshot3();
        this.topWeaponBodyshot3 = data.topWeaponBodyshot3();
        this.topWeaponLegshot3 = data.topWeaponLegshot3();
        this.topWeaponKills3 = data.topWeaponKills3();
        this.topMap1 = data.topMap1();
        this.topMapWinrate1 = data.topMapWinrate1();
        this.topMapWins1 = data.topMapWins1();
        this.topMapLosses1 = data.topMapLosses1();
        this.topMap2 = data.topMap2();
        this.topMapWinrate2 = data.topMapWinrate2();
        this.topMapWins2 = data.topMapWins2();
        this.topMapLosses2 = data.topMapLosses2();
        this.topMap3 = data.topMap3();
        this.topMapWinrate3 = data.topMapWinrate3();
        this.topMapWins3 = data.topMapWins3();
        this.topMapLosses3 = data.topMapLosses3();
        this.topMap4 = data.topMap4();
        this.topMapWinrate4 = data.topMapWinrate4();
        this.topMapWins4 = data.topMapWins4();
        this.topMapLosses4 = data.topMapLosses4();
        this.topMap5 = data.topMap5();
        this.topMapWinrate5 = data.topMapWinrate5();
        this.topMapWins5 = data.topMapWins5();
        this.topMapLosses5 = data.topMapLosses5();
        this.views = data.views();
    }
}

