## Revision History
Date | Version | Description | Author
--- | --- | --- | ---
25.10.19 | 1.0 | First release of the UC | Kolja Groß
05.12.19 | 1.1 | Added Pre and Post conditions | Niclas Schmuck

## Table of Contents
- [1. Use Case Create Todo for Event](#1-use-case-create-account)
  - [1.1 Brief Description](#11-brief-description)
- [2. Flow of Events](#2-flow-of-events)
  - [2.1 Basic Flow](#21-basic-flow)
  - [2.2 Alternative Flows](#22-alternative-flows)
  - [2.3 Feature File](#23-feature-files)
- [3. Preconditions](#4-preconditions)
- [4. Postconditions](#5-postconditions)

## 1. Use-Case Create Todo for Event
### 1.1 Brief Description
This use case is to create a todo according to an appointment.

## 2. Flow of Events
### 2.1 Basic Flow
![Workflow Event](https://github.com/gnaatz/evendo/blob/docu/doc/activity-diagrams/ActivityDiagram_TODO.svg)
#### 2.1.1 Activity Diagram
![Activity Diagram](https://github.com/gnaatz/evendo/blob/docu/doc/activity-diagrams/ActivityDiagram_TODO.svg)
#### 2.1.2 Mock up
![Mockup](https://github.com/gnaatz/evendo/blob/docu/doc/app.png)
 ### 2.3 Feature File
![Feature File](https://github.com/gnaatz/evendo/blob/docu/doc/feature-files-screenshots/CreateTodoInEventFeatureScreenshot.jpeg)
### 2.2 Alternative Flows
There are no alternative possible flows discussed. Only our Basic Flow should work.

## 3. Preconditions
1. The user has to be logged in
2. The call has to be sent by the android client
3. All required parameters should be given.

## 4. Postconditions
After sending request to the service the service should create an todo for an appointment directly into the database. The client should sync this service with the local stored data.

## 5. Function Points Calculation
This Usecase has a classification of 43.24 Function Points. This is how we calculated the score:
![FunctionPointsCalculation1](https://github.com/gnaatz/evendo/blob/docu/doc/function-points/CreateTODO01.png)
![FunctionPointsCalculation2](https://github.com/gnaatz/evendo/blob/docu/doc/function-points/CreateTODO02.png)


Compared to our other usecases, this score is pretty high. The reason is that creating a todo event to your calendar is pretty much more complicated than chaning the current day (this only implies an select). Add a TODO implies an insert, maybe an update and of course a select. You can see our overall function points diagram down here:
![FunctionPoints](https://github.com/gnaatz/evendo/blob/docu/doc/pm/Function%20Points/Time_vs_FP.png)


