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
import org.fragkakis.txclient.util.Authenticator;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResourcesClientTest {

    private static final String USERNAME = "fragkakis";
    private static final String PASSWORD = "fragkakis123";
    private ResteasyClient resteasyClient;
    private ResourcesClient resourcesClient;


    @BeforeMethod
    public void setUp() throws Exception {
        resteasyClient = new ResteasyClientBuilder()
                .register(new Authenticator(USERNAME, PASSWORD))
                .register(new JacksonContextResolver())
                .build();
        ResteasyWebTarget target = resteasyClient.target("https://www.transifex.com/api/2/");
        resourcesClient= target.proxy(ResourcesClient.class);

    }

    @AfterMethod
    public void tearDown() {
        resteasyClient.close();
    }

    @Test
    public void getResourcesTest() {

        List<Resource> resources = resourcesClient.getResources("proj1");
        assertTrue(resources.size() > 0);
    }

    @Test
    public void createResourceTest() throws IOException {

        long time = new Date().getTime();

        Resource resource = new Resource();
        resource.setI18n_type("PROPERTIES");
        resource.setSlug("testresource" + time);
        resource.setName("testresource" + time);

        Properties properties = new Properties();
        properties.put("11111", "This is a Unicode string (*(*@#$ με ελληνικούς χαρακτήρες");
        properties.put("22222", "This is another Unicode string (*(*@#$ με ελληνικούς χαρακτήρες");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        properties.store(baos, null);

        resource.setContent(baos.toString());

        resourcesClient.create("proj1", resource);
    }

    @Test
    public void getResourceTest() {

        Resource resource = resourcesClient.getResource("proj1", "testresource", "");
        assertEquals(resource.getI18n_type(), "TXT");
        assertEquals(resource.getSlug(), "testresource");
        assertEquals(resource.getName(), "testresource");
        assertEquals(resource.getWordcount(), Integer.valueOf(4));
        assertEquals(resource.getTotal_entities(), Integer.valueOf(1));
        assertEquals(resource.getProject_slug(), "proj1");

        Calendar dateCreated = Calendar.getInstance();
        dateCreated.setTime(resource.getCreated());
        assertEquals(dateCreated.get(Calendar.YEAR), 2014);

        Calendar dateLastUpdate = Calendar.getInstance();
        dateLastUpdate.setTime(resource.getLast_update());
        assertEquals(dateLastUpdate.get(Calendar.YEAR), 2014);

    }

    @Test
    public void updateResourceTest() {
        String slug = "testresource";
        String updatedSlug = "testresource_upd";

        Resource resource = resourcesClient.getResource("proj1", slug, null);
        resource.setSlug(updatedSlug);
        resource.setName(updatedSlug);
        resource.setI18n_type(null);
        resource.setContent(null);
        resource.setPriority(null);

        resourcesClient.updateResource("proj1", slug, resource);

        resource.setSlug(slug);
        resource.setName(slug);
        resourcesClient.updateResource("proj1", updatedSlug, resource);
    }

    @Test
    public void deleteResourceTest() {

        long time = new Date().getTime();

        Resource resource = new Resource();
        resource.setI18n_type("TXT");
        resource.setSlug("testresourcetobedeleted" + time);
        resource.setName("testresourcetobedeleted" + time);
        resource.setContent("This is the content");

        resourcesClient.create("proj1", resource);

        resourcesClient.deleteResource("proj1", resource.getSlug());
    }

}
