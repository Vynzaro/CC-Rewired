<!--
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

# Changelog

All notable changes made specifically in CC: Rewired are documented in this file. The inherited CC: Tweaked version
history remains available in the [in-game changelog](projects/core/src/main/resources/data/computercraft/lua/rom/help/changelog.md).

The structure of this file is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/). Dates use the
`YYYY-MM-DD` format.

## Fork baseline

| Field | Value |
| --- | --- |
| Upstream project | [CC: Tweaked](https://github.com/cc-tweaked/CC-Tweaked) |
| Minecraft version | `1.20.1` |
| Upstream branch | [`mc-1.20.x`](https://github.com/cc-tweaked/CC-Tweaked/tree/mc-1.20.x) |
| Declared upstream version | `1.120.2` |
| Published upstream release | [`v1.20.1-1.120.2`](https://github.com/cc-tweaked/CC-Tweaked/releases/tag/v1.20.1-1.120.2), commit [`c3cfb20`](https://github.com/cc-tweaked/CC-Tweaked/commit/c3cfb206de28769c81ee45a44ad9fcf741cc7091) |
| Exact fork point | Commit [`358a6e6`](https://github.com/cc-tweaked/CC-Tweaked/commit/358a6e6263decab39856e6ad7f2ff5cdbf5e5ac2), dated 2026-08-28 |
| First fork-specific commit | Commit [`e9d1720`](https://github.com/Vynzaro/CC-Rewired/commit/e9d1720f6cf85b0ededb48159e280d69d7939745), dated 2026-09-07 |

The exact fork point still declared version `1.120.2`, but it was eight upstream commits ahead of the published
`1.120.2` tag. Consequently, CC: Rewired also inherited the [post-release CC: Tweaked changes][upstream-delta]
committed between 2026-08-08 and 2026-08-28.

## [0.1.0-alpha.1] - Unreleased

This initial development version establishes CC: Rewired as an independent fork for Minecraft 1.20.1. It focuses on
project identity, distribution metadata, documentation and build reliability. It does not yet contain the planned
interface, networking, peripheral, power-system or model redesigns.

### Added

- Added original CC: Rewired light and dark logos, a 16×16 icon source and an updated resource-pack icon.
- Added `LICENSING.md` to explain the ComputerCraft → CC: Tweaked → CC: Rewired lineage and file-level licensing.
- Added CC: Rewired-specific bug, feature, pull-request and general issue guidance.
- Added manually triggered verification builds through GitHub Actions.
- Added `RW-DOCS/` with a documentation index and gated version roadmap covering the visual, CraftOS, device, power,
  networking, server, industrial, robotics and optional integration plans.

### Changed

- Renamed the project, distributions, JAR manifests, documentation site and visible in-game branding to CC: Rewired.
- Changed the development version from CC: Tweaked `1.120.2` to CC: Rewired `0.1.0-alpha.1` and marked it unstable.
- Changed newly published Java artifacts to the `io.github.vynzaro` group and `cc-rewired-*` archive names.
- Pointed Forge, Fabric, Maven, Modrinth and GitHub release metadata to the CC: Rewired project and maintainer.
- Replaced CC: Tweaked update metadata so CC: Rewired installations are not offered upstream releases as updates.
- Updated the CraftOS host string, MOTD, credits, standalone emulator title, debug labels and translated creative-tab
  name to identify CC: Rewired.
- Reworked the README, contribution guide, code of conduct, architecture notes, mod pages and API documentation around
  the new project's scope and attribution requirements.
- Moved the contributor architecture guide from `projects/ARCHITECTURE.md` to `RW-DOCS/ARCHITECTURE.md` and updated its
  references.
- Preserved upstream creators and contributors in project lineage and in-game credits instead of presenting them as
  current CC: Rewired maintainers.

### Fixed

- Added Parchment's public Artifactory repository as an alternative mapping source and redirected the exclusive
  `vanilla-extract` repository to it, preventing builds from depending solely on an unavailable canonical endpoint.

### Compatibility

- Retained the `computercraft` mod ID, resource namespace, public Java package names, Lua APIs and world identifiers.
- Retained the inherited Forge and Fabric targets for Minecraft 1.20.1.
- No intentional gameplay or scripting behaviour changes are included in this version.

[0.1.0-alpha.1]: https://github.com/Vynzaro/CC-Rewired/compare/358a6e6263decab39856e6ad7f2ff5cdbf5e5ac2...mb-1.20.x
[upstream-delta]: https://github.com/cc-tweaked/CC-Tweaked/compare/v1.20.1-1.120.2...358a6e6263decab39856e6ad7f2ff5cdbf5e5ac2
