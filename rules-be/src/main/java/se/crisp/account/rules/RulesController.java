package se.crisp.account.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.crisp.account.rules.domain.Rule;

import java.util.List;

@SuppressWarnings("MVCPathVariableInspection")
@RequestMapping("${api.base.path}/rules")
@RestController
public class RulesController {

    private final RuleRepository ruleRepository;

    @Autowired
    public RulesController(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @PostMapping
    public ResponseEntity<String> postNewRule(@RequestBody NewRuleRequest newRuleRequest) {
        Rule rule = Rule
                .casino(newRuleRequest.getCasino())
                .gameNameContains(newRuleRequest.getGameNameContains())
                .gameNameContainsNot(newRuleRequest.getGameNameContainsNot())
                .build();
        ruleRepository.save(rule);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rule>> getAllRules() {
        List<Rule> ruleList = ruleRepository.findAll();
        return new ResponseEntity<>(ruleList, HttpStatus.OK);
    }
}

