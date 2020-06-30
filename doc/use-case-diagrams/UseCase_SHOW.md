## Revision History
Date | Version | Description | Author
--- | --- | --- | ---
25.10.19 | 1.0 | First release of the UC | Kolja Groß
05.12.19 | 1.1 | Added Pre and Post conditions | Niclas Schmuck
28.04.20 | 1.2 | Added Pre and Post conditions | Niclas Schmuck

## Table of Contents
- [1. Use Case Show Event](#1-use-case-create-account)
  - [1.1 Brief Description](#11-brief-description)
- [2. Flow of Events](#2-flow-of-events)
  - [2.1 Basic Flow](#21-basic-flow)
  - [2.2 Alternative Flows](#22-alternative-flows)
   - [2.3 Feature File](#23-feature-file)
- [3. Preconditions](#4-preconditions)
- [4. Postconditions](#5-postconditions)
- [5. Function Points Calculation](#5-function-points-calculation)

## 1. Use-Case Show Event
### 1.1 Brief Description
This use case is for showing entries in the calendar, called events.

## 2. Flow of Events
### 2.1 Basic Flow
![Workflow Event](https://github.com/gnaatz/evendo/blob/docu/doc/activity-diagrams/ActivityDiagram_ShowEvent.svg)
#### 2.1.1 Activity Diagram
![Activity Diagram](https://github.com/gnaatz/evendo/blob/docu/doc/activity-diagrams/ActivityDiagram_ShowEvent.svg)
#### 2.1.2 Mock up
![Mockup](https://github.com/gnaatz/evendo/blob/docu/doc/mockups/editMockup.png)
### 2.2 Alternative Flows
There are no alternative possible flows discussed. Only our Basic Flow should work.
### 2.3 Feature File
![Feature File](https://github.com/gnaatz/evendo/blob/docu/doc/feature-files-screenshots/ShowEventFeatureScreenshot.jpeg)
## 3. Preconditions
1. The user has to be logged in
2. The call has to be sent by the android client
3. All required parameters should be given.

## 4. Postconditions
After sending request to the service the service should return all entries in database for this user. The client should sync this service with the local stored data.

## 5. Function Points Calculation
This Usecase has a classification of 12.6 Function Points. This is how we calculated the score:
![FunctionPointsCalculation1](https://github.com/gnaatz/evendo/blob/docu/doc/function-points/ShowEvent01.png)
![FunctionPointsCalculation2](https://github.com/gnaatz/evendo/blob/docu/doc/function-points/ShowEvent02.png)


Compared to our other usecases, this is a low score. You can see our overall function points diagram down here: 
![FunctionPoints](https://github.com/gnaatz/evendo/blob/docu/doc/pm/Function%20Points/Time_vs_FP.png)

