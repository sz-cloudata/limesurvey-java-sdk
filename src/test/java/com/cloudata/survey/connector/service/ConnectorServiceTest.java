/**
 * File name: ConnectorServiceTest Author: Dorsey Q F TANG Date: 5/29/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.service;

import com.cloudata.survey.connector.LSurveyConstants;
import com.cloudata.survey.connector.creator.LSurveyRequestCreator;
import com.cloudata.survey.connector.creator.SimpleHttpClientCreator;
import com.cloudata.survey.connector.creator.SimpleHttpMethodCreator;
import com.cloudata.survey.connector.struct.*;
import com.cloudata.survey.connector.utils.LimeSurveyManager;
import com.cloudata.survey.connector.view.InitConnResponse;
import com.cloudata.survey.connector.view.ListSurveysResponse;
import com.cloudata.survey.connector.view.SurveyResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
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
        LimeSurveyManager manager = new LimeSurveyManager();
        manager.setUri(LS_URI);
        manager.setMethodCreator(new SimpleHttpMethodCreator());
        manager.setClientCreator(new SimpleHttpClientCreator());

        service = new ConnectorSerivceImpl();
        ((ConnectorSerivceImpl) service).setManager(manager);
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
        final String SESSION_KEY = "7sbp5azchew484g6wgijg8633btbtx7s";
        SurveyResponse resposne = service.addSurvey(new LSurveyRequestCreator() {

            public LSurveyRequest create() {
                AddSurveyRequest reqParams = new AddSurveyRequest();
                reqParams.setSurveyTitle("Restful API test03");
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
        final long SURVEY_ID = 561483;
        final String SESSION_KEY = "7sbp5azchew484g6wgijg8633btbtx7s";
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
}