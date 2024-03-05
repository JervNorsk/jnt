rootProject.projectDir
    .listFiles()
    ?.filter { it -> it.isDirectory }
    ?.filter { it -> it.name.equals("integrations") }
    ?.forEach {
        it.listFiles()
            ?.forEach { file ->
                includeBuild(file) {
                    name = "${rootProject.name}-${name}"
                }
            }
    }
