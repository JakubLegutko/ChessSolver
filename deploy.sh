#!/bin/bash

COMPRESED_FILE='vim.tgz'
USER='legutko_1196904'

tar -zcvf ${COMPRESED_FILE} *
scp -i ~/.ssh/id_rsa ${COMPRESED_FILE} ${USER}@spk-ssh.if.uj.edu.pl:/home/${USER}
ssh -i ~/.ssh/id_rsa ${USER}@spk-ssh.if.uj.edu.pl "java -jar /scratch/uforamus/ChessTestClient/client.jar 172.30.24.15 $COMPRESED_FILE"
