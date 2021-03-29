#!/bin/bash

CODEGEN_FILE=swagger-codegen-cli.jar

if [ ! -f "$CODEGEN_FILE" ]; then
  wget https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/3.0.25/swagger-codegen-cli-3.0.25.jar -O swagger-codegen-cli.jar
fi

java -jar $CODEGEN_FILE generate -i ./restaurant-api.yaml \
  -o code-generated \
  -l spring \
  --api-package com.vcompany.restaurant.api.controller \
  --model-package com.vcompany.restaurant.api.model \
  --group-id vcompany-api \
  --artifact-id restaurant-api \
  -D hideGenerationTimestamp=true \
  -Djava8=true