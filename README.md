![](https://github.com/jsmiith/discord-bot-best-practices/blob/master/banner.png)

# The best practices for Discord Bots :robot:

This is a list of the best practices for Discord Bots, as curated by the community. These guidelines are influenced massively by the guidelines listed in [meew0's repository](https://github.com/meew0/discord-bot-best-practices), which has apparently "lost relevance", and hasn't been updated in two years.

*These guidelines are intended for bots running on public servers. If your bot is restricted to private ones, this document most likely does not apply to you.*

## 1. Commands should be explicitly invoked.

Bots should not activate during a normal chat. Instead, you should use a prefix for your bot, or make it so it only responds when your bot is directly @mentioned.

## 2. Use unique prefixes.

Single characters such as `!`, `$`, and `.` are very common prefixes, and should be avoided due to the amount of bots already using them. Instead, opt to use a unique prefix for your bot For example, if your bot was called `owlbot`, you could use `owl` as your prefix, or maybe a less commonly used character like `"`. You should also avoid using `#` and `@` as your bot's prefix, as those are used to mention channels (`#channel`), or a user (`@user#1234`). Ideally, your bot's prefix should be configurable on a server-by-server basis so that server owners can ensure that every bot has their own unique prefix of their choice - however, this is not mandatory.

## 3. Don't be greedy.

Restrict yourself to a small number of prefixes as to reduce the risk of collision with others.

## 4. Don't overuse mentions.

If you reply directly to a command, do not use a mention; they can lead to bot reply loops. Mentions are fine if a long-running command is executed, but private messages are a good alternative.

## 5. Have an `info` command.

Your `info` command should provide information about the bot, such as what framework it is using, the used version, `help` command, and, most importantly, who made it.

## 6. Don't reply with "invalid command".

If a user attempts to run a command that does not exist, let it fail silently. Do not have it reply with something like "invalid command". However, if a command is correct but the arguments are wrong then it is okay to reply with something along the lines with "invalid args". If there is more than one bot in a server that shares a prefix, this can result in very obnoxious usage.

**If your bot's prefix is configurable, this rule can probably be safely disregarded.**

## 7. Be respectful of Discord's API

Bots that abuse and misuse Discord's API ruin things for everyone. Make sure to factor in rate-limiting and backoff in your bot code, and be intelligent about using the API. Make sure to ask for help if you are unsure about the right way to implement things.

## 8. Ignore both your own and other bot's messages.

This helps prevent infinite self-loops and potential security exploits. Using a zero-width space such as `\u200B` and `\u180E` also prevents your bot from triggering other bot's commands. The Discord API also tells you if a user is a bot (the `bot` property on the `User` object - [see the reference](https://discordapp.com/developers/docs/resources/user#user-object)

## 9. Keep NSFW features locked to NSFW channels.

All NSFW commands/features should only work in NSFW-marked channels.

## 10. Use mentioning the bot to help users.

Allowing a mention by the prefix (`@myawesomebot#1234 help`) or adding a way to find the bot's prefix with only a mention (`@myawesomebot#1234`) will help users who are new to your bot greatly in getting started.

### Note

If you have an idea for an addition or change to this document, please do make a pull request and we can discuss it.
