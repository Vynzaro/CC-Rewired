<!--
SPDX-FileCopyrightText: 2020 The CC: Tweaked Developers
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

# Contributing to CC: Rewired

CC: Rewired welcomes focused bug reports, design proposals, documentation and code contributions. The project is in
early development, so discuss large changes in an issue before implementing them.

## Reporting issues

Use the repository's [issue templates]. Search existing issues first and include the CC: Rewired version, Minecraft
version, mod loader, logs and exact reproduction steps.

Do not report CC: Tweaked bugs here unless they can be reproduced with a CC: Rewired build.

## Development environment

The complete build uses:

- JDK 25. Gradle targets Java 17 bytecode for Minecraft 1.20.1.
- Git.
- Node.js 20 or later only when building the documentation website.

Clone the repository:

```shell
git clone https://github.com/Vynzaro/CC-Rewired.git
cd CC-Rewired
```

Build and test on Linux or macOS:

```shell
./gradlew assemble
./gradlew check
./gradlew :forge:runClient
```

On Windows PowerShell:

```powershell
.\gradlew.bat assemble
.\gradlew.bat check
.\gradlew.bat :forge:runClient
```

The Forge JAR is written to `projects/forge/build/libs/`. Do not install CC: Rewired together with CC: Tweaked: both use
the `computercraft` compatibility ID.

## Project scope

Forge 1.20.1 is the primary target for the first release line. The inherited Fabric modules should continue compiling,
but new features do not need a simultaneous Fabric implementation unless the relevant issue explicitly requires it.

Read [the architecture document] before modifying shared code. Do not rename the `computercraft` mod ID, resource
namespace, Lua APIs or `dan200.computercraft` packages as part of an unrelated change.

Before proposing a new subsystem, check the [roadmap]. Features assigned to later milestones need an approved design
issue before implementation so foundational APIs are not improvised out of order.

## Tests

- Core and CraftOS tests: `./gradlew :core:test`
- General checks: `./gradlew check`
- Forge game tests: `./gradlew :forge:runGametest`
- Data generation after model, recipe or language-provider changes: `./gradlew runData`

Visual changes should include clear before-and-after screenshots. Compatibility changes should state their effect on old
worlds, Lua programs and addon mods.

## Documentation

Build the documentation with:

```shell
./gradlew docWebsite
```

The generated site is written to `projects/web/build/site/`. Documentation uses [illuaminate] and Markdown.

## AI-assisted contributions

AI-assisted work is permitted, but the contributor remains fully responsible for every submitted line. Pull requests
must disclose substantial generative-AI use and must be manually reviewed, tested and checked for licensing or provenance
problems. Unverified bulk-generated code will be rejected.

## Licensing

Preserve every inherited SPDX copyright and license line. Add new copyright notices only for original contributions.
Binary assets need appropriate `.license` sidecars or `REUSE.toml` annotations. See [LICENSING.md].

[issue templates]: https://github.com/Vynzaro/CC-Rewired/issues/new/choose
[the architecture document]: RW-DOCS/ARCHITECTURE.md
[roadmap]: RW-DOCS/ROADMAP.md
[illuaminate]: https://github.com/SquidDev/illuaminate/
[LICENSING.md]: LICENSING.md
