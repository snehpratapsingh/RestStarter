package com.spr.sports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spr.sports.model.Player;
import com.spr.sports.model.Team;
import com.spr.sports.repository.PlayerRepository;
import com.spr.sports.repository.TeamRepository;

@RestController
@RequestMapping(path = "/sports/")
public class FootballService implements SportsService {
	@Autowired
	TeamRepository teamRepo;
	@Autowired
	PlayerRepository playerRepo;
	
	
	@Override
	@PostMapping(path="/team/add")
	public Team createTeam(@RequestBody Team team) {
		teamRepo.save(team);
		return team;
	}

	@Override
	@PostMapping(path="/player/add/{teamName}")
	public Player addPlayer(@RequestBody Player player, @PathVariable("teamName") String teamName) {
		/*
		 * Team team=teamRepo.findByTeamName(teamName);
		 * System.out.println("Team found: "+team); player.setPlayerTeam(team);
		 */
		System.out.println("Player to save : "+player);
		playerRepo.save(player);
		return player;
	}

	@Override
	@GetMapping(path = "/team/{teamId}")
	public List<Player> getAllPlayersByTeam(@PathVariable("teamId") int teamId) {
		System.out.println("getAllPlayersByTeam() called");
		List<Player> playerList=teamRepo.findAllPlayersByTeam(teamId);
		
		return playerList;
	}

}
