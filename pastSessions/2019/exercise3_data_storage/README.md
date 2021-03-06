# Exercise 3: Data Storage

In this exercise you will store real-time messages on Elastic Search from Flink

![Exercise architecture](../img/architecture_exercise3.png)

## Setup

Download Elastic and Kibana:

* **Elastic**: https://www.elastic.co/es/downloads/elasticsearch
* **Kibana**: https://www.elastic.co/es/downloads/kibana

Unzip and launch it:

* Launch Elastic on Elastic installation folder:
```
bin\elasticsearch
```

* Launch kibana on kibana installation folder:
```
bin\kibana
```

## Development

* Access to Kibana (http://localhost:5601)
* Go to Dev Tools and execute the following query and Create mapping for latestUpdate field
```
PUT quotes
{
  "mappings": {
    "properties": {
      "latestUpdate": {
        "type": "date" 
      }
    }
  }
}
```
* Evolve the code used on exercise 2 to persist processing output on elasticsearch. 
* Replace kafka sink with Elastic Sink on Stock pipeline on `src/main/java/com/gft/upv/flink/StreaminStockJob.java`
* Implement document storage using Elastic Sinkc connector `src/main/java/com/gft/upv/flink/proccess/ExtendedElasticSink.java` (Follow instructions on https://ci.apache.org/projects/flink/flink-docs-stable/dev/connectors/elasticsearch.html using Java Elastic Search 6.x example )
* Launch `StreamingStokJob` on the IDE, (provide the topic parameter)
* Access to Kibana (http://localhost:5601)
* Go to Management --> Kibana --> Index Patterns.
* Create quotes (quotes*) pattern.
* Go to Dev Tools and execute the following query and you will get quotes indexed:

```
GET quotes/_search
{
  "size": 10

}
```

* Create a mapping for twitter index:
```
PUT tweets
{
  "mappings": {
    "properties": {
      "text": {
        "type": "text",
        "analyzer": "english",
        "fielddata": true,
        "fields": {
          "keyword": {
            "type": "keyword"
          }
        }
      }
    }
  }
}
```

* Launch `src/main/java/com/gft/upv/flink/TwitterStockJob.java` (pass twitter topic as argument)
* Go to Management --> Kibana --> Index Patterns
* Create twitter (tweets*) pattern
* Go to Dev Tools and execute following query and you will get quotes indexed:
```
GET tweets/_search
{
  "size": 10

}
```

In case you need help, you can check ElasticSink API here --> https://ci.apache.org/projects/flink/flink-docs-stable/dev/connectors/elasticsearch.html
