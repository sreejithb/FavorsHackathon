/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.hackathon.favors.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "favorsApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.favors.hackathon.com",
    ownerName = "backend.myapplication.favors.hackathon.com",
    packagePath=""
  )
)
public class FavorsEndPoint {

    /** A simple endpoint method that takes a name and says Hi back */



}
