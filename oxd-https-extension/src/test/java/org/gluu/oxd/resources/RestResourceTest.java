package org.gluu.oxd.resources;

import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;
import freemarker.template.utility.StringUtil;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.codehaus.jackson.map.ObjectMapper;
import org.gluu.oxd.OxdHttpsApplication;
import org.gluu.oxd.OxdHttpsConfiguration;
import org.gluu.oxd.RestResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.xdi.oxd.client.CommandClient;
import org.xdi.oxd.client.GetTokensByCodeTest;
import org.xdi.oxd.common.CommandResponse;
import org.xdi.oxd.common.CoreUtils;
import org.xdi.oxd.common.params.*;
import org.xdi.oxd.common.response.*;
import org.xdi.oxd.rs.protect.Jackson;
import org.xdi.oxd.rs.protect.RsResourceList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class RestResourceTest {

    public static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("oxd-https-extension-ce-dev3.yml");

    private static RegisterSiteParams registerSiteParams;
    private static String userId = null;
    private static String userSecret = null;
    private static int oxdPort = 0;
    private static String oxdHost = null;
    private static String accessToken = null;
    private static Client client;
    private static String oxdId = null;

    @ClassRule
    public static final DropwizardAppRule<OxdHttpsConfiguration> RULE = new DropwizardAppRule<>(OxdHttpsApplication.class, CONFIG_PATH);
    @ClassRule
    public static final ResourceTestRule RESOURCES = ResourceTestRule.builder().build();

    @BeforeClass
    public static void setUp() throws Exception {
        client = ClientBuilder.newClient();
        OxdHttpsConfiguration configuration = new OxdHttpsConfiguration();

        registerSiteParams = new RegisterSiteParams();
        registerSiteParams.setOpHost(configuration.getOpHost()); // your locally hosted gluu server can work
        registerSiteParams.setAuthorizationRedirectUri(configuration.getAuthorizationRedirectUrl());//Your client application auth redirect url
        registerSiteParams.setScope(Lists.newArrayList("openid", "profile", "email", "uma_protection", "uma_authorization"));  //Scope
        registerSiteParams.setTrustedClient(true);
        registerSiteParams.setGrantType(Lists.newArrayList("authorization_code", "client_credentials"));

        userId = configuration.getUserID();
        userSecret = configuration.getUserSecret();
        oxdPort = Integer.parseInt(configuration.getOxdPort());
        oxdHost = configuration.getOxdHost();

        //Get AccessToken
        SetupClientResponse setupClientResponse = setupClient(registerSiteParams);

        GetClientTokenParams clientTokenParams = new GetClientTokenParams();
        clientTokenParams.setClientId(setupClientResponse.getClientId());
        clientTokenParams.setClientSecret(setupClientResponse.getClientSecret());
        clientTokenParams.setScope(Lists.newArrayList("openid", "profile", "email", "uma_protection"));
        clientTokenParams.setOpHost(configuration.getOpHost());

        GetClientTokenResponse clientTokenResponse = getClientToken(clientTokenParams);
        accessToken = clientTokenResponse.getAccessToken();

        oxdId = setupClientResponse.getOxdId();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        client.close();
    }

    @Test
    public void testSetupClient() throws IOException {
        SetupClientResponse setupclientResponse = setupClient(registerSiteParams);
        assertNotNull(setupclientResponse);
        output("SETUP CLIENT", setupclientResponse);
    }

    @Test
    public void testGetClientToken() throws IOException {
        SetupClientResponse setupclientResponse = setupClient(registerSiteParams);
        assertNotNull(setupclientResponse);
        output("SETUP CLIENT", setupclientResponse);

        GetClientTokenParams clientTokenParams = new GetClientTokenParams();
        clientTokenParams.setClientId(setupclientResponse.getClientId());
        clientTokenParams.setClientSecret(setupclientResponse.getClientSecret());
        clientTokenParams.setScope(Lists.newArrayList("openid", "profile", "email", "uma_protection", "uma_authorization"));   //Scope
        clientTokenParams.setOpHost(registerSiteParams.getOpHost());

        GetClientTokenResponse clientTokenResponse = getClientToken(clientTokenParams);
        assertNotNull(clientTokenResponse);
        output("GET CLIENT TOKEN", clientTokenResponse);
    }

    @Test
    public void testRegisterSite() throws IOException {
        assertNotNull(accessToken);

        RegisterSiteResponse registerSiteResponse = registerSite(registerSiteParams);
        assertNotNull(registerSiteResponse);
        output("REGISTER SITE", registerSiteResponse);
    }

    @Test
    public void testUpdateSite() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        UpdateSiteParams updateSiteParams = new UpdateSiteParams();
        updateSiteParams.setOxdId(oxdId);
        updateSiteParams.setScope(Lists.newArrayList("openid", "profile", "email", "uma_protection", "uma_authorization"));

        CommandResponse commandResponse = updateSite(updateSiteParams);
        assertNotNull(commandResponse);
        output("UPDATE SITE", commandResponse);
    }

    @Test
    public void testGetAuthorizationUrl() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        GetAuthorizationUrlParams getAuthorizationUrlParams = new GetAuthorizationUrlParams();
        getAuthorizationUrlParams.setOxdId(oxdId);

        GetAuthorizationUrlResponse getAuthorizationUrlResponse = getAuthorizationUrl(getAuthorizationUrlParams);
        assertNotNull(getAuthorizationUrlResponse);
        output("GET AUTHORIZATION URL", getAuthorizationUrlResponse);
    }

    @Test
    public void testGetTokenByCode() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        String state = CoreUtils.secureRandomString();
        String code = codeRequest(oxdId, state);
        assertNotNull(code);

        GetTokensByCodeParams params = new GetTokensByCodeParams();
        params.setCode(code);
        params.setOxdId(oxdId);
        params.setState(state);

        GetTokensByCodeResponse getTokenByCodeResponse = getTokenByCode(params);
        assertNotNull(getTokenByCodeResponse);

        output("GET TOKEN BY CODE", getTokenByCodeResponse);
    }

    @Test
    public void testGetUserInfo() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        String state = CoreUtils.secureRandomString();
        String code = codeRequest(oxdId, state);
        assertNotNull(code);

        GetTokensByCodeParams params = new GetTokensByCodeParams();
        params.setCode(code);
        params.setOxdId(oxdId);
        params.setState(state);

        GetTokensByCodeResponse getTokenByCodeResponse = getTokenByCode(params);
        assertNotNull(getTokenByCodeResponse);

        GetUserInfoParams getUserInfoParams = new GetUserInfoParams();
        getUserInfoParams.setOxdId(oxdId);
        getUserInfoParams.setAccessToken(getTokenByCodeResponse.getAccessToken());

        GetUserInfoResponse getUserInfoResponse = getUserInfo(getUserInfoParams);
        assertNotNull(getUserInfoResponse);
        output("GET USER INFO", getUserInfoResponse);
    }

    @Test
    public void testGetLogoutUri() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        String state = CoreUtils.secureRandomString();

        String code = codeRequest(oxdId, state);
        assertNotNull(code);

        GetTokensByCodeParams params = new GetTokensByCodeParams();
        params.setCode(code);
        params.setOxdId(oxdId);
        params.setState(state);

        GetTokensByCodeResponse getTokenBuCodeResponse = getTokenByCode(params);
        assertNotNull(getTokenBuCodeResponse);

        GetLogoutUrlParams getLogoutUrlParams = new GetLogoutUrlParams();
        getLogoutUrlParams.setOxdId(oxdId);
        getLogoutUrlParams.setIdTokenHint(getTokenBuCodeResponse.getIdToken());

        LogoutResponse logoutResponse = getLogoutUri(getLogoutUrlParams);
        assertNotNull(logoutResponse);
        output("LOGOUT URI", logoutResponse);
    }

    @Test
    public void testgetAccessTokenByRefreshToken() throws IOException {
        assertNotNull(oxdId);

        String state = CoreUtils.secureRandomString();
        String code = codeRequest(oxdId, state);
        assertNotNull(code);

        GetTokensByCodeParams params = new GetTokensByCodeParams();
        params.setCode(code);
        params.setOxdId(oxdId);
        params.setState(state);

        GetTokensByCodeResponse getTokenByCodeResponse = getTokenByCode(params);
        assertNotNull(getTokenByCodeResponse);

        GetAccessTokenByRefreshTokenParams getAccessTokenByRefreshTokenParams = new GetAccessTokenByRefreshTokenParams();
        getAccessTokenByRefreshTokenParams.setOxdId(oxdId);
        getAccessTokenByRefreshTokenParams.setRefreshToken(getTokenByCodeResponse.getRefreshToken());
        getAccessTokenByRefreshTokenParams.setScope(Lists.newArrayList("openid", "profile", "email", "uma_protection", "uma_authorization"));   //Scope

        GetClientTokenResponse getClientTokenResponse = getAccessTokenByRefreshToken(getAccessTokenByRefreshTokenParams);
        assertNotNull(getClientTokenResponse);
        output("GET ACCESSTOKEN BY REFRESHTOKEN", getClientTokenResponse);
    }


    @Test
    public void testUmaRsProtect() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        String rsProtect = "{\"resources\":[{\"path\":\"/scim\",\"conditions\":[{\"httpMethods\":[\"GET\"],\"scopes\":[\"https://scim-test.gluu.org/identity/seam/resource/restv1/scim/vas1\"],\"ticketScopes\":[\"https://scim-test.gluu.org/identity/seam/resource/restv1/scim/vas1\"]}]}]}";

        RsProtectParams rsProtectParams = new RsProtectParams();
        rsProtectParams.setOxdId(oxdId);
        rsProtectParams.setResources(resourceList(rsProtect).getResources());

        RsProtectResponse rsProtectResponse = umaRsProtect(rsProtectParams);
        assertNotNull(rsProtectResponse);
        output("UMA Rs Resource Protection", rsProtectResponse);
    }


    @Test
    public void testUmaRsCheckAccess() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        RsCheckAccessParams rsCheckAccessParams = new RsCheckAccessParams();
        rsCheckAccessParams.setOxdId(oxdId);
        rsCheckAccessParams.setRpt(" ");
        rsCheckAccessParams.setPath("/scim");
        rsCheckAccessParams.setHttpMethod("GET");

        RsCheckAccessResponse rsCheckAccessResponse = umaRsCheckAccess(rsCheckAccessParams);
        assertNotNull(rsCheckAccessResponse);
        output("UMA Rs check Access", rsCheckAccessResponse);
    }

    @Test
    public void testUmaRpGetRpt() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        RsCheckAccessParams rsCheckAccessParams = new RsCheckAccessParams();
        rsCheckAccessParams.setOxdId(oxdId);
        rsCheckAccessParams.setRpt(" ");
        rsCheckAccessParams.setPath("/scim");
        rsCheckAccessParams.setHttpMethod("GET");

        RsCheckAccessResponse rsCheckAccessResponse = umaRsCheckAccess(rsCheckAccessParams);
        assertNotNull(rsCheckAccessResponse);


        RpGetRptParams rpGetRptParams = new RpGetRptParams();
        rpGetRptParams.setOxdId(oxdId);
        rpGetRptParams.setTicket(rsCheckAccessResponse.getTicket());

        RpGetRptResponse rpGetRptResponse = umaRpGetRpt(rpGetRptParams);
        assertNotNull(rpGetRptResponse);
        output("UMA RP GET RPT", rpGetRptResponse);
    }

    @Test
    public void testUmaRpGetClaimsGatheringUrl() throws IOException {
        assertNotNull(accessToken);
        assertNotNull(oxdId);

        RsCheckAccessParams rsCheckAccessParams = new RsCheckAccessParams();
        rsCheckAccessParams.setOxdId(oxdId);
        rsCheckAccessParams.setRpt(" ");
        rsCheckAccessParams.setPath("/scim");
        rsCheckAccessParams.setHttpMethod("GET");

        RsCheckAccessResponse rsCheckAccessResponse = umaRsCheckAccess(rsCheckAccessParams);
        assertNotNull(rsCheckAccessResponse);

        RpGetRptParams rpGetRptParams = new RpGetRptParams();
        rpGetRptParams.setOxdId(oxdId);
        rpGetRptParams.setTicket(rsCheckAccessResponse.getTicket());

        RpGetRptResponse rpGetRptResponse = umaRpGetRpt(rpGetRptParams);
        assertNotNull(rpGetRptResponse);

        RpGetClaimsGatheringUrlParams rpGetClaimsGatheringUrlParams = new RpGetClaimsGatheringUrlParams();
        rpGetClaimsGatheringUrlParams.setOxdId(oxdId);
        rpGetClaimsGatheringUrlParams.setTicket(rsCheckAccessResponse.getTicket());
        rpGetClaimsGatheringUrlParams.setClaimsRedirectUri("https://client.example.com/cb");
        rpGetClaimsGatheringUrlParams.setProtectionAccessToken(accessToken);

        RpGetClaimsGatheringUrlResponse rpGetClaimsGatheringUrlResponse = umaRpGetClaimsGatheringUrl(rpGetClaimsGatheringUrlParams);
        assertNotNull(rpGetRptResponse);
        output("UMA RP GET CLAIMS GATHERING URL", rpGetClaimsGatheringUrlResponse);
    }

    private String codeRequest(String oxdId, String state) {
        CommandClient client = null;
        try {
            String nonce = CoreUtils.secureRandomString();

            client = new CommandClient(oxdHost, oxdPort);
            return GetTokensByCodeTest.codeRequest(client, oxdId, userId, userSecret, state, nonce);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CommandClient.closeQuietly(client);
        }
        return null;
    }

    private static Object getParameterJson(Object para) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(para);
    }

    private static RsResourceList resourceList(String rsProtect) throws IOException {
        rsProtect = StringUtil.replace(rsProtect, "'", "\"");
        return Jackson.createJsonMapper().readValue(rsProtect, RsResourceList.class);
    }

    private static SetupClientResponse setupClient(RegisterSiteParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("setup-client", para);
        return RestResource.read(commandResponse.getData().toString(), SetupClientResponse.class);
    }

    private static GetClientTokenResponse getClientToken(GetClientTokenParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("get-client-token", para);
        return RestResource.read(commandResponse.getData().toString(), GetClientTokenResponse.class);
    }

    private RegisterSiteResponse registerSite(RegisterSiteParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("register-site", para);
        return RestResource.read(commandResponse.getData().toString(), RegisterSiteResponse.class);
    }

    private CommandResponse updateSite(UpdateSiteParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        return httpClient("update-site", para);
    }

    private GetAuthorizationUrlResponse getAuthorizationUrl(GetAuthorizationUrlParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("get-authorization-url", para);
        return RestResource.read(commandResponse.getData().toString(), GetAuthorizationUrlResponse.class);
    }

    private GetTokensByCodeResponse getTokenByCode(GetTokensByCodeParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("get-tokens-by-code", para);
        return RestResource.read(commandResponse.getData().toString(), GetTokensByCodeResponse.class);
    }

    private GetUserInfoResponse getUserInfo(GetUserInfoParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("get-user-info", para);
        return RestResource.read(commandResponse.getData().toString(), GetUserInfoResponse.class);
    }

    private LogoutResponse getLogoutUri(GetLogoutUrlParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("get-logout-uri", para);
        return RestResource.read(commandResponse.getData().toString(), LogoutResponse.class);
    }

    private GetClientTokenResponse getAccessTokenByRefreshToken(GetAccessTokenByRefreshTokenParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("get-access-token-by-refresh-token", para);
        return RestResource.read(commandResponse.getData().toString(), GetClientTokenResponse.class);
    }

    private RsProtectResponse umaRsProtect(RsProtectParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("uma-rs-protect", para);
        return RestResource.read(commandResponse.getData().toString(), RsProtectResponse.class);
    }

    private RsCheckAccessResponse umaRsCheckAccess(RsCheckAccessParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("uma-rs-check-access", para);
        return RestResource.read(commandResponse.getData().toString(), RsCheckAccessResponse.class);
    }

    private RpGetRptResponse umaRpGetRpt(RpGetRptParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("uma-rp-get-rpt", para);
        return RestResource.read(commandResponse.getData().toString(), RpGetRptResponse.class);
    }

    private RpGetClaimsGatheringUrlResponse umaRpGetClaimsGatheringUrl(RpGetClaimsGatheringUrlParams siteParams) throws IOException {
        Object para = getParameterJson(siteParams);
        CommandResponse commandResponse = httpClient("uma-rp-get-claims-gathering-url", para);
        return RestResource.read(commandResponse.getData().toString(), RpGetClaimsGatheringUrlResponse.class);
    }

    private static CommandResponse httpClient(String endpoint, Object para) throws IOException {
        final String entity = client.target("http://localhost:" + RULE.getLocalPort() + "/" + endpoint)
                .request()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .post(Entity.json(para))
                .readEntity(String.class);

        System.out.println("Plain string: " + entity);
        return RestResource.read(entity, CommandResponse.class);
    }

    private static void output(String testCase, Object response) {
        System.out.println("[INFO] --------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("[INFO] TEST CASE : " + testCase);
        System.out.println("[INFO] ----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("[INFO] RESPONSE   : " + response);
        System.out.println("[INFO] ----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }
}