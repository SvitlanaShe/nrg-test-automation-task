# QA Engineer Task
> Outfittery - Team NRG

Hello! If you're looking at this repository, it means you're considering work at Outfittery, and that's awesome! Thank you for considering working with us!

So, this repository is nothing but a simple boilerplate to help you setting up your front-end work environment for the task. It gives you access to pre-defined colors, directives, components, etc, that you might need during your task, besides showing you a bit of what we use at Outfittery.

There certainly is a lot of room for improvement. During your coding task, if you find anything that needs improvement, feel free to do it. If you could let us know about such improvements, it'd actually be awesome, as that'd allow us to continuously improve and hire more awesome people like yourself :)

# Test Suite

## Prerequisites

Install JDK 8. Place the chromium app ([mac](https://sourceforge.net/projects/osxportableapps/files/Chromium/) [windows](https://sourceforge.net/projects/crportable/)) under `build/browsers/chrome`. Place the [chromium driver](http://www.seleniumhq.org/download/) under `build/drivers`.

## Downloading browser dependencies

TODO

## Browsers

All tests will run against the browsers we have provided in the `build\browsers` directory. These are:

* Firefox (Version:41.0)
* Chrome (Version:53.0)

## Drivers
To control the automated interaction process with have provided the following drivers in the `build\drivers` directory for interacting with Chrome and Firefox respectively:

* Chromedriver (Version: 2.26)
* Geckodriver (Version: 0.14.0)

When updating the browsers, please ensure that you update the drivers to the recommended version for that browser.


## Running the example tests:

In the root directory, enter the following:

`./gradlew systemTests` (Unix style CML) or `gradlew systemTests` (WIN style CML)


### Reports
After you tests have finished running. You can find detailed reports on whether they passed, or if they failed, where they failed and the cause of the failure.

By default, you can find them in the `build/serenity/index.html`

### Flags
Flags can be used in the gradle command to change how the test runs.

`-Pstory=x` By changing the value of `x` to the name of the story file you want to run. This is particularly useful when you have a large test suite but only want to run one story.

`-Pbrowser=Firefox` or `-Pbrowser=Chrome` will allow you to specify which browser you would like to run. If you do not define a browser chromium will be used.

`-i` This provides more detailed logging in the console.

## File Structure

We advice that in your file structure that you separate different areas of the page into seperate pages, selectors and steps classes. In our example you can see that we have done this with the homepage/base page, and the login page for Wikipedia.

### Pages directory
The pages directory stores methods that interact with different aspects of the webpage.

### Selectors directory
The selectors directory stores the selectors for various elements on webpages.

### Steps directory
The steps directory links our steps in the story files to methods in the pages file. This is done Using Jbehave.

### Suites directory
Suites are used to gather stories which should be ran together. Each suite should either list all stories that should be ran when using that suite, but giving the path to each individual story, or take a path to a directory with all the stories that should be ran.

### Utils Directory
The utils directory provides methods to help you interact with the web page. Our CustomDriver class is used to provide drivers for using Firefox and Chrome.

 The Utils class provides methods for different types of interactions with the page, such as clicking or double clicking elements.

 The WaitUtils class provides various methods that wait for a condition to be true, such as waiting for a element to be present on the page. By default, these waits last for up to 10 seconds. This can be changed by changing the value of `TIMEOUT_SECONDS`.

### Stories directory
The stories directory is designed to keep your story files. Each story file follows the Jbehave scenario format.

 By default the SystemTestSuite will gather all stories in this directory and run them when you run the `systemTests` gradle command.

## Suggestions and Troubleshooting

* Its ideal to use a WaitUtils method to ensure that the element you want to work with is present on the page before interacting with it.
* `Stale Element Exceptions occur` when an element has changed in the time it has taken the test to find it and before it has been interacted with. Waiting for an element to enter its final state before interacting with it is good practice.
* If the selenium reports `index.html` file is not being produced in `build/serenity/` try adding `aggregate` to the end of your gradle command when running the tests.

## Useful Links
[http://www.seleniumhq.org/]

[https://docs.gradle.org/current/release-notes.html]

[http://jbehave.org/]

[https://sites.google.com/a/chromium.org/chromedriver/]

[https://github.com/mozilla/geckodriver/releases]

## Questions? Complaints? Suggestions?

As part of your recruiting process, you'll be invited to a Slack channel where you'll have access to everyone from our team, so, feel free to talk to us via Slack or drop us an e-mail :)
