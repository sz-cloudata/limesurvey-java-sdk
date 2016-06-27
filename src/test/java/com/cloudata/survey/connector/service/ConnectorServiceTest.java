/**
 * File name: ConnectorServiceTest Author: Dorsey Q F TANG Date: 5/29/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.LSurveyConfigs;
import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.creator.SimpleHttpClientCreator;
import com.cloudata.survey.connector.creator.SimpleHttpMethodCreator;
import com.cloudata.survey.connector.importer.*;
import com.cloudata.survey.connector.struct.*;
import com.cloudata.survey.connector.utils.LimeSurveyManager;
import com.cloudata.survey.connector.utils.StringUtils;
import com.cloudata.survey.connector.view.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;
import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.*;

/**
 * A test for {@link ConnectorService}.
 *
 * Author: DORSEy
 */
public class ConnectorServiceTest {
    private ConnectorService service;

    private static final String LS_URI = "http://clouddata.f3322.net:10080/akso/index.php/admin/remotecontrol";

    private static final String USER_NAME = "yunshu";

    private static final String PASSWORD = "engine";

    @Before
    public void setUp() {
        // leverage spring IoC to do instantiation.
        LimeSurveyManager manager = new LimeSurveyManager();
        manager.setUri(LS_URI);
        manager.setMethodCreator(new SimpleHttpMethodCreator());
        manager.setClientCreator(new SimpleHttpClientCreator());

        service = new ConnectorServiceImpl();
        ((ConnectorServiceImpl) service).setManager(manager);
    }

    @Test
    public void testGetConnection() {
        InitConnResponse response = service.getConnection(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                InitConnRequest reqParams = new InitConnRequest(USER_NAME, PASSWORD);
                LSurveyRequest request = new LSurveyRequest(LSurveyConstants.CMD_GET_SESSION_KEY, reqParams);

                return request;
            }
        });

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSessionKey());
        System.out.println(response.getSessionKey());
    }

    @Test
    public void testReleaseConnection() {
        // pls correct the following session key for testing.
        final String SESSION_KEY = "emwyddd6xh7xprt5inpq3zzq3c5kxxiv";
        boolean succeed = service.releaseConnection(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                ConnRequest reqParams = new ConnRequest(SESSION_KEY);
                LSurveyRequest request = new LSurveyRequest(LSurveyConstants.CMD_RELEASE_SESSION_KEY, reqParams);

                return request;
            }
        });

        Assert.assertTrue(succeed);
    }

    @Test
    public void testAddSurvey() {
        // pls correct the following session key for testing.
        final String SESSION_KEY = "28rfh6zb28s9f22gjuv5yru9pjg6mbam";
        SurveyResponse resposne = service.addSurvey(new LSurveyRequestCreator() {

            public LSurveyRequest create() {
                AddSurveyRequest reqParams = new AddSurveyRequest();
                reqParams.setSurveyTitle("Restful API test04");
                reqParams.setSurveyLanguage("en");
                reqParams.setSurveyFormat(SurveyFormat.A_FORMAT.getVal());
                reqParams.setSessionKey(SESSION_KEY);

                return new LSurveyRequest(LSurveyConstants.CMD_ADD_SURVEY, reqParams);
            }
        });

        Assert.assertNotNull(resposne);
        System.out.println(resposne.getSurveyId());
    }

    @Test
    public void testDeleteSurvey() {
        // pls correct the following two constants for testing.
        final int SURVEY_ID = 135443;
        final String SESSION_KEY = "28rfh6zb28s9f22gjuv5yru9pjg6mbam";
        boolean succeed = service.deleteSurvey(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                DeleteSurveyRequest reqParams = new DeleteSurveyRequest(SESSION_KEY, SURVEY_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_DELETE_SURVEY, reqParams);
            }
        });

        Assert.assertTrue(succeed);
    }

    @Test
    public void testListSurveys() {
        // pls correct me for testing.
        final String SESSION_KEY = "vh2b9r55bagfv593d662fiyytwsp4swx";
        ListSurveysResponse response = service.listSurveys(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                ListSurveysRequest reqParams = new ListSurveysRequest(SESSION_KEY);

                return new LSurveyRequest(LSurveyConstants.CMD_LIST_SURVEYS, reqParams);
            }
        });

        Assert.assertNotNull(response);
        System.out.println(response.getDetails());
    }

    @Test
    public void testActivateSurvey() {
        // pls correct me for testing.
        final int SURVEY_ID = 818388;
        final String SESSION_KEY = "njvd9xqhr42aqmw9q38zctexd6hxt3rm";
        boolean succeed = service.activateSurvey(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                ActivateSurveyRequest reqParams = new ActivateSurveyRequest(SESSION_KEY, SURVEY_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_ACTIVATE_SURVEY, reqParams);
            }
        });

        Assert.assertTrue(succeed);
    }

    @Test
    public void testGetSiteSettings() {
        // pls correct me for testing
        final String SESSION_KEY = "p7i6zb7zibrxprhvmaid6nht7g2z8pm8";
        GetSiteSettingsResponse response = service.getSiteSettings(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                GetSiteSettingsRequest reqParams = new GetSiteSettingsRequest(SESSION_KEY, LSurveyConfigs.CONFIG_ALLOWED_RESOURCE_UPLOADS);

                return new LSurveyRequest(LSurveyConstants.CMD_GET_SITE_SETTINGS, reqParams);
            }
        });

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSettingVal());
        System.out.println(response);
    }

    @Test
    public void testGetSurveySettings() {
        // pls correct me for testing
        final String SESSION_KEY = "qc896y8bki5r2wvxzbzd29vz8k5p92vq";
        final int SURVEY_ID = 818388;

        GetSurveyPropertiesResponse response = service.getSurveyProperties(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                GetSurveyPropertiesRequest reqParams = new GetSurveyPropertiesRequest();
                reqParams.setSurveyInSession(SESSION_KEY, SURVEY_ID);

                List<String> surveySettings = new ArrayList<String>();
                surveySettings.add(LSurveyConstants.SERIALIZED_SURVEY_TEMPLATE);
                surveySettings.add(LSurveyConstants.SERIALIZED_FAX_TO);
                surveySettings.add(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID);
                reqParams.setSurveySettings(surveySettings);

                return new LSurveyRequest(LSurveyConstants.CMD_GET_SURVEY_PROPERTIES, reqParams);
            }
        });

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getSurveyProperties());
        System.out.println(response);
    }

    @Test
    public void testSetSurveyProperties() {
        // pls correct me for testing
        final String SESSION_KEY = "28rfh6zb28s9f22gjuv5yru9pjg6mbam";
        final int SURVEY_ID = 135443;

        boolean result = service.setSurveyProperties(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                SetSurveyPropertiesRequest reqParams = new SetSurveyPropertiesRequest(SESSION_KEY, SURVEY_ID);
                Map<String, Object> settings = new HashMap<String, Object>();
                settings.put("faxto", "Dorsey for testing");
                reqParams.setSurveyData(settings);

                return new LSurveyRequest(LSurveyConstants.CMD_SET_SURVEY_PROPERTIES, reqParams);
            }
        });

        Assert.assertTrue(result);
    }

    @Test
    public void testGetAllSummaries() {
        // pls correct me for testing
        final String SESSION_KEY = "srykin7sdf4jhj3gtba5adpcw3ppzhi7";
        final int SURVEY_ID = 818388;

        GetAllSummariesResponse response = service.getAllSummaries(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                GetSummaryRequest reqParams = GetSummaryRequest.getAllSummariesRequest(SESSION_KEY, SURVEY_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_GET_SUMMARY, reqParams);
            }
        });

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getStatistics());
        System.out.println(response);
    }

    @Test
    public void testAddGroup() {
        // pls correct me for testing
        final String SESSION_KEY = "28rfh6zb28s9f22gjuv5yru9pjg6mbam";
        final int SURVEY_ID = 846936;

        AddGroupResponse response = service.addGroup(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                String groupTitle = "Restful API group test02";
                String groupDesc = "for restful API add group test";
                AddGroupRequest reqParams = new AddGroupRequest(SESSION_KEY, SURVEY_ID, groupTitle, groupDesc);

                return new LSurveyRequest(LSurveyConstants.CMD_ADD_GROUP, reqParams);
            }
        });

        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testDeleteGroup() {
        // pls correct me for testing.
        final String SESSION_KEY = "srykin7sdf4jhj3gtba5adpcw3ppzhi7";
        final int SURVEY_ID = 135443;
        final int GROUP_ID = 4;

        boolean succeed = service.deleteGroup(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                SurveyGroupInSession reqParams = new SurveyGroupInSession(SESSION_KEY, SURVEY_ID, GROUP_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_DELETE_GROUP, reqParams);
            }
        });

        Assert.assertTrue(succeed);
    }

    @Test
    public void testListGroups() {
        // pls correct me for testing.
        final String SESSION_KEY = "qc896y8bki5r2wvxzbzd29vz8k5p92vq";
        final int SURVEY_ID = 135443;

        ListGroupsResponse response = service.listGroups(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                SurveyInSession reqParams = new SurveyInSession(SESSION_KEY, SURVEY_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_LIST_GROUPS, reqParams);
            }
        });

        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testGetGroupProperties() {
        final String SESSION_KEY = "qc896y8bki5r2wvxzbzd29vz8k5p92vq";
        final int GROUP_ID = 6;
        GetGroupPropertiesResponse result = service.getGroupProperties(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                GetGroupPropertiesRequest reqParams = new GetGroupPropertiesRequest(SESSION_KEY, GROUP_ID, null);

                List<String> groupSettingNames = new ArrayList<String>();
                groupSettingNames.add("gid");
                groupSettingNames.add("group_name");

                reqParams.setGroupSettings(groupSettingNames);

                return new LSurveyRequest(LSurveyConstants.CMD_GET_GROUP_PROPERTIES, reqParams);
            }
        });

        Assert.assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void testSetGroupProperties() {
        final String SESSION_KEY = "28rfh6zb28s9f22gjuv5yru9pjg6mbam";
        final int GROUP_ID = 6;
        boolean result = service.setGroupProperties(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                SetGroupPropertiesRequest reqParams = new SetGroupPropertiesRequest(SESSION_KEY, GROUP_ID, null);
                Map<String, Object> properties = new HashMap<String, Object>();
                properties.put("group_name", "group properties set testing");
                reqParams.setProperties(properties);

                return new LSurveyRequest(LSurveyConstants.CMD_SET_GROUP_PROPERTIES, reqParams);
            }
        });

        Assert.assertTrue(result);
    }

    @Test
    public void testImportQuestion() {
        final String SESSION_KEY = "6xnvyi3caxz7qyvyz95uqyswwk334kan";
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;
        final int QUESTION_ID = 77;
        final String QUESTION_Title = "Q01";

        ImportQuestionResponse response = service.importQuestion(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                String templatePath = "/templates";
                String templateName = "question_lsq.ftl";

                LSurveySingleChosenQuestion question = new LSurveySingleChosenQuestion();
                question.setQuestionId(QUESTION_ID);
                question.setQuestion("How old are you?");
                question.setLanguage("en");
                question.setQuestionTitle(QUESTION_Title);
                question.setGroupId(GROUP_ID);
                question.setSurveyId(SURVEY_ID);
                question.setMandatory("N");

                List<LSurveyAnswer> answers = new ArrayList<LSurveyAnswer>();
                LSurveyAnswer answer = new LSurveyAnswer();
                answer.setLanguage("en");
                answer.setAnswer("12");
                answer.setCode("A1");
                answer.setQuestionId(QUESTION_ID);
                answers.add(answer);

                answer = new LSurveyAnswer();
                answer.setLanguage("en");
                answer.setAnswer("14");
                answer.setCode("A2");
                answer.setQuestionId(QUESTION_ID);
                answers.add(answer);
                answer.setDefault(true);
                question.setAnswers(answers);

                String importData = null;
                try {
                    importData = TemplateProducer.produce(templatePath, templateName, question);
                } catch (IOException e) {
                    importData = null;
                }

                System.out.println(importData);
                System.out.println();
                String encoded = StringUtils.base64Encode(importData);
                ImportQuestionRequest reqParams = new ImportQuestionRequest();
                reqParams.setSurveyGroupInSession(SESSION_KEY, SURVEY_ID, GROUP_ID);
                reqParams.setImportData(encoded);
                reqParams.setImportDataType(AllowedQuestionImportDataType.QUESTION_LSQ);
                reqParams.setMandatory(false);


                return new LSurveyRequest(LSurveyConstants.CMD_IMPORT_QUESTION, reqParams);
            }
        });

        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testImportQuestionMultiple() {
        final String SESSION_KEY = "uz6cnfs7ssazjnng5879bpdd6xe4qr8i";
        final int SURVEY_ID = 846936;
        final int GROUP_ID = 7;
        final int QUESTION_ID = 77;
        final String QUESTION_Title = "Q001";

        ImportQuestionResponse response = service.importQuestion(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                String templatePath = "/templates";
                String templateName = "question_with_multiple_answers_lsq.ftl";

                LSurveyMultipleChosenQuestion question = new LSurveyMultipleChosenQuestion();
                question.setMandatory("N");
                question.setGroupId(GROUP_ID);
                question.setQuestionTitle(QUESTION_Title);
                question.setQuestion("Chinese province?");
                question.setLanguage("en");
                question.setParentQuestionId(0);
                question.setSurveyId(SURVEY_ID);

                List<LSurveyMultipleAnswers> answerses = new LinkedList<LSurveyMultipleAnswers>();
                LSurveyMultipleAnswers answer = new LSurveyMultipleAnswers();
                answer.setQuestion("GuangDong");
                answer.setQuestionId(QUESTION_ID);
                answer.setDefault(false);
                answer.setTitle("SQ01");
                answer.setQuestionOrder(1);

                answerses.add(answer);
                answer = new LSurveyMultipleAnswers();
                answer.setQuestion("GuangXi");
                answer.setQuestionId(QUESTION_ID);
                answer.setDefault(false);
                answer.setTitle("SQ02");
                answer.setQuestionOrder(2);

                answerses.add(answer);
                answer = new LSurveyMultipleAnswers();
                answer.setQuestion("HuNan");
                answer.setQuestionId(QUESTION_ID);
                answer.setDefault(false);
                answer.setTitle("SQ03");
                answer.setQuestionOrder(3);

                answerses.add(answer);
                answer = new LSurveyMultipleAnswers();
                answer.setQuestion("Peking");
                answer.setQuestionId(QUESTION_ID);
                answer.setDefault(true);
                answer.setTitle("SQ04");
                answer.setQuestionOrder(4);

                answerses.add(answer);
                question.setSubquestions(answerses);

                String importData = null;
                try {
                    importData = TemplateProducer.produce(templatePath, templateName, question);
                } catch (IOException e) {
                    importData = null;
                }

                importData = StringUtils.base64Encode(importData);
                ImportQuestionRequest reqParams = new ImportQuestionRequest();
                reqParams.setSurveyGroupInSession(SESSION_KEY, SURVEY_ID, GROUP_ID);
                reqParams.setImportData(importData);
                reqParams.setImportDataType(AllowedQuestionImportDataType.QUESTION_LSQ);
                reqParams.setMandatory(false);


                return new LSurveyRequest(LSurveyConstants.CMD_IMPORT_QUESTION, reqParams);
            }
        });

        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testDeleteQuestion() {
        final String SESSION_KEY = "6xnvyi3caxz7qyvyz95uqyswwk334kan";
        final int QUESTION_ID = 78;

        boolean result = service.deleteQuestion(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                QuestionInSession reqParams = new QuestionInSession(SESSION_KEY, QUESTION_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_DELETE_QUESTION, reqParams);
            }
        });

        Assert.assertTrue(result);
    }

    @Test
    public void testListQuestions() {
        final String SESSION_KEY = "x64wuxhskgtx58qqnzn86m8isxet3xir";
        final int SURVEY_ID = 846936;

        ListQuestionsResponse response = service.listQuestions(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                SurveyInSession reqParams = new SurveyInSession(SESSION_KEY, SURVEY_ID);

                return new LSurveyRequest(LSurveyConstants.CMD_LIST_QUESTIONS, reqParams);
            }
        });

        Assert.assertNotNull(response);
        System.out.println(response);
    }

    @Test
    public void testGetQuestionProperties() {
        // pls correct me for testing.
        final String SESSION_KEY = "sh6ebdig3derkgvajg4fa9f3av35sazr";
        final int QUESTION_ID = 79;

        Map<String, String> resposne = service.getQuestionProperties(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                GetQuestionPropertiesRequest reqParams = new GetQuestionPropertiesRequest(SESSION_KEY, QUESTION_ID, null);
                List<String> properties = new ArrayList<String>();
                properties.add("question");
                reqParams.setProperties(properties);

                return new LSurveyRequest(LSurveyConstants.CMD_GET_QUESTION_PROPERTIES, reqParams);
            }
        });

        Assert.assertNotNull(resposne);
        Assert.assertTrue(resposne.size() == 1d);
        System.out.println(resposne);
    }

    @Test
    public void testSetQuestionProperties() {
        // pls correct me for testing.
        final String SESSION_KEY = "sh6ebdig3derkgvajg4fa9f3av35sazr";
        final int QUESTION_ID = 79;

        boolean response = service.setQuestionProperties(new LSurveyRequestCreator() {
            public LSurveyRequest create() {
                SetQuestionPropertiesRequest reqParams = new SetQuestionPropertiesRequest();
                reqParams.setQuestionInSession(SESSION_KEY, QUESTION_ID);
                Map<String, Object> questionData = new HashMap<String, Object>();
                questionData.put("question", "How old are your son?");
                reqParams.setQuestionData(questionData);

                return new LSurveyRequest(LSurveyConstants.CMD_SET_QUESTION_PROPERTIES, reqParams);
            }
        });

        Assert.assertTrue(response);
    }
}
