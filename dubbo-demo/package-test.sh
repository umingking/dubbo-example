#!/bin/bash
echo -----------------------------------------------------------------------------
echo 开始编译打包测试环境的包
echo -----------------------------------------------------------------------------
mvn  package -Dmaven.test.skip=true -Ptest
read -n 1