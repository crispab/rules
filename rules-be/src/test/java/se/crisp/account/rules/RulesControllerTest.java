package se.crisp.account.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class RulesControllerTest {

    private static final String SOME_CASINO = "some casino";
    private static final String SOME_NAME_RULE = "some name rule";
    private static final String SOME_OTHER_NAME_RULE = "some other name rule";
    private RulesController rulesController;

    @Mock
    private RuleRepository ruleRepository;

    @BeforeEach
    void setUp() {
        rulesController = new RulesController(ruleRepository);
    }

    @Test
    void postNewRule() {
        NewRuleRequest newRuleRequest = NewRuleRequest
                .casino(SOME_CASINO)
                .gameNameContains(SOME_NAME_RULE)
                .gameNameContainsNot(SOME_OTHER_NAME_RULE)
                .build();

        ResponseEntity<String> responseEntity = rulesController.postNewRule(newRuleRequest);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
