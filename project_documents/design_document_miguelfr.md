# [MiguelFR] Design Document

## *LBC Projects Repository* Design

## 1. Problem Statement

*Learn and Be Curious Projects Repository (LBCPR) is a service to save past LBC projects so future students
can check and be inspired for their own projects ideas.*


## 2. Top Questions to Resolve in Review

1. Should I have a table developer and relate it with the table team and the table team to table project or should just
have a dev1, dev2, dev3 and dev4 fields in the table team ?  
2. Should the dev have the information about their course or should it be in the project ?  
3. Should the projects table have fields for beginning and end date of the projects ? Will I be able to deal with date fields ?
4. In the table Project should the title of the project be the primary key or use id ?

## 3. Use Cases

U1. *As a [LBCPR] user, I want to be able to register a project with a title, course, year, description, git url,
and the dev team(name, List of members)*
U2. *As a [LBCPR] user, I want to be able to update a project.*
U3. *As a [LBCPR] user, I want to view a list of all past LBC projects when I access the service.*
U4. *As a [LBCPR] user, I want to select a project from the list of all project to view all details of the project.*

## 4. Project Scope

### 4.1. In Scope

*Create a project.
*List all projects.
*Update a project.

### 4.2. Out of Scope

*Search a project by any specific field.
*Manage a team or devs.
*Manage courses.
*Delete projects.

# 5. Proposed Architecture Overview

This service will provide the functionalities to create, update and list all the projects.

We will use the API Gateway and Lambda to create four endpoints (GetAllProjects, GetProject, UpdateProject, CreateProject).

Projects and Teams will be stored in separated tables in DynamoDB.

We will provide a web interface for users to interact with the service, creating, updating and view the list of all
projects and select specific project in the list to vie more details. 

# 6. API

## 6.1. Public Models

// ProjectModel
String id;
String title;
String description;
String course;
String git_url;
Integer year;
String teamId;

// TeamModel
String id;
String name;
List<String> members;


## 6.2. *First Endpoint*

*Describe the behavior of the first endpoint you will build into your service
API. This should include what data it requires, what data it returns, and how it
will handle any known failure cases. You should also include a sequence diagram
showing how a user interaction goes from user to website to service to database,
and back. This first endpoint can serve as a template for subsequent endpoints.
(If there is a significant difference on a subsequent endpoint, review that with
your team before building it!)*

*(You should have a separate section for each of the endpoints you are expecting
to build...)*

## 6.3 *Second Endpoint*

*(repeat, but you can use shorthand here, indicating what is different, likely
primarily the data in/out and error conditions. If the sequence diagram is
nearly identical, you can say in a few words how it is the same/different from
the first endpoint)*

# 7. Tables

## 7.1. projects
id          // partition key, string
title       // string
description // string
course      // string
git_ural    // string
year        // number
teamId      // string

## 7.2 teams
id      // partition key, string
name    // string
members // list

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*
