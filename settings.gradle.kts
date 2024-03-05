rootProject.projectDir
    .listFiles()
    ?.filter { it -> it.isDirectory }
    ?.filter { it -> it.name.equals("integrations") }
    ?.filter { it -> it.name.equals("services") }
    ?.forEach {
        it.listFiles()
            ?.forEach { file ->
                includeBuild(file) {
                    name = "${rootProject.name}-${name}"
                }
            }
    }
