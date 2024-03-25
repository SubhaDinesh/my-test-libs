# Set variables
NEXUS_URL="http://13.233.143.178:8081"
REPOSITORY="my-test-release"
GROUP_ID="in.javahome"
ARTIFACT_ID="my-test"
VERSION="1.1"
USERNAME="admin"
PASSWORD="Mitakshi21"

# Retrieve artifact metadata
METADATA=$(curl -s -u "${USERNAME}:${PASSWORD}" "${NEXUS_URL}/service/rest/v1/search/assets?repository=${REPOSITORY}&group=${GROUP_ID}&name=${ARTIFACT_ID}&version=${VERSION}")
echo $METADATA
# Extract the download URL from the metadata
DOWNLOAD_URL=$(echo "${METADATA}" | jq -r '.items[0].downloadUrl')

# Download the artifact
curl -u "${USERNAME}:${PASSWORD}" -O "${DOWNLOAD_URL}"
