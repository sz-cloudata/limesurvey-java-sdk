/**
 * File name: LSurveyMultipleChosenQuestion Author: Dorsey Q F TANG Date: 6/27/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import java.util.List;

/**
 * Represents the multiple-chosen kind question.
 *
 * Author: DORSEy
 */
public class LSurveyMultipleChosenQuestion extends LSurveyQuestion {
    /**
     * the answers associated to the question.
     */
    private List<LSurveyMultipleAnswers> subquestions;

    /**
     * The flag to determine it is multiple-chosen kind question.
     */
    private final String questionType = "M";

    private int relevance = 1;

    /**
     * Empty constructor of {@link LSurveyMultipleChosenQuestion}.
     */
    public LSurveyMultipleChosenQuestion() {
        setType(questionType);
    }

    public List<LSurveyMultipleAnswers> getSubquestions() {
        return subquestions;
    }

    public void setSubquestions(List<LSurveyMultipleAnswers> subquestions) {
        this.subquestions = subquestions;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }
}
