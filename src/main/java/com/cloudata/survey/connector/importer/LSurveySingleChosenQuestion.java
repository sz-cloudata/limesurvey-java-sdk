/**
 * File name: LSurveySingleChosenQuestion Author: Dorsey Q F TANG Date: 6/27/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import java.util.List;

/**
 * The question for single-chosen kind.
 *
 * Author: DORSEy
 */
public class LSurveySingleChosenQuestion extends LSurveyQuestion {
    /**
     * The answers to this question.
     */
    private List<LSurveyAnswer> answers;

    /**
     * indicates it's single chosen question.
     */
    private static final String questionType = "L";

    /**
     * Empty constructor of {@link LSurveySingleChosenQuestion}.
     */
    public LSurveySingleChosenQuestion() {
        setType(questionType);
    }

    public List<LSurveyAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<LSurveyAnswer> answers) {
        this.answers = answers;
    }
}
