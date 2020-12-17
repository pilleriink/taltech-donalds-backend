FROM openjdk:11-slim

RUN set -eux; \
    mkdir -p /opt/taltech-donald

WORKDIR /opt/taltech-donald/

COPY build/libs/taltech-donald.jar .
COPY docker-entrypoint.sh .
RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["/opt/taltech-donald/docker-entrypoint.sh"]

EXPOSE 8080
