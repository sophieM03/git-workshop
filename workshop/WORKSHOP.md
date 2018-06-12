---
author: Joris
title: Git workshop
date: 11/06/2018
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

4. Attach your public key `~/.ssh/id_rsa_society.pub` to your GitHub account.

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

## Setup the playground

1. Install sbt.

2. Clone the workshop repository with:

```bash
git clone git@society.github.com:zengularity/playground
```

3. Inside the `playground` directory, launch the playground with:

```bash
sbt "~fastOptJS"
```

4. Open `playground/index.html` on your browser.

## Create a local branch

1. Check your current branch with:

```bash
git branch
```
