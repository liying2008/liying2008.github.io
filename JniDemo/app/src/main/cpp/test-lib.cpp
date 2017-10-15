#include <jni.h>
#include <string>

extern "C"
jstring
Java_cc_duduhuo_jnidemo_MainActivity_getTextFromCpp(
        JNIEnv* env,
        jobject /* this */) {
    std::string text = "Text From C++";
    return env->NewStringUTF(text.c_str());
}

