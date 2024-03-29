package com.example.valorant.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
