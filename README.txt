********************************************************************************
GEOLOCATION DEMO DATASET BULK LOAD
********************************************************************************

Clone this repository

Build and deploy the project into a Liferay Portal

Once the Portal is up and running, open the gogo shell

Execute the "load" command (you can pass a number as a parameter to determine how 
many Journal Articles will be inserted. If you choose to not pass any number, the 
default value will be 10)

* In case the project doesn't build correctly nor the bundle doesn't start 
immediately after deployment, double check the dependencies versions in the
build.gradle file and the versions of the same packages deployed in the Portal

********************************************************************************
DATABASE x ELASTICSEARCH COMPARISON
********************************************************************************

After execute the load command, you can check if everything was indexed
correctly. Just count the number of rows in the JournalArticle table in the DB
and then count the number of documents indexed in the Elasticsearch to see if
they match.

Run the following query to count the number of Journal Articles inserted in the
database of your choice (syntax may differ depending on the database):

SELECT count(*) FROM <schema>.JournalArticle where companyId = <companyId>;

Run the following query to count the number of Journal Articles indexed in the
Elasticsearch server:

curl -XGET 'http://localhost:9200/liferay-<companyId>/_count' -d 
'{
  "query": {
    "term": {
      "entryClassName": "com.liferay.journal.model.JournalArticle"
    }
  }
}'

*If you're using elasticsearch-head to run this query, make sure you're using
the POST method instead of GET.

********************************************************************************
SOURCE URLS
********************************************************************************

https://data.cityofboston.gov/City-Services/311-Service-Requests/awu8-dc52
https://data.cityofboston.gov/browse?limitTo=datasets&utf8=✓
https://data.cityofboston.gov/resource/awu8-dc52.json

********************************************************************************
APIS
********************************************************************************

https://github.com/socrata/datasync
https://github.com/socrata/soda-java

********************************************************************************
APP URL
********************************************************************************

http://www.cityofboston.gov/doit/apps/citizensconnect.asp

