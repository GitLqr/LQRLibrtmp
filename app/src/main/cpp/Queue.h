//
// Created by lqr on 19-10-16.
//

#ifndef LQRLIBRTMP_QUEUE_H
#define LQRLIBRTMP_QUEUE_H

#include <queue>
#include <pthread.h>
#include "AndroidLog.h"

extern "C" {
#include "librtmp/rtmp.h"
};

class Queue {
public:
    std::queue<RTMPPacket *> queuePacket;
    pthread_mutex_t mutexPacket;
    pthread_cond_t condPacket;

public:
    Queue();

    ~Queue();

    int putRtmpPacket(RTMPPacket *packet);

    RTMPPacket *getRtmpPacket();

    void clean();

    void notifyQueue();
};

#endif //LQRLIBRTMP_QUEUE_H
