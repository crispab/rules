package se.crisp.account.rules;

public class NewRuleRequest {
    private String casino;
    private String gameNameContains;
    private String gameNameContainsNot;

    public String getCasino() {
        return casino;
    }

    public String getGameNameContains() {
        return gameNameContains;
    }

    public String getGameNameContainsNot() {
        return gameNameContainsNot;
    }

    public static IGameNameContains casino(String casinoField) {
        return new Builder(casinoField);
    }

    public static class Builder implements IGameNameContains, IGameNameContainsNot, IBuild {
        private final NewRuleRequest rule;

        public Builder(String casino) {
            rule = new NewRuleRequest();
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
        public NewRuleRequest build() {
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
        NewRuleRequest build();
    }
}
