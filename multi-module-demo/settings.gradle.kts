pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
rootProject.name = "multi-module-demo"
include("module-main", "module-1", "module-2", "module-3")

