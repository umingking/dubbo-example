#!/bin/bash
echo -----------------------------------------------------------------------------
echo 开始编译打包开发环境的包
echo -----------------------------------------------------------------------------
mvn  package -Dmaven.test.skip=true -Pdev
read -n 1