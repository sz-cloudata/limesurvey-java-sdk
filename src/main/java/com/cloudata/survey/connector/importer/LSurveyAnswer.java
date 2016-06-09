/**
 * File name: LSurveyAnswer Author: Dorsey Q F TANG Date: 6/8/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import java.io.Serializable;

/**
 *
 * Author: DORSEy
 */
public class LSurveyAnswer implements Serializable {
    /**
     * The question id.
     */
    private int questionId;

    /**
     * The code.
     */
    private String code;

    /**
     * The answer.
     */
    private String answer;

    /**
     * The language.
     */
    private String language;

    /**
     * indicates whether this answer is the default, means correct.
     */
    private boolean isDefault;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(final boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{").append("questionId: ").append(questionId);
        builder.append(", code: ").append(code);
        builder.append(", answer: ").append(answer);
        builder.append(", language: ").append(language);
        builder.append(", isDefault: ").append(isDefault ? "Y" : "N");
        builder.append("}");

        return builder.toString();
    }
}
