FROM clojure

RUN echo '{:user {:plugins [[lein-ring "0.9.6"]]}}' > /root/.lein/profiles.clj

COPY . /usr/src/app
WORKDIR /usr/src/app

CMD lein ring server-headless