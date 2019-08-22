package com.spr.sports.service;

import java.util.List;

import com.spr.sports.model.Player;
import com.spr.sports.model.Team;

public interface SportsService {
	public Team createTeam(Team team);
	public Player addPlayer(Player player, String teamId);
	public List<Player> getAllPlayersByTeam(int teamId);
	
}
