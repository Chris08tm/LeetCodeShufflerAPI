package com.LeetCodeShufflerAPI.LeetShuffler.Service;


import com.LeetCodeShufflerAPI.LeetShuffler.Model.LeetCodeQuestionModel;
import com.LeetCodeShufflerAPI.LeetShuffler.Repository.LeetCodeQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeetCodeQuestionService {

    private LeetCodeQuestionRepository leetCodeQuestionRepository;

    // Using Spring Boot's constructor injection instead of autowired
    public LeetCodeQuestionService(LeetCodeQuestionRepository leetCodeQuestionRepository){
        this.leetCodeQuestionRepository = leetCodeQuestionRepository;
    }

    /*
    Find Operations
     */
    public List<LeetCodeQuestionModel> findAll(){
        return leetCodeQuestionRepository.findAll();
    }

    public LeetCodeQuestionModel findById(Long id){
        return leetCodeQuestionRepository.findById(id).orElse(null);
    }

    /*
    Save Operations
     */
    public void saveQuestion(LeetCodeQuestionModel leetCodeQuestionModel){
        leetCodeQuestionRepository.save(leetCodeQuestionModel);
    }

    public void saveQuestions(List<LeetCodeQuestionModel> leetCodeQuestionModels){
        leetCodeQuestionRepository.saveAll(leetCodeQuestionModels);
    }

    /*
    Delete Operations
     */
    public void deleteQuestion(Long id){
        leetCodeQuestionRepository.deleteById(id);
    }

    /*
    Shuffle Operation
     */
    public LeetCodeQuestionModel randomQuestion(){
        return leetCodeQuestionRepository.getRandomQuestion();
    }
}
