package com.spr.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.sports.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
