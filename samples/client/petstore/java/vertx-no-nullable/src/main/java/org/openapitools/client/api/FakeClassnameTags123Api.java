package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.model.Client;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import java.util.*;

public interface FakeClassnameTags123Api {

    void testClassname(@javax.annotation.Nonnull Client body, Handler<AsyncResult<Client>> handler);

    void testClassname(@javax.annotation.Nonnull Client body, ApiClient.AuthInfo authInfo, Handler<AsyncResult<Client>> handler);

}
