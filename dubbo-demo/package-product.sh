#!/bin/bash
echo -----------------------------------------------------------------------------
echo ��ʼ����������İ�
echo -----------------------------------------------------------------------------
mvn  package -Dmaven.test.skip=true -Pproduct
read -n 1
