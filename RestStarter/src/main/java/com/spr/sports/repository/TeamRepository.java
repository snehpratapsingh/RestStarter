package com.spr.sports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spr.sports.model.Player;
import com.spr.sports.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	@Query("from Player where team_Id=:teamId")
	List<Player> findAllPlayersByTeam(@Param("teamId") int teamId);

	Team findByTeamName(String teamName);
	
	

	
}
