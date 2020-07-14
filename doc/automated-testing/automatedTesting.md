# Automated Testing and Deployment

### Introduction
Because our automated testing and deployment system is different to others, I want to introduce you into our automated testing and deployment system now. Our Frontend uses Kotlin and is simply a system with not that much logic that's why we only use test on build functions integrated in Android Studio. 

### Used Software
- Cron(-jobs)
- NodeJS
- Shellscript


### Cron - What is that?

The software utility **cron** is a time-based **job** scheduler in Unix-like computer operating systems. Users that set up and maintain software environments use **cron** to schedule **jobs** (commands or shell scripts) to run periodically at fixed times, dates, or intervals.

Abstracted to our project, cron runs our shell script every day at 1 am, 5am, 10am, 1pm, 6pm. 

### ShellScript - a little part of our script
We are only showing a bit of our code because it would be to complex to explain the full code. 
```bash
#!/bin/sh

# Check if screen exists
if ! screen -list | grep -q "evendo"; then
# Pull latest changes
git pull
# Afterwards install
npm install
# Execute Test Run with errorHandling
# If a test fails, our test will automatically execute an api call which sends a mail. 
sh ./runTestsWithErrorHandling.sh

else
# Start Node Server
sh ./startUp.sh
fi
```

### How does it work?

It works with a simple principle: it will be executed by cron several times a day. The cronjob runs the executable script. This script pulls our latest branch from GitHub, next runs an `npm install` followed by `npm test --runInBand` (mentioned in another script). Our Test Framework for NodeJS has the possibility to run other NodeJS Code on success or on failure of tests by extending the code of our test framework. In those function bodies we have implemented a function of NodeMailer, which is a smtp mail package for NodeJS. That means that we get notified by mail, if a test failed and we can simply react to that.

### Code Extension
We extended the expect by overwriting the expect(something).toBe(expectedValue) by the following code. In addition to that, we added our NodeMailer.
```javascript
expect.extend({
toBe(received, argument) {
const  pass = (received == argument);
if (pass) {
return {
pass:  true,
message: () =>  `expected ${received}. matched: ${argument}`,
}
} else {
const  nodemailer = require('nodemailer');
let  testAccount = nodemailer.createTestAccount();
let  transporter = nodemailer.createTransport({
host:  "smtp.ethereal.email",
port:  587,
secure:  false,
auth: {
user:  testAccount.user,
pass:  testAccount.pass,
},
});
let  info = transporter.sendMail({
from:  '"Error Handler" <error@evendo.com>',
to:  "mailaddr@mail.de",
subject:  "Found error",
text:  "Your test could not get completed. Please check",
html:  "Your test could not get completed. Please check",
});
return {
pass:  false,
message: () =>  `expected ${received}. matched: ${argument}`,
}
}
}
});
```

### Flow Chart

![FlowChart1](https://github.com/gnaatz/evendo/blob/docu/doc/automated-testing/flow1.png?raw=true)
![FlowChart2](https://github.com/gnaatz/evendo/blob/docu/doc/automated-testing/flow2.png?raw=true)


### Conclusion

If there will be another project, we could definitely use that system how it is. It worked pretty well and updates as well as roll backs were updated pretty good. If you have any further questions, please feel free to ask.
