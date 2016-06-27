/**
 * File name: LSurveyMultipleAnswers Author: Dorsey Q F TANG Date: 6/27/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import java.io.Serializable;

/**
 * The options for the related multiple-chosen kind question.
 *
 * Author: DORSEy
 */
public class LSurveyMultipleAnswers implements Serializable {
    /**
     * The ID.
     * <strong>
     *     LimeSurvey takes multiple-chosen answers as sub-questions
     *     of the question.
     * </strong>
     */
    private int questionId;

    /**
     * The title.
     */
    private String title;

    /**
     * The type.
     */
    private final String type = "T";

    /**
     * The answer. The LimeSurvey takes it as sub questions of the question.
     */
    private String question;

    private int questionOrder;

    /**
     * Whether it's the default chosen.
     */
    private boolean isDefault;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
