package com.LeetCodeShufflerAPI.LeetShuffler.Service;


import com.LeetCodeShufflerAPI.LeetShuffler.Model.LeetCodeQuestionModel;
import com.LeetCodeShufflerAPI.LeetShuffler.Repository.LeetCodeQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeetCodeQuestionService {

    private LeetCodeQuestionRepository leetCodeQuestionRepository;
    private ArrayList<LeetCodeQuestionModel> seenList = new ArrayList<>();
    private final int NUM_QUESTIONS_PRE_REOCCURRANCE = 3;

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

    public void saveQuestions(List<LeetCodeQuestionModel> leetCodeQuestionModels){
        for(LeetCodeQuestionModel qm : leetCodeQuestionModels){
            if(leetCodeQuestionRepository.findByName(qm.getName()) == null) leetCodeQuestionRepository.save(qm);
        }
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
        LeetCodeQuestionModel question = leetCodeQuestionRepository.getRandomQuestion();

        while(seenList.contains(question) && leetCodeQuestionRepository.count() > seenList.size()){
            question = leetCodeQuestionRepository.getRandomQuestion();
        }

        if(seenList.size() >= NUM_QUESTIONS_PRE_REOCCURRANCE) {
            seenList.remove(0);
            seenList.add(question);
        }
        else seenList.add(question);

        return question;
    }
}
