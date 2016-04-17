~~~
    GET     /api/topic/{id} (com.pods.resources.TopicResources)
    GET     /api/topics (com.pods.resources.TopicResources)
    POST    /api/topics/create (com.pods.resources.TopicResources)

    GET     /api/node/{id} (com.pods.resources.NodeResources)
    GET     /api/nodes/bytopic/{topic_id} (com.pods.resources.NodeResources)
    POST    /api/nodes/create (com.pods.resources.NodeResources)

    GET     /api/resource/{resource_id} (com.pods.resources.ResourceResources)
    GET     /api/resources/bynode/{node_id} (com.pods.resources.ResourceResources)
    POST    /api/resources/create (com.pods.resources.ResourceResources)
~~~

~~~
{
}
curl -H "Content-Type: application/json" -d @create_topic.json 'http://www.pathwaysofdiscovery.online/api/topic/'
~~~

~~~
curl -H "Content-Type: application/json" 'http://www.pathwaysofdiscovery.online/api/topics/'
curl -H "Content-Type: application/json" 'http://www.pathwaysofdiscovery.online/api/topics/'

~~~




