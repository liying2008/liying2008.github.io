group = "cc.duduhuo.multi-module"
version = "1.0.0"

allprojects {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        mavenCentral()
    }
}

tasks.register<Delete>("cleanAll") {
    delete(rootProject.buildDir)
    subprojects {
        delete("out")
    }
}
