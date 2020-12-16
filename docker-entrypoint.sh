#!/usr/bin/sh

set -Eeo pipefail

WORKDIR=/opt/taltech-donald/

cd $WORKDIR

/usr/bin/env java -jar taltech-donald.jar
