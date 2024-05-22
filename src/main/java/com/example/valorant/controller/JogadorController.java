package com.example.valorant.controller;

import com.example.valorant.jogador.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/search")
    public ResponseEntity<List<Jogador>> searchJogadores(@RequestParam String username) {
        List<Jogador> jogadores = repository.findByUsernameContainingIgnoreCase(username);
        return ResponseEntity.ok(jogadores);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<JogadorResponseDTO> getPlayerDetails(@PathVariable Long id) {
        Optional<Jogador> optionalJogador = repository.findById(id);
        if (optionalJogador.isPresent()) {
            JogadorResponseDTO jogadorResponseDTO = new JogadorResponseDTO(optionalJogador.get());
            return ResponseEntity.ok(jogadorResponseDTO);
        } else {
            throw new EntityNotFoundException("Player not found with id: " + id);
        }
    }

    @GetMapping("/porcen-vitoria")
    public List<Map<String, Object>> findWinPercentage() {
        List<Object[]> results = repository.findWinPercentage();
        List<Map<String, Object>> formattedResults = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> playerData = new LinkedHashMap<>();
            playerData.put("username", (String) result[0]);
            playerData.put("matches", ((BigDecimal) result[1]));
            playerData.put("winPercentage", (String) result[2]);
            formattedResults.add(playerData);
        }

        return formattedResults;
    }

    @GetMapping("/porcenVitAgent")
    public List<Map<String, Object>> porcenVitAgent() {
        List<Object[]> results = repository.porcenVitAgent();
        List<Map<String, Object>> formattedResults = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> playerData = new LinkedHashMap<>();
            playerData.put("username", (String) result[0]);
            playerData.put("Top Agente 1", (String) result[1]);
            playerData.put("Top Matches Agente 1", (String) result[2]);
            playerData.put("Top Win Agente 1", (String) result[3]);
            formattedResults.add(playerData);
        }

        return formattedResults;
    }

    @GetMapping("/jogadorHeadshotAcima30")
    public List<Map<String, Object>> jogadorHeadshotAcima30() {
        List<Object[]> results = repository.jogadorHeadshotAcima30();
        List<Map<String, Object>> formattedResults = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> playerData = new LinkedHashMap<>();
            playerData.put("username", (String) result[0]);
            playerData.put("kills", ((BigDecimal) result[1]));
            playerData.put("headshot", (String) result[2]);
            formattedResults.add(playerData);
        }

        return formattedResults;
    }

    @GetMapping("total-jogadores")
    public List<Map<String, Object>> totalJogador() {
        List<Object[]> results = repository.totalJogador();
        List<Map<String, Object>> formattedResults = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> playerData = new LinkedHashMap<>();
            playerData.put("Total Jogadores ", ((Number) result[0]).longValue());
            formattedResults.add(playerData);
        }

        return formattedResults;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("criar-jogador")
    public void saveJogador(@RequestBody JogadorRequestDTO data) {
        List<Object[]> existingPlayer = repository.jogadorExiste(data.username(), data.tag());
        Object[] rset = existingPlayer.get(0);
        boolean pExists = (boolean) rset[0];

        if (pExists) {
            repository.updateJogador(
                    data.dpR(),
                    data.kdr(),
                    data.headshot(),
                    data.win(),
                    data.wins(),
                    data.kast(),
                    data.dddeltaR(),
                    data.kills(),
                    data.deaths(),
                    data.assists(),
                    data.acs(),
                    data.kadRatio(),
                    data.killsPerRound(),
                    data.clutch1v1s(),
                    data.flawlessRounds(),
                    data.currentRating(),
                    data.peakRating(),
                    data.playtime(),
                    data.matches(),
                    data.level(),
                    data.losses(),
                    data.topAgent1(),
                    data.topAgent2(),
                    data.topAgent3(),
                    data.topHoursAgent1(),
                    data.topHoursAgent2(),
                    data.topHoursAgent3(),
                    data.topMatchesAgent1(),
                    data.topMatchesAgent2(),
                    data.topMatchesAgent3(),
                    data.topWinAgent1(),
                    data.topWinAgent2(),
                    data.topWinAgent3(),
                    data.topKDAgent1(),
                    data.topKDAgent2(),
                    data.topKDAgent3(),
                    data.topWeapon1(),
                    data.topWeaponHeadshot1(),
                    data.topWeapon2(),
                    data.topWeaponHeadshot2(),
                    data.topWeapon3(),
                    data.topWeaponHeadshot3(),
                    data.username(),
                    data.tag());
        } else {
            Jogador jogadorData = new Jogador(data);
            repository.save(jogadorData);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<JogadorResponseDTO> getJogadorById(@PathVariable Long id) {
        Optional<Jogador> optionalJogador = repository.findById(id);
        if (optionalJogador.isPresent()) {
            JogadorResponseDTO jogadorResponseDTO = new JogadorResponseDTO(optionalJogador.get());
            return ResponseEntity.ok(jogadorResponseDTO);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<JogadorResponseDTO> getAll() {

        List<JogadorResponseDTO> jogadorList = repository.findAll().stream().map(JogadorResponseDTO::new).toList();
        return jogadorList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateJogador(@PathVariable Long id, @RequestBody JogadorRequestDTO data) {
        Optional<Jogador> optionalJogador = repository.findById(id);
        if (optionalJogador.isPresent()) {
            Jogador jogador = optionalJogador.get();
            jogador.setUsername(data.username());
            jogador.setTag(data.tag());
            jogador.setUrl(data.url());
            jogador.setDpR(data.dpR());
            jogador.setKdr(data.kdr());
            jogador.setHeadshot(data.headshot());
            jogador.setWin(data.win());
            jogador.setWins(data.wins());
            jogador.setKast(data.kast());
            jogador.setDddeltaR(data.dddeltaR());
            jogador.setKills(data.kills());
            jogador.setDeaths(data.deaths());
            jogador.setAssists(data.assists());
            jogador.setAcs(data.acs());
            jogador.setKadRatio(data.kadRatio());
            jogador.setKillsPerRound(data.killsPerRound());
            jogador.setClutch1v1s(data.clutch1v1s());
            jogador.setFlawlessRounds(data.flawlessRounds());
            jogador.setCurrentRating(data.currentRating());
            jogador.setPeakRating(data.peakRating());
            jogador.setPlaytime(data.playtime());
            jogador.setMatches(data.matches());
            jogador.setLevel(data.level());
            jogador.setLosses(data.losses());
            jogador.setTopAgent1(data.topAgent1());
            jogador.setTopAgent2(data.topAgent2());
            jogador.setTopAgent3(data.topAgent3());
            jogador.setTopHoursAgent1(data.topHoursAgent1());
            jogador.setTopHoursAgent2(data.topHoursAgent2());
            jogador.setTopHoursAgent3(data.topHoursAgent3());
            jogador.setTopMatchesAgent1(data.topMatchesAgent1());
            jogador.setTopMatchesAgent2(data.topMatchesAgent2());
            jogador.setTopMatchesAgent3(data.topMatchesAgent3());
            jogador.setTopWinAgent1(data.topWinAgent1());
            jogador.setTopWinAgent2(data.topWinAgent2());
            jogador.setTopWinAgent3(data.topWinAgent3());
            jogador.setTopKDAgent1(data.topKDAgent1());
            jogador.setTopKDAgent2(data.topKDAgent2());
            jogador.setTopKDAgent3(data.topKDAgent3());
            jogador.setTopWeapon1(data.topWeapon1());
            jogador.setTopWeaponHeadshot1(data.topWeaponHeadshot1());
            jogador.setTopWeapon2(data.topWeapon2());
            jogador.setTopWeaponHeadshot2(data.topWeaponHeadshot2());
            jogador.setTopWeapon3(data.topWeapon3());
            jogador.setTopWeaponHeadshot3(data.topWeaponHeadshot3());
            repository.save(jogador);
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteJogador(@PathVariable Long id) {
        Optional<Jogador> optionalJogador = repository.findById(id);
        if (optionalJogador.isPresent()) {
            Jogador jogador = optionalJogador.get();
            repository.delete(jogador);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

}
