package com.spr.sports.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence")
	@SequenceGenerator(name = "team_sequence", sequenceName = "TEAM_SEQ")
	private int teamId;

	private String teamName;

	@OneToMany(mappedBy = "playerTeam", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Player> teamPlayerList;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getTeamPlayerList() {
		return teamPlayerList;
	}

	public void setTeamPlayerList(List<Player> teamPlayerList) {
		this.teamPlayerList = teamPlayerList;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName +  "]";
	}

}
