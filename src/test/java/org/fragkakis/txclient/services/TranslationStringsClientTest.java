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


import org.fragkakis.txclient.model.Translation;
import org.fragkakis.txclient.model.TranslationString;
import org.fragkakis.txclient.util.Authenticator;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TranslationStringsClientTest {

    private static final String USERNAME = "fragkakis";
    private static final String PASSWORD = "fragkakis123";
    private ResteasyClient resteasyClient;
    private TranslationStringsClient translationStringsClient;


    @BeforeMethod
    public void setUp() throws Exception {
        resteasyClient = new ResteasyClientBuilder()
                .register(new Authenticator(USERNAME, PASSWORD))
                .register(new JacksonContextResolver())
                .build();
        ResteasyWebTarget target = resteasyClient.target("https://www.transifex.com/api/2/");
        translationStringsClient = target.proxy(TranslationStringsClient.class);
    }

    @AfterMethod
    public void tearDown() {
        resteasyClient.close();
    }

    @Test
    public void getTranslationStringsTest() {

        List<TranslationString> translationStrings = translationStringsClient.getTranslationStrings("proj1", "47644", "el");
        assertTrue(translationStrings.size() > 0);
    }

}
