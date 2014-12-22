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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {

    private String slug;
    private String name;
    private String accept_translations;
    private String i18n_type;
    private String category;
    private Short priority;
    private String content;

    private Date created;
    private String project_slug;
    private Integer wordcount;
    private Integer total_entities;
    private Date last_update;
//            available_languages


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccept_translations() {
        return accept_translations;
    }

    public void setAccept_translations(String accept_translations) {
        this.accept_translations = accept_translations;
    }

    public String getI18n_type() {
        return i18n_type;
    }

    public void setI18n_type(String i18n_type) {
        this.i18n_type = i18n_type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getProject_slug() {
        return project_slug;
    }

    public void setProject_slug(String project_slug) {
        this.project_slug = project_slug;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public Integer getWordcount() {
        return wordcount;
    }

    public void setWordcount(Integer wordcount) {
        this.wordcount = wordcount;
    }

    public Integer getTotal_entities() {
        return total_entities;
    }

    public void setTotal_entities(Integer total_entities) {
        this.total_entities = total_entities;
    }
}
