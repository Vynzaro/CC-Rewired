<!--
SPDX-FileCopyrightText: 2017 The CC: Tweaked Developers
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

<p align="left">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="doc/logo-darkmode.png">
    <source media="(prefers-color-scheme: light)" srcset="doc/logo.png">
    <img alt="CC: Rewired" src="doc/logo.png" width="413" height="64">
  </picture>
</p>

> ComputerCraft, rewired for modern Minecraft.

---

> [!WARNING]
> CC: Rewired is in early alpha development. Expect incomplete visual changes, compatibility work and breaking changes
> between development releases.

CC: Rewired (CC:RW) is an independent fork of [CC: Tweaked], itself a fork of the original [ComputerCraft]. It keeps the
programmable computers, turtles, peripherals and Lua ecosystem while rebuilding the mod around the visual language,
user experience and technology of modern Minecraft.

CC: Rewired is maintained by **Vynzaro** and is not affiliated with or endorsed by the CC: Tweaked developers.

## Current scope

- Primary target: **Minecraft 1.20.1 with Forge 47**.
- Current milestone: project identity, interface and visual foundation.
- The inherited Fabric build remains in the repository for compatibility testing, but Forge is the supported development
  target for the first releases.
- Networking, power, modern cables and new peripheral systems are planned work, not current features.

## Compatibility policy

CC: Rewired currently retains the `computercraft` mod ID, resource namespace, Java API packages and Lua APIs. This makes
it a drop-in replacement for CC: Tweaked where practical and means the two mods must not be installed together.

Internal compatibility identifiers are deliberately different from the public CC: Rewired brand. They will only change
if a tested migration path exists for worlds, programs and addon mods.

## Downloads

- [Modrinth]
- [CurseForge]
- [Source code and development builds][GitHub]

Only install files published through these project pages or produced by this repository's GitHub Actions workflow.

## Roadmap and engineering documents

Development is divided into gated release lines instead of implementing every planned system at once. Read the
[version roadmap] for the current milestone, future CraftOS, device, power, networking, server, robotics and integration
work. The inherited module layout and loader boundaries are described in [architecture].

## Building from source

The build currently requires JDK 25 and emits Java 17-compatible bytecode for Minecraft 1.20.1.

```shell
git clone https://github.com/Vynzaro/CC-Rewired.git
cd CC-Rewired
./gradlew assemble
```

On Windows PowerShell, use `.\gradlew.bat assemble`. The Forge JAR is written to `projects/forge/build/libs/`.

## Contributing

Issues, design proposals, documentation and code contributions are welcome. Read [CONTRIBUTING.md] before opening a pull
request. The initial roadmap is intentionally narrow: establish a stable identity and development baseline before adding
new infrastructure systems.

## Attribution and licensing

CC: Rewired contains substantial inherited work from ComputerCraft and CC: Tweaked. Their copyright notices and project
history are preserved. Licensing is recorded per file through SPDX metadata; see [LICENSING.md] and [`LICENSES/`].

[CC: Tweaked]: https://github.com/cc-tweaked/CC-Tweaked
[ComputerCraft]: https://github.com/dan200/ComputerCraft
[Modrinth]: https://modrinth.com/project/cc-rewired
[CurseForge]: https://www.curseforge.com/minecraft/mc-mods/cc-rewired
[GitHub]: https://github.com/Vynzaro/CC-Rewired
[CONTRIBUTING.md]: CONTRIBUTING.md
[LICENSING.md]: LICENSING.md
[`LICENSES/`]: LICENSES/
[version roadmap]: RW-DOCS/ROADMAP.md
[architecture]: RW-DOCS/ARCHITECTURE.md
