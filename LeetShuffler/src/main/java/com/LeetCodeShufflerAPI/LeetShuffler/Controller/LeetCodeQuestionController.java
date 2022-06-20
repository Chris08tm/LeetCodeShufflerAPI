package com.LeetCodeShufflerAPI.LeetShuffler.Controller;

import com.LeetCodeShufflerAPI.LeetShuffler.Model.LeetCodeQuestionModel;
import com.LeetCodeShufflerAPI.LeetShuffler.Repository.LeetCodeQuestionRepository;
import com.LeetCodeShufflerAPI.LeetShuffler.Service.LeetCodeQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shuffler")
public class LeetCodeQuestionController {

    private LeetCodeQuestionService leetCodeQuestionService;

    // Using Spring Boot's constructor injection instead of autowired
    public LeetCodeQuestionController(LeetCodeQuestionService leetCodeQuestionService){
        this.leetCodeQuestionService = leetCodeQuestionService;
    }

    // GET localhost:8080/streams
    @GetMapping
    public List<LeetCodeQuestionModel> findAll(){
        return leetCodeQuestionService.findAll();
    }

    // GET localhost:8080/streams
    @GetMapping("/{id}")
    public LeetCodeQuestionModel findById(){
        return null;
    }

    // GET localhost:8080/streams
    @GetMapping("/random")
    public LeetCodeQuestionModel findRandom(){
        return leetCodeQuestionService.randomQuestion();
    }

    // POST localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveQuestions(@RequestBody List<LeetCodeQuestionModel> leetCodeQuestionModels){
        leetCodeQuestionService.saveQuestions(leetCodeQuestionModels);
    }

}
