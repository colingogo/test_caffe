#!/usr/bin/env sh

TOOLS=../../build/tools

GLOG_logtostderr=1 
$TOOLS/test_net.bin lenet_test.prototxt lenet_iter_2000 2000 CPU
