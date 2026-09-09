<!--
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

# CC: Rewired versioning policy

This document defines how CC: Rewired versions are numbered, named and published. The
[`ROADMAP.md`](ROADMAP.md) assigns capabilities to release lines; this document defines what the numbers mean.

## Source of truth

The version declared as `modVersion` in [`gradle.properties`](../gradle.properties) is the version embedded in builds.
The other release records must agree with it:

- [`CHANGELOG.md`](../CHANGELOG.md) records released behaviour and compatibility changes.
- [`ROADMAP.md`](ROADMAP.md) records planned scope and exit gates.
- A Git tag identifies the exact immutable source revision used for a published release.
- Modrinth, CurseForge and GitHub release entries must use the same version and artifacts.

Changing a roadmap table does not change the software version. Changing `gradle.properties` without the corresponding
changelog and release work does not create a release.

## Development version format

Before 1.0, versions use this format:

```text
0.<release-line>.<iteration>[-<channel>.<sequence>]
```

| Part | Meaning before 1.0 | Example |
| --- | --- | --- |
| `0` | The public platform and compatibility contracts are not stable yet | `0.1.4` |
| `release-line` | The capability line in the roadmap | `1` for the visual foundation |
| `iteration` | A sequential public checkpoint inside that line | `4` for the fifth `0.1.x` checkpoint |
| `channel` | Optional stability qualifier | `alpha`, `beta` or `rc` |
| `sequence` | Revision of that prerelease candidate | `2` in `0.1.4-beta.2` |

`0.1.x` and `0.1.XX` are planning notation only. Actual releases use a number such as `0.1.3`; they never contain `x`
and never use leading zeroes such as `0.1.03`.

The third component may contain planned additions as well as fixes while the project is in `0.x`. This is an explicit
pre-1.0 project convention, not a claim of strict Semantic Versioning. Starting with `1.0.0`, CC: Rewired will use
normal `MAJOR.MINOR.PATCH` Semantic Versioning for its documented public APIs and compatibility contracts.

## Release channels

| Form | Use | Intended audience |
| --- | --- | --- |
| `0.1.2-alpha.1` | Incomplete implementation, missing migration work or known major defects | Contributors and testers |
| `0.1.2-beta.1` | Planned scope complete, but broader compatibility and gameplay testing remain | Testers and modpack authors |
| `0.1.2-rc.1` | Optional final candidate; only release-blocking fixes are accepted | Release validation |
| `0.1.2` | Supported public checkpoint for that development line | Normal users willing to use pre-1.0 software |

A whole release line must not be labelled alpha by default. A prerelease suffix is used only when the individual build
is not ready to be the next public checkpoint. A version without a suffix is still pre-1.0 and does not promise stable
APIs beyond the compatibility commitments documented for that release.

The current publishing scripts map `isUnstable=true` to a GitHub prerelease and a Modrinth alpha. Before publishing the
first beta, the scripts must be extended to represent `alpha`, `beta` and `release` separately. Until then, beta or
release-candidate versions must not be published with incorrect channel metadata.

## Increment rules before 1.0

- Increment the iteration for each published checkpoint in the active release line: `0.1.2` → `0.1.3`.
- Start the next roadmap line at iteration zero: `0.1.8` → `0.2.0`.
- Restart a prerelease sequence when the target version or channel changes: `0.1.3-alpha.2` → `0.1.3-beta.1`.
- Do not reuse, replace or silently rebuild a published version. Publish a new iteration instead.
- Record every user-visible change, migration requirement and intentional incompatibility in `CHANGELOG.md`.
- Move unfinished work to a later iteration instead of weakening the current release gate.

The roadmap may merge, split or reorder unreleased iterations. Already published numbers and Git tags are permanent.

## Minecraft version and release tags

The Minecraft target is distribution metadata, not part of `modVersion`. The existing build uses the following Git tag
format to distinguish artifacts targeting different Minecraft versions:

```text
v<minecraft-version>-<mod-version>
```

Examples:

```text
v1.20.1-0.1.0-alpha.1
v1.20.1-0.1.0
v1.20.1-0.1.4
```

A port which changes only the supported Minecraft version may share a CC: Rewired version only when its behaviour and
public contracts are equivalent. Loader support is declared in release metadata and the compatibility matrix rather
than encoded into `modVersion`.

## Stability at and after 1.0

`1.0.0` requires the exit gate in the roadmap. After that release:

- `MAJOR` changes for incompatible public API or documented compatibility changes.
- `MINOR` changes for backwards-compatible functionality.
- `PATCH` changes for backwards-compatible fixes.
- Prerelease channels retain the same `alpha.N`, `beta.N` and `rc.N` syntax.

World formats, Lua APIs, Java APIs, network protocols and addon contracts may have their own protocol or schema
versions. They must not infer compatibility solely from the mod's display version.
