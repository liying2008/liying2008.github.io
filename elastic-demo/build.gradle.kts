group = "cc.duduhuo.elasticdemo"
version = "0.0.1-SNAPSHOT"

allprojects {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        mavenCentral()
    }
}

tasks.register<Delete>("cleanAll") {
    delete(rootProject.buildDir)
    subprojects {
        delete(buildDir)
        delete("out")
    }
}