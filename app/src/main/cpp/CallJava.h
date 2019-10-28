//
// Created by lqr on 19-10-16.
//

#ifndef LQRLIBRTMP_CALLJAVA_H
#define LQRLIBRTMP_CALLJAVA_H

#include <jni.h>
#include <stdlib.h>

#define THREAD_MAIN 1
#define THREAD_CHILD 2

class CallJava {
public:
    JNIEnv *jniEnv = NULL;
    JavaVM *javaVM = NULL;
    jobject jobj;
    jmethodID jmid_conn;
    jmethodID jmid_conns;
    jmethodID jmid_connf;

public:
    CallJava(JNIEnv *jniEnv, JavaVM *javaVM, const jobject *jobj);

    ~CallJava();

    void conn(int type);

    void conns(int type);

    void connf(int type, char *msg);
};

#endif //LQRLIBRTMP_CALLJAVA_H
