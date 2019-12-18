package au.com.optus.ctc.controller;

import au.com.optus.ctc.dao.AccountProfileRepository;
import au.com.optus.ctc.dao.TrialsSummaryRepository;
import au.com.optus.ctc.model.AccountProfile;
import au.com.optus.ctc.model.TrialsSummary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;

/**
 * Created by optus on 28/10/19.
 */

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(value = "/api/ctc/trials/trialssummary")
public class TrialsSummaryController {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    TrialsSummaryRepository repository;

    @Autowired
    AccountProfileRepository accountRepository;

    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public String fetchTrialsSummaryDetails(@PathVariable("id") Long id) throws JsonProcessingException {
        TrialsSummary summary = repository.findById(id).get();
        return  mapper.writeValueAsString(summary);
    }

    @PostMapping(value = "/userTrialsSummary", headers = "Accept=application/json")
    public String saveUserTrialsSummary(@RequestBody TrialsSummary summary,  @PathVariable String id) throws JsonProcessingException {
        Optional<AccountProfile> user = accountRepository.findById(id);
        HashSet<AccountProfile> account = new HashSet<>();
        account.add(user.get());
        if(user.isPresent()) {
            summary.setAccount(account);
        }
        mapper.writeValueAsString(repository.save(summary));
        return "Success";
    }


    @DeleteMapping("/deleteTrialsSummary/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        TrialsSummary summary = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        repository.delete(summary);
    }
}
