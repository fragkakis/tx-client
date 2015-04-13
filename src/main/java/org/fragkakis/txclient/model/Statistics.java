package org.fragkakis.txclient.model;

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

public class Statistics {

    private String reviewed_percentage;
    private String completed;
    private Integer untranslated_words;
    private String last_commiter;
    private Integer reviewed;
    private Integer translated_entities;
    private Integer translated_words;
    private Integer untranslated_entities;

    public String getReviewed_percentage() {
        return reviewed_percentage;
    }

    public void setReviewed_percentage(String reviewed_percentage) {
        this.reviewed_percentage = reviewed_percentage;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public Integer getUntranslated_words() {
        return untranslated_words;
    }

    public void setUntranslated_words(Integer untranslated_words) {
        this.untranslated_words = untranslated_words;
    }

    public String getLast_commiter() {
        return last_commiter;
    }

    public void setLast_commiter(String last_commiter) {
        this.last_commiter = last_commiter;
    }

    public Integer getReviewed() {
        return reviewed;
    }

    public void setReviewed(Integer reviewed) {
        this.reviewed = reviewed;
    }

    public Integer getTranslated_entities() {
        return translated_entities;
    }

    public void setTranslated_entities(Integer translated_entities) {
        this.translated_entities = translated_entities;
    }

    public Integer getTranslated_words() {
        return translated_words;
    }

    public void setTranslated_words(Integer translated_words) {
        this.translated_words = translated_words;
    }

    public Integer getUntranslated_entities() {
        return untranslated_entities;
    }

    public void setUntranslated_entities(Integer untranslated_entities) {
        this.untranslated_entities = untranslated_entities;
    }
}
