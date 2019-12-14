package se.crisp.account.rules;

import org.springframework.data.jpa.repository.JpaRepository;
import se.crisp.account.rules.domain.Rule;

public interface RuleRepository extends JpaRepository<Rule, String> {
}
