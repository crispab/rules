package se.crisp.account.rules.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rule {
    @Id
    private String id;

    @Column(name = "casino", length = 100)
    private String casino;

    @Column(name = "game_name_contains", length = 100)
    private String gameNameContains;

    @Column(name = "game_name_contains_not", length = 100)
    private String gameNameContainsNot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCasino() {
        return casino;
    }

    public void setCasino(String casino) {
        this.casino = casino;
    }

    public String getGameNameContains() {
        return gameNameContains;
    }

    public void setGameNameContains(String gameNameContains) {
        this.gameNameContains = gameNameContains;
    }

    public String getGameNameContainsNot() {
        return gameNameContainsNot;
    }

    public void setGameNameContainsNot(String gameNameContainsNot) {
        this.gameNameContainsNot = gameNameContainsNot;
    }
}
