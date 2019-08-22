package com.spr.sports.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
	@SequenceGenerator(name = "player_sequence", sequenceName = "PLAYER_SEQ")
	private int playerId;

	private String playerName;

	private String playerPosition;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team playerTeam;

	
	public Player(String playerName, String playerPosition, Team playerTeam) {
		
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.playerTeam = playerTeam;
	}
	public Player() {}
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public Team getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(Team playerTeam) {
		this.playerTeam = playerTeam;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", playerPosition=" + playerPosition
				+  "]";
	}

}
