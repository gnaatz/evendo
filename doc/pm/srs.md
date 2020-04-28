# Evendo - Software Requirement Specification

## Table of Contents
- [1. Introduction](#)
	- [1.1 Purpose](#)
	- [1.2 Scope](#)
	- [1.3 Definitions, Acronyms, and Abbreviations](#)
	- [1.4 References](#)
	- [1.5 Overview](#)
- [2. Overall Description](#)
- [3. Specific Requirements](#)
	- [3.1 Functionality](#)
	- [3.2 Usability](#)
	- [3.3 Reliability](#)
	- [3.4 Performence](#)
	- [3.5 Supportability](#)
	- [3.6 Design Constraints](#)
	- [3.7 On-line User Documentation and Help System Requirements](#)
	- [3.8 Purchased Components](#)
	- [3.9 Interfaces](#)
	- [3.10 Licensing Requirements](#)
	- [3.11 Legal, Copyright, and Other Notices](#)
	- [3.12 Applicable Standards](#)
- [4. Supporting Information](#)

## 1. Introduction


### 1.1 Purpose

The purpose of this SRS is to discribe the requirements of our complete Application.
The Main focus is the Android-App.

### 1.2 Scope

The Evendo Appllication helps you to stay organized. It provides the opportunity to assign ToDos directly to an Event in one of your calendars. You will never forget a pre-meeting task if you use Evendo.

You can create Calendars, Events and ToDos or create ToDos connected to an Event. You will be able to even import RAPLA or any ical file you wish.
The Data will be saved on a backend Server so you can log on on multiple devices.
You will find our UseCase models here - [4. Supporting Information](#)

### 1.3 Definitions, Acronyms, and Abbreviations

### 1.4 References

- Projectdefinition

### 1.5 Overview

The Document is organized by feature.
Throguh the fact that we are in the beginning of our project the most parts of this SRS are not discussed jet, but will be added according to the stand of the project.

## 2. Overall Description

- product perspective
- product functions
- user characteristics
- constraints
- assumptions and dependencies

## 3. Specific Requirements

### 3.1 Functionality

- Create Calendar
- Create Event
- Create ToDo
- Create ToDo for Event
- Import Calendar

#### 3.1.1 Create Calendar

The user shall be able to create a new calendar in the app, with a by the user specified name.

#### 3.1.2 Create Event

In each calendar an event is createble. The name, date, time, description and reminder are specifiable parameters. It shall also be possible to attach ToDos (as described in 3.1.4).

#### 3.1.3 Create ToDO

In the ToDo-Tab the user can create general ToDos which not correspond with any event.
The ToDo contains here just a description.

#### 3.1.4 Create ToDo for Event

It is possible to create an ToDo for an Event, where you can set a time before the start of the event when the ToDo needs to be done and of course a description.

#### 3.1.5 Import Calendar

The user can import calendars to this application e.g. RAPLA and assign then ToDos to the events there.

### 3.2 Usability

The user should be able to use our application as an default tool in his daily life.

#### 3.2.1 Easy Use
	
The app is held basic to give the user a great experience working with our app.

### 3.3 Reliability

The user always can rely on the data shown to him.

#### 3.3.1 No inconsistency

If the user has made any changes it shall be impossible that the data is not synced with the backend and the changes get lost. 

### 3.4 Performance

To be discussed.

#### 3.4.1 Performance Requirement One

### 3.5 Supportability

#### 3.5.1 Android

The app will be exclusively available for android in the first sight. IOS compatibility is therfore currently not planned.

#### 3.5.2 Conventions

The Team will try his best to fullfill the coding and naming standards of the languages used.

### 3.6 Design Constraints

#### 3.6.1 Android Studio

The main part of the app will be developt using Android Studio.

#### 3.6.2 Design

We made a design prototype of how the app should look like.
You can find it [here]( evendo/doc/app.png)

### 3.7 On-line User Documentation and Help System Requirements

Our app should be intuitive so we don't need to add an documentation to use our calendar. 

### 3.8 Purchased Components

One server for the hosting of the blog and one for YouTrack.
One Server for the backend.

### 3.9 Interfaces


#### 3.9.1 User Interfaces

The general App.
	- Calendar View
	- ToDo View
	- Settings View
	- Create Event Dialog
	- Create ToDo Dialog
	- Import Calendar Dialog
	- Create ToDo for Event Dialog

#### 3.9.2 Hardware Interfaces

The frontend should be hardware independent.

The backend is build for x64 hardware.

#### 3.9.3 Software Interfaces

The frontend software is limited to Android. Explicit versions will be released after checking the requirements of our Kotlin Code.

The backend software is not limited to any operating system.

#### 3.9.4 Communication Interfaces

Backend Server for the storage of the data to allow the access via multiple devices.

### 3.10 Licensing Requirements

Evendo will be released on MIT License.

### 3.11 Legal, Copyright, and Other Notices

Nothing required.
 
### 3.12 Applicable Standards

tbd

## 4. Supporting Information

Use-Case Diagrams:
[Create Event](https://github.com/gnaatz/evendo/blob/docu/doc/use-case-diagrams/UseCase_EVENT.md)
[Create ToDo](https://github.com/gnaatz/evendo/blob/docu/doc/use-case-diagrams/UseCase_TODO.md)
[Show Event](https://github.com/gnaatz/evendo/blob/docu/doc/use-case-diagrams/UseCase_SHOW.md)
[Change Day](https://github.com/gnaatz/evendo/blob/docu/doc/use-case-diagrams/UseCase_CHANGEDAY.md)
[Create ToDO in Event](https://github.com/gnaatz/evendo/blob/docu/doc/use-case-diagrams/UseCase_CREATETODOINEVENT.md)
