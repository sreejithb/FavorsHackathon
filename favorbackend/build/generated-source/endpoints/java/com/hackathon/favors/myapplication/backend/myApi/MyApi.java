/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-07-08 17:28:43 UTC)
 * on 2016-09-03 at 15:35:21 UTC 
 * Modify at your own risk.
 */

package com.hackathon.favors.myapplication.backend.myApi;

/**
 * Service definition for MyApi (v2).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link MyApiRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class MyApi extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.22.0 of the myApi library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myApplicationId.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "myApi/v2/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public MyApi(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  MyApi(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "amINearby".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link AmINearby#execute()} method to invoke the remote operation.
   *
   * @param fbid
   * @return the request
   */
  public AmINearby amINearby(java.lang.String fbid) throws java.io.IOException {
    AmINearby result = new AmINearby(fbid);
    initialize(result);
    return result;
  }

  public class AmINearby extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.MyBean> {

    private static final String REST_PATH = "amINearby/{fbid}";

    /**
     * Create a request for the method "amINearby".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link AmINearby#execute()} method to invoke the remote operation. <p>
     * {@link
     * AmINearby#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param fbid
     * @since 1.13
     */
    protected AmINearby(java.lang.String fbid) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.MyBean.class);
      this.fbid = com.google.api.client.util.Preconditions.checkNotNull(fbid, "Required parameter fbid must be specified.");
    }

    @Override
    public AmINearby setAlt(java.lang.String alt) {
      return (AmINearby) super.setAlt(alt);
    }

    @Override
    public AmINearby setFields(java.lang.String fields) {
      return (AmINearby) super.setFields(fields);
    }

    @Override
    public AmINearby setKey(java.lang.String key) {
      return (AmINearby) super.setKey(key);
    }

    @Override
    public AmINearby setOauthToken(java.lang.String oauthToken) {
      return (AmINearby) super.setOauthToken(oauthToken);
    }

    @Override
    public AmINearby setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (AmINearby) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public AmINearby setQuotaUser(java.lang.String quotaUser) {
      return (AmINearby) super.setQuotaUser(quotaUser);
    }

    @Override
    public AmINearby setUserIp(java.lang.String userIp) {
      return (AmINearby) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String fbid;

    /**

     */
    public java.lang.String getFbid() {
      return fbid;
    }

    public AmINearby setFbid(java.lang.String fbid) {
      this.fbid = fbid;
      return this;
    }

    @Override
    public AmINearby set(String parameterName, Object value) {
      return (AmINearby) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getUserStat".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link GetUserStat#execute()} method to invoke the remote operation.
   *
   * @param fbid
   * @return the request
   */
  public GetUserStat getUserStat(java.lang.String fbid) throws java.io.IOException {
    GetUserStat result = new GetUserStat(fbid);
    initialize(result);
    return result;
  }

  public class GetUserStat extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.MyBean> {

    private static final String REST_PATH = "mybean/{fbid}";

    /**
     * Create a request for the method "getUserStat".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link GetUserStat#execute()} method to invoke the remote operation. <p>
     * {@link
     * GetUserStat#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param fbid
     * @since 1.13
     */
    protected GetUserStat(java.lang.String fbid) {
      super(MyApi.this, "GET", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.MyBean.class);
      this.fbid = com.google.api.client.util.Preconditions.checkNotNull(fbid, "Required parameter fbid must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetUserStat setAlt(java.lang.String alt) {
      return (GetUserStat) super.setAlt(alt);
    }

    @Override
    public GetUserStat setFields(java.lang.String fields) {
      return (GetUserStat) super.setFields(fields);
    }

    @Override
    public GetUserStat setKey(java.lang.String key) {
      return (GetUserStat) super.setKey(key);
    }

    @Override
    public GetUserStat setOauthToken(java.lang.String oauthToken) {
      return (GetUserStat) super.setOauthToken(oauthToken);
    }

    @Override
    public GetUserStat setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetUserStat) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetUserStat setQuotaUser(java.lang.String quotaUser) {
      return (GetUserStat) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetUserStat setUserIp(java.lang.String userIp) {
      return (GetUserStat) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String fbid;

    /**

     */
    public java.lang.String getFbid() {
      return fbid;
    }

    public GetUserStat setFbid(java.lang.String fbid) {
      this.fbid = fbid;
      return this;
    }

    @Override
    public GetUserStat set(String parameterName, Object value) {
      return (GetUserStat) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getjobInfo".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link GetjobInfo#execute()} method to invoke the remote operation.
   *
   * @param jobid
   * @return the request
   */
  public GetjobInfo getjobInfo(java.lang.Integer jobid) throws java.io.IOException {
    GetjobInfo result = new GetjobInfo(jobid);
    initialize(result);
    return result;
  }

  public class GetjobInfo extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating> {

    private static final String REST_PATH = "grocerylistwithrating/{jobid}";

    /**
     * Create a request for the method "getjobInfo".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link GetjobInfo#execute()} method to invoke the remote operation. <p>
     * {@link
     * GetjobInfo#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param jobid
     * @since 1.13
     */
    protected GetjobInfo(java.lang.Integer jobid) {
      super(MyApi.this, "GET", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating.class);
      this.jobid = com.google.api.client.util.Preconditions.checkNotNull(jobid, "Required parameter jobid must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetjobInfo setAlt(java.lang.String alt) {
      return (GetjobInfo) super.setAlt(alt);
    }

    @Override
    public GetjobInfo setFields(java.lang.String fields) {
      return (GetjobInfo) super.setFields(fields);
    }

    @Override
    public GetjobInfo setKey(java.lang.String key) {
      return (GetjobInfo) super.setKey(key);
    }

    @Override
    public GetjobInfo setOauthToken(java.lang.String oauthToken) {
      return (GetjobInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public GetjobInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetjobInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetjobInfo setQuotaUser(java.lang.String quotaUser) {
      return (GetjobInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetjobInfo setUserIp(java.lang.String userIp) {
      return (GetjobInfo) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer jobid;

    /**

     */
    public java.lang.Integer getJobid() {
      return jobid;
    }

    public GetjobInfo setJobid(java.lang.Integer jobid) {
      this.jobid = jobid;
      return this;
    }

    @Override
    public GetjobInfo set(String parameterName, Object value) {
      return (GetjobInfo) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "postAcceptJob".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link PostAcceptJob#execute()} method to invoke the remote operation.
   *
   * @param jobid
   * @param delid
   * @return the request
   */
  public PostAcceptJob postAcceptJob(java.lang.Integer jobid, java.lang.String delid) throws java.io.IOException {
    PostAcceptJob result = new PostAcceptJob(jobid, delid);
    initialize(result);
    return result;
  }

  public class PostAcceptJob extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating> {

    private static final String REST_PATH = "postAccept/{jobid}/{delid}";

    /**
     * Create a request for the method "postAcceptJob".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link PostAcceptJob#execute()} method to invoke the remote operation. <p>
     * {@link PostAcceptJob#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientR
     * equest)} must be called to initialize this instance immediately after invoking the constructor.
     * </p>
     *
     * @param jobid
     * @param delid
     * @since 1.13
     */
    protected PostAcceptJob(java.lang.Integer jobid, java.lang.String delid) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating.class);
      this.jobid = com.google.api.client.util.Preconditions.checkNotNull(jobid, "Required parameter jobid must be specified.");
      this.delid = com.google.api.client.util.Preconditions.checkNotNull(delid, "Required parameter delid must be specified.");
    }

    @Override
    public PostAcceptJob setAlt(java.lang.String alt) {
      return (PostAcceptJob) super.setAlt(alt);
    }

    @Override
    public PostAcceptJob setFields(java.lang.String fields) {
      return (PostAcceptJob) super.setFields(fields);
    }

    @Override
    public PostAcceptJob setKey(java.lang.String key) {
      return (PostAcceptJob) super.setKey(key);
    }

    @Override
    public PostAcceptJob setOauthToken(java.lang.String oauthToken) {
      return (PostAcceptJob) super.setOauthToken(oauthToken);
    }

    @Override
    public PostAcceptJob setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (PostAcceptJob) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public PostAcceptJob setQuotaUser(java.lang.String quotaUser) {
      return (PostAcceptJob) super.setQuotaUser(quotaUser);
    }

    @Override
    public PostAcceptJob setUserIp(java.lang.String userIp) {
      return (PostAcceptJob) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer jobid;

    /**

     */
    public java.lang.Integer getJobid() {
      return jobid;
    }

    public PostAcceptJob setJobid(java.lang.Integer jobid) {
      this.jobid = jobid;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String delid;

    /**

     */
    public java.lang.String getDelid() {
      return delid;
    }

    public PostAcceptJob setDelid(java.lang.String delid) {
      this.delid = delid;
      return this;
    }

    @Override
    public PostAcceptJob set(String parameterName, Object value) {
      return (PostAcceptJob) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "postDelivered".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link PostDelivered#execute()} method to invoke the remote operation.
   *
   * @param jobid
   * @return the request
   */
  public PostDelivered postDelivered(java.lang.Integer jobid) throws java.io.IOException {
    PostDelivered result = new PostDelivered(jobid);
    initialize(result);
    return result;
  }

  public class PostDelivered extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating> {

    private static final String REST_PATH = "postDelivered/{jobid}";

    /**
     * Create a request for the method "postDelivered".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link PostDelivered#execute()} method to invoke the remote operation. <p>
     * {@link PostDelivered#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientR
     * equest)} must be called to initialize this instance immediately after invoking the constructor.
     * </p>
     *
     * @param jobid
     * @since 1.13
     */
    protected PostDelivered(java.lang.Integer jobid) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating.class);
      this.jobid = com.google.api.client.util.Preconditions.checkNotNull(jobid, "Required parameter jobid must be specified.");
    }

    @Override
    public PostDelivered setAlt(java.lang.String alt) {
      return (PostDelivered) super.setAlt(alt);
    }

    @Override
    public PostDelivered setFields(java.lang.String fields) {
      return (PostDelivered) super.setFields(fields);
    }

    @Override
    public PostDelivered setKey(java.lang.String key) {
      return (PostDelivered) super.setKey(key);
    }

    @Override
    public PostDelivered setOauthToken(java.lang.String oauthToken) {
      return (PostDelivered) super.setOauthToken(oauthToken);
    }

    @Override
    public PostDelivered setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (PostDelivered) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public PostDelivered setQuotaUser(java.lang.String quotaUser) {
      return (PostDelivered) super.setQuotaUser(quotaUser);
    }

    @Override
    public PostDelivered setUserIp(java.lang.String userIp) {
      return (PostDelivered) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer jobid;

    /**

     */
    public java.lang.Integer getJobid() {
      return jobid;
    }

    public PostDelivered setJobid(java.lang.Integer jobid) {
      this.jobid = jobid;
      return this;
    }

    @Override
    public PostDelivered set(String parameterName, Object value) {
      return (PostDelivered) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "postGroceryList".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link PostGroceryList#execute()} method to invoke the remote operation.
   *
   * @param ownerid
   * @param content the {@link com.hackathon.favors.myapplication.backend.myApi.model.GroceryList}
   * @return the request
   */
  public PostGroceryList postGroceryList(java.lang.String ownerid, com.hackathon.favors.myapplication.backend.myApi.model.GroceryList content) throws java.io.IOException {
    PostGroceryList result = new PostGroceryList(ownerid, content);
    initialize(result);
    return result;
  }

  public class PostGroceryList extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.MyBean> {

    private static final String REST_PATH = "postGroceryList/{ownerid}";

    /**
     * Create a request for the method "postGroceryList".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link PostGroceryList#execute()} method to invoke the remote operation.
     * <p> {@link PostGroceryList#initialize(com.google.api.client.googleapis.services.AbstractGoogleC
     * lientRequest)} must be called to initialize this instance immediately after invoking the
     * constructor. </p>
     *
     * @param ownerid
     * @param content the {@link com.hackathon.favors.myapplication.backend.myApi.model.GroceryList}
     * @since 1.13
     */
    protected PostGroceryList(java.lang.String ownerid, com.hackathon.favors.myapplication.backend.myApi.model.GroceryList content) {
      super(MyApi.this, "POST", REST_PATH, content, com.hackathon.favors.myapplication.backend.myApi.model.MyBean.class);
      this.ownerid = com.google.api.client.util.Preconditions.checkNotNull(ownerid, "Required parameter ownerid must be specified.");
    }

    @Override
    public PostGroceryList setAlt(java.lang.String alt) {
      return (PostGroceryList) super.setAlt(alt);
    }

    @Override
    public PostGroceryList setFields(java.lang.String fields) {
      return (PostGroceryList) super.setFields(fields);
    }

    @Override
    public PostGroceryList setKey(java.lang.String key) {
      return (PostGroceryList) super.setKey(key);
    }

    @Override
    public PostGroceryList setOauthToken(java.lang.String oauthToken) {
      return (PostGroceryList) super.setOauthToken(oauthToken);
    }

    @Override
    public PostGroceryList setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (PostGroceryList) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public PostGroceryList setQuotaUser(java.lang.String quotaUser) {
      return (PostGroceryList) super.setQuotaUser(quotaUser);
    }

    @Override
    public PostGroceryList setUserIp(java.lang.String userIp) {
      return (PostGroceryList) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String ownerid;

    /**

     */
    public java.lang.String getOwnerid() {
      return ownerid;
    }

    public PostGroceryList setOwnerid(java.lang.String ownerid) {
      this.ownerid = ownerid;
      return this;
    }

    @Override
    public PostGroceryList set(String parameterName, Object value) {
      return (PostGroceryList) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "postHandedOver".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link PostHandedOver#execute()} method to invoke the remote operation.
   *
   * @param jobid
   * @param delid
   * @return the request
   */
  public PostHandedOver postHandedOver(java.lang.Integer jobid, java.lang.String delid) throws java.io.IOException {
    PostHandedOver result = new PostHandedOver(jobid, delid);
    initialize(result);
    return result;
  }

  public class PostHandedOver extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating> {

    private static final String REST_PATH = "postHandedOver/{jobid}/{delid}";

    /**
     * Create a request for the method "postHandedOver".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link PostHandedOver#execute()} method to invoke the remote operation.
     * <p> {@link PostHandedOver#initialize(com.google.api.client.googleapis.services.AbstractGoogleCl
     * ientRequest)} must be called to initialize this instance immediately after invoking the
     * constructor. </p>
     *
     * @param jobid
     * @param delid
     * @since 1.13
     */
    protected PostHandedOver(java.lang.Integer jobid, java.lang.String delid) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRating.class);
      this.jobid = com.google.api.client.util.Preconditions.checkNotNull(jobid, "Required parameter jobid must be specified.");
      this.delid = com.google.api.client.util.Preconditions.checkNotNull(delid, "Required parameter delid must be specified.");
    }

    @Override
    public PostHandedOver setAlt(java.lang.String alt) {
      return (PostHandedOver) super.setAlt(alt);
    }

    @Override
    public PostHandedOver setFields(java.lang.String fields) {
      return (PostHandedOver) super.setFields(fields);
    }

    @Override
    public PostHandedOver setKey(java.lang.String key) {
      return (PostHandedOver) super.setKey(key);
    }

    @Override
    public PostHandedOver setOauthToken(java.lang.String oauthToken) {
      return (PostHandedOver) super.setOauthToken(oauthToken);
    }

    @Override
    public PostHandedOver setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (PostHandedOver) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public PostHandedOver setQuotaUser(java.lang.String quotaUser) {
      return (PostHandedOver) super.setQuotaUser(quotaUser);
    }

    @Override
    public PostHandedOver setUserIp(java.lang.String userIp) {
      return (PostHandedOver) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer jobid;

    /**

     */
    public java.lang.Integer getJobid() {
      return jobid;
    }

    public PostHandedOver setJobid(java.lang.Integer jobid) {
      this.jobid = jobid;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String delid;

    /**

     */
    public java.lang.String getDelid() {
      return delid;
    }

    public PostHandedOver setDelid(java.lang.String delid) {
      this.delid = delid;
      return this;
    }

    @Override
    public PostHandedOver set(String parameterName, Object value) {
      return (PostHandedOver) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "postNearby".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link PostNearby#execute()} method to invoke the remote operation.
   *
   * @param fbid
   * @param nearby
   * @return the request
   */
  public PostNearby postNearby(java.lang.String fbid, java.lang.Integer nearby) throws java.io.IOException {
    PostNearby result = new PostNearby(fbid, nearby);
    initialize(result);
    return result;
  }

  public class PostNearby extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRatingCollection> {

    private static final String REST_PATH = "postNearby/{fbid}/{nearby}";

    /**
     * Create a request for the method "postNearby".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link PostNearby#execute()} method to invoke the remote operation. <p>
     * {@link
     * PostNearby#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param fbid
     * @param nearby
     * @since 1.13
     */
    protected PostNearby(java.lang.String fbid, java.lang.Integer nearby) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.GroceryListWithRatingCollection.class);
      this.fbid = com.google.api.client.util.Preconditions.checkNotNull(fbid, "Required parameter fbid must be specified.");
      this.nearby = com.google.api.client.util.Preconditions.checkNotNull(nearby, "Required parameter nearby must be specified.");
    }

    @Override
    public PostNearby setAlt(java.lang.String alt) {
      return (PostNearby) super.setAlt(alt);
    }

    @Override
    public PostNearby setFields(java.lang.String fields) {
      return (PostNearby) super.setFields(fields);
    }

    @Override
    public PostNearby setKey(java.lang.String key) {
      return (PostNearby) super.setKey(key);
    }

    @Override
    public PostNearby setOauthToken(java.lang.String oauthToken) {
      return (PostNearby) super.setOauthToken(oauthToken);
    }

    @Override
    public PostNearby setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (PostNearby) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public PostNearby setQuotaUser(java.lang.String quotaUser) {
      return (PostNearby) super.setQuotaUser(quotaUser);
    }

    @Override
    public PostNearby setUserIp(java.lang.String userIp) {
      return (PostNearby) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String fbid;

    /**

     */
    public java.lang.String getFbid() {
      return fbid;
    }

    public PostNearby setFbid(java.lang.String fbid) {
      this.fbid = fbid;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer nearby;

    /**

     */
    public java.lang.Integer getNearby() {
      return nearby;
    }

    public PostNearby setNearby(java.lang.Integer nearby) {
      this.nearby = nearby;
      return this;
    }

    @Override
    public PostNearby set(String parameterName, Object value) {
      return (PostNearby) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "sayHi".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link SayHi#execute()} method to invoke the remote operation.
   *
   * @param name
   * @return the request
   */
  public SayHi sayHi(java.lang.String name) throws java.io.IOException {
    SayHi result = new SayHi(name);
    initialize(result);
    return result;
  }

  public class SayHi extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.MyBean> {

    private static final String REST_PATH = "sayHi/{name}";

    /**
     * Create a request for the method "sayHi".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link SayHi#execute()} method to invoke the remote operation. <p> {@link
     * SayHi#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param name
     * @since 1.13
     */
    protected SayHi(java.lang.String name) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.MyBean.class);
      this.name = com.google.api.client.util.Preconditions.checkNotNull(name, "Required parameter name must be specified.");
    }

    @Override
    public SayHi setAlt(java.lang.String alt) {
      return (SayHi) super.setAlt(alt);
    }

    @Override
    public SayHi setFields(java.lang.String fields) {
      return (SayHi) super.setFields(fields);
    }

    @Override
    public SayHi setKey(java.lang.String key) {
      return (SayHi) super.setKey(key);
    }

    @Override
    public SayHi setOauthToken(java.lang.String oauthToken) {
      return (SayHi) super.setOauthToken(oauthToken);
    }

    @Override
    public SayHi setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SayHi) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SayHi setQuotaUser(java.lang.String quotaUser) {
      return (SayHi) super.setQuotaUser(quotaUser);
    }

    @Override
    public SayHi setUserIp(java.lang.String userIp) {
      return (SayHi) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String name;

    /**

     */
    public java.lang.String getName() {
      return name;
    }

    public SayHi setName(java.lang.String name) {
      this.name = name;
      return this;
    }

    @Override
    public SayHi set(String parameterName, Object value) {
      return (SayHi) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "youAreNearby".
   *
   * This request holds the parameters needed by the myApi server.  After setting any optional
   * parameters, call the {@link YouAreNearby#execute()} method to invoke the remote operation.
   *
   * @param nearbystat
   * @return the request
   */
  public YouAreNearby youAreNearby(java.lang.Integer nearbystat) throws java.io.IOException {
    YouAreNearby result = new YouAreNearby(nearbystat);
    initialize(result);
    return result;
  }

  public class YouAreNearby extends MyApiRequest<com.hackathon.favors.myapplication.backend.myApi.model.MyBean> {

    private static final String REST_PATH = "youAreNearby/{nearbystat}";

    /**
     * Create a request for the method "youAreNearby".
     *
     * This request holds the parameters needed by the the myApi server.  After setting any optional
     * parameters, call the {@link YouAreNearby#execute()} method to invoke the remote operation. <p>
     * {@link
     * YouAreNearby#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param nearbystat
     * @since 1.13
     */
    protected YouAreNearby(java.lang.Integer nearbystat) {
      super(MyApi.this, "POST", REST_PATH, null, com.hackathon.favors.myapplication.backend.myApi.model.MyBean.class);
      this.nearbystat = com.google.api.client.util.Preconditions.checkNotNull(nearbystat, "Required parameter nearbystat must be specified.");
    }

    @Override
    public YouAreNearby setAlt(java.lang.String alt) {
      return (YouAreNearby) super.setAlt(alt);
    }

    @Override
    public YouAreNearby setFields(java.lang.String fields) {
      return (YouAreNearby) super.setFields(fields);
    }

    @Override
    public YouAreNearby setKey(java.lang.String key) {
      return (YouAreNearby) super.setKey(key);
    }

    @Override
    public YouAreNearby setOauthToken(java.lang.String oauthToken) {
      return (YouAreNearby) super.setOauthToken(oauthToken);
    }

    @Override
    public YouAreNearby setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (YouAreNearby) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public YouAreNearby setQuotaUser(java.lang.String quotaUser) {
      return (YouAreNearby) super.setQuotaUser(quotaUser);
    }

    @Override
    public YouAreNearby setUserIp(java.lang.String userIp) {
      return (YouAreNearby) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer nearbystat;

    /**

     */
    public java.lang.Integer getNearbystat() {
      return nearbystat;
    }

    public YouAreNearby setNearbystat(java.lang.Integer nearbystat) {
      this.nearbystat = nearbystat;
      return this;
    }

    @Override
    public YouAreNearby set(String parameterName, Object value) {
      return (YouAreNearby) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link MyApi}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link MyApi}. */
    @Override
    public MyApi build() {
      return new MyApi(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link MyApiRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMyApiRequestInitializer(
        MyApiRequestInitializer myapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(myapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
