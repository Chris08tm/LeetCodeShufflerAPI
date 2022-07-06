package com.LeetCodeShufflerAPI.LeetShuffler.Repository;

import com.LeetCodeShufflerAPI.LeetShuffler.Model.LeetCodeQuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeetCodeQuestionRepository extends JpaRepository<LeetCodeQuestionModel, Long> {
    @Query(value="SELECT * FROM question ORDER BY RAND() LIMIT 1", nativeQuery = true)
    LeetCodeQuestionModel getRandomQuestion();


    LeetCodeQuestionModel findByName(String name);

}
