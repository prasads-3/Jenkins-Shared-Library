#!/bin/bash

FILES=(
  owasp_dependency
  sonarqube_analysis
  sonarqube_code_quality
  docker_build
  docker_push
)

for file in "${FILES[@]}"
do
cat > vars/${file}.groovy <<EOF
def call() {
    echo "${file}() called"
}
EOF

echo "Created vars/${file}.groovy"
done
