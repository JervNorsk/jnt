rootProject.apply {
    name = "jnt"

    // ------------------------------------------------------------------------
    // Services
    // ------------------------------------------------------------------------
    projectDir
        .listFiles()
        ?.filter { it -> it.isDirectory }
        ?.filter { it -> it.name in arrayOf("services") }
        ?.forEach {
            it.listFiles()
                ?.forEach { file ->
                    includeBuild(file)
                }
        }

    // ------------------------------------------------------------------------
    // Integrations
    // ------------------------------------------------------------------------
    projectDir
        .listFiles()
        ?.filter { it -> it.isDirectory }
        ?.filter { it -> it.name in arrayOf("integrations") }
        ?.forEach {
            it.listFiles()
                ?.forEach { file ->
//                    includeBuild(file) {
//                        name = "${rootProject.name}-${name}"
//                    }
                }
        }
}
