---
title: Git workshop
date: \today
---

## Introduction

Workshop goal: get good practices contributing code in team with git and GitHub:

- work on branches,
- submit pull requests for review,
- keep a clean history.

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

2. Protect the master branch in the GitHub setting of your fork:

- from being forced-pushed,
- from being deleted,
- require 1 review before merging a branch into master.

3. In the settings, add the person sitting at your left as a collaborator. He
   will review your pull requests.

4. Clone the workshop repository with:

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

## Add a visualization arrow

1. Add an arrow `=====>` above the input, the number of equals is the number of
   todos.
2. Color in green a number of equals that is the number of completed todos.

## Refactoring

1. Rename `todos` to `items`.
2. Reorder the

## Add a count of deleted arrows

1. foo
