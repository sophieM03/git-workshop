---
title: Git workshop
date: \today
---

## Introduction

Workshop goal: get good practices contributing code in team with git and GitHub:

- work on branches,
- keep a clean history,
- submit pull requests for review.

You will manipulate on a Scala.js playground.

## Setup your GitHub account

1. Create a GitHub account attached to your society.

2. Create its key `~/.ssh/id_rsa_society` that will be attached to your account:

```bash
ssh-keygen -t rsa -b 4096 -C "mail@society.com"
```

3. Add `society.github.com` host to your ssh config:

```sshconfig
Host society.github.com
  HostName github.com
  IdentityFile ~/.ssh/id_rsa_society
```

4. Attach your public key `~/.ssh/id_rsa_society.pub` to your GitHub account
   from the GitHub interface.

## Setup your git configuration

We are configuring git to use your society email in the folder `path-to-society-apps/`.

1. Create `path-to-society-apps/.gitconfig`:

```gitconfig
[user]
  email = mail@society.com
```

2. Include `path-to-society-apps/.gitconfig` in `.gitconfig`:

```gitconfig
[includeIf "gitdir:path-to-society-apps/"]
  path = path-to-society-apps/.gitconfig
```

## Fork the repository

1. Fork `zengularity/git-workshop` from the GitHub interface.

2. In options settings, uncheck `merge commits` and `rebase merging`, keep only
   `squash commit` checked.

3. In branches settings, protect the master branch in the GitHub setting of
   your fork:

- from being forced-pushed,
- from being deleted,
- require 1 review before merging a branch into master.

4. In the collaborators settings, add the person sitting at your left. He will
   review your pull requests.

5. Clone the workshop repository with:

```bash
git clone
  git@society.github.com:your-username/git-workshop
```

## Setup the playground

1. Install sbt.

2. Inside the `playground` directory, launch the playground with:

```bash
sbt "~fastOptJS"
```

3. Open `playground/index.html` on your browser.

## Create a branch

1. Check that your current branch is master with:

```bash
git branch
```

2. Create a branch and move into it with:

```bash
git branch feature/arrow
git checkout feature/arrow
# Can be shorten to: git checkout -b feature/arrow
```

## Add a visualization arrow of the todos

Add an arrow `=====>` above the input, the number of equals is the number of
todos.

## Stage your files

1. Look at the files you have modified with:

```bash
git status
```

2. Add files manually or by group with:

```bash
git add file-or-directory
```

3. Look at the files staged for the next commit with:

```bash
git status
```

4. Try `git reset` to unstage files.

5. Restage the unstaged files and verify that there have been successfully
   staged.

## Prepare a commit and push it to origin

1. Create a commit for your staged files with:

```bash
git commit
```

2. In the first line, resume your work by beginning with an action verb:

- Add a login banner on the home page
- Integrate the project detail page
- Fix focus on the input component

3. Push your commit to origin with:

```bash
git push origin feature/arrow
```

4. You can view your remotes with:

```bash
git remote -v
```

## Colorize the arrow

Colorize in green a number of equals that is the number of completed todos.

## Prepare a new commit and push it to origin

- Add the modified files.
- Commit with an action verb at the beginning of the message.
- Push it to origin.

## Prepare a pull request

Create a pull request from your branch `feature/arrow` in the GitHub interface.
But don’t merge it yet, your collaborator is very busy and can’t review right
now.

## Refactor the TodoList component

You’re gonna refactor the TodoList component.

## Create a new branch

We’re making refactoring from another branch, that will lead to another pull
request. This new branch will be based on master, and not on the current
feature branch you have been working on.

You have 2 options:

1. Option 1:

```bash
git checkout master
git checkout -b refactor/todo-list
```

2. Option 2:

```bash
git branch refactor/todo-list master
git checkout refactor/todo-list
```

## Refactor (1/2)

Rename `todos` to `items`.

## You end your day and push a WIP commit

In case there is a problem with your local commit, you want to push your WIP
work at the end of the day. Moreover, you don’t have time to think of a better
name for your commit.

1. Stage your files on the refactoring.

2. Create your WIP commit:

```bash
git commit -m "WIP"
```

3. Push it to origin.

## Refactor (2/2)

Rename `isCompleted` in the `Todo` model to `isDone`.

## Melt you changes into the WIP commit

1. Stage your files on the refactoring.

2. Check that the previous commit is the WIP commit before melting your staged
   changes into it.

```bash
git log --one-line
```

3. Now that you’re sure that the previous commit is the WIP one, melt your
   changes into it, and modify the commit message too:

```bash
git commit --amend
```

This command can be used even if there is no actual staged modifications, in
order to modify the previous commit message.

## Push it to origin and create a pull request

1. Analyze what `git status` tells you.

2. Try to push your changes to origin with:

```bash
git push origin refactor/todo-list
```

3. Because you have modified git history that had already been pushed, you have
   to force your modifications to origin with:

```bash
git push --force origin refactor/todo-list
```

Beware, a force commit is risky if another person is working in the same branch
as you.

4. Create a pull request.

## Pull request review

1. Review the refactor pull request of the person on your right. Submit a
   comment somewhere and request changes.

2. TODO

## Add a count of deleted arrows

1. TODO ?

## TODO

- git show
- get synced from master
- gitignore ?
- git rebase -i ?
- gitconfig aliases
