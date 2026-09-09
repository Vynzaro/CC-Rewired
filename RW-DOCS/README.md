<!--
SPDX-FileCopyrightText: 2026 Vynzaro

SPDX-License-Identifier: MPL-2.0
-->

# CC: Rewired project documents

This directory contains CC: Rewired-specific planning and engineering documents which are useful to contributors but
are not required at the repository root.

## Current documents

- [Roadmap](ROADMAP.md): ordered release lines, scope, acceptance gates and deferred research.
- [Versioning policy](VERSIONING.md): numbering rules, prerelease channels and Git tag format.
- [Release checklist](RELEASE-CHECKLIST.md): required preparation, validation and publication steps.
- [Architecture](ARCHITECTURE.md): inherited module layout, loader boundaries and testing architecture.

## Repository documentation policy

The following files remain at the repository root because hosting platforms, legal tooling and contributors expect
them there:

- `README.md`
- `CHANGELOG.md`
- `CONTRIBUTING.md`
- `CODE_OF_CONDUCT.md`
- `LICENSING.md`
- `LICENSES/`

Build-coupled website and distribution material remains in `doc/`. It must not be moved without also updating the
Gradle publishing and documentation configuration.

Future design specifications should normally be added here. Likely documents include a visual design guide, device-bus
contract, network protocol specification, power model and compatibility matrix. A specification should only be created
when its subsystem is close enough to implementation for its decisions to be testable.
