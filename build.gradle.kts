import com.google.common.base.CaseFormat
import java.text.SimpleDateFormat
import java.util.Date

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.kotlinParcelize) apply false
    alias(libs.plugins.googleService) apply false
    alias(libs.plugins.ksp) apply false
}


task("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

val appVersionCode by extra(2009)
val appVersionName by extra("2.0.9")


task("backup", Zip::class) {
    dependsOn("clean")
    from(projectDir)
    val folders = listOf(
        ".git/**", ".gradle/**", ".idea/**", "build/**", "app/release/**", "app/build/**", "app/src/androidTest/**", "app/src/test/**"
    )
    excludes.addAll(folders)
    val date = Date()
    val sdf = SimpleDateFormat("yyyy.MM.dd_HH.mm")
    val time = sdf.format(date)
    val projectName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, rootProject.name)
    archiveFileName.set(projectName + "_" + time + "_v" + appVersionName + ".zip")
    destinationDirectory.set(file("../"))
}