# SpellChecker SpringBoot Application

1- Initially words loaded from txt file : dictionary.txt

2- Endpoint to perform spell check
-> Request Type : POST
-> URL : http://IP:Port/spellchecker/check
-> Body :
{
	"word": word to be checked
}
-> Response : Set of relevant words
-> Sample request and response

3- Endpoint to refresh dictionary at runtime 
-> Request Type : GET
-> URL : http://IP:Port/spellchecker/reload


################################################################################################################################
Sample Req/Resp :


Request :
POST /check HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 3e8aaf5b-099b-4662-93d7-991690943d14

{
	"word":"talm"
}

Response:
{
    "relevantWords": [
        "tale",
        "talk",
        "tall"
    ],
    "status": "OK"
}

#################################################################################################################

POST /check HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: f2a94b5b-0dcc-44e8-8c20-c2d291e916ab

{
	"word":"thnk"
}

{
    "relevantWords": [
        "tank",
        "think"
    ],
    "status": "OK"
}



