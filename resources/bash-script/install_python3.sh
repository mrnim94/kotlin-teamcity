#!/bin/sh
apt update -y
apt install software-properties-common
add-apt-repository ppa:deadsnakes/ppa -y
apt update -y
python3 --version