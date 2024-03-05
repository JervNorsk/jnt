with(rootProject) {
    name = "jnt"
    with(projectDir) {
        listFiles()
            ?.filter { it -> it.isDirectory }
            ?.filter { it -> it.name.matches("integrations|services".toRegex()) }
            ?.forEach {
                it.listFiles()
                    ?.forEach { file ->
                        includeBuild(file) {
                            name = "${rootProject.name}-${name}"
                        }
                    }
            }
    }
}
