# Vorprojekt Raneem Malhis



## Getting started


```
cd existing_repo
git remote add origin https://gitlab2.cip.ifi.lmu.de/malhisr/vorprojekt-raneem-malhis.git
git branch -M main
git push -uf origin main
```

## Integrate with your tools

- [ ] [Set up project integrations](https://gitlab2.cip.ifi.lmu.de/malhisr/vorprojekt-raneem-malhis/-/settings/integrations)

## Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/user/project/merge_requests/auto_merge/)

## Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

# Datenmodell
Das Spiel besteht aus:

    Spielern

    Karten (mit Effekten)

    einem Deck (Nachziehstapel)

    einem Ablagestapel

    evtl. einem Spielleiter (Game Manager), der den Ablauf koordiniert


## UML
┌────────────┐
│    Game    │
├────────────┤
│ - players  │
│ - deck     │
│ - discard  │
│ - currentPlayerIndex │
├────────────┤
│ + startGame()       │
│ + playTurn()        │
│ + checkWin()        │
└────────────┘
│
▼
┌────────────┐
│   Player   │
├────────────┤
│ - name     │
│ - hand     │
│ - isOut    │
│ - tokens   │
├────────────┤
│ + drawCard(deck)    │
│ + playCard(card)    │
└────────────┘
│
▼
┌────────────┐
│   Card     │
├────────────┤
│ - name     │
│ - value    │
│ - effect() │
├────────────┤
│ + applyEffect()     │
└────────────┘

┌────────────┐
│   Deck     │
├────────────┤
│ - cards    │
├────────────┤
│ + shuffle()│
│ + draw()   │
└────────────┘


## Name
Vorprojekt Raneem Malhis, Love Letter

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
