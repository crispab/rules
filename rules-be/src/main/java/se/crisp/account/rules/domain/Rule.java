package se.crisp.account.rules.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

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

    void setId(String id) {
        this.id = id;
    }

    public String getCasino() {
        return casino;
    }

    void setCasino(String casino) {
        this.casino = casino;
    }

    public String getGameNameContains() {
        return gameNameContains;
    }

    void setGameNameContains(String gameNameContains) {
        this.gameNameContains = gameNameContains;
    }

    public String getGameNameContainsNot() {
        return gameNameContainsNot;
    }

    void setGameNameContainsNot(String gameNameContainsNot) {
        this.gameNameContainsNot = gameNameContainsNot;
    }

    public static IGameNameContains casino(String casino) {
        return new Builder(casino);
    }

    public static class Builder implements IGameNameContains, IGameNameContainsNot, IBuild {
        private final Rule rule;

        public Builder(String casino) {
            rule = new Rule();
            rule.casino = casino;
        }

        @Override
        public IGameNameContainsNot gameNameContains(String gameNameContains) {
            rule.gameNameContains = gameNameContains;
            return this;
        }

        @Override
        public IBuild gameNameContainsNot(String gameNameContainsNot) {
            rule.gameNameContainsNot = gameNameContainsNot;
            return this;
        }

        @Override
        public Rule build() {
            rule.id = UUID.randomUUID().toString();
            return rule;
        }
    }

    public interface IGameNameContains {
        IGameNameContainsNot gameNameContains(String gameNameContains);
    }

    public interface IGameNameContainsNot {
        IBuild gameNameContainsNot(String gameNameContainsNot);
    }

    public interface IBuild {
        Rule build();
    }

}
