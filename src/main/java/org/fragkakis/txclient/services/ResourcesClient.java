package org.fragkakis.txclient.services;

/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.fragkakis.txclient.model.Resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface ResourcesClient {

    @GET
    @Path("project/{project}/resources")
    @Produces(MediaType.APPLICATION_JSON)
    List<Resource> getResources(@PathParam("project") String project);

    @POST
    @Path("project/{project}/resources")
    @Consumes(MediaType.APPLICATION_JSON)
    void create(@PathParam("project") String project, Resource resource);

    @GET
    @Path("project/{project}/resource/{slug}")
    @Produces(MediaType.APPLICATION_JSON)
    Resource getResource(@PathParam("project") String project, @PathParam("slug") String slug, @QueryParam("details") String details);

    @PUT
    @Path("project/{project}/resource/{slug}")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateResource(@PathParam("project") String project, @PathParam("slug") String slug, Resource resource);

    @DELETE
    @Path("project/{project}/resource/{slug}")
    void deleteResource(@PathParam("project") String project, @PathParam("slug") String slug);

}
