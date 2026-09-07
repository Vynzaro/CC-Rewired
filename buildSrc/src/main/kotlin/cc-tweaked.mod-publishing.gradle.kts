// SPDX-FileCopyrightText: 2023 The CC: Tweaked Developers
// SPDX-FileCopyrightText: 2026 Vynzaro
//
// SPDX-License-Identifier: MPL-2.0

import cc.tweaked.gradle.setProvider

plugins {
    id("com.modrinth.minotaur")
    id("cc-tweaked.publishing")
}

abstract class ModPublishingExtension {
    abstract val output: Property<AbstractArchiveTask>

    init {
        output.finalizeValueOnRead()
    }
}

val modPublishing = project.extensions.create("modPublishing", ModPublishingExtension::class.java)

val isUnstable = extra["isUnstable"] == "true"
val modVersion = extra["modVersion"] as String
val mcVersion = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
    .findVersion("minecraft").get().toString()

modrinth {
    token = findProperty("modrinthApiKey") as String? ?: ""
    projectId = "cc-rewired"
    versionNumber = modVersion
    versionName = modVersion
    versionType = if (isUnstable) "alpha" else "release"
    uploadFile.setProvider(modPublishing.output)
    gameVersions.add(mcVersion)
    changelog = "Release notes can be found on the [GitHub repository](https://github.com/Vynzaro/CC-Rewired/releases/tag/v$mcVersion-$modVersion)."

    syncBodyFrom = provider { rootProject.file("doc/mod-page.md").readText() }
}

tasks.publish { dependsOn(tasks.modrinth) }
