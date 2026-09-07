// SPDX-FileCopyrightText: 2022 The CC: Tweaked Developers
// SPDX-FileCopyrightText: 2026 Vynzaro
//
// SPDX-License-Identifier: MPL-2.0

plugins {
    `java-library`
    `maven-publish`
}

publishing {
    publications {
        register<MavenPublication>("maven") {
            artifactId = base.archivesName.get()
            from(components["java"])
            suppressAllPomMetadataWarnings()

            pom {
                name = "CC: Rewired"
                description = "A modern reengineering of ComputerCraft for current Minecraft, built from CC: Tweaked."
                url = "https://github.com/Vynzaro/CC-Rewired"

                scm {
                    connection = "scm:git:https://github.com/Vynzaro/CC-Rewired.git"
                    developerConnection = "scm:git:ssh://git@github.com/Vynzaro/CC-Rewired.git"
                    url = "https://github.com/Vynzaro/CC-Rewired"
                }

                issueManagement {
                    system = "github"
                    url = "https://github.com/Vynzaro/CC-Rewired/issues"
                }

                licenses {
                    license {
                        name = "ComputerCraft Public License, Version 1.0"
                        url = "https://github.com/Vynzaro/CC-Rewired/blob/mb-1.20.x/LICENSES/LicenseRef-CCPL.txt"
                        distribution = "repo"
                    }
                    license {
                        name = "Mozilla Public License, Version 2.0"
                        url = "https://github.com/Vynzaro/CC-Rewired/blob/mb-1.20.x/LICENSES/MPL-2.0.txt"
                        distribution = "repo"
                    }
                }
            }
        }
    }
}
