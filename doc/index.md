<!--
SPDX-FileCopyrightText: 2020 The CC: Tweaked Developers
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

<h1>
    <picture>
        <source media="(prefers-color-scheme: dark)" srcset="logo-darkmode.png">
        <source media="(prefers-color-scheme: light)" srcset="logo.png">
        <img alt="CC: Rewired" src="logo.png">
    </picture>
</h1>

CC: Rewired is an independent fork of [CC: Tweaked], itself based on the original [ComputerCraft]. It provides
programmable computers, turtles and peripherals powered by Lua, while developing a modern visual and interaction model
for current Minecraft.

> [!WARNING]
> CC: Rewired is in early alpha development. The current release line establishes the project's identity and visual
> foundation; many planned modern systems are not implemented yet.

## Current platform

The first supported target is **Minecraft 1.20.1 with Forge 47**. The inherited Fabric module remains available for
compatibility testing but is not the primary target for the first releases.

Published builds are available from [Modrinth] and [CurseForge]. Development builds are produced by [GitHub Actions].

## What works today

CC: Rewired retains the proven ComputerCraft feature set inherited from CC: Tweaked:

- Computers and pocket computers programmable in Lua.
- Turtles capable of mining, crafting and world automation.
- Monitors, printers, speakers, disk drives and wired or wireless modems.
- Peripheral access to inventories and compatible modded blocks.
- HTTP, WebSocket, filesystem, shell and networking APIs.

## Direction

The project will modernise these systems in controlled stages: interface and block presentation first, followed by a
new user experience and, after separate design work, modern networking, power and peripheral infrastructure. Planned
features are not advertised as released features until they exist in a tested build.

## Compatibility

CC: Rewired keeps the `computercraft` mod ID, resource namespace, Java API packages and Lua APIs. Existing worlds,
programs and addon mods should therefore remain compatible wherever the fork has not documented a deliberate change.
CC: Rewired and CC: Tweaked cannot be installed together.

## Getting started

The API reference in this site documents the code included in the current build. Existing ComputerCraft and CC: Tweaked
tutorials remain useful because the first CC: Rewired versions preserve their programming model.

## Project and support

- [Source code]
- [Issue tracker]
- [Contributing guide]
- [Licensing and attribution]

CC: Rewired is maintained by Vynzaro and is not affiliated with or endorsed by the CC: Tweaked developers.

[CC: Tweaked]: https://github.com/cc-tweaked/CC-Tweaked
[ComputerCraft]: https://github.com/dan200/ComputerCraft
[Modrinth]: https://modrinth.com/project/cc-rewired
[CurseForge]: https://www.curseforge.com/minecraft/mc-mods/cc-rewired
[GitHub Actions]: https://github.com/Vynzaro/CC-Rewired/actions
[Source code]: https://github.com/Vynzaro/CC-Rewired
[Issue tracker]: https://github.com/Vynzaro/CC-Rewired/issues
[Contributing guide]: https://github.com/Vynzaro/CC-Rewired/blob/mb-1.20.x/CONTRIBUTING.md
[Licensing and attribution]: https://github.com/Vynzaro/CC-Rewired/blob/mb-1.20.x/LICENSING.md
