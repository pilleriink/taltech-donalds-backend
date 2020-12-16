FROM openjdk:11-slim

RUN set -eux; \
    mkdir -p /opt/taltech-donald

WORKDIR /opt/taltech-donald/

COPY ./build/libs/taltech-donald.jar .
COPY ./docker-entrypoint.sh .
RUN chmod +x docker-entrypoint.sh
RUN apt-get install -y locales
RUN locale-gen en_US.UTF-8
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en' LC_ALL='en_US.UTF-8'

ENTRYPOINT ["/opt/taltech-donald/docker-entrypoint.sh"]

EXPOSE 8080
