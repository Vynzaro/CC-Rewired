// SPDX-FileCopyrightText: 2022 The CC: Tweaked Developers
// SPDX-FileCopyrightText: 2026 Vynzaro
//
// SPDX-License-Identifier: MPL-2.0

/** Default configuration for non-modloader-specific Minecraft projects. */

import cc.tweaked.gradle.CCTweakedExtension
import cc.tweaked.gradle.CCTweakedPlugin
import cc.tweaked.gradle.MinecraftConfigurations
import org.gradle.api.artifacts.repositories.MavenArtifactRepository

plugins {
    id("cc-tweaked.java-convention")
    id("cc.tweaked.vanilla-extract")
}

plugins.apply(CCTweakedPlugin::class.java)

// vanilla-extract restricts Parchment to this repository, so redirect it explicitly when the canonical host is down.
repositories.named<MavenArtifactRepository>("Parchment") {
    url = uri("https://ldtteam.jfrog.io/artifactory/parchmentmc-public/")
}

val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

minecraft {
    version(libs.findVersion("minecraft").get().toString())

    mappings {
        parchment(libs.findVersion("parchmentMc").get().toString(), libs.findVersion("parchment").get().toString())
    }

    unpick(libs.findLibrary("yarn").get())
}

dependencies {
    // Depend on error prone annotations to silence a lot of compile warnings.
    compileOnly(libs.findLibrary("errorProne.annotations").get())
}

MinecraftConfigurations.setupBasic(project)

extensions.configure(CCTweakedExtension::class.java) {
    linters(minecraft = true, loader = null)
}
