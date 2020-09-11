# cs101f2020-practical01-solution

## DUE: September 14 by 9:10am

[![Actions Status](../../workflows/build/badge.svg)](../../actions)

## Table of Contents

* [Objectives](#objectives)
* [Introduction](#introduction)
* [Continuous Learning](#continuous-learning)
* [System Commands](#system-commands)
  + [Using Docker](#using-docker)
  + [Using Gradle](#using-gradle)
* [Program Requirements](#program-requirements)
* [Expected Program Output](#expected-program-output)
* [Automated Checks with GatorGrader](#automated-checks-with-gatorgrader)
* [Using GitHub Actions CI](#using-github-actions-ci)
* [Reporting Problems](#reporting-problems)
* [Receiving Assistance](#receiving-assistance)
* [Project Assessment](#project-assessment)

## Objectives

To continue to practice using GitHub to access the files for a course assignment.  Additionally, to review how to use
software development programs such as a "terminal window" and the "Docker Desktop".  You will also continue to practice using Slack to support communication with the technical leaders and the instructor.  Next, you will learn how to implement and test a Java program that passes parameters to swap values, also practicing how to use an automated grading tool to assess your progress towards correctly completing the project.

## Introduction

Designed for use with [GitHub Classroom](https://classroom.github.com/) and
[GatorGrader](https://github.com/GatorEducator/gatorgrader/), this repository
contains the solution for a practical assignment in an introductory computer
science class that uses the Java programming language. The GitHub Actions Continuous Integration (CI) builds for
this repository will pass, as evidenced by a green &#x2714; instead of a red
&#x2717; appearing in the commit logs. An instructor would use this repository
to create a "starter" repository with purposefully omitted features that a
student would then need to add in order to achieve the stated learning
objectives. Please bear in mind that much of the content in this document is
written in its current form under the assumption that it will also accompany the
"starter" repository that an instructor shares with a student through the use of
[GitHub Classroom](https://classroom.github.com/).

This assignment requires a programmer to implement and test a Java program,
called `Swap`, that will produce six lines of output. For this assignment, the
programmer must implement a swapping method that accepts parameters of type
`AtomicInteger`. The programmer is also responsible for learning how to run and
extend a test suite written in the JUnit testing framework, as explained in
Section 1.9. As verified by
[Checkstyle](https://github.com/checkstyle/checkstyle), the source code for the
`Swap.java` and `TestSwap.java` files must adhere to all of the
requirements in the [Google Java Style
Guide](https://google.github.io/styleguide/javaguide.html).

The source code in the `Swap.java` file must also pass additional tests set by
the [GatorGrader tool](https://github.com/gkapfham/gatorgrader). GatorGrader
will also check that your program performs the correct computation and produces
the expected output for a single call of the `swap` method. More details about
the GatorGrader checks are included later in this document and in the carefully
formatted assignment sheet.

## Continuous Learning

If you have not done so already, please read all of the relevant [GitHub
Guides](https://guides.github.com/) that explain how to use many of the features
that GitHub provides. In particular, please make sure that you have read the
following GitHub guides: [Mastering
Markdown](https://guides.github.com/features/mastering-markdown/), [Hello
World](https://guides.github.com/activities/hello-world/), and [Documenting Your
Projects on GitHub](https://guides.github.com/features/wikis/). Each of these
guides will help you to understand how to use both [GitHub](http://github.com) and
[GitHub Classroom](https://classroom.github.com/).

Students who want to learn more about how to use
[Docker](https://www.docker.com) should review the [Docker
Documentation](https://docs.docker.com/). Students are also encouraged to review
the documentation for their text editor, which is available for text editors
like [Atom](https://atom.io/docs) and [VS
Code](https://code.visualstudio.com/docs). You should also review the [Git
documentation](https://git-scm.com/doc) to learn more about how to use the Git
command-line client. In addition to talking with the instructor and technical
leader for your course, students are encouraged to search
[StackOverflow](https://stackoverflow.com/) for answers to their technical
questions.

To do well on this assignment, you should also review Chapter 1 of the course
textbook, paying close attention to Sections 1.1 through 1.3. Students who want
to learn more about how the provided source code uses packages are encouraged to
read Section 1.8 of the textbook. If a student wants to learn more about
software testing, they should review the content in Section 1.9. Please see the
course instructor or one of the teaching assistants or tutors if you have
questions about any of these reading assignments.

## System Commands

This project invites students to enter system commands into a terminal window.
This assignment uses [Docker](https://www.docker.com) to deliver programs, such
as `gradle` and the source code and packages needed to run
[GatorGrader](https://github.com/GatorEducator/gatorgrader), to a students'
computer, thereby eliminating the need for a programmer to install them on their
development workstation. Individuals who do not want to install Docker can
optionally install of the programs mentioned in the [Project
Requirements](#requirements) section of this document.

### Using Docker

Once you have installed [Docker
Desktop](https://www.docker.com/products/docker-desktop), you can use the
following `docker run` command to start `gradle grade` as a containerized
application, using the [DockaGator](https://github.com/GatorEducator/dockagator)
Docker image available on
[DockerHub](https://cloud.docker.com/u/gatoreducator/repository/docker/gatoreducator/dockagator).

```bash
docker run --rm --name dockagator \
  -v "$(pwd)":/project \
  -v "$HOME/.dockagator":/root/.local/share \
  gatoreducator/dockagator
```

The aforementioned command will use `"$(pwd)"` (i.e., the current directory) as
the project directory and `"$HOME/.dockagator"` as the cached GatorGrader
directory. Please note that both of these directories must exist, although only
the project directory must contain something. Generally, the project directory
should contain the source code and technical writing of this assignment, as
provided to a student through GitHub. Additionally, the cache directory should
not contain anything other than directories and programs created by DockaGator,
thus ensuring that they are not otherwise overwritten during the completion of
the assignment. To ensure that the previous command will work correctly, you
should create the cache directory by running the command `mkdir
$HOME/.dockagator`. If the above `docker run` command does not work correctly on
the Windows operating system, you may need to instead run the following command
to work around limitations in the terminal window:

```bash
docker run --rm --name dockagator \
  -v "$(pwd):/project" \
  -v "$HOME/.dockagator:/root/.local/share" \
  gatoreducator/dockagator
```

Here are some additional commands that you may need to run when using Docker:

* `docker info`: display information about how Docker runs on your workstation
* `docker images`: show the Docker images installed on your workstation
* `docker container list`: list the active images running on your workstation
* `docker system prune`: remove many types of "dangling" components from your workstation
* `docker image prune`: remove all "dangling" docker images from your workstation
* `docker container prune`: remove all stopped docker containers from your workstation
* `docker rmi $(docker images -q) --force`: remove all docker images from your workstation

### Using Gradle

Since the above `docker run` command uses a Docker image that, by default, runs
`gradle grade` and then exits the Docker container, you may want to instead run
the following command so that you enter an "interactive terminal" that will
allow you to repeatedly run commands within the Docker container.

```bash
docker run -it --rm --name dockagator \
  -v "$(pwd)":/project \
  -v "$HOME/.dockagator":/root/.local/share \
  gatoreducator/dockagator /bin/bash
```

Once you have typed this command, you can use the [GatorGrader
tool](https://github.com/GatorEducator/gatorgrader) in the Docker container by
typing the command `gradle grade` in your terminal. Running this command will
produce a lot of output that you should carefully inspect. If GatorGrader's
output shows that there are no mistakes in the assignment, then your source code
and writing are passing all of the automated baseline checks. However, if the
output indicates that there are mistakes, then you will need to understand what
they are and then try to fix them.

You can also complete several important Java programming tasks by using the
`gradle` tool. For instance, you can compile (i.e., create bytecode from the
program's source code if it is correct) the program using the command `gradle
build`. Here are some other commands that you can type:

* `gradle grade`: run the [GatorGrader](https://github.com/GatorEducator/gatorgrader) tool to check your work
* `gradle clean`: clean the project of all the derived files
* `gradle check`: check the quality of the code using Checkstyle
* `gradle build`: create the bytecode from the Java source code
* `gradle run`: run the Java program in the command-line
* `gradle cleanTest`: clean the JUnit test suite of derived files
* `gradle test`: run the JUnit test suite and display the results
* `gradle tasks`: display details about the Gradle system

To run one of these commands, you must be in the main (i.e., "home base")
directory for this assignment where the `build.gradle` file is located.

## Program Requirements

The instructor will provide you with the necessary software development tools through a Docker container.  Once you have installed Docker Desktop, you can use a "docker run" command to start "gradle grade" as a containerized application, using the "DockaGator" Docker image available on DockerHub.  Before you start to build and test your program, please study the source code of the Swap program, noticing that one of its methods is incomplete.  Specifically, you will notice that the program is missing an implementation of the swap method.  Can you add in a full implementation of this method?  Why do you think that the swap method accepts parameters of type `AtomicInteger`?

Next, you should also notice that the `Swap` has a test suite called `TestSwap` that is written in the JUnit testing framework; please refer to Section 1.9 and the comments in the source code of this test suite to learn more about how it works.  Intuitively, a JUnit test suite has individual test cases, written as Java methods, that each work to establish a confidence in the correctness ofSwap.  First, please note that this test suite initially passes even though the program is incorrect.  Why?  Finally, you should add at least two new test cases to this suite.  What type of tests are most needed?

Now, if you want to "build" your program you can type the command `gradle build` in your terminal, thereby causing the Java compiler to check your program for errors and get it ready to run.  If you see any error messages, go back to your text editor and figure out what you mistyped and  fix  it.   Oncer  you  have  solved  the  problem,  make  a  note  of  the  error  and  the  solution  for resolving it.  Re-save your program and then build it again by re-running the `gradle build`.  If you cannot build `Swap` correctly, then please message a technical leader or the instructor.  You can  also  run  the  test  suite  for  the `Swap` by  typing  `gradle test`  in  the  terminal.   What  is  the purpose of each of these test cases?  What output do you see from running the test suite?  Does this output suggest that the program is likely to produce the correct output?

Once you resolve all of the building and testing errors, you can run your swapping program by typing `gradle run` in the terminal window — this is the "execute" step that will run your program and produce the designated output.  Do you see that it produces correct output as shown in the next section? If not, then determine what is wrong and then repair the program and re-build and re-run it.

## Expected Program Output

Typing the command `gradle run` in the terminal window should produce the
following output for the completed version of `Swap`. As long as your
program adheres to all of the requirements for the assignment and passes all of
the verification checks, your version should produce similar output. With that
said, program output may vary according to, for instance, the name of the
programmer and the date on which you ran the program.

```
> Configure project :
Configured GatorGradle 0.4.4

> Task :run
Values before the swap:
  First value : 10
  Second value: 20
Values after the swap:
  First value : 20
  Second value: 10

BUILD SUCCESSFUL in 6s
2 actionable tasks: 1 executed, 1 up-to-date
```

Running the command `gradle -q --console plain run` will suppress the display of
Gradle's diagnostic information and produce output like the following.

```
Values before the swap:
  First value : 10
  Second value: 20
Values after the swap:
  First value : 20
  Second value: 10
```

## Automated Checks with GatorGrader

In addition to meeting all of the requirements outlined in the assignment sheet,
your submission must pass the following checks that
[GatorGrader](https://github.com/GatorEducator/gatorgrader) automatically
assesses:

- Repository has at least 5 commit(s)
- The Swap.java in src/main/java/practicalone has at least 2 single-line Java comment(s)
- The Swap.java in src/main/java/practicalone has at least 3 multiple-line Java comment(s)
- The Swap.java in src/main/java/practicalone has at least 6 of the `println(` fragment
- The Swap.java in src/main/java/practicalone has exactly 0 of the `Add Your Name Here` fragment
- The Swap.java in src/main/java/practicalone has exactly 0 of the `TODO` fragment
- The Swap.java in src/main/java/practicalone has exactly 1 of the `package practicalone` fragment
- The TestSwap.java in src/test/java/practicalone has at least 1 multiple-line Java comment(s)
- The TestSwap.java in src/test/java/practicalone has at least 3 of the `@Test` fragment
- The TestSwap.java in src/test/java/practicalone has at least 3 single-line Java comment(s)
- The TestSwap.java in src/test/java/practicalone has exactly 0 of the `Add Your Name Here` fragment
- The TestSwap.java in src/test/java/practicalone has exactly 0 of the `TODO` fragment
- The TestSwap.java in src/test/java/practicalone has exactly 1 of the `package practicalone` fragment
- The command `gradle -q --console plain run` executes correctly
- The command `gradle build` executes correctly
- The command output has exactly 1 of the `Values after the swap` fragment
- The command output has exactly 1 of the `Values before the swap` fragment
- The command output has exactly 6 lines
- The file Swap.java exists in the src/main/java/practicalone directory
- The file TestSwap.java exists in the src/test/java/practicalone directory

If [GatorGrader's](https://github.com/GatorEducator/gatorgrader) automated
checks pass correctly, the tool will produce the output like the following in
addition to returning a zero exit code (which you can access by typing the
command `echo $?`).

```
        ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
        ┃ Passed 20/20 (100%) of checks for cs101-F2019-practical1! ┃
        ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
```

## Using GitHub Actions CI

This assignment uses [GitHub Actions CI](https://github.com/features/actions) to automatically run
[GatorGrader](https://github.com/GatorEducator/gatorgrader) and additional
checking programs every time you commit to your GitHub repository. The checking
will start as soon as you have accepted the assignment &mdash; thus creating your own
private repository. If you
do not see either a yellow &#9679; or a green &#x2714; or a red &#x2717; in your
listing of commits, then please contact the instructor.

## Reporting Problems

If you have found a problem with this assignment's provided source code or
documentation, then you can go to the [Computer Science 101 Fall 2020 Practical
1](https://github.com/allegheny-computer-science-101-f2020/practical01-solution)
repository and [raise an
issue](https://github.com/allegheny-computer-science-101-f2020/practical01-solution/issues).
If you have found a problem with the [GatorGrader
tool](https://github.com/GatorEducator/gatorgrader) and the way that it checks
your assignment, then you can also [raise an
issue](https://github.com/GatorEducator/gatorgrader/issues) in that repository.
To ensure that your issue is properly resolved, please provide as many details
as is possible about the problem that you experienced. If you discover a problem
with the assignment sheet for this project, then please raise an issue in the
GitHub repository that provides the assignment sheets for your course.

Whenever possible, individuals who find, and use the appropriate GitHub issue
tracker to correctly document, a mistake in any aspect of this assignment will
receive free [GitHub stickers](https://octodex.github.com/) and extra credit
towards their grade for the project.

## Receiving Assistance

If you are having trouble completing any part of this project, then please talk
with either the course instructor or a student technical leader during the
course session. Alternatively, you may ask questions in the Slack workspace for
this course. Finally, you can schedule a meeting during the course instructor's
office hours.

## Project Assessment

The grade that a student receives on this practical assignment is a checkmark grade (0 or 1) and is based on:

- **Percentage of Correct Gatorgrader Checks**: Students will receive 1 if their solution passes at least 50% of GatorGrader checks, otherwise they will receive 0.
Students are encouraged to repeatedly revise their source code in an attempt
to get their GitHub Actions CI build to pass.
