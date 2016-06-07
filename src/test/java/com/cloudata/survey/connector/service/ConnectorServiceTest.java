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
import com.cloudata.survey.connector.struct.*;
import com.cloudata.survey.connector.utils.LimeSurveyManager;
import com.cloudata.survey.connector.view.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        final String SESSION_KEY = "srykin7sdf4jhj3gtba5adpcw3ppzhi7";
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
        final int SURVEY_ID = 561483;
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
        final String SESSION_KEY = "srykin7sdf4jhj3gtba5adpcw3ppzhi7";
        final int SURVEY_ID = 135443;

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
}
