FROM openjdk:11-slim

RUN set -eux; \
    mkdir -p /opt/taltech-donald

WORKDIR /opt/taltech-donald/

COPY backend/build/libs/taltech-donald.jar .
COPY backend/docker-entrypoint.sh .
RUN chmod +x docker-entrypoint.sh

ENTRYPOINT ["/opt/taltech-donald/docker-entrypoint.sh"]

EXPOSE 8080
