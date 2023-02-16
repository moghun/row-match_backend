package com.dreamGames.rowMatchBackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ranks")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TournamentRankInGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userID", referencedColumnName = "ID")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "tournamentGroupID", referencedColumnName = "ID")
    private TournamentGroup group;
    private Boolean claimStatus;
    private Integer currentScore;
    private Integer finalRank;

    public TournamentRankInGroup(User user, TournamentGroup group, Boolean claimStatus, Integer currentScore) {
        this.user = user;
        this.group = group;
        this.claimStatus = claimStatus;
        this.currentScore = currentScore;
        this.finalRank = -1;
    }
}