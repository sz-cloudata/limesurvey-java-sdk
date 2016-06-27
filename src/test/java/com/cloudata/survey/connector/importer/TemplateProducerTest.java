/**
 * File name: TemplateProducerTest Author: Dorsey Q F TANG Date: 6/9/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A test for {@link TemplateProducer}.
 *
 * Author: DORSEy
 */
public class TemplateProducerTest {
    @Test
    public void testProduce() throws IOException {
        String templatePath = "/templates";
        String templateName = "question_lsq.ftl";

        LSurveySingleChosenQuestion question = new LSurveySingleChosenQuestion();
        question.setQuestionId(1);
        question.setQuestion("How old are you?");
        question.setLanguage("en");
        question.setType("L");
        question.setQuestionTitle("Q01");
        question.setGroupId(1);
        question.setSurveyId(1);
        question.setMandatory("N");

        List<LSurveyAnswer> answers = new ArrayList<LSurveyAnswer>();
        LSurveyAnswer answer = new LSurveyAnswer();
        answer.setLanguage("en");
        answer.setAnswer("12");
        answer.setCode("A1");
        answer.setQuestionId(1);
        answers.add(answer);

        answer = new LSurveyAnswer();
        answer.setLanguage("en");
        answer.setAnswer("14");
        answer.setCode("A2");
        answer.setQuestionId(1);
        answers.add(answer);
        answer.setDefault(true);

        question.setAnswers(answers);

        String out = TemplateProducer.produce(templatePath, templateName, question);

        Assert.assertNotNull(out);
        System.out.println(out);
    }
}
