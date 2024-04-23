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
            playerData.put("username", (String) result[0]); // Nome do jogador
            playerData.put("matches", ((BigDecimal) result[1])); // Número de partidas
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
            playerData.put("username", (String) result[0]); // Nome do jogador
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
            playerData.put("username", (String) result[0]); // Nome do jogador
            playerData.put("kills", ((BigDecimal) result[1])); // Número de partidas
            playerData.put("headshot", (String) result[2]); // Percentual de vitórias
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
            playerData.put("Total Jogadores ", ((Number) result[0]).longValue()); // Cast to Long
            formattedResults.add(playerData);
        }

        return formattedResults;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("criar-jogador")
    public void saveJogador(@RequestBody JogadorRequestDTO data){
        Jogador jogadorData = new Jogador(data);
        repository.save(jogadorData);
        return;
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
    public List<JogadorResponseDTO> getAll(){

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
            jogador.setPlaytime(data.playtime());
            jogador.setMatches(data.matches());
            jogador.setRating(data.rating());
            jogador.setLevel(data.level());
            jogador.setLoses(data.loses());
            jogador.setDamage_round(data.damage_round());
            jogador.setHeadshot(data.headshot());
            jogador.setWin(data.win());
            jogador.setWins(data.wins());
            jogador.setKills(data.kills());
            jogador.setDeaths(data.deaths());
            jogador.setAssists(data.assists());
            jogador.setKad_ratio(data.kad_ratio());
            jogador.setKills_round(data.kills_round());
            jogador.setClutches(data.clutches());
            jogador.setTop_agents_1(data.top_agents_1());
            jogador.setTop_hours_agent_1(data.top_hours_agent_1());
            jogador.setTop_matches_agent_1(data.top_matches_agent_1());
            jogador.setTop_win_agent_1(data.top_win_agent_1());
            jogador.setTop_kd_agent_1(data.top_kd_agent_1());
            jogador.setTop_weapon_1(data.top_weapon_1());
            jogador.setTop_weapon_headshot_1(data.top_weapon_headshot_1());
            jogador.setTop_weapon_2(data.top_weapon_2());
            jogador.setTop_weapon_headshot_2(data.top_weapon_headshot_2());
            jogador.setTop_maps_1(data.top_maps_1());
            jogador.setTop_porcentagem_map_win_1(data.top_porcentagem_map_win_1());
            repository.save(jogador);
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteJogador(@PathVariable Long id){
        Optional<Jogador> optionalJogador = repository.findById(id);
        if(optionalJogador.isPresent()){
            Jogador jogador = optionalJogador.get();
            repository.delete(jogador);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

}
