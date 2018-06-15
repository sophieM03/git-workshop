---
title: Git workshop
date: \today
---

## Introduction

Workshop goal: get good practices contributing code in team with git and GitHub:

- use core git commands,
- work on branches,
- submit pull requests for review,
- keep a clean history,

You will manipulate on a Scala.js playground.

## Setup your GitHub account

1. Create a GitHub account attached to your society.

2. Update your account avatar, it will be easier for your collaborators to
   identify you.

## Create an SSH key and attach it to your account

1. Create the key `~/.ssh/id_rsa_society` that will be attached to your account:

```bash
ssh-keygen -t rsa -b 4096 -C "mail@society.com"
```

2. Add `society.github.com` host to your ssh config:

```sshconfig
Host society.github.com
  HostName github.com
  IdentityFile ~/.ssh/id_rsa_society
```

3. Attach your public key `~/.ssh/id_rsa_society.pub` to your GitHub account
   from the GitHub interface.

## Setup your git configuration

You are configuring git to use your society email in the folder
`path-to-society-apps/`.

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

## Setup the playground

1. Clone the workshop repository with:

```bash
git clone
  git@society.github.com:your-username/git-workshop
```

2. Install [SBT](https://www.scala-sbt.org/).

3. Inside the `playground` directory, launch the playground with:

```bash
sbt "~fastOptJS"
```

4. Open `playground/index.html` on your browser.

## Get repository information on the CLI

1. List the previous commits with:

```bash
git log # or git log --oneline
```

2. Show the details (diff) of the last commit with:

```bash
git show
```

3. List the local branches:

```bash
git branch
```

4. List all the branches (with remote):

```bash
git branch -a
```

## Add a new feature

You are going to add an arrow which length is the number of todos.

## Create a branch

Create a branch and move into it with:

```bash
git checkout -b feature/arrow
```

## Add a visualization arrow of the todos

Above the input which let you add todos, add an arrow `=====>`, with the number
of equals corresponding to the number of todos.

1. Initially 4 todos: `====>`
2. A todo is added: `=====>`
3. 2 todos are removed: `===>`

## When you’re done, stage your files

1. Look at the files you have modified with:

```bash
git status
```

2. Look at your unstaged modifications with:

```bash
git diff
```

3. Add files manually or by group with:

```bash
git add file-or-directory # git reset … to undo
```

4. Look at the files staged for the next commit with:

```bash
git status # The files added previously should be listed
```

5. Look at your staged modifications with:

```bash
git diff --staged
```

## Prepare a commit

1. Create a commit for your staged files with:

```bash
git commit
```

2. The command above open an editor which let you write the commit message,
   resume your work by beginning with an action verb, like this:

- Add a login banner on the home page
- Integrate the project detail page
- Fix focus on the input component

3. If you need to, add a description after a blank line.

## Push your commit to your repository

1. Push your commit to origin with:

```bash
git push origin feature/arrow
```

2. In the command above, `origin` is the remote URI of your repository. You
   could have other remotes. Check your repository URI with:

```bash
git remote -v
```

## Improve the arrow

You want to improve the arrow so that it give the information of done todos.

Colorize in green the number of equals in the arrow corresponding to the number
of completed todos.

## Prepare a new commit and push it to origin

1. Use a shortcut to add and commit your file:

```bash
git commit -a
```

2. Push it to origin.

## Prepare a pull request

1. Create a pull request from `feature/arrow` in the GitHub interface. Because
   you have made a fork, the destination is `zengularity/git-workflow`, change
   it to your repository `username/git-workflow`.

2. Give it a title resuming your modification.

3. You can give more information in the description if necessary.

4. Add a *Quality Insurance* scenario in the description which indicate
   precisely the steps to check if your feature is valid or no.

```
**QA**

1. Go here and add this,
2. you should see that,
3. etc.
```

## Unfortunately, your collaborator is busy

Because you need 1 review, you can’t merge your pull request yet. So, you’re
gonna do another thing: refactor the TodoList component.

## Create a new branch

You’ll refactor changes from another branch, this will lead to another pull
request. This new branch will be based on master, and not on the current
feature branch you have been working on.

```bash
git checkout master
git checkout -b refactor/todo-list
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
git log -n 1 # Must show the WIP commit
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

3. Because you have modified the branch history that had already been pushed, you have
   to force your modifications to origin with:

```bash
git push --force origin refactor/todo-list
```

Beware, a force commit is risky, you can loose code in the process.

4. Create a pull request from the GitHub interface, and think about the title
   and the description, which should contains a QA. Don’t forget to target your
   fork and not `zengularity/git-workflow`.

## Review a pull request

Review the **refactor** pull request of the person on your right. Because you
are picky, submit a comment to replace `isDone` by `isFinished` and request
changes.

## Modify your pull request

The person on your left requested changes on you pull request. Because you
agree on his comment:

1. replace `isDone` by `isFinished`,
2. stage your modified files,
3. create a fix commit,
4. push it to your branch.

You are creating a fix commit instead of ammending the last one, so that the
reviewer will see only new changes and will not have to review everything back
again.

## Approve the pull request

The person on your right made the changes you requested, you can approve his
pull request.

## Merge your pull request with squash

Now that your pull request is approved:

1. click on “merge with squash”,

2. Prepare a well-formed commit message:

- The first line is:
    - a summary of your modification,
    - it begins with an action verb.
- The rest is a detail of your modifications:
    - it can contain a list of modifications begining with `-` or `*`,
    - it can link to un issue with its URL.

3. Check that you can still access to every commit you did in the GitHub
   interface.

## Get the changes on master on your machine

1. Go to the master branch and get synchronized with origin/master with:

```bash
git checkout master
git pull
```

2. Check that you refactor is in a single commit on your local master branch.

3. Delete your feature branch with:

```bash
git branch -d refactor/todo-list
```

## Going back to the visualization arrow

You want to merge your visualization arrow feature. Unfortunately, your feature
now has conflicts with the master branch. You have the choice between rebasing
and merging.

## Rebasing vs. merging

You’ll use rebase instead of merge. Instead of having a merge commit, you move
the entire branch to begin on the tip of the branch you rebase from. See more
details [here](https://www.atlassian.com/git/tutorials/merging-vs-rebasing).

That means:

- it can be more complex than merging if you have multiple commits,
- and you have to change the history :
   - you risk (when handling conflicts) to introduce unwanted changes while losing the original (valid) changes forever,
- but that will lead to a cleaner history,
- and you’ll avoid strange and repetitive merge conflicts in case you merge
  multiple times.

## Rebase and resolve the conflicts

1. Go to the feature branch.

```bash
git checkout ...
```

2. Get remote changes and rebase from master with:

```bash
git fetch
git rebase origin/master
```

3. All the parts in conflict have been marked on your files, resolve them. You
   can use:

   - your raw editor,
   - your editor merge tool,
   - `git mergetool` (with vim, nvim, meld, …).

## Finalize the rebase

1. Add your modified files.

2. Continue the rebase with:

```bash
git rebase --continue
```

The rebase will continue to be applied on the next commits, but because you have
only one commit, the rebase is now done.

3. Check that the project compiles successfully, and that the visualization
   arrow still works.

4. Push force your branch to origin.

## Pull request validation

You now have time to check the **arrow** pull request of the person on your
right. Whenever your pull request is validated, merge it.

## Being faster with git config aliases

You can add git aliases in `.gitconfig`, for example:

```gitconfig
[alias]
  tree = log --graph --oneline
  p = push origin HEAD
```

## RTFM

```bash
man git branch
man git rebase
…
```

## TODO

- Rename branch both locally and remotly
- git stash scenario
