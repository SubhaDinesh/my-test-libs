NEXUS_URL="http://13.233.143.178:8081"
REPOSITORY="my-test-release"
GROUP_ID="in.javahome"
ARTIFACT_ID="my-test"
VERSION="1.1"
USERNAME="admin"
PASSWORD="Mitakshi21"
METADATA=$(curl -s -u admin/Mitakshi21 "${NEXUS_URL}/service/rest/v1/search/assets?repository=${REPOSITORY}&group=${GROUP_ID}&name=${ARTIFACT_ID}&version=${VERSION}")
echo $METADATA
DOWNLOAD_URL=$(echo "${METADATA}" | jq -r '.items[0].downloadUrl')
curl -u "${USERNAME}:${PASSWORD}" -O "${DOWNLOAD_URL}"
