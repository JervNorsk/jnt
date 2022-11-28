rootProject.apply {
    name = "jnt"
}

includeBuild("Game/SecondLife") {
    name = "jnt-secondlife"
}

includeBuild("Lib/cli") {
    name = "jnt-cli"
}
