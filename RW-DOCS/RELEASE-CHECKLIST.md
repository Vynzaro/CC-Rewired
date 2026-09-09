<!--
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

# CC: Rewired release checklist

Use this checklist for every published development or stable release. Version meanings are defined in
[`VERSIONING.md`](VERSIONING.md); feature scope and exit gates are defined in [`ROADMAP.md`](ROADMAP.md).

## 1. Freeze the candidate

- [ ] Select one target version and release channel.
- [ ] Confirm that every included issue belongs to the target roadmap iteration.
- [ ] Move unfinished work to a later iteration instead of silently expanding or weakening the release.
- [ ] Stop accepting unrelated changes into the candidate.
- [ ] Confirm the supported Minecraft version and loaders.

## 2. Review compatibility and provenance

- [ ] Document changes to worlds, registries, Lua APIs, Java APIs, configuration, peripherals and network protocols.
- [ ] Confirm that migrations and rollback limitations are documented and tested.
- [ ] Review new code and assets for licence compatibility and correct SPDX information.
- [ ] Preserve inherited ComputerCraft and CC: Tweaked notices where their work remains.
- [ ] Confirm that AI-assisted material has been reviewed and disclosed where required by the distribution platform.

## 3. Prepare versioned files

- [ ] Set `modVersion` in [`gradle.properties`](../gradle.properties).
- [ ] Set `isUnstable` consistently with the publishing channel.
- [ ] Add or finalise the matching section in [`CHANGELOG.md`](../CHANGELOG.md).
- [ ] Update the in-game `whatsnew.md` summary when player-visible behaviour changes.
- [ ] Update the in-game inherited changelog only when its scope and attribution remain clear.
- [ ] Update screenshots, mod-page text, compatibility notes and documentation when they changed.
- [ ] Search the repository for the previous version and review every remaining occurrence.

The current automation supports only `alpha` or `release` publication metadata. Do not label a build beta or release
candidate until the publishing scripts support that channel correctly.

## 4. Validate the candidate

Run the same essential checks as continuous integration:

```shell
./gradlew assemble
pipx run pre-commit run --show-diff-on-failure --color=always --all-files
./gradlew check -x runGametest
./gradlew downloadAssets
./gradlew runGametest
./gradlew docWebsite --no-daemon
```

- [ ] All required GitHub Actions jobs pass on the candidate commit.
- [ ] Forge 1.20.1 starts with the generated release JAR, not only from the development environment.
- [ ] A new world and a representative inherited CC: Tweaked world load successfully.
- [ ] Existing computers, turtles, monitors, peripherals and representative Lua programs pass smoke tests.
- [ ] Client/server connection behaviour is tested when protocol-facing code changed.
- [ ] Visual releases include in-game comparison screenshots at normal Minecraft scale.
- [ ] No generated file, report or local secret is included in the commit or artifacts.

If a required external Maven repository is unavailable, the release is blocked. A cached local build is not enough to
prove that contributors and CI can reproduce the candidate.

## 5. Publish once

- [ ] Merge or fast-forward the exact reviewed candidate commit into the release branch.
- [ ] Create the immutable tag `v<minecraft-version>-<mod-version>` on that commit.
- [ ] Build all distributed JARs from the tagged commit.
- [ ] Publish the same artifacts and release notes to GitHub, Modrinth and CurseForge as applicable.
- [ ] Verify filenames, hashes, Minecraft versions, loaders, dependency metadata and release channel after upload.
- [ ] Do not replace a published JAR silently; increment the version for every correction.

## 6. Close and monitor

- [ ] Replace `Unreleased` with the actual `YYYY-MM-DD` date in `CHANGELOG.md`.
- [ ] Add the comparison link for the released version.
- [ ] Mark completed roadmap issues and move remaining issues forward.
- [ ] Announce known limitations without presenting roadmap items as implemented features.
- [ ] Monitor crash reports, installation failures and migration problems.
- [ ] If a release is unsafe, mark it clearly and publish a corrected version; do not erase its history.

## Release decision

A release proceeds only when every required exit gate and validation item passes. Documentation, provenance,
compatibility and reproducibility are release requirements, not cleanup work deferred until afterward.
