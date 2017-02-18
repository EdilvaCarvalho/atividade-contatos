FROM payara/server-web
MAINTAINER Edilva <edilva.intin@gmail.com>
ENV DOMAIN domain1
ENV LIB /opt/payara41/glassfish/domains/${DOMAIN}/lib/
ENV DEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
ADD target/atividade-avaliativa-contatos-1.0/WEB-INF/lib/ ${LIB}
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
ADD target/atividade-avaliativa-contatos-1.0.war  ${DEPLOY}
