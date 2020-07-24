# Test plan

## 1.	Introduction
### 1.1	Purpose
The purpose of this Test Plan is to collect all of the information to plan and control our Tests in one document. 

### 1.2	Scope
This document includes an overview of our unit tests and api tests.

### 1.3	 References
This document exists with reference to the following documents:
| Reference        | 
| ------------- |
| [SAD](https://github.com/gnaatz/evendo/blob/docu/doc/pm/SAD.pdf) | 
| [Function Points](https://github.com/gnaatz/evendo/tree/docu/doc/pm/Function%20Points) |
| [Automated Testing](https://github.com/gnaatz/evendo/blob/docu/doc/automated-testing/automatedTesting.md) |
| [Metrics](https://evendo.gnaatz.de/?p=121) |

            
## 2.	Testing
### 2.1	Why should we test?
Testing source code is pretty important for us to keep our software up and running. If there is any kind of error we should get notified and maybe try to handle the error automatically.

### 2.2	Test-Calculation-Parameters
Our testing is motivated by 
- quality risks 
- technical risks
- use cases 
- functional requirements

## 3.	Architecture Overview
Evendo is splitted up in 2 main software elements: the backend and the frontend. Our backend communicates with the frontend via REST Services. 
It should be very important that the REST Services of our backend are running smoothly and without any errors because our frontend requires storing data in the backend.

## 4.	Planned Tests
### 4.1	Software Testing
The Frontend will be tested using cucumber, junit and gherkin on build to fulfill approx 70% of our frontend is working good. 
The Backend will be tested by using jest which is a Javascript test framework provided by Facebook for free. Because the api tests are pretty important, we reached out a test coverage of 98%.  
### 4.2 Hardware Testing
The Hardware is getting monitored by our hoster. In addition to that we automize a daily speedtest to ensure that full network speed is available.

## 5.	Test Approach
### 5.1 Initital Test-Idea Catalogs and Other Reference Sources
**n/a**
### 5.2	Testing Techniques and Types
#### 5.2.1 Backend API-Testing
|| |
|---|---|
|Technique Objective  	| All functions of our backend will be called, their results will be compared with preset results |
|Technique 		| Backend will start up to run the tests |
|Expectation 		| The function should return the expected data, the test should be successful |
|Required Tools 	| jest, NodeJS |
|Success Criteria	| The function returns the expected data |


#### 5.2.2 Frontend Testing
|| |
|---|---|
|Technique Objective  	| Frontend interaction should be tested by our tests. |
|Technique 		| Gherkin tests will test the frontend functionallity. |
|Expectation 		| Backend should return the required data for the frontend that the tests will be successful. Data request initialized by test.  |
|Required Tools 	| Gherkin, JUnit, Kotlin, Evendo Backend |
|Success Criteria	| The function returns the expected data |

#### 5.2.3 Business Cycle Testing
**n/a**

#### 5.2.4 User Interface Testing
**n/a**

#### 5.2.5 Performance Profiling 
|| |
|---|---|
|Technique Objective  	| Network connection speedtest |
|Technique 		| Using cron, bash and speedtest-cli without any other framework |
|Expectation 		| The network speed will be checked to provide the best possible service for our customers. We will receive an email if network is not working properly. |
|Required Tools 	| cron, bash and speedtest-cli |
|Success Criteria	| The network speed is above 100MB down and 100MB up |

#### 5.2.6 Load Testing
**n/a**

#### 5.2.7 Stress Testing
**n/a**

#### 5.2.8	Volume Testing
**n/a**

#### 5.2.9	Security and Access Control Testing
**n/a**

#### 5.2.10	Failover and Recovery Testing
**n/a**

#### 5.2.11	Configuration Testing
**n/a**

#### 5.2.12	Installation Testing
Installation testing is described in this document:
https://github.com/gnaatz/evendo/blob/docu/doc/automated-testing/automatedTesting.md

## 6.	Entry and Exit Criteria
### 6.1	Test Plan
#### 6.1.1	Test Plan Entry Criteria
All tests will run within a screen environment. After starting the screen, our automated testing script will execute all tests and our framework will notify us if something is not working.
#### 6.1.2	Test Plan Exit Criteria
When all tests have passed.

## 7.	Deliverables
### 7.1	Test Evaluation Summaries
Our testing environment will notify us by mail if something is not working. If there is no information - all should work fine.
### 7.2	Reporting on Test Coverage
n/a
### 7.3	Perceived Quality Reports
n/a
### 7.4	Incident Logs and Change Requests
n/a
### 7.5	Smoke Test Suite and Supporting Test Scripts
n/a

## 8.	Testing Workflow
Tests in the IDE will be executed automatically on build of our application. Our Backend-Tests will run several times a day.
## 9.	Environmental Needs
### 9.1	Base System Hardware
Processor: Intel Xeon E5 (4 cores)
RAM: 8GB (DDR3 ECC)
SSD/HDD: 100GB/1000GB

### 9.2	Base Software Elements in the Test Environment
Our operating system is linux (debian) 9. For testing we are using NodeJS v12 and the latest version of jest.

### 9.3	Productivity and Support Tools
We are using Github where to host our code:
[github.com](https://github.com/gnaatz/evendo)
As well as YouTrack:
[youtrack.schmuck-media.com](https://youtrack.schmuck-media.com)

### 9.4	Test Environment Configurations
n/a

## 10.	Responsibilities, Staffing, and Training Needs
### 10.1	People and Roles
Everyone of us is responsible for his code. 
### 10.2	Staffing and Training Needs
**n/a**
## 11. Milestones
Our milestone was that all implementation of tests was finished due to 30.06.2020.


## 12.	Risks, Dependencies, Assumptions, and Constraints
Something got destroyed which our tests does not cover or occures in other cases where our test do not jump into. In this case we should roll back our system to the last stable version.
## 13. Management Process and Procedures
**n/a**

## 14. Metrics

Everything about our Metrics Document can be found here:
https://evendo.gnaatz.de/?p=121


Disclaimer: Thanks a lot to UniTasks, that we are allowed to use their template :) 
