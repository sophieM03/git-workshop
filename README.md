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
```

Those command can be shorten to:

```bash
git checkout -b feature/arrow
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

2. The command above let you write the commit message, resume your work by
   beginning with an action verb, like this:

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

Colorize in green the number of equals in the arrow corresponding to the number
of completed todos.

## Prepare a new commit and push it to origin

- Add the modified files.
- Commit with an action verb at the beginning of the message.
- Push it to origin.

## Prepare a pull request

Create a pull request from your branch `feature/arrow` in the GitHub interface,
but don’t merge it yet, your collaborator is very busy and can’t review right
now.

## Refactor the TodoList component

You’re gonna refactor the TodoList component.

## Create a new branch

You’ll refactor changes from another branch, this will lead to another pull
request. This new branch will be based on master, and not on the current
feature branch you have been working on.

You have 2 options:

```bash
git checkout master
git checkout -b refactor/todo-list
```

or

```bash
git branch refactor/todo-list master
git checkout refactor/todo-list
```

## Refactor (1/2)

Rename `todos` to `items` in the `TodoList` component.

## End your day and push a WIP commit

At the end of the day, that’s interesting to push your code even if it’s still
WIP.

1. Stage your files on the refactoring.

2. Create your WIP commit, you don’t bother with the naming:

```bash
git commit -m "WIP"
```

3. Push it to origin.

## Refactor (2/2)

Rename `isCompleted` to `isDone` in the `Todo` model.

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

## Push to origin and create a pull request

1. Analyze what `git status` tells you.

2. Try to push your changes to origin with:

```bash
git push origin refactor/todo-list
```

3. Because you have modified the history that had already been pushed, you have
   to force your modifications to origin with:

```bash
git push --force origin refactor/todo-list
```

Beware, a force commit is risky, you can loose code in the process,
particularly if another person is working in the same branch as you.

4. Create a pull request.

## Review a pull request

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
- gitconfig aliases (end of the workshop)
