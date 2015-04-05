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


import org.fragkakis.txclient.model.Project;
import org.fragkakis.txclient.util.Authenticator;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class ProjectsClientTest {

    private static final String USERNAME = "fragkakis";
    private static final String PASSWORD = "fragkakis123";
    private ResteasyClient resteasyClient;
    private ProjectsClient projectsClient;


    @BeforeMethod
    public void setUp() throws Exception {
        resteasyClient = new ResteasyClientBuilder()
                .register(new Authenticator(USERNAME, PASSWORD))
                .register(new JacksonContextResolver())
                .build();
        ResteasyWebTarget target = resteasyClient.target("https://www.transifex.com/api/2/");
        projectsClient = target.proxy(ProjectsClient.class);

    }

    @AfterMethod
    public void tearDown() {
        resteasyClient.close();
    }

    @Test
    public void getProjectsTest() {

        List<Project> projects = projectsClient.getProjects();
        assertTrue(projects.size() > 0);
    }

    @Test
    public void createProjectTest() {
        Project project = new Project();
        String now = "" + new Date().getTime();
        project.setName("testProject" + now);
        project.setSlug("testProject" + now);
        project.setDescription("blah");
        project.setPrivateProject(false);
        project.setRepository_url("https://github.com/fragkakis/tx-client");
        project.setSource_language_code("en");
        projectsClient.createProject(project);
    }

    @Test
    public void getProjectTest() {

        Project project = projectsClient.getProject("proj1", "");
        assertNotNull(project);
    }


}
